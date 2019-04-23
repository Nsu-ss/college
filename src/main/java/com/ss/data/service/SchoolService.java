package com.ss.data.service;

import com.ss.data.bean.College;
import com.ss.data.bean.Line;
import com.ss.data.bean.Major;
import com.ss.data.bean.Score;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SchoolService {

    List<Score> getByScore(String type, String province, String score , String year);

    College getCollegeById( Integer id);

    List<Major> getMajor(String name);

    List<College> getByPosition(String type, String province);

    List<Line> getLines(String province,String year);

    List<Line> lines();

    void  delete(Line line);

    Line getLine (Integer id);

}
