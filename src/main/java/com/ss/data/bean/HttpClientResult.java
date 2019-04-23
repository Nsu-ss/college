package com.ss.data.bean;

import java.io.Serializable;

public class HttpClientResult implements Serializable {

    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }

    private int code;

    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpClientResult{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }
}
