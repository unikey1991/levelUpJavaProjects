package lesson47.dto;

import java.io.Serializable;

/**
 * Created by java on 16.05.2017.
 */
public class TargetData implements Serializable {

    private String email;
    private String userName;


    public TargetData(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }

    public TargetData(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
