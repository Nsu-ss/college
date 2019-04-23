package com.ss.data.service.impl;

import com.ss.data.bean.College;
import com.ss.data.bean.Line;
import com.ss.data.bean.Major;
import com.ss.data.bean.Score;
import com.ss.data.dao.SchoolDao;
import com.ss.data.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public List<Score> getByScore(String type, String province, String score , String year) {
        return schoolDao.getByScore(type,province,score,year);
    }

    @Override
    public College getCollegeById(Integer id) {
        return schoolDao.getCollegeById(id);
    }

    @Override
    public List<Major> getMajor(String name) {
        return schoolDao.getMajor(name);
    }

    @Override
    public List<College> getByPosition(String type, String province) {
        return schoolDao.getByPosition(type,province);
    }


    @Override
    public List<Line> getLines(String province, String year) {
        return schoolDao.getLines(province,year);
    }

    @Override
    public List<Line> lines() {
        return schoolDao.lines();
    }

    @Override
    public void delete(Line line) {
         schoolDao.delete(line);
    }

    @Override
    public Line getLine(Integer id) {
        return schoolDao.getLine(id);
    }
}
