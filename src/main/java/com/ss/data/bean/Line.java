package com.ss.data.bean;

public class Line {

    private Integer id ;

    private String district;

    private String year;

    private String type;

    private String batch;

    private String low;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                ", batch='" + batch + '\'' +
                ", low='" + low + '\'' +
                '}';
    }
}
