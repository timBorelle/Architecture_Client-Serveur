import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

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
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Saisir le nom du ficher (exemple = document1.txt :");
    	String filename = sc.nextLine();
    	
    	String file = new File(filename).getAbsolutePath();
    	ProtocoleClient.envoyerDemande(file);
    } // main(String[])

} // class FileClient
