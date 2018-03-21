package studentManagment.model.DAO.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DAO<E,PK> {
    E getById(PK id);
    List<E> getAll();
    PK insert(E entity);
    PK update(E entity);
    PK delete(E delete);

    default void closeResources(Connection con, Statement statement, ResultSet resultSet){
        //close connection
        try {
            if(con!=null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //close statement
        try {
            if(statement!=null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //close resulting set
        try {
            if(resultSet!=null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
