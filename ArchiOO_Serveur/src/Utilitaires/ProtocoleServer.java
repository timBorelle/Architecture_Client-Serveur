package Utilitaires;
import java.net.Socket;

public class ProtocoleServer implements IProtocoleServer {
    //private Transport transport;
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

    public String recupererDemande() {
        try {
            return (String) this.transport.recevoir();
        } catch (Exception e) {
            envoyerErreur(e);
            return null;
        }

    }


    public void envoyerErreur(Exception e) {
        try {
            String erreur = "Une erreur est survenu : \n" + e;
            this.transport.envoyer(erreur);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                this.transport.fermer();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
    }


    public void envoyerResultat(String result) {
        try {
            String processOk = "La lecture a fonctionné voici le résultat : \n" + result;
            this.transport.envoyer(processOk);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.transport.fermer();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

}
