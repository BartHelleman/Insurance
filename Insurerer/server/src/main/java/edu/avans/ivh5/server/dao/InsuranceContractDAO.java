package edu.avans.ivh5.server.dao;

import edu.avans.ivh5.shared.models.InsuranceContract;
import edu.avans.ivh5.shared.util.DateFormatter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class InsuranceContractDAO implements DAOInterface {

    private final XMLParser XMLParser;

    public InsuranceContractDAO() throws ParserConfigurationException, SAXException, IOException {
        this.XMLParser = new XMLParser("InsuranceContracts.xml", "InsuranceContracts.xsd");
    }

    @Override
    public boolean add(Object item) {
        if (item instanceof InsuranceContract) {
            System.out.println("Return true");
            InsuranceContract insuranceContract = (InsuranceContract) item;
            Element insuranceContractNode = this.XMLParser.createElement("contract");

            Element BSN = this.XMLParser.createElement("BSN");
            Text insuranceContractBSN = this.XMLParser.createTextNode(insuranceContract.getBSN());
            BSN.appendChild(insuranceContractBSN);
            insuranceContractNode.appendChild(BSN);

            Element clientName = this.XMLParser.createElement("clientName");
            Text insuranceContractClientName = this.XMLParser.createTextNode(insuranceContract.getClientName());
            clientName.appendChild(insuranceContractClientName);
            insuranceContractNode.appendChild(clientName);

            Element ownRisk = this.XMLParser.createElement("ownRisk");
            Text insuranceContractOwnRisk = this.XMLParser.createTextNode(String.valueOf(insuranceContract.getOwnRisk()));
            ownRisk.appendChild(insuranceContractOwnRisk);
            insuranceContractNode.appendChild(ownRisk);

            Element insuranceID = this.XMLParser.createElement("insuranceID");
            Text insuranceContractID = this.XMLParser.createTextNode(Integer.toString(insuranceContract.getInsuranceID()));
            insuranceID.appendChild(insuranceContractID);
            insuranceContractNode.appendChild(insuranceID);

            Element startDate = this.XMLParser.createElement("startDate");
            Text insuranceContractStartDate = this.XMLParser.createTextNode(DateFormatter.dateToString(insuranceContract.getStartDate()));
            startDate.appendChild(insuranceContractStartDate);
            insuranceContractNode.appendChild(startDate);

            Element endDate = this.XMLParser.createElement("endDate");
            Text insuranceContractEndDate = this.XMLParser.createTextNode(DateFormatter.dateToString(insuranceContract.getEndDate()));
            endDate.appendChild(insuranceContractEndDate);
            insuranceContractNode.appendChild(endDate);

            this.XMLParser.addNode(insuranceContractNode);
            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        } else {
            System.out.println("Return false");
        }
        return false;
    }

    @Override
    public List<Object> get(Object value) {
        if (value instanceof String) {
            return getInsuranceContract((String) value);
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public boolean change(Object oldObject, Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object searchPattern) {
        List<Object> result = get(searchPattern);

        InsuranceContract contractToDelete;
        if (searchPattern instanceof String) {

            contractToDelete = (InsuranceContract) result.get(0);

            List<Node> nodes = this.XMLParser.findElementsByName("contract", contractToDelete.getBSN());
            nodes.stream().forEach((node) -> {
                this.XMLParser.deleteNode(node);
            });

            DAOInterface.save(this.XMLParser.getXmlFile(), this.XMLParser.getDocument());
            return true;
        }

        return false;
    }

    private List<Object> getInsuranceContract(String searchPattern) {
        List<Object> insuranceContracts = new ArrayList();
        List<Node> insuranceContractNodes = this.XMLParser.findElementsByName("contract", searchPattern);

        if (searchPattern instanceof String) {
            if (!insuranceContractNodes.isEmpty()) {
                for (Node insuranceContractNode : insuranceContractNodes) {
                    String BSN = this.XMLParser.getValueByNodeName(insuranceContractNode, "BSN");
                    String clientName = this.XMLParser.getValueByNodeName(insuranceContractNode, "clientName");
                    BigDecimal ownRisk = new BigDecimal(this.XMLParser.getValueByNodeName(insuranceContractNode, "ownRisk"));
                    int insuranceID = Integer.parseInt(this.XMLParser.getValueByNodeName(insuranceContractNode, "insuranceID"));
                    Date startDate = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(insuranceContractNode, "startDate"));
                    Date endDate = DateFormatter.stringToDate(this.XMLParser.getValueByNodeName(insuranceContractNode, "endDate"));

                    if (searchPattern.equals(BSN)) {
                        insuranceContracts.add(new InsuranceContract(BSN, ownRisk, clientName, insuranceID, startDate, endDate));
                    }
                }
            }
        }
        return insuranceContracts;
    }
}
