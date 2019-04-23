package com.ss.data.bean;

import java.io.Serializable;

public class Major implements Serializable {

    private Integer id;

    private String name ;

    private String big;

    private String small;

    private String info;//开办院校地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", big='" + big + '\'' +
                ", small='" + small + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
