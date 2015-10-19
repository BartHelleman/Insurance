package edu.avans.ivh5.server.dao;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLParser {

    private File xmlFile;
    private File xsdFile;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;
    
    
    /**
     * 
     * @param xmlFile
     * @param xsdFile
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public XMLParser(File xmlFile, File xsdFile) throws ParserConfigurationException, SAXException, IOException{
        
        this.xmlFile = xmlFile;
        this.xsdFile = xsdFile;
        
        // Validate the XML
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(xsdFile);
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(xmlFile));
        
        // Open the XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
    }

   
    public NodeList getNodes(String name)
    {
        return document.getElementsByTagName(name);
    }
    
    
}
