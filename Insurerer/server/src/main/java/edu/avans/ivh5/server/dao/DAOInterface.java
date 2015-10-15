package edu.avans.ivh5.server.dao;

public interface DAOInterface{
    boolean add(Object item);
    boolean get(Object item);
    boolean change(Object oldObject, Object newObject);
    boolean delete(Object object);
}