package edu.avans.ivh5.server.dao;

import java.io.File;
import javax.xml.parsers.*;

public class XMLParser {

    private File xmlFile;
    private File xsdFile;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    //private Document document;
    
    public XMLParser(File xmlFile, File xsdFile) throws ParserConfigurationException{
        this.xmlFile = xmlFile;
        this.xsdFile = xsdFile;
        
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }
    
    
}
