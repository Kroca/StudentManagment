package studentManagment.model.Templates;

import java.sql.Date;

public class LessonTemplate {

    private int id;
    private int course_id;
    private Date date;
    private CourseTemplate course;



    public LessonTemplate(int id, int course_id, Date date) {
        this.id = id;
        this.course_id = course_id;
        this.date = date;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCourse_id() {
        return course_id;
    }

    public Date getDate() {
        return date;
    }

    public void setCourse(CourseTemplate course) {
        this.course = course;
    }

    public CourseTemplate getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

