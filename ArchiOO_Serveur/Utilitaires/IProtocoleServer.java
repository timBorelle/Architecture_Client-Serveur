package Utilitaires;

public interface IProtocoleServer {
    /**
     *Méthode permettant de lancer l'exécution du service
     * proposé par le serveur
     */
    String recupererDemande() throws Exception;


    /**
     * Méthode qui retourne le résultat du serveur
     */
    void envoyerResultat(String result) throws Exception;


}
