package carrental.model;

import java.util.Objects;

public class Users {
    private String username;
    private String UserID;
    private String Password;
    private userRole Role;
    private String details;

    public Users() {
    }

    public Users(String username, String UserID, userRole Role, String Password, String details) {
        this.username = username;
        this.UserID = UserID;
        this.Role = Role;
        this.Password = Password;
        this.details = "";
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public String toString() {
        return "Users{" +
                "UserID=" + UserID +
                ", username='" + username + '\'' +
                ", role=" + Role +
                '}';
    }
}

