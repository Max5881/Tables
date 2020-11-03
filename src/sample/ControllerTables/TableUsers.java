package sample.ControllerTables;

public class TableUsers {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    public TableUsers(String id,String firstName, String lastName, String email, String login, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
