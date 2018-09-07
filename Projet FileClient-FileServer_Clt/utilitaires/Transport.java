package utilitaires;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Transport implements InterfaceTransport {

    private Socket s = null;
    private ObjectOutputStream out;
    private ObjectInputStream din;
    

    /*
    *   Partie client
    */
    public Transport(String adresse, int port) throws Exception {
        s = new Socket(adresse, port);
        out = new ObjectOutputStream(s.getOutputStream());
        din = new ObjectInputStream(s.getInputStream());
    }

    /*
    *   Partie serveur
    */
    public Transport(Socket socket) throws IOException{
        this.s = socket;
        din = new ObjectInputStream(s.getInputStream());
        out = new ObjectOutputStream(s.getOutputStream());
    }

    public void envoyer(Object object) throws IOException{
        out.writeObject(object);
    }

    public Object recevoir() throws IOException, ClassNotFoundException  {
        return din.readObject();
    }

    public void fermer() throws IOException {
        if (out != null) {
            out.close();
        }
        if (din != null) {
            din.close();
        }
        if (s != null) {
            s.close();
        }
    }
}
