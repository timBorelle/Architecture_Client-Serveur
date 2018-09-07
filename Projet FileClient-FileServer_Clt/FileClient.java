import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

import utilitaires.Transport;

public class FileClient {
    private static final int PORT = 1234;

    private static boolean usageOk(String[] argv) {
        if (argv.length != 2) {
            String msg = "usage is: "
                       + "FileClient server-name file-name";
            System.out.println(msg);
            return false;
        } // if
        return true;
    }
    
    public static void main(String[] args) {
        int exitCode = 0;
        
        String[] argv = new String[2]; 
        argv[0] = "localhost";
        argv[1] = "C:\\Users\\tim-b\\eclipse-workspace\\M1\\INF2_Framework_comp_webS\\"
    			+ "architectureClient_Server\\Projet FileClient-FileServer_Clt\\document1.txt";
        if (!usageOk(argv))
          System.exit(1);
        //Socket s = null;
        Transport transport = null;
        try {
            //s = new Socket(argv[0], PORT);
        	transport = new Transport(argv[0], PORT);
        } catch (IOException e) {
            System.err.println("Unable to connect to server");
            e.printStackTrace();
            System.exit(1);
        } // try
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //InputStream in = null;
        Object dataO = null;
        try {
            /*OutputStream out = s.getOutputStream();
        	new PrintStream(out).print(argv[1]+"\n");	// print, write -> transport.envoyer
            int ch;
            in = new BufferedInputStream(s.getInputStream());
            DataInputStream din = new DataInputStream(in);
            String serverStatus = din.readLine();*/	// -> transport.recevoir
        	
        	transport.envoyer(argv[1]);
        	dataO = transport.recevoir();
        	String serverStatus = dataO.toString();
        	System.out.println("Serveur status : "+"\n"+serverStatus+"\n");
            if (serverStatus.startsWith("Bad")) {
                System.out.println ("Bad");
                exitCode = 1;
            } else {
            	System.out.println ("Good");
                /*while((ch = in.read()) >= 0) {
                    System.out.write((char)ch);
                }*/ // while
            	System.out.println(transport.recevoir()); 
            } // if
        } catch (IOException | ClassNotFoundException e) {
            exitCode = 1;
        } finally {
            try {
            	if (transport != null) {
					transport.fermer();
				}
            } catch (IOException e) {
            } // try
        } // try
        System.exit(exitCode);
    } // main(String[])
} // class FileClient
