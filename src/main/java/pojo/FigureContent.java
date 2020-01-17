package pojo;

import java.util.Date;

public class FigureContent {
    private int fcId;
    private String fog_figure;
    private String fcName;
    private String fcLink;
    private Date fcDate;

    public Date getFcDate() {
        return fcDate;
    }
    public void setFcDate(Date fcDate) {
        this.fcDate = fcDate;
    }
    public int getFcId() {
        return fcId;
    }
    public void setFcId(int fcId) {
        this.fcId = fcId;
    }
    public String getFog_figure() {
        return fog_figure;
    }
    public void setFog_figure(String fog_figure) {
        this.fog_figure = fog_figure;
    }
    public String getFcName() {
        return fcName;
    }
    public void setFcName(String fcName) {
        this.fcName = fcName;
    }
    public String getFcLink() {
        return fcLink;
    }
    public void setFcLink(String fcLink) {
        this.fcLink = fcLink;
    }
}
