package studentManagment.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentManagment.model.DAO.interfaces.ScheduleDAO;
import studentManagment.model.Templates.LessonTemplate;
import studentManagment.model.Templates.ScheduleTemplate;
import studentManagment.model.Templates.StudentTemplate;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;


    public List<ScheduleTemplate> getStudentsSchedule(Integer studentId){
        return scheduleDAO.getLessonsForStudent(studentId);
    }

    public List<ScheduleTemplate> getFullSchedule(){
        return scheduleDAO.getAll();
    }

    public void addLesson(ScheduleTemplate entry){
        scheduleDAO.insert(entry);
    }
    public void removeLesson(ScheduleTemplate entry){
        scheduleDAO.delete(entry);
    }
    public void changeLesson(ScheduleTemplate entry){
        scheduleDAO.update(entry);
    }
}
