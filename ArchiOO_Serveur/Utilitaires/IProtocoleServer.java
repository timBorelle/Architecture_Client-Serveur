package Utilitaires;

public interface IProtocoleServer {
    /**
     *Méthode permettant de lancer l'exécution du service
     * proposé par le serveur
     */
    String recupererDemande();

    /**
     * Méthode qui retourne une exception si il y a un problème d'execution côté serveur
     * @param e
     */
    void envoyerErreur(Exception e);

    /**
     * Méthode qui retourne le résultat du serveur
     */
    void envoyerResultat(String result);


}
