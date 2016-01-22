    package edu.avans.ivh5.shared.models;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    public String accountType;

    public User(String username, String password, String accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    
}
