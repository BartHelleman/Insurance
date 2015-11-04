/*
 * 
 */
package edu.avans.ivh5.client.main;

import edu.avans.ivh5.client.presentation.LoginGUI;
import java.rmi.*;
import edu.avans.ivh5.shared.util.*;
import edu.avans.ivh5.shared.api.*;
import java.rmi.registry.*;

import org.apache.log4j.*;

/**
 * <p>
 * Client that connects to the given RMI service from the registry and opens a
 * GUI. The RMI registry must be running and the server class must be available
 * in order for this client to work properly.
 * </p>
 * <p>
 * This application requires the properties that were specified in the
 * accompanying properties file. Adjust the properties in the file to change the
 * settings and behavior of this client.
 * </p>
 *
 * @author Robin Schellius
 */
public class RmiMain {

    // Get a logger instance for the current class
    static Logger logger = Logger.getLogger(RmiMain.class);
    private static ClientInterface rmiInterface;

    /**
     * Constructor. Locate the registry, lookup the service name that was
     * provided via the properties file, and instantiate a
     * RemoteMemberAdminManagerClient stub.
     *
     * @param hostname The host where the server is running.
     * @see RemoteMemberAdminClientIF
     */
    public RmiMain(String hostname) {

        System.out.println("Constructor using " + hostname);

        // The service name consists of a group name and a service name.
        // The group name enables finding all services within a given group.
        String service = "/standard";//Settings.props.getProperty(Settings.propRmiServiceGroup)
                //+ Settings.props.getProperty(Settings.propRmiServiceName);

        //RemoteMemberAdminClientIF manager = null;
        try {
            System.out.println("Locate registry on " + hostname);
            Registry registry = LocateRegistry.getRegistry(hostname);
            System.out.println("Found registry");

            System.out.println("Connecting to remote service " + service);
            rmiInterface = (ClientInterface) registry.lookup(service);
            System.out.println("Connected");
        } catch (java.security.AccessControlException e) {
            System.out.println("Could not access registry: " + e.getMessage());
            return;
        } catch (RemoteException e) {
            System.out.println("RemoteException: " + e.getMessage());
            return;
        } catch (NotBoundException e) {
            System.out.println("Service not found: " + e.getMessage());
            return;
        }
        
        LoginGUI gui = new LoginGUI();
    }

    /**
     * Main method setting up this client application.
     *
     * @param args Command line argument identifying the property file. <br/>
     * Format: -properties [filename].
     */
    public static void main(String[] args) {

		// Get the properties file name from the command line, and load the
        // properties.
        if (args.length == 0) {
            String propertiesfile = "resources\\client.properties";//= parseCommandLine(args);
            Settings.loadProperties(propertiesfile);
        } else {
            System.out.println("No properties file was found. Provide a properties file name.");
            System.out.println("Program is exiting.");
            return;
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        // Create the client, and connect it to the given (server) hostname.
        String hostname = "localhost";//System.getProperty(Settings.propRmiHostName);
        new RmiMain(hostname);
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
            System.out.println("Error reading command line parameters.");
            System.out.println("Usage: -properties [filename or URL]");
            System.out.println("       -properties client.properties");
            System.exit(0);
        }
        
        return propertiesfilename;
    }

    public static ClientInterface getRmiInterface() {
        return rmiInterface;
    }
    
    
}
