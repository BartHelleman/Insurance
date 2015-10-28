package edu.avans.ivh5.server.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public interface DAOInterface {
    boolean add(Object item);
    List<Object> get(Object value);
    boolean change(Object oldObject, Object newObject);
    boolean delete(Object object);
    
    static void save(File file, Document document) {
        Transformer transformer = null;
        try
        {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch(TransformerException e)
        {
            throw new RuntimeException(e.getMessage());
        }
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        
        try {
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
        } catch(IOException | TransformerException e)
        {
            throw new RuntimeException(e.getMessage());
        }
        
    }
}