package pojo;

import java.util.Date;

public class StudentContent {
    private int scId;
    private String fog_student;
    private String scName;
    private String scLink;
    private Date scDate;

    public Date getScDate() {
        return scDate;
    }
    public void setScDate(Date scDate) {
        this.scDate = scDate;
    }
    public int getScId() {
        return scId;
    }
    public void setScId(int scId) {
        this.scId = scId;
    }
    public String getFog_student() {
        return fog_student;
    }
    public void setFog_student(String fog_student) {
        this.fog_student = fog_student;
    }
    public String getScName() {
        return scName;
    }
    public void setScName(String scName) {
        this.scName = scName;
    }
    public String getScLink() {
        return scLink;
    }
    public void setScLink(String scLink) {
        this.scLink = scLink;
    }
}
