package studentManagment.model.Templates;

import java.sql.Date;

public class CourseTemplate {
    private int id;
    private int profId;
    private ProfessorTemplate professorTemplate;
    private String subject;

    public CourseTemplate(int studId, int profId, String subject) {
        this.id = studId;
        this.profId = profId;
        this.subject = subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    public ProfessorTemplate getProfessorTemplate() {
        return professorTemplate;
    }

    public void setProfessorTemplate(ProfessorTemplate professorTemplate) {
        this.professorTemplate = professorTemplate;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public int getProfId() {
        return profId;
    }

    public String getSubject() {
        return subject;
    }
}
