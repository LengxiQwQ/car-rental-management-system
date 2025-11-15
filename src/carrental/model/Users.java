package carrental.model;

public class Users {
    private String username;
    private String UserID;
    private userRole Role;
    private String Password;

    public Users() {
    }
    public Users(String username, String UserID, userRole Role, String Password) {
        this.username = username;
        this.UserID = UserID;
        this.Role = Role;
        this.Password = Password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getUserID() {

        return UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public userRole getRole() {

        return Role;
    }

    public void setRole(userRole role) {

        Role = role;
    }

    public String getPassword() {

        return Password;
    }

    public void setPassword(String password) {

        Password = password;
    }
}

