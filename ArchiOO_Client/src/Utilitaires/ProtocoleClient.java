package Utilitaires;

import java.io.IOException;

public class ProtocoleClient implements IProtocoleClient {
    InterfaceTransport transport;

    public ProtocoleClient(InterfaceTransport transport){
        this.transport = transport;
    }

    public void envoyerDemande(String fileName) throws IOException {
        this.transport.envoyer(fileName);
    }

    public String recevoirResultat() throws IOException, ClassNotFoundException{
        return (String) this.transport.recevoir();
    }
}
