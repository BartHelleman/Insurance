package edu.avans.ivh5.client.businesslogic;

public class LoginManager {

    public void login(String username, String password){
        if(isLoginValid(username, password)) {
            // Login succesful
            
        } 
        else {
            // Login unsuccesful
            
        }
    }
    
    public boolean isLoginValid(String username, String password) {
        return false;
    }
    
    public void logout(){
        
    }
}
