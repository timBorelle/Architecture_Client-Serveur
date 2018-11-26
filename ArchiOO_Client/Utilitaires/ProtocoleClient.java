package Utilitaires;

public class ProtocoleClient implements IProtocoleClient {
    private String result;
    private String pathFile;
    private Transport transport;

    public ProtocoleClient(String adresse, int port) throws Exception {
        this.transport = new Transport(adresse, port);
    }

    public void envoyerDemande(String fileName) throws Exception {
        this.pathFile = fileName;
        this.transport.envoyer(this.pathFile);
        if ((this.result = (String) this.transport.recevoir()).getClass().equals(Exception.class))
            throw new Exception("Problème de lecture/ouverture côté serveur");
    }

    public String recevoirResultat() {
        return this.result;
    }
}
