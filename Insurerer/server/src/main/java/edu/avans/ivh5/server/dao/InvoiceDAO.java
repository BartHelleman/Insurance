package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.Invoice;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import edu.avans.ivh5.shared.util.DateFormatter;
import java.math.BigDecimal;

public class InvoiceDAO implements DAOInterface {

    private XMLParser XMLParser;

    public InvoiceDAO() throws ParserConfigurationException, SAXException, IOException{
            this.XMLParser = new XMLParser("Invoices.xml", "Invoices.xsd");
    }
    
    @Override
    public boolean add(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get(Object value) {
        if(value instanceof String) {
            return getInvoices((String)value);
        }
        else
            throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Object> getInvoices(String searchPattern) {
        List<Object> invoices = new ArrayList<>();
        List<Node> invoiceNodes = this.XMLParser.findElementsByName("invoice", searchPattern);
        
        for(int i = 0; i < invoiceNodes.size(); i++) {
            Node invoiceNode = invoiceNodes.get(i);
            
            int invoiceNumber = Integer.parseInt(this.XMLParser.getValueByNodeName(invoiceNode, "invoiceNumber"));
            Date date = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(invoiceNode, "date"));
            Date expirationDate = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(invoiceNode, "expirationDate"));
            BigDecimal VAT = new BigDecimal(this.XMLParser.getValueByNodeName(invoiceNode, "VAT"));
            
            invoices.add(new Invoice(invoiceNumber, date, expirationDate, VAT));
        }
        
        return invoices;
    }
    
}
