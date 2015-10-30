package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.models.Invoice;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import edu.avans.ivh5.shared.util.DateFormatter;
import java.math.BigDecimal;
import org.w3c.dom.*;

public class InvoiceDAO implements DAOInterface {

    private XMLParser XMLParser;

    public InvoiceDAO() throws ParserConfigurationException, SAXException, IOException{
            this.XMLParser = new XMLParser("Invoices.xml", "Invoices.xsd");
    }
    
    @Override
    public boolean add(Object item) {
        if(item instanceof Invoice) {
            Invoice invoice = (Invoice)item;
            Element invoiceNode = this.XMLParser.createElement("invoice");
            
            Element invoiceNumber = this.XMLParser.createElement("invoiceNumber");
            Text invoiceNumberText = this.XMLParser.createTextNode(Integer.toString(invoice.getInvoiceNumber()));
            invoiceNumber.appendChild(invoiceNumberText);
            invoiceNode.appendChild(invoiceNumber);
            
            Element invoiceDate = this.XMLParser.createElement("date");
            Text invoiceDateText = this.XMLParser.createTextNode(DateFormatter.dateToString(invoice.getDate()));
            invoiceDate.appendChild(invoiceDateText);
            invoiceNode.appendChild(invoiceDate);
            
            Element expirationDate = this.XMLParser.createElement("expirationDate");
            Text expirationDateText = this.XMLParser.createTextNode(DateFormatter.dateToString(invoice.getExpirationDate()));
            expirationDate.appendChild(expirationDateText);
            invoiceNode.appendChild(expirationDate);
            
            Element VAT = this.XMLParser.createElement("VAT");
            Text VATText = this.XMLParser.createTextNode(invoice.toString());
            VAT.appendChild(VATText);
            invoiceNode.appendChild(VAT);
            
            this.XMLParser.addNode(invoiceNode);
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }
        
        return false;
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
    public boolean delete(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Object> getInvoices(String searchPattern) {
        List<Object> invoices = new ArrayList<>();
        List<Node> invoiceNodes = this.XMLParser.findElementsByName("invoice", searchPattern);
        
        for (Node invoiceNode : invoiceNodes) {
            int invoiceNumber = Integer.parseInt(this.XMLParser.getValueByNodeName(invoiceNode, "invoiceNumber"));
            Date date = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(invoiceNode, "date"));
            Date expirationDate = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(invoiceNode, "expirationDate"));
            BigDecimal VAT = new BigDecimal(this.XMLParser.getValueByNodeName(invoiceNode, "VAT"));
            
            invoices.add(new Invoice(invoiceNumber, date, expirationDate, VAT));
        }
        
        return invoices;
    }
}
