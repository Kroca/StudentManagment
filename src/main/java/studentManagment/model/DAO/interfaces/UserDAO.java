package studentManagment.model.DAO.interfaces;

import studentManagment.model.DAO.interfaces.DAO;
import studentManagment.model.Templates.UserTemplate;

public interface UserDAO extends DAO<UserTemplate,Integer> {
    UserTemplate authenticateUser(String login, String pas);
}
