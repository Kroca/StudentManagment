package studentManagment.model.DAO.impl;

import org.springframework.stereotype.Repository;
import studentManagment.model.DAO.DBConnection;
import studentManagment.model.DAO.interfaces.StudentDAO;
import studentManagment.model.Templates.CourseTemplate;
import studentManagment.model.Templates.StudentTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    public StudentTemplate getById(Integer id) {
        StudentTemplate studentTemplate = null;
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from students WHERE id = "+id);
            if(resultSet.next()) {
                studentTemplate = new StudentTemplate(id ,resultSet.getString("major"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResources(con,statement,resultSet);
        }
        return studentTemplate;
    }

    public List<StudentTemplate> getAll() {
        throw new NotImplementedException();
    }

    public Integer insert(StudentTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer update(StudentTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer delete(StudentTemplate delete) {
        throw new NotImplementedException();
    }
}
