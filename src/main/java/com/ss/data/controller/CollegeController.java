package com.ss.data.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.data.Utils.HttpUtil;
import com.ss.data.bean.*;
import com.ss.data.service.DataService;
import org.apache.http.HttpStatus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.Transient;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/college")
public class CollegeController {

    private static Logger logger = LoggerFactory.getLogger(CollegeController.class);

    @Autowired
    private DataService dataService;


    //学校
    //@RequestMapping("data")
    public String getData(){

        HttpClientResult result = null;
        List<String>  list = new ArrayList<String>();
        List<College>  colleges = new ArrayList<College>();



        for (int i = 1;i<108;i++){
            String url = "http://college.gaokao.com/schlist/a100/p"+i+"/";

            try {
                //target="_blank">南开大学,'[\u4e00-\u9fa5]+'
                result = HttpUtil.doGet(url);
                String rex = ",'[\\u4e00-\\u9fa5()（）-]+'|"+
                        "：[\\u4e00-\\u9fa5[a-zA-Z].://—-]+|" +
                        "：[-]{6}|"+
                        "<span class=\"c211 rm5\">211</span><span class=\"c985\">985</span>"+"|"+
                        "<span class=\"c211 rm5\">211</span>"+"|"+"<span class=\"c985\">985</span>";
                Matcher m = splitString(rex,result.getContent());
                while (m.find()){
                    String s = m.group().replace(",","")
                            .replace("：","")
                            .replaceAll("'","")
                            .replace("<span class=\"c211 rm5\">","")
                            .replace("<span class=\"c985\">","")
                            .replaceAll("</span>","");
                    list.add(s);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j<list.size()-1;){
            College college = new College();
            college.setName(list.get(j++));
            college.setDistrict(list.get(j++));
            String s = list.get(j++);
            if ("211985".equals(s)){
                college.setToo("211");
                college.setNef("985");
            }else if ("211".equals(s)){
                college.setToo("211");
                college.setNef("");
            }else if ("985".equals(s)){
                college.setToo("");
                college.setNef("985");
            }else {
                college.setToo("_");
                college.setNef("_");
            }
            college.setType(list.get(j++));
            college.setParent(list.get(j++));
            college.setNature(list.get(j++));
            college.setWeb(list.get(j++));
            //data.add(college);
            if (!colleges.contains(college)){
                colleges.add(college);
            }
        }
        Integer flag = dataService.addCollege(colleges);
        return  "";
    }

    //专业
    //@RequestMapping("/major")
    public String getMajor(){
        HttpClientResult result = null;
        List<String>  list = new ArrayList<String>();
        List<Major>   majors = new ArrayList<>();
        Integer flag = 0;

        for (int i = 0;i<34;i++){
            String url = "http://daxue.exam8.com/Major/RightSearch?sortId=0&subjectId=0&majorName=&pageIndex="+i;

            try {
                result = HttpUtil.doGet(url);
                String rex = "<td><a href=\"/m/[0-9]{0,4}\" target=\"_blank\">([\\u4e00-\\u9fa5()（）-]+)</a></td>"
                        +"|"+"<td>([\\u4e00-\\u9fa5]{0,20})</td>";
                Matcher m = splitString(rex,result.getContent());
                while (m.find()){
                    String s = m.group().replace("<td><a href=\"","")
                            .replaceAll(" target=\"_blank\">","")
                            .replaceAll("</a></td>","")
                            .replaceAll("<td>","").replaceAll("</td>","");
                   list.add(s);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0;i<list.size()-1;){
            Major major = new Major();
            logger.info(i+"");
            String [] data = list.get(i++).split("\"");
            major.setInfo("http://daxue.exam8.com"+data[0]);
            major.setName(data[1]);
            major.setBig(list.get(i++));
            major.setSmall(list.get(i++));
            majors.add(major);
        }
        logger.info(dataService.addMajor(majors)+"");
        return  "";
    }


    //专业
    //@RequestMapping("/set")
    public String SetCollegeMajor(){
        HttpClientResult result = null;
        List<Major> majors = dataService.getMajors();
        List<String> names = new ArrayList<>();

        for (Major major : majors){
            try {
                result = HttpUtil.doGet(major.getInfo());

                String rex = "<td style=\"width:50%;\"><a href=\"/c/[0-9]{0,5}/\" target=\"_blank\">([\\u4e00-\\u9fa5]+)</a></td>";
                Matcher m = splitString(rex,result.getContent());

                while (m.find()){
                    String s = m.group().replaceAll("<td style=\"width:50%;\"><a href=\"/c/[0-9]{0,5}/\" target=\"_blank\">","")
                            .replaceAll("</a></td>","");
                    names.add(s);
                }
                dataService.setCollegeMajor(names,major.getId());
                names.clear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  "";
    }


   // @RequestMapping("rank")
    public String GetCollegeRanking(){
        HttpClientResult results = null;
        List<Rank> rankList = new ArrayList<>();
        for (int i = 0;i<401;i=i+25){

            Map<String,String> pars = new HashMap<String, String>();
            if (i == 0){
                pars.put("start",Integer.toString(i+1));
            }else {
                pars.put("start",Integer.toString(i));
            }
            pars.put("amount","25");
            pars.put("otype","3");
            try {
                results = HttpUtil.doPost("http://www.gaokaopai.com/Rank-index.html",pars);

                String ranks = JSONObject.parseObject(JSONObject.parseObject(results.getContent()).getString("data")).getString("ranks");

                rankList.addAll(JSON.parseArray(ranks, Rank.class));

                logger.info("当前第"+i+"页"+JSON.parseArray(ranks, Rank.class).size()+"共"+rankList.size());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer flag = dataService.setRank(rankList);

        return  "";
    }


    //@RequestMapping("/score")
    @ResponseBody
    public String getScore(){
        HttpClientResult result = null;
        List<String> data =new ArrayList<String>();
        List<Score> scores = new ArrayList<Score>();
            for (int j = 182;j<2668;j++){
                for (int i = 1; i<3 ;i++){
                    String url = "http://college.gaokao.com/school/tinfo/"+j+"/result/16/"+i+"/";

                    try {
                        result = HttpUtil.doGet(url);
                        if (result.getCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR){
                            break;
                        }
                        String type = "";
                        switch (i){
                            case 1: type="理科";
                            break;
                            case 2: type="文科";
                            break;
                        }
                        logger.info(type);
                        String s = result.getContent();

                        Document document = Jsoup.parse(s);
                        Elements element2 = document.select("h2");

                        String name = element2.toString().replaceAll("<h2>","").replaceAll("</h2>","");
                        logger.info(name);


                        Document document1 = Jsoup.parse(s);
                        Elements elementw = document.getElementsByClass("szw");
                        Elements elementz = document1.getElementsByClass("sz");
                        for (Element e :elementw){
                            Elements ch =  e.children();
                           for (int m = 0;m<ch.size();m++){
                               if (m == 3){
                                   ch.get(m).html(ch.get(m).children().html());
                               }
                               if (m == 5 && "".equals(ch.get(m).html()) ){
                                   ch.get(m).html("不详");
                               }
                               data.add(ch.get(m).html());
                           }
                        }
                        for (Element e1 :elementz){
                            Elements ch2 =  e1.children();
                            for (int n = 0;n<ch2.size();n++){
                                if (n == 3){
                                    ch2.get(n).html(ch2.get(n).children().html());
                                }
                                if (n == 5 && "".equals(ch2.get(n).html()) ){
                                    ch2.get(n).html("不详");
                                }
                                data.add(ch2.get(n).html());
                            }
                        }
                        for (int d=0;d<data.size()-1;){
                            Score score = new Score();
                            score.setCollegeName(name);
                            score.setType(type);
                            score.setYear(data.get(d++));
                            score.setLow(data.get(d++));
                            score.setHigh(data.get(d++));
                            score.setAvage(data.get(d++));
                            score.setSum(data.get(d++));
                            score.setBatch(data.get(d++));
                            scores.add(score);
                        }
                        data.clear();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (!scores.isEmpty()){
                    dataService.setScore(scores);
                    scores.clear();
                    try {
                        Thread.sleep(40000);
                    }catch (Exception e){
                        logger.info("异常"+e.getMessage());
                    }
                }else {
                    logger.info(data.toString());
                }
            }
        return  "ss";
    }

   // @RequestMapping("introduce")
    @ResponseBody
    public String getIntroduce(){
        HttpClientResult result = null;

        for (int i = 1077; i < 2668;i++){
            String url = "http://college.gaokao.com/school/tinfo/"+i+"/intro/";

            try {
                HttpUtil.doGet(url);
                result = HttpUtil.doGet(url);
                if (result.getCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR){
                    continue;
                }
                String data = result.getContent();
                Document document1 = Jsoup.parse(data);
                Elements element = document1.select("h2");
                String name = element.toString().replaceAll("<h2>","").replaceAll("</h2>","");
                logger.info(name);

                Elements elements = document1.getElementsByClass("jj");
                String introduce = elements.html().toString().replaceAll(" class=\"title_h3 icon_intro\"","");
                if (!"".equals(name) && !"".equals(introduce)){
                    Integer id = dataService.getCollegesId(name);
                    if (id !=null){
                        dataService.setIntroduce(introduce,id);
                    }
                    Thread.sleep(35000);
                }
            }catch (Exception e){
                logger.info(e.getMessage());
            }
        }

        return "good";
    }

    //@RequestMapping("/province")
    @ResponseBody
    public String getProvince(){
        HttpClientResult result = null;
        List<String> data = null;
        List<Line>  lines = new ArrayList<>();
        for (int i = 1; i <56;i++){
            String url = "http://college.gaokao.com/areapoint/p"+i+"/";

            try {
                HttpUtil.doGet(url);
                result = HttpUtil.doGet(url);
                if (result.getCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR){
                    continue;
                }
                String s = result.getContent();
                Document document1 = Jsoup.parse(s);
                Elements element1 = document1.getElementsByTag("table");
                data = new ArrayList<>(Arrays.asList(element1.get(0).getElementsByTag("td").text().split(" ")));

                for (int j = 0; j<data.size()-1;){
                    Line line = new Line();
                    line.setYear(data.get(j++));
                    line.setDistrict(data.get(j++));
                    line.setType(data.get(j++));
                    line.setBatch(data.get(j++));
                    line.setLow(data.get(j++));
                    lines.add(line);
                }
                data.clear();
            }catch (Exception e){
                e.printStackTrace();
            }
            dataService.setLine(lines);
            lines.clear();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return "good";
    }



    private static Matcher splitString(String rex,String result){
        Pattern p = Pattern.compile(rex);
        return  p.matcher(result);
    }

}
