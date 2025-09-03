/**
 * I N F 1 1 2 0
 *
 * Locataire
 * Cette classe Représente un locataire avec ses informations personnelles.
 *
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM Ali
 * @author LADF17289101    /CHEA82090206
 * @version 03/04/2025
 */

public class Locataire {
    //Declaration des attributs
    private String nom;
    private String prenom;
    private String numTelephone;
    private String numPermisDeConduire;

    /**
     * Constructeur avec paramètres pour l'objet Location
     * @param nom : Le nom du client
     * @param prenom : Le prénom du client
     * @param numTelephone : Le numéro de téléphone du client
     * @param numPermisDeConduire : Le permis de conduire du client
     */
    public Locataire(String nom, String prenom, String numTelephone, String numPermisDeConduire) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTelephone = numTelephone;
        this.numPermisDeConduire = numPermisDeConduire;
    }

    /**
     * Getteur de l'objet Locataire pour avoir le nom
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getteur de l'objet Locataire pour avoir le prénom
     * @return le prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getteur de l'objet Locataire pour avoir le numéro de téléphone
     * @return le numéro de télépohone du client
     */
    public String getNumTelephone() {
        return numTelephone;
    }

    /**
     * Getteur de l'objet Locataire pour avoir le numéro du permis de conduire
     * @return le numéro du permis de conduire du client
     */
    public String getNumPermisDeConduire() {
        return numPermisDeConduire;
    }
}
