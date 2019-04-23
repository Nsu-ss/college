package com.ss.data.bean;

public class Score {
    private Integer id;
    private  String collegeName;
    private  String year;
    private  String low;
    private  String high;
    private  String avage;
    private  String sum;
    private  String batch;
    private  String status;
    private  String type;

    private  College college = new College();

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getAvage() {
        return avage;
    }

    public void setAvage(String avage) {
        this.avage = avage;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", collegeName='" + collegeName + '\'' +
                ", year='" + year + '\'' +
                ", low='" + low + '\'' +
                ", high='" + high + '\'' +
                ", avage='" + avage + '\'' +
                ", sum='" + sum + '\'' +
                ", batch='" + batch + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", college=" + college +
                '}';
    }
}
