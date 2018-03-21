package studentManagment.model.Templates;

public class ProfessorTemplate extends UserTemplate {

    private String faculty;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ProfessorTemplate(String faculty) {
        this.faculty = faculty;
    }
}
