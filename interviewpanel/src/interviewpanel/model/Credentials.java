package interviewpanel.model;

public class Credentials {
    String userName;
    int password;

    public Credentials(String interviewerName, int interviewerPassword) {
        this.userName=interviewerName;
        this.password=interviewerPassword;
    }

    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public String getUserName()
    {
        return userName;
    }
    public int getPassword()
    {
        return password;
    }

}
