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
import java.util.stream.Collectors;

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
     * Initialize the XMLparser
     * @param xmlFile The name of the XML file
     * @param xsdFile The name of the XSD file
     * @throws ParserConfigurationException 
     * @throws SAXException Occurs if the XML, XSD or the actual validation is invalid
     * @throws IOException Occurs if the XML or XSD cannot be found
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

   
    /**
     * Get all nodes with a certain name
     * @param name Name of the node
     * @return List of all the nodes that match the name
     */
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
    
    /**
     * Get a list of nodes that match the type and search pattern
     * @param type The name of the tag that it's in, for example "client"
     * @param searchPattern A string whose value will need to be matched
     * @return 
     */
    public List<Node> findElementsByName(String type, String searchPattern)
    {
        ArrayList<Node> nodeList = new ArrayList<>();
        
        // First get all the nodes with a specific name
        NodeList nodes = getNodes(type);
        
        for(int i = 0; i < nodes.getLength(); i++)
        {
            Node currentNode = nodes.item(i);
            if(!(currentNode instanceof Element))
                continue;
            
            // Get the sub/child nodes of the current node
            NodeList childNodes = currentNode.getChildNodes();
            
            for(int j = 0; j < childNodes.getLength(); j++)
            {
                Node childNode = childNodes.item(j);
                if(!(childNode instanceof Element))
                    continue;
                
                // If any of the values match the string, this is the node that we need
                String nodeValue = getNodeValue(childNode);
                if(nodeValue.contains(searchPattern))
                    nodeList.add(currentNode);
            }
        }
        
        // Turn the list into a stream, select all the distinct (aka unique) items, then turn it back into a list
        return nodeList.stream().distinct().collect(Collectors.toList());
    }
    
    /**
     * Looks inside a node for an element with a specific name and returns its value
     * @param beginNode The node where to look for the element
     * @param name The name of the element 
     * @return The value of the element
     */
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
    
    public Element createElement(String elementName)
    {
        return document.createElement(elementName);
    }
    
    public Text createTextNode(String value)
    {
        return document.createTextNode(value);
    }
    
    /**
     * Every document has the same structure. This node will be appended at the end of the first child node.
     * @param nodeToAdd The contents of the node that will be appended
     */
    public void addNode(Node nodeToAdd)
    {
        NodeList allNodes = getAllNodes();
        
        for(int i = 0; i < allNodes.getLength(); i++) {
            Node currentNode = allNodes.item(i);
            if(currentNode instanceof Element) {
                currentNode.getParentNode().appendChild(nodeToAdd);
                break;
            }
        }
    }

    public File getXmlFile() {
        return xmlFile;
    }

    public File getXsdFile() {
        return xsdFile;
    }
    
    
    
    /**
     * Gets the full file path based on just the name of the XML
     * This assumes the location is in a specific folder
     * @param name Name of the file to find
     * @return Absolute path of the file
     * @throws FileNotFoundException is thrown when the file cannot be found
     */
    private static File getFileByName(String name) throws FileNotFoundException
    {
        URL fileURL = XMLParser.class.getResource("/" + name);
        if(fileURL == null)
            throw new FileNotFoundException("Could not find the specified file");
        
        String filePath = fileURL.getPath();
        return new File(filePath);
    }
    
    
    /**
     * Gets the value of a very specific node
     * @param node The node whose value will be retrieved
     * @return The value of the node
     */
    public static String getNodeValue(Node node)
    {
        return node.getLastChild().getTextContent().trim();
    }
    
}
