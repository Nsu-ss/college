package com.ss.data.bean;

public class Rank {

   private String  uni_name;

    private String  category_3;

    private String  city_code;

    private String  slogo;

    private String  safehard;

    private String  wu_total;

    private String  wu_training_score;

    private String  uni_id;

    private String  uni_type;

    private String  wu_scientific_score;

    public String getUni_name() {
        return uni_name;
    }

    public void setUni_name(String uni_name) {
        this.uni_name = uni_name;
    }

    public String getCategory_3() {
        return category_3;
    }

    public void setCategory_3(String category_3) {
        this.category_3 = category_3;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getSlogo() {
        return slogo;
    }

    public void setSlogo(String slogo) {
        this.slogo = slogo;
    }

    public String getSafehard() {
        return safehard;
    }

    public void setSafehard(String safehard) {
        this.safehard = safehard;
    }

    public String getWu_total() {
        return wu_total;
    }

    public void setWu_total(String wu_total) {
        this.wu_total = wu_total;
    }

    public String getWu_training_score() {
        return wu_training_score;
    }

    public void setWu_training_score(String wu_training_score) {
        this.wu_training_score = wu_training_score;
    }

    public String getUni_id() {
        return uni_id;
    }

    public void setUni_id(String uni_id) {
        this.uni_id = uni_id;
    }

    public String getUni_type() {
        return uni_type;
    }

    public void setUni_type(String uni_type) {
        this.uni_type = uni_type;
    }

    public String getWu_scientific_score() {
        return wu_scientific_score;
    }

    public void setWu_scientific_score(String wu_scientific_score) {
        this.wu_scientific_score = wu_scientific_score;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "uni_name='" + uni_name + '\'' +
                ", category_3='" + category_3 + '\'' +
                ", city_code='" + city_code + '\'' +
                ", slogo='" + slogo + '\'' +
                ", safehard='" + safehard + '\'' +
                ", wu_total='" + wu_total + '\'' +
                ", wu_training_score='" + wu_training_score + '\'' +
                ", uni_id='" + uni_id + '\'' +
                ", uni_type='" + uni_type + '\'' +
                ", wu_scientific_score='" + wu_scientific_score + '\'' +
                '}';
    }
}
