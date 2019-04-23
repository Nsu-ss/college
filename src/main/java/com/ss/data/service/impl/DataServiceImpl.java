package com.ss.data.service.impl;

import com.ss.data.bean.*;
import com.ss.data.dao.DataDao;
import com.ss.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public Integer addCollege(List<College> list) {
        return dataDao.addCollege(list);
    }


    @Override
    public Integer addMajor(List<Major> list) {
        return dataDao.addMajor(list);
    }


    @Override
    public List<Major> getMajors() {
        return dataDao.getMajors();
    }

    @Override
    public Integer setCollegeMajor(List<String> list, Integer id) {
        return dataDao.setCollegeMajor(list,id);
    }

    @Override
    public Integer setRank(List<Rank> list) {
        return dataDao.setRank(list);
    }

    @Override
    public Integer getCollegesId(String name) {
        return dataDao.getCollegesId(name);
    }

    @Override
    public Integer setScore(List<Score> scores) {
        return dataDao.setScore(scores);
    }

    @Override
    public Integer setIntroduce(String introduce,Integer  id) {
        return dataDao.setIntroduce(introduce,id);
    }

    @Override
    public Integer setLine(List<Line> lines) {
        return dataDao.setLine(lines);
    }
}
