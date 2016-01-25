package edu.avans.ivh5.client.businesslogic;

import edu.avans.ivh5.client.main.RmiMain;
import edu.avans.ivh5.shared.models.*;

import java.rmi.RemoteException;


public class InsuranceContractManager {

    public InsuranceContract getInsuranceContract(Client client) throws RemoteException {
        return RmiMain.getRmiInterface().getInsuranceContract(client);
    }

    public InsuranceContract addInsuranceContract(InsuranceContract contract) throws RemoteException {
        return RmiMain.getRmiInterface().addInsuranceContract(contract);
    }

    public boolean deleteInsuranceContract(Client client) throws RemoteException {
        return RmiMain.getRmiInterface().deleteInsuranceContract(client);
    }
    
    public boolean changeInvoice(Invoice invoice, Invoice invoices) throws RemoteException {
        return RmiMain.getRmiInterface().changeInvoice(invoice, invoices);
    }
}
