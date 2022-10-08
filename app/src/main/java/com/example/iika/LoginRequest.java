package com.example.iika;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
//    @SerializedName("cmd")
//    @Expose
//    private String cmd;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public LoginRequest(String email, String password) {
//        this.cmd = cmd;
        this.email = email;
        this.password = password;
    }

//    public String getCmd() {
//        return cmd;
//    }
//
//    public void setCmd(String cmd) {
//        this.cmd = cmd;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
