package studentManagment.model.Templates;

import studentManagment.model.DAO.interfaces.StudentDAO;

public class ScheduleTemplate {
    private int student_id;
    private int lesson_id;
    private StudentTemplate studentTemplate;
    private LessonTemplate lessonTemplate;

    public StudentTemplate getStudentTemplate() {
        return studentTemplate;
    }

    public void setStudentTemplate(StudentTemplate studentTemplate) {
        this.studentTemplate = studentTemplate;
    }

    public LessonTemplate getLesson() {
        return lessonTemplate;
    }

    public void setLessonTemplate(LessonTemplate lessonTemplate) {
        this.lessonTemplate = lessonTemplate;
    }

    public ScheduleTemplate(int student_id, int lesson_id) {
        this.student_id = student_id;
        this.lesson_id = lesson_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }
}
