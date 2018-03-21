package studentManagment.model.Templates;

public class UserTemplate {

    protected int id;
    private String fullname;
    private String login;
    private String password;
    private String role;

    public UserTemplate(String fullname, String login, String password, String role) {
        this.fullname = fullname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserTemplate() {
    }

    public UserTemplate(int id, String fullname, String login, String password, String role) {
        this.id = id;
        this.fullname = fullname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
