package user;

public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String uesrGender;
    private String userEmail;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUesrGender() {
        return this.uesrGender;
    }

    public void setUesrGender(String uesrGender) {
        this.uesrGender = uesrGender;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}