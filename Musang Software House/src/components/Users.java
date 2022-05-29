package components;

public class Users {
    private String userID;
    private String userName;
    private String password;

    public Users(String userID, String userName, String password) {
        super();
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    public Users() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
