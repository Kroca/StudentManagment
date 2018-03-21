package studentManagment.model.DAO.impl;

import org.springframework.stereotype.Repository;
import studentManagment.model.DAO.DBConnection;
import studentManagment.model.DAO.interfaces.UserDAO;
import studentManagment.model.Templates.UserTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    public UserTemplate authenticateUser(String login, String pas) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        UserTemplate template = null;

        try {
            con = DBConnection.getDataSource().getConnection();
            String sql ="select * from users WHERE login= ? AND password= ?";
            statement = con.prepareStatement(sql);
            statement.setString(1,login);
            statement.setString(2,pas);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                template = new UserTemplate(resultSet.getInt("id"), resultSet.getString("fullname"),
                         resultSet.getString("login"), resultSet.getString("password"),resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResources(con,statement,resultSet);
        }
        return template;
    }

    public UserTemplate getById(Integer id) {
        UserTemplate template = null;
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.getDataSource().getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from users WHERE id = "+id);
            if(resultSet.next()) {
                template =  new UserTemplate(resultSet.getInt("id"), resultSet.getString("fullname"),
                        resultSet.getString("login"), resultSet.getString("password"),resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResources(con,statement,resultSet);
        }
        return template;
    }

    public List<UserTemplate> getAll() {
        throw new NotImplementedException();
    }

    public Integer insert(UserTemplate entity) {
        String name = entity.getFullname();
        String login = entity.getLogin();
        String password = entity.getPassword();
        String role = entity.getRole();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try
        {
            con = DBConnection.getDataSource().getConnection();
            String query = "insert into users(fullname,login,password,role) values (?,?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, role);
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

    public Integer update(UserTemplate entity) {
        throw new NotImplementedException();
    }

    public Integer delete(UserTemplate delete) {
        throw new NotImplementedException();
    }
}
