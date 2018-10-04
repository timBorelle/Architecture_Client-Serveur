import java.io.IOException;

import utilitaires.Transport;

public class ProtocoleClient {

	private static final String ADDRESS = "localhost";
	private static final int PORT = 1234;
	private static final String FILEPATH = "D:\\Master\\INF2\\Architecture_Client-Serveur\\file.txt";


	public static void envoyerDemande(String nomFichier) {
		Transport transport = null; 
		try {
			transport = new Transport(ADDRESS, PORT);
		} catch (IOException e) {
			System.err.println("Unable to connect to server");
			e.printStackTrace();
			System.exit(1);
		} // try
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int exitCode = 0;
		Object dataO = null;
		try {	           
			transport.envoyer(nomFichier);
			dataO = transport.recevoir();
			String serverStatus = dataO.toString();
			System.out.println("Serveur status : "+"\n"+serverStatus+"\n");
			if (serverStatus.startsWith("Bad")) {
				System.out.println ("Bad");
				exitCode = 1;
			} else {
				System.out.println ("Good");
				System.out.println(transport.recevoir()); 
			} 
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
	}

	public static void main(String[] args) {
		//envoyerDemande(FILEPATH);
	}
}