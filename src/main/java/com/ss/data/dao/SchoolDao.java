package com.ss.data.dao;


import com.ss.data.bean.College;
import com.ss.data.bean.Line;
import com.ss.data.bean.Major;
import com.ss.data.bean.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolDao {

    List<Score> getByScore(@Param("type") String type, @Param("province") String province,
                           @Param("score") String score, @Param("year") String year );

    College getCollegeById(@Param("id") Integer id);

    List<Major> getMajor(@Param("name") String name);

    List<College> getByPosition(@Param("type")String type, @Param("province")String province);

    List<Line> getLines(@Param("province")String province,@Param("year") String year);

    @Select("select * from province_line")
    List<Line> lines();


    void delete(@Param("line") Line line);


    Line getLine(@Param("id") Integer id);

}
