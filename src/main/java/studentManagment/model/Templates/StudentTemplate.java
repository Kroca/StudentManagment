package studentManagment.model.Templates;

public class StudentTemplate extends UserTemplate {
    private String major;
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public StudentTemplate(Integer id, String major){
        this.id = id;
        this.major = major;
    }
}
