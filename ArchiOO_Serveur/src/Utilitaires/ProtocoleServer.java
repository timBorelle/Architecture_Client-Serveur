package Utilitaires;
import java.io.IOException;
import java.net.Socket;

public class ProtocoleServer implements IProtocoleServer {
    private InterfaceTransport transport;

    /*
     * Constructeur avec injection de d�pendance
     */
    public ProtocoleServer(InterfaceTransport it) throws Exception {
        this.transport = it;
    }
    
    public ProtocoleServer(Socket s) throws Exception {
        this.transport = new Transport(s);
    }

    public String recupererDemande() throws IOException, ClassNotFoundException{
    	return (String) this.transport.recevoir();
    }

    public void envoyerResultat(String result) throws Exception {
    	String processOk = "La lecture a fonctionné voici le résultat : \n" + result;
        this.transport.envoyer(processOk);
    }

}
