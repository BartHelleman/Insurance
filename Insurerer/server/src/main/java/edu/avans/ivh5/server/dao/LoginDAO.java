package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.User;

public class LoginDAO implements DAOInterface {

    @Override
    public boolean add(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //haal hier het account op
        //nu even hardcoded
        String name = "Rico";
        String password = "Bakels";
                
        //maak er nu een object van
        
        User ricoUser = new User(name, password);
        
        return ricoUser;
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
