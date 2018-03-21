package studentManagment.model.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import studentManagment.model.DAO.interfaces.CourseDAO;
import studentManagment.model.DAO.DBConnection;
import studentManagment.model.DAO.interfaces.ProfessorDAO;
import studentManagment.model.Templates.CourseTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    ProfessorDAO professorDAO;

    public CourseTemplate getById(Integer id) {
        CourseTemplate course = null;
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from course WHERE id = "+id);
            if(resultSet.next()) {
                int profId = resultSet.getInt("prof_id");
                course = new CourseTemplate(id,profId,resultSet.getString("subject"));
                course.setProfessorTemplate(professorDAO.getById(profId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResources(con,statement,resultSet);
        }
        return course;
    }

    public List<CourseTemplate> getAll() {
        throw new NotImplementedException();
    }

    public Integer insert(CourseTemplate courseTemplate) {
       throw new NotImplementedException();
    }

    public Integer update(CourseTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer delete(CourseTemplate delete) {
        throw new NotImplementedException();
    }
}
