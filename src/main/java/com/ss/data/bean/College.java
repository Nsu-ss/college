package com.ss.data.bean;

import java.io.Serializable;
import java.util.Objects;

public class College implements Serializable {

    private Integer id;

    private String name;

    private String type; //高校类型

    private String district;  //地区

    private String phone;

    private String address;

    private String web;  //网站

    private Integer ranking;

    private String too; //211

    private String nef; //985

    private String nature;  //高校性质   本科  专科

    private String introduce;

    private String parent;

    private  Score score;


    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }


    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getToo() {
        return too;
    }

    public void setToo(String too) {
        this.too = too;
    }

    public String getNef() {
        return nef;
    }

    public void setNef(String nef) {
        this.nef = nef;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", district='" + district + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", web='" + web + '\'' +
                ", ranking=" + ranking +
                ", too='" + too + '\'' +
                ", nef='" + nef + '\'' +
                ", nature='" + nature + '\'' +
                ", introduce='" + introduce + '\'' +
                ", parent='" + parent + '\'' +
                ", score=" + score +
                '}';
    }

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return Objects.equals(name, college.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }*/
}
