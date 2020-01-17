package pojo;

import java.util.Date;

public class AlumniContent {
    private int acId;
    private String fog_alumni;
    private String acName;
    private String acLink;
    private Date acDate;

    public Date getAcDate() {
        return acDate;
    }
    public void setAcDate(Date acDate) {
        this.acDate = acDate;
    }
    public int getAcId() {
        return acId;
    }
    public void setAcId(int acId) {
        this.acId = acId;
    }
    public String getFog_alumni() {
        return fog_alumni;
    }
    public void setFog_alumni(String fog_alumni) {
        this.fog_alumni = fog_alumni;
    }
    public String getAcName() {
        return acName;
    }
    public void setAcName(String acName) {
        this.acName = acName;
    }
    public String getAcLink() {
        return acLink;
    }
    public void setAcLink(String acLink) {
        this.acLink = acLink;
    }
}
