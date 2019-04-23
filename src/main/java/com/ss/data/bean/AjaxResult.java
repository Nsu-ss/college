package com.ss.data.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.data.common.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.LinkedHashMap;

public class AjaxResult {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer code ;

    private  String message;

    private LinkedHashMap<String, Object> data = new LinkedHashMap<>();//封装json的map

    public AjaxResult(){};

    public AjaxResult(ResultEnum result){
        this.code = result.value();
    };

    public AjaxResult(ResultEnum result, String message){
        this.code = result.value();
        this.message = message;

    };

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(ResultEnum code) {
        this.code = code.value();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void  put(String key , Object vaule){
        data.put(key,vaule);
    }

    public  Object get(String key){
        return  data.get(key);
    }

    public LinkedHashMap<String, Object> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.info(new Date() + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
