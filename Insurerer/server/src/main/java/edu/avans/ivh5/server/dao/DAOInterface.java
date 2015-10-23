package edu.avans.ivh5.server.dao;

import java.util.List;

public interface DAOInterface {
    boolean add(Object item);
    List<Object> get(Object value);
    boolean change(Object oldObject, Object newObject);
    boolean delete(Object object);
}