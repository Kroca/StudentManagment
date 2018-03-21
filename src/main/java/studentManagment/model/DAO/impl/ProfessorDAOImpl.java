package studentManagment.model.DAO.impl;

import org.springframework.stereotype.Repository;
import studentManagment.model.DAO.DBConnection;
import studentManagment.model.DAO.interfaces.ProfessorDAO;
import studentManagment.model.Templates.ProfessorTemplate;
import studentManagment.model.Templates.StudentTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO {
    public ProfessorTemplate getById(Integer id) {
        ProfessorTemplate professorTemplate = null;
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from professors WHERE id = "+id);
            if(resultSet.next()) {
                professorTemplate = new ProfessorTemplate(resultSet.getString("faculty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResources(con,statement,resultSet);
        }
        return professorTemplate;
    }

    public List<ProfessorTemplate> getAll() {
        throw new NotImplementedException();
    }

    public Integer insert(ProfessorTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer update(ProfessorTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer delete(ProfessorTemplate delete) {
        throw new NotImplementedException();
    }

}
