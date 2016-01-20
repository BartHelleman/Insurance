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
            Text VATText = this.XMLParser.createTextNode(invoice.getVAT().toString());
            VAT.appendChild(VATText);
            invoiceNode.appendChild(VAT);
            
            Element treatmentStatus = this.XMLParser.createElement("treatmentStatus");
            Text treatmentStatusText = this.XMLParser.createTextNode(invoice.getTreatmentStatus());
            treatmentStatus.appendChild(treatmentStatusText);
            invoiceNode.appendChild(treatmentStatus);
            
            Element BSN = this.XMLParser.createElement("BSN");
            Text BSNText = this.XMLParser.createTextNode(invoice.getBSN());
            BSN.appendChild(BSNText);
            invoiceNode.appendChild(BSN);
            
            Element clientName = this.XMLParser.createElement("clientName");
            Text clientNameText = this.XMLParser.createTextNode(invoice.getClientName());
            clientName.appendChild(clientNameText);
            invoiceNode.appendChild(clientName);
            
            Element clientAddress = this.XMLParser.createElement("clientAddress");
            Text clientAddressText = this.XMLParser.createTextNode(invoice.getClientAddress());
            clientAddress.appendChild(clientAddressText);
            invoiceNode.appendChild(clientAddress);
            
            Element clientPostcodeCity = this.XMLParser.createElement("clientPostcodeCity");
            Text clientPostcodeCityText = this.XMLParser.createTextNode(invoice.getClientPostcodeCity());
            clientPostcodeCity.appendChild(clientPostcodeCityText);
            invoiceNode.appendChild(clientPostcodeCity);
            
            Element companyName = this.XMLParser.createElement("companyName");
            Text companyNameText = this.XMLParser.createTextNode(invoice.getCompanyName());
            companyName.appendChild(companyNameText);
            invoiceNode.appendChild(companyName);
            
            Element companyAddress = this.XMLParser.createElement("companyAddress");
            Text companyAddressText = this.XMLParser.createTextNode(invoice.getCompanyAddress());
            companyAddress.appendChild(companyAddressText);
            invoiceNode.appendChild(companyAddress);
            
            Element companyPostcodeCity = this.XMLParser.createElement("companyPostcodeCity");
            Text companyPostcodeCityText = this.XMLParser.createTextNode(invoice.getCompanyPostcodeCity());
            companyPostcodeCity.appendChild(companyPostcodeCityText);
            invoiceNode.appendChild(companyPostcodeCity);
            
            Element companyKVK = this.XMLParser.createElement("companyKVK");
            Text companyKVKText = this.XMLParser.createTextNode(invoice.getCompanyKVK());
            companyKVK.appendChild(companyKVKText);
            invoiceNode.appendChild(companyKVK);
            
            Element amountSessions = this.XMLParser.createElement("amountSessions");
            Text amountSessionsText = this.XMLParser.createTextNode(invoice.getAmountSessions());
            amountSessions.appendChild(amountSessionsText);
            invoiceNode.appendChild(amountSessions);
            
            Element pricePerSession = this.XMLParser.createElement("pricePerSession");
            Text pricePerSessionText = this.XMLParser.createTextNode(invoice.getPricePerSession());
            pricePerSession.appendChild(pricePerSessionText);
            invoiceNode.appendChild(pricePerSession);
            
            Element treatmentCode = this.XMLParser.createElement("treatmentCode");
            Text treatmentCodeText = this.XMLParser.createTextNode(invoice.getTreatmentCode());
            treatmentCode.appendChild(treatmentCodeText);
            invoiceNode.appendChild(treatmentCode);
            
            Element deductible = this.XMLParser.createElement("deductible");
            Text deductibleText = this.XMLParser.createTextNode(invoice.getDeductible().toString());
            deductible.appendChild(deductibleText);
            invoiceNode.appendChild(deductible);
            
            Element amountToPay = this.XMLParser.createElement("amountToPay");
            Text amountToPayText = this.XMLParser.createTextNode(invoice.getAmountToPay().toString());
            amountToPay.appendChild(amountToPayText);
            invoiceNode.appendChild(amountToPay);
            
            Element paid = this.XMLParser.createElement("paid");
            Text paidText = this.XMLParser.createTextNode(Boolean.toString(invoice.getPaid()));
            paid.appendChild(paidText);
            invoiceNode.appendChild(paid);         
            
            this.XMLParser.addNode(invoiceNode);
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        } else {
            return false;
        }
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
        //if(delete(((Insurance)oldObject)))
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
            String treatmentStatus = this.XMLParser.getValueByNodeName(invoiceNode, "treatmentStatus");
            String BSN = this.XMLParser.getValueByNodeName(invoiceNode, "BSN");
            String clientName = this.XMLParser.getValueByNodeName(invoiceNode, "clientName");
            String clientAddress = this.XMLParser.getValueByNodeName(invoiceNode, "clientAddress");
            String clientPostcodeCity = this.XMLParser.getValueByNodeName(invoiceNode, "clientPostcodeCity");
            String companyName = this.XMLParser.getValueByNodeName(invoiceNode, "companyName");
            String companyAddress = this.XMLParser.getValueByNodeName(invoiceNode, "companyAddress");
            String companyPostcodeCity = this.XMLParser.getValueByNodeName(invoiceNode, "companyPostcodeCity");
            String companyKVK = this.XMLParser.getValueByNodeName(invoiceNode, "companyKVK");
            String amountSessions = this.XMLParser.getValueByNodeName(invoiceNode, "amountSessions");
            String pricePerSession = this.XMLParser.getValueByNodeName(invoiceNode, "pricePerSession");
            String treatmentCode = this.XMLParser.getValueByNodeName(invoiceNode, "treatmentCode");
            BigDecimal deductible = new BigDecimal(this.XMLParser.getValueByNodeName(invoiceNode, "deductible"));
            BigDecimal amountToPay = new BigDecimal(this.XMLParser.getValueByNodeName(invoiceNode, "amountToPay"));
            boolean paid = Boolean.getBoolean(this.XMLParser.getValueByNodeName(invoiceNode, "paid"));
            
            //invoices.add(new Invoice(invoiceNumber, date, expirationDate, VAT,treatmentStatus, null));
            invoices.add(new Invoice(invoiceNumber, date, expirationDate, VAT, treatmentStatus, BSN, clientName, clientAddress, clientPostcodeCity, companyName, companyAddress, companyPostcodeCity, companyKVK, amountSessions, pricePerSession, treatmentCode, deductible, amountToPay, paid));
        }
        
        return invoices;
    }
    
    public int generateInvoiceNumber()
    {
        return new Random().nextInt(1000000);
    }
     
}
