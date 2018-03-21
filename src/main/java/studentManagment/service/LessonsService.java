package studentManagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentManagment.model.DAO.impl.CourseDAOImpl;
import studentManagment.model.DAO.impl.LessonDAOImpl;
import studentManagment.model.DAO.interfaces.CourseDAO;
import studentManagment.model.DAO.interfaces.LessonDAO;
import studentManagment.model.DAO.interfaces.ScheduleDAO;
import studentManagment.model.DAO.interfaces.StudentDAO;
import studentManagment.model.Templates.LessonTemplate;

import java.util.List;

@Service
public class LessonsService {

    @Autowired
    LessonDAO lessonDAO;

    public LessonTemplate getById(Integer id){
        return lessonDAO.getById(id);
    }

    public int deleteById(int id){
        LessonTemplate template = lessonDAO.getById(id);
        return lessonDAO.delete(template);
    }
    public int delete(LessonTemplate lessonTemplate){

        return lessonDAO.delete(lessonTemplate);
    }

    public int edit(LessonTemplate lessonTemplate){
        return lessonDAO.update(lessonTemplate);
    }


}
