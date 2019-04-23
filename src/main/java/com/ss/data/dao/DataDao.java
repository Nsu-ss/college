package com.ss.data.dao;

import com.ss.data.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDao {

     Integer addCollege(@Param("list")List<College> list);

     Integer addMajor(@Param("list")List<Major> list);

     List<Major> getMajors();

     Integer setCollegeMajor(@Param("list")List<String> list,@Param("id")Integer id);

     Integer setRank(@Param("list")List<Rank> list);

     Integer getCollegesId(@Param("name") String name);

     Integer setScore(@Param("scores") List<Score> scores);

     Integer setIntroduce (@Param("introduce") String introduce,@Param("id") Integer name);

     Integer setLine(@Param("lines")List<Line> lines);

}
