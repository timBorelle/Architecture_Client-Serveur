package Utilitaires;
public interface IProtocoleClient {

    /**
     * Permet d'envoyer le path du fichier à lire
     * @param fileName
     * @throws Exception
     */
    void envoyerDemande(String fileName) throws Exception;

    /**
     * Permet de récupérer le message du serveur
     * @return
     */
    String recevoirResultat() throws Exception;
}
