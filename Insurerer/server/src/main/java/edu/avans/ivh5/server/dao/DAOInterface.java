package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.User;

public interface DAOInterface{
    boolean add(Object item);
    User get(String username);
    boolean change(Object oldObject, Object newObject);
    boolean delete(Object object);
}