import java.io.File;
import java.util.Scanner;

import Utilitaires.IProtocoleClient;
import Utilitaires.ProtocoleClient;
import Utilitaires.Transport;

public class FileClient {
    private static final int PORT = 1234;
    private static final String ADRESSE = "localhost";


    public static void main(String[] args) {
        int exitCode = 0;
        String contenu;
        IProtocoleClient protocoleClient;
        Scanner sc = null;
        try {
        	protocoleClient = new ProtocoleClient(new Transport(ADRESSE, PORT));
            sc = new Scanner(System.in);
            System.out.println("Saisir le nom du ficher (exemple = C:\\document1.txt) :");
            String filename = sc.nextLine();
            String file = (new File(filename)).getAbsolutePath();
            protocoleClient.envoyerDemande(file);
            contenu = protocoleClient.recevoirResultat();
            System.out.println(contenu);
        } 
        catch (ClassNotFoundException e) {
        	System.out.println(e);
        	exitCode = 10;
        }
        catch (IOException e) {
        	System.out.println(e);
        	exitCode = 5;
        }
        catch (Exception e) {
            System.out.println(e);
            exitCode = 1;
        }
        sc.close();
        System.exit(exitCode);
    }
}
