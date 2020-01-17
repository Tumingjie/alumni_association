package pojo;

import java.util.Date;

public class MediumContent {
    private int mcId;
    private String fog_medium;
    private String mcName;
    private String mcLink;
    private Date mcDate;

    public Date getMcDate() {
        return mcDate;
    }
    public void setMcDate(Date mcDate) {
        this.mcDate = mcDate;
    }
    public int getMcId() {
        return mcId;
    }
    public void setMcId(int mcId) {
        this.mcId = mcId;
    }
    public String getFog_medium() {
        return fog_medium;
    }
    public void setFog_medium(String fog_medium) {
        this.fog_medium = fog_medium;
    }
    public String getMcName() {
        return mcName;
    }
    public void setMcName(String mcName) {
        this.mcName = mcName;
    }
    public String getMcLink() {
        return mcLink;
    }
    public void setMcLink(String mcLink) {
        this.mcLink = mcLink;
    }
}
