package Utilitaires;


public class ProtocoleClient implements IProtocoleClient {
    private String result;
    private String pathFile;
    InterfaceTransport transport;

    public ProtocoleClient(InterfaceTransport transport){
        this.transport = transport;
    }

    public void envoyerDemande(String fileName) throws Exception {
        this.pathFile = fileName;
        this.transport.envoyer(this.pathFile);
        this.result = (String) this.transport.recevoir();
        /*if ((this.result = (String) this.transport.recevoir()).getClass().equals(Exception.class))
            throw new Exception("Problème de lecture/ouverture côté serveur");*/
    }

    public String recevoirResultat() throws Exception {
    	try {
    		return this.result;
    	}catch (Exception e) {
    		throw new Exception("Problème de lecture/ouverture côté serveur");
		}
    }
}
