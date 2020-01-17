package pojo;

import java.util.List;


public class Department {
    private int dtId;
    private String dtName;
    private List<Classes> classes;

    public List<Classes> getClasses() {
        return classes;
    }
    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
    public int getDtId() {
        return dtId;
    }
    public void setDtId(int dtId) {
        this.dtId = dtId;
    }
    public String getDtName() {
        return dtName;
    }
    public void setDtName(String dtName) {
        this.dtName = dtName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dtId=" + dtId +
                ", dtName='" + dtName + '\'' +
                ", classes=" + classes +
                '}';
    }
}
