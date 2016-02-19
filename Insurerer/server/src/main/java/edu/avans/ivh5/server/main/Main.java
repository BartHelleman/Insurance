/*
 */
package edu.avans.ivh5.server.main;

import edu.avans.ivh5.shared.api.ClientInterface;
import edu.avans.ivh5.server.rmi.ClientImpl;
import edu.avans.ivh5.shared.models.SharedTreatment;
import edu.avans.ivh5.shared.rmi.InsuranceServerInterface;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;
import edu.avans.ivh5.shared.rmi.PhysioServerInterface;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;

import org.apache.log4j.Logger;


/**
 * Creates the stub, which will be remote accessible by the client, and
 * registers it at the rmiregistry by a servicename. Clients can retrieve the
 * remote stub by this servicename.
 *
 * @author Robin Schellius
 */
public class Main {

    // Implements the specific DAO functionality (MySQL, XML).
    // static public String daofactoryclassname;
    // Access to remote manager
    static private ClientInterface stub;
    static private PhysioServerInterface physioInterface;
    static private InsuranceServerInterface insuranceInterface;
    public static final boolean RMI = false;
    // Get a logger instance for the current class
    static Logger logger = Logger.getLogger(Main.class);

    /**
     * Empty constructor
     *
     * @throws RemoteException
     */
    public Main() throws RemoteException, IOException {
        try {
            System.out.println("Constructor");
        } catch(Exception e)
        {
            System.out.println();
            System.in.read();
        }
    }

    /**
     * Initialize the server, register it in the RMI registry, and
     * (automatically) start listening for incoming client calls.
     *
     * @param args Command line arguments indicating the servicename for this
     * server.
     */
    public static void main(String args[]) {

		// Get the properties file name from the command line, and load the
        // properties.
        String propertiesfile = "C:\\xampp\\htdocs\\classes\\standard.properties";
        System.setProperty("java.security.policy", "file://C:/xampp/htdocs/classes/standard.policy");

        /**
         * Install the security manager. The SecurityManager looks for the
         * system property java.security.policy, which points to the se
         */
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        // Configure logging using the given log config file.
        //PropertyConfigurator.configure(Settings.props.getProperty("C:\\Users\\Burak\\Documents\\InsuranceProftaak\\InsuranceIVH5\\Insurerer\\server\\target\\classes\\resources\\standard.logconfig"));
        System.out.println("Starting application");

        try {

            String service = "/standard";
            String otherService = "/other";
            String hostname = "localhost";
            
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            String ip = in.readLine(); //you get the I
            
            System.setProperty("java.rmi.server.hostname", ip);

			// ShutdownHook handles cleaning up the registry when this
            // application exits.
            ShutdownHook shutdownHook = new ShutdownHook(service);
            Runtime.getRuntime().addShutdownHook(shutdownHook);

            System.out.println("Creating stub");
            ClientImpl obj = new ClientImpl();
            ClientImpl obj1 = new ClientImpl();
            stub = (ClientInterface) UnicastRemoteObject.exportObject(obj, 0);
            insuranceInterface = (InsuranceServerInterface)UnicastRemoteObject.exportObject(obj1, 0);

            System.out.println("Locating registry on '" + hostname + "'");
            Registry registry = LocateRegistry.getRegistry(hostname);
            System.out.println("Registering stub using name \"" + service + "\"");
            registry.rebind(service, stub);
            registry.rebind(otherService, insuranceInterface);

            System.out.println("Server ready");
        } catch (java.rmi.ConnectException e) {
            System.out.println("Could not connect: " + e.getMessage());
            System.out.println("(is rmiregistry running?)");
        } catch (java.security.AccessControlException e) {
            System.out.println("No access: " + e.getMessage());
            System.out.println("(is the HTTP webserver running?)");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        InvoiceGeneratorTask task = new InvoiceGeneratorTask();
        
        
        if(RMI) {
            while(true) {
            try {
                // Connect to other system
                String hostname = "145.48.114.166";
                String service = "/other";

                Registry registry = LocateRegistry.getRegistry(hostname);
                physioInterface = (PhysioServerInterface) registry.lookup(service);
                if(physioInterface == null)
                    throw new Exception();
                //Remote r = registry.lookup(service);
                //ArrayList<SharedTreatment> result = physioInterface.getAllFinishedTreatments();
                System.out.println("Done");
                break;
            }
            catch(RemoteException e)
            {
                try{
                    Thread.sleep(3000);
                } catch(Exception ex)
                {
                    
                }
                System.out.println("RemoteException: " + e.getMessage());
            }
            catch(Exception e)
            {
                try{
                    Thread.sleep(3000);
                } catch(Exception ex)
                {
                    
                }
                System.out.println("NotBoundException: " + e.getMessage());
            }
        }
        }
    }

    public static PhysioServerInterface getPhysioInterface() {
        return physioInterface;
    }
    
    

    /**
     * When the server is stopped, by Ctrl-C or closing the window that it is
     * running in, we want to unregister ourselves from the registry and
     * decouple the stub, so that clients cannot find the remote stub without a
     * running server.
     *
     * @throws RemoteException
     */
    public static void exit(String service) throws RemoteException {
        System.out.println("Server is exiting, cleaning up registry.");
        try {
            System.out.println("Unbind servicename " + service);
            Naming.unbind(service);
        } catch (java.net.MalformedURLException e) {
            logger.error("Servicename not found in registry.");
        } catch (java.rmi.NoSuchObjectException e) {
            logger.error("Server not found in registry.");
        } catch (Exception e) {
            logger.error("Could not contact registry.");
        } finally {
            System.out.println("Bye.");
        }
    }

    /**
     * Read the command line and parse the name of the properties file. The
     * properties file contains all required properties for running this
     * application.
     * <p>
     * Options: -properties [filename]
     * </p>
     *
     * @param args The string of options given to this application via the
     * command line.
     */
    private static String parseCommandLine(String[] args) {
        boolean errorFound = false;
        String propertiesfilename = null;

        if (args.length != 2) {
            System.out.println("Error reading options; expected 2 but found "
                    + args.length + ".");
            errorFound = true;
        } else {
            if (args[0].equalsIgnoreCase("-properties")) {
                propertiesfilename = args[1];
            } else {
                errorFound = true;
            }
        }
        if (errorFound) {
            System.out.println("Use: -properties [filename or URL]");
            System.out.println("     -properties \"http://localhost/path/to/file.props\"");
            System.out.println("     -properties \"file:/C:/path/to/server.cnf\"");
        }
        return propertiesfilename;
    }
}

/**
 * ShutdownHook is a way to handle application cleanup in case the process is
 * stopped by an external event, such as the user stopping the program.
 *
 * @see http
 * ://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html#addShutdownHook
 * (java.lang.Thread)
 * @see http://www.onjava.com/pub/a/onjava/2003/03/26/shutdownhook.html
 *
 * @author Robin Schellius
 */
class ShutdownHook extends Thread {

    // The service that we will clean up.
    private String service;

    // Constructor
    public ShutdownHook(String svc) {
        service = svc;
    }

    public void run() {
        try {
            Main.exit(service);
        } catch (RemoteException e) {
            System.out.println("Error exiting: could not contact remote server or registry.");
        }
    }
}
