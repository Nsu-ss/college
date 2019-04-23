package com.ss.data.service;


import com.ss.data.bean.*;


import java.util.List;

public interface DataService {

    Integer addCollege(List<College> list);

    Integer addMajor(List<Major> list);

    List<Major> getMajors();

    Integer setCollegeMajor(List<String> list,Integer id);

    Integer setRank(List<Rank> list);

    Integer getCollegesId(String name);

    Integer setScore(List<Score> scores);

    Integer setIntroduce (String introduce,Integer id);

    Integer setLine(List<Line> lines);
}
