package pojo;

import java.util.Date;

public class HelpContent {
    private int hcId;
    private String fog_help;
    private String hcName;
    private String hcLink;
    private Date hcDate;

    public Date getHcDate() {
        return hcDate;
    }
    public void setHcDate(Date hcDate) {
        this.hcDate = hcDate;
    }
    public int getHcId() {
        return hcId;
    }
    public void setHcId(int hcId) {
        this.hcId = hcId;
    }
    public String getFog_help() {
        return fog_help;
    }
    public void setFog_help(String fog_help) {
        this.fog_help = fog_help;
    }
    public String getHcName() {
        return hcName;
    }
    public void setHcName(String hcName) {
        this.hcName = hcName;
    }
    public String getHcLink() {
        return hcLink;
    }
    public void setHcLink(String hcLink) {
        this.hcLink = hcLink;
    }
}
