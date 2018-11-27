package Utilitaires;


public class ProtocoleClient implements IProtocoleClient {
    InterfaceTransport transport;

    public ProtocoleClient(InterfaceTransport transport){
        this.transport = transport;
    }

    public void envoyerDemande(String fileName) throws Exception {
        this.transport.envoyer(fileName);
    }

    public String recevoirResultat() throws Exception{
        if (((String) this.transport.recevoir()).getClass().equals(Exception.class))
            throw new Exception("Problème de lecture/ouverture côté serveur");
        else return (String) this.transport.recevoir();
    }
}
