package pojo;

import java.util.Date;

public class NewsContent {
    private int ncId;
    private String fog_news;
    private  String ncName;
    private String ncLink;
    private Date ncDate;

    public int getNcId() {
        return ncId;
    }
    public void setNcId(int ncId) {
        this.ncId = ncId;
    }
    public String getFog_news() {
        return fog_news;
    }
    public void setFog_news(String fog_news) {
        this.fog_news = fog_news;
    }
    public String getNcName() {
        return ncName;
    }
    public void setNcName(String ncName) {
        this.ncName = ncName;
    }
    public String getNcLink() {
        return ncLink;
    }
    public void setNcLink(String ncLink) {
        this.ncLink = ncLink;
    }
    public Date getNcDate() {
        return ncDate;
    }
    public void setNcDate(Date ncDate) {
        this.ncDate = ncDate;
    }
}
