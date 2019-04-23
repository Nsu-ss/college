package com.ss.data.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ss.data.bean.*;
import com.ss.data.common.ResultEnum;
import com.ss.data.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.Year;
import java.util.List;

@Controller
@RequestMapping(value = "school")
public class SchoolController {
    Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SchoolService schoolService;

    //主页
    @RequestMapping(value = "/index")
    public String main(){
        return "pages/main";
    }

    ///按分数差大学的页面
    @RequestMapping(value = "/score")
    public String score(){
        return "pages/score";
    }


    /**
     * 按分数差大学
     * @param page 分页参数
     * @param type 学校类型
     * @param province 省份
     * @param score 实际分数
     * @return json对象
     */
    @RequestMapping(value = "/getCollegeByScore")
    @ResponseBody
    public AjaxResult getCollegeByScore(Integer page,String type,String province,String year,String score){
        if (type== null || province == null || score == null && page ==null){
            return  new AjaxResult(ResultEnum.PARAM_IS_NULL);
        }
        AjaxResult result = new AjaxResult();
        PageHelper.startPage(page,6);
        List<Score> college = schoolService.getByScore(type,province,score,year);
        PageInfo<Score> colleges = new PageInfo<Score>(college);
        result.put("data",colleges);
        result.setCode(ResultEnum.SUCCESS);
        return result;
    }


    //按位置差大学的页面
    @RequestMapping(value = "/position")
    public String position(){
        return "pages/position";
    }


    /**
     * 按位置查大学
     * @param province 所在省份
     * @param level 等级
     * @param page 分页参数
     * @return json对象
     */
    @RequestMapping(value = "/getCollegeByPosition")
    @ResponseBody
    public AjaxResult getCollegeByPosition(String province,String level, Integer page){

        AjaxResult result= new AjaxResult();
        if (province ==null && level==null && page==null){
            return  new AjaxResult(ResultEnum.PARAM_IS_NULL);
        }
        //设置分页
        PageHelper.startPage(page,7);
        //获取信息
        List<College> colleges = schoolService.getByPosition(level,province);
        //转成信息
        PageInfo<College> info = new PageInfo<>(colleges);
        result.setCode(ResultEnum.SUCCESS);
        result.put("colleges",info);
        //返回信息
        return result;
    }


    //查国内大学
    @RequestMapping(value = "/college")
    public String college(){
        return "pages/colleges";
    }

    //按分数差大学的data
    @RequestMapping(value = "/data")
    public String data(String score,String province,String type,String year,ModelMap map){
        map.put("score",score);
        map.put("province",province);
        map.put("type",type);
        map.put("year",year);
        return "pages/data";
    }

    //大学信息
    @RequestMapping(value = "/collegeInfo")
    public String collegeInfo(Integer id,ModelMap modelMap)
    {
        College college = schoolService.getCollegeById(id);
        String ss = JSON.toJSONString(college);
        modelMap.put("college",ss);
        return "pages/collegeData";
    }

    /**
     * 大学专业信息
     * @param name 专业名称
     * @return ajaxResult
     */
    @RequestMapping(value = "/major")
    @ResponseBody
    public AjaxResult getMajor(String name)
    {
        //获取大学专业信息
        List<Major> majors = schoolService.getMajor(name);
        logger.info(majors.toString());
        //创建返回对象
        AjaxResult result = new AjaxResult();
        //设置返回状态
        result.setCode(ResultEnum.SUCCESS);
        //保存返回数据
        result.put("major",majors);
        return  result;
    }


    //查省级分数线页面
    @RequestMapping(value = "/getProvinceLine")
    public String getProvinceLine(String province,String year,ModelMap modelMap){
        modelMap.put("provicne",province);
        modelMap.put("year",year);
        return "pages/provinceLine";
    }

    //查省级分数线数据
    @RequestMapping(value = "/getLine")
    @ResponseBody
    public AjaxResult getLine(String province,String year){
        AjaxResult result = new AjaxResult(ResultEnum.SUCCESS);
        if (province ==null || year == null){
            result.setCode(ResultEnum.PARAM_IS_NULL);
            return  result;
        }
        logger.info(province+year);
        List lines = schoolService.getLines(province,year);

        result.put("data",lines);
        logger.info(lines.toString());

        return result;
    }



    //查找专业
    @RequestMapping(value = "/Course")
    public String getCourse(){
        return "pages/collegeCourse";
    }


    //按专业查大学
    @RequestMapping(value = "/getCollegeByMajor")
    public String getCollegeByMajor(){
        return "pages/colleges";
    }





}
