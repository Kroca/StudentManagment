package studentManagment.model.DAO.interfaces;

import javafx.util.Pair;
import studentManagment.model.Templates.LessonTemplate;
import studentManagment.model.Templates.ScheduleTemplate;
import studentManagment.model.Templates.StudentTemplate;

import java.util.List;

public interface ScheduleDAO extends DAO<ScheduleTemplate,Pair<Integer,Integer>>{
    List<ScheduleTemplate> getStudentsForLesson(Integer lessonId);

    List<ScheduleTemplate> getLessonsForStudent(Integer studentId);
}
