package pojo;

public class Classes {
    private int csId;
    private String fog_department;
    private int csNum;

    public int getCsId() {
        return csId;
    }
    public void setCsId(int csId) {
        this.csId = csId;
    }
    public String getFog_department() {
        return fog_department;
    }
    public void setFog_department(String fog_department) {
        this.fog_department = fog_department;
    }
    public int getCsNum() {
        return csNum;
    }
    public void setCsNum(int csNum) {
        this.csNum = csNum;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "csId=" + csId +
                ", fog_department='" + fog_department + '\'' +
                ", csNum=" + csNum +
                '}';
    }
}
