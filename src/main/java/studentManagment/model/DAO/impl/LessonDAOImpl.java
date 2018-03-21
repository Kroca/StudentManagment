package studentManagment.model.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import studentManagment.model.DAO.DBConnection;
import studentManagment.model.DAO.interfaces.CourseDAO;
import studentManagment.model.DAO.interfaces.LessonDAO;
import studentManagment.model.DAO.interfaces.StudentDAO;
import studentManagment.model.Templates.LessonTemplate;
import studentManagment.model.Templates.StudentTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonDAOImpl implements LessonDAO {

    @Autowired
    CourseDAO courseDAO;

    public LessonTemplate getById(Integer id) {
        LessonTemplate lessonTemplate = null;
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from lessons WHERE id = "+id);
            if(resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                lessonTemplate = new LessonTemplate(id,courseId,resultSet.getDate("date"));
                lessonTemplate.setCourse(courseDAO.getById(courseId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResources(con,statement,resultSet);
        }
        return lessonTemplate;
    }

    public List<LessonTemplate> getAll() {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<LessonTemplate> lessonTemplates = new ArrayList<>();
        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from lesson");
            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                LessonTemplate temp = new LessonTemplate(resultSet.getInt("id"), courseId,resultSet.getDate("date"));
                temp.setCourse(courseDAO.getById(courseId));
                lessonTemplates.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, statement, resultSet);
        }
        return lessonTemplates;
    }

    public Integer insert(LessonTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer update(LessonTemplate entity) {
        if(entity==null)
            return 0;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try
        {
            con = DBConnection.getDataSource().getConnection();
            String query = "UPDATE lessons SET course_id = ?, date = ? WHERE id = ?;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getCourse_id());
            preparedStatement.setDate(2, entity.getDate());
            preparedStatement.setInt(3, entity.getId());
            return preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }finally {
            closeResources(con,preparedStatement,null);
        }
        return 0;
    }

    public Integer delete(LessonTemplate entity) {
        if(entity==null)
            return 0;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try
        {
            con = DBConnection.getDataSource().getConnection();
            String query = "DELETE FROM lessons WHERE id = ?;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getId());
            return preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }finally {
            closeResources(con,preparedStatement,null);
        }
        return 0;
    }

}
