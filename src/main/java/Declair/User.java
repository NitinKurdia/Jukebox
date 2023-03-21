package Declair;

public class User {
    private int userId;
    private String userName;
    private long mobileNumber;
    private String email;

    public User(int userId, String userName, int mobileNumber, String email) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
