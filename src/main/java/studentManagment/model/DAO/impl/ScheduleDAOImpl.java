package studentManagment.model.DAO.impl;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import studentManagment.model.DAO.DBConnection;
import studentManagment.model.DAO.interfaces.LessonDAO;
import studentManagment.model.DAO.interfaces.ScheduleDAO;
import studentManagment.model.DAO.interfaces.StudentDAO;
import studentManagment.model.Templates.LessonTemplate;
import studentManagment.model.Templates.ScheduleTemplate;
import studentManagment.model.Templates.StudentTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    LessonDAO lessonDAO;

    @Override
    public List<ScheduleTemplate> getStudentsForLesson(Integer lessonId) {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<ScheduleTemplate> scheduleTemplates = new ArrayList<>();


        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();


            resultSet = statement.executeQuery("select student_id from schedule where lesson_id= " + lessonId);
            while (resultSet.next()) {
                int studId = resultSet.getInt("student_id");
                StudentTemplate temp = studentDAO.getById(studId);
                ScheduleTemplate scheduleTemplate = new ScheduleTemplate(studId,lessonId);
                scheduleTemplate.setStudentTemplate(temp);
                scheduleTemplates.add(scheduleTemplate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, statement, resultSet);
        }
        return scheduleTemplates;
    }

    @Override
    public List<ScheduleTemplate> getLessonsForStudent(Integer studentId) {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<ScheduleTemplate> scheduleTemplates = new ArrayList<>();
        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select lesson_id from schedule where student_id=" + studentId);
            while (resultSet.next()) {
                int lessonId = resultSet.getInt("lesson_id");
                ScheduleTemplate tempSch = new ScheduleTemplate(studentId,lessonId);
                LessonTemplate temp = lessonDAO.getById(resultSet.getInt("lesson_id"));
                tempSch.setLessonTemplate(temp);
                scheduleTemplates.add(tempSch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, statement, resultSet);
        }
        return scheduleTemplates;
    }


    @Override
    public ScheduleTemplate getById(Pair<Integer, Integer> id) {
        throw new NotImplementedException();
    }

    @Override
    public List<ScheduleTemplate> getAll() {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<ScheduleTemplate> scheduleTemplates = new ArrayList<>();
        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from schedule");
            while (resultSet.next()) {
                int studId = resultSet.getInt("student_id");
                int lessonId= resultSet.getInt("lesson_id");
                ScheduleTemplate temp = new ScheduleTemplate(studId,lessonId);
                temp.setLessonTemplate(lessonDAO.getById(lessonId));
                temp.setStudentTemplate(studentDAO.getById(studId));
                scheduleTemplates.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, statement, resultSet);
        }
        return scheduleTemplates;
    }

    @Override
    public Pair<Integer, Integer> insert(ScheduleTemplate entity) {
        throw new NotImplementedException();
    }

    @Override
    public Pair<Integer, Integer> update(ScheduleTemplate entity) {
        throw new NotImplementedException();
    }

    @Override
    public Pair<Integer, Integer> delete(ScheduleTemplate delete) {
        throw new NotImplementedException();
    }
}
