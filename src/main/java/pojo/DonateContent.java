package pojo;

import java.util.Date;

public class DonateContent {
    private int dcId;
    private String fog_donate;
    private String dcName;
    private String dcLink;
    private Date dcDate;

    public Date getDcDate() {
        return dcDate;
    }
    public void setDcDate(Date dcDate) {
        this.dcDate = dcDate;
    }
    public int getDcId() {
        return dcId;
    }
    public void setDcId(int dcId) {
        this.dcId = dcId;
    }
    public String getFog_donate() {
        return fog_donate;
    }
    public void setFog_donate(String fog_donate) {
        this.fog_donate = fog_donate;
    }
    public String getDcName() {
        return dcName;
    }
    public void setDcName(String dcName) {
        this.dcName = dcName;
    }
    public String getDcLink() {
        return dcLink;
    }
    public void setDcLink(String dcLink) {
        this.dcLink = dcLink;
    }
}
