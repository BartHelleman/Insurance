package edu.avans.ivh5.server.dao;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.lang.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    private File xmlFile;
    private File xsdFile;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    public Document getDocument() {
        return document;
    }
    
    private static final String RESOURCES = "/edu/avans/ivh5/server/resources/";
    /**
     * 
     * @param xmlFile
     * @param xsdFile
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public XMLParser(String xmlFile, String xsdFile) throws ParserConfigurationException, SAXException, IOException{
        
        this.xmlFile = getFileByName(xmlFile);
        this.xsdFile = getFileByName(xsdFile);
        
        // Validate the XML
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(this.xsdFile);
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(this.xmlFile));
        
        // Open the XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(this.xmlFile);
        document.getDocumentElement().normalize();
    }

   
    public NodeList getNodes(String name)
    {
        return document.getDocumentElement().getElementsByTagName(name);
    }
    
    public NodeList getAllNodes()
    {
        return document.getDocumentElement().getChildNodes();
    }
    
    public String getValue(Element element)
    {
        return element.getLastChild().getTextContent().trim();
    }
    
    public List<Node> findElementsByName(String type, String searchPattern)
    {
        ArrayList<Node> nodeList = new ArrayList<>();
        
        NodeList nodes = getNodes(type);
        for(int i = 0; i < nodes.getLength(); i++)
        {
            Node currentNode = nodes.item(i);
            if(!(currentNode instanceof Element))
                continue;
            
            NodeList childNodes = currentNode.getChildNodes();
            for(int j = 0; j < childNodes.getLength(); j++)
            {
                Node childNode = childNodes.item(j);
                if(!(childNode instanceof Element))
                    continue;
                
                String nodeValue = childNode.getLastChild().getTextContent().trim();
                if(nodeValue.contains(searchPattern))
                    nodeList.add(currentNode);
            }
        }
        
        return nodeList;
    }
    
    public String getValueByNodeName(Node beginNode, String name)
    {
        NodeList childNodes = beginNode.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++)
        {
            if(childNodes.item(i).getNodeName().equals(name))
            {
                return getNodeValue(childNodes.item(i));
            }
        }
        
        return null;
    }
    
    private static File getFileByName(String name) throws FileNotFoundException
    {
        URL fileURL = XMLParser.class.getResource("/" + name);
        if(fileURL == null)
            throw new FileNotFoundException("Could not find the specified file");
        
        String filePath = fileURL.getPath();
        //filePath = filePath.replace("file:/", "");
        //String filePath = fileURL.toString();
        return new File(filePath);
    }
    
    public static String getNodeValue(Node node)
    {
        return node.getLastChild().getTextContent().trim();
    }
    
}
