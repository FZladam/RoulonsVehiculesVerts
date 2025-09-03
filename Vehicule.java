/**
 * I N F 1 1 2 0
 *
 * Vehicule
 * Cette classe Représente un véhicule avec un type, une grandeur, un prix de location par jour
 * et un prix d'assurance par jour.
 *
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM Ali
 * @author LADF17289101    / CHEA82090206
 * @version 03/04/2025
 */

public class Vehicule {
    public static final char HYBRIDE = 'H';
    public static final char ELECTRIQUE = 'E';
    public static final char PETIT = 'P';
    public static final char GRAND = 'G';
    public static final char INTERMEDIAIRE = 'I';
    public static final String TYPE_H = "Hybride";
    public static final String TYPE_E = "Electrique";
    public static final String GRANDEUR_P = "Petit";
    public static final String GRANDEUR_I = "Intermediaire";
    public static final String GRANDEUR_G = "Grand";

    private char typeVehicule;
    private char grandeurVehicule;
    private float prixLocationJour;
    private float prixAssuranceJour;

    /**
     * Constructeur de la classe véhicule
     * @param typeVehicule : Type de véhicule
     * @param grandeurVehicule : Grandeur du véhicule
     * @param prixLocationJour : Prix de location par jour du véhicule
     * @param prixAssuranceJour : Prix de l'assurance par jour du véhicule
     */
    public Vehicule(char typeVehicule, char grandeurVehicule, float prixLocationJour, float prixAssuranceJour) {
        this.typeVehicule = typeVehicule;
        this.grandeurVehicule = grandeurVehicule;
        this.prixLocationJour = prixLocationJour;
        this.prixAssuranceJour = prixAssuranceJour;
    }

    /**
     * Getter du type de véhicule de la classe objet Véhicule
     * @return le type de véhicule
     */
    public char getTypeVehicule() {
        return typeVehicule;
    }

    /**
     * Getter de la grandeur du véhicule de la classe objet Véhicule
     * @return la grandeur de véhicule
     */
    public char getGrandeurVehicule() {
        return grandeurVehicule;
    }

    /**
     * Getteur du prix de location par jour de la classe objet Véhicule
     * @return le prix de location par jour
     */
    public float getPrixLocationJour() {
        return prixLocationJour;
    }

    /**
     * Getteur du prix de l'assurance par jour de la classe objet Véhicule
     * @return le prix de l'assurance par jour
     */
    public float getPrixAssuranceJour() {
        return prixAssuranceJour;
    }

    /**
     * Méthode pour transformer le type de véhicule de char à String
     * @return la description du type de vehicule
     */
    public String obtenirTypeVehicule() {
        String descriptionTypeVehicule = "";
        switch (typeVehicule) {
            case 'H':
                descriptionTypeVehicule = TYPE_H;
                break;
            case 'E':
                descriptionTypeVehicule = TYPE_E;
                break;
        }
        return descriptionTypeVehicule;
    }

    /**
     * Méthode pour transformer la grandeur du véhicule de char à String
     * @return la description de la grandeur du vehicule
     */
    public String obtenirGrandeurVehicule() {
        String descriptionGrandeaurVehicule = "";
        switch (grandeurVehicule) {
            case 'P':
                descriptionGrandeaurVehicule = GRANDEUR_P;
                break;
            case 'I':
                descriptionGrandeaurVehicule = GRANDEUR_I;
                break;
            case 'G':
                descriptionGrandeaurVehicule = GRANDEUR_G;
                break;
        }
        return descriptionGrandeaurVehicule;
    }
}
