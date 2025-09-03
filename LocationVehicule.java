/**
 * INF1120
 *
 * Cette classe gère la location de véhicule en stockant dans un objet les informations sur le locataire et le
 * véhicule loué.
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @version 03/04/2025 
 */
public class LocationVehicule {

    public static final int MAXIMUM_LOCATION_VEHICULE = 50;
    private Locataire locataire;
    private VehiculeLoue[] vehiculeLoue = new VehiculeLoue[MAXIMUM_LOCATION_VEHICULE];

    /**
     * Constructeur null
     */
    public LocationVehicule() {
        
    }

    /**
     * Constructeur avec paramètres de la classe de location de véhicule
     * @param locataire : Informations client
     * @param vehiculeLoue : Information sur le véhicule loués
     */
    public LocationVehicule(Locataire locataire, VehiculeLoue[] vehiculeLoue) {
        this.locataire = locataire;
        this.vehiculeLoue = vehiculeLoue;
    }

    /**
     * Setteur pour la classe LocationVehicule faisant appel à l'objet Locataire
     * @param locataire : Information du locataire
     */
    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    /**
     * Getteur des informations de l'objet Locataire
     * @return locataire : Information du lcoataire
     */
    public Locataire getLocataire() {
        return locataire;
    }

    /**
     * Getteur de l'objet VehiculeLoue depuis l'objet LocationVéhicule
     * @return les informations du véhicule loués
     */
    public VehiculeLoue[] getVehiculeLoue() {
        return vehiculeLoue;
    }

    /**
     * Cette méthode sert à obtenir le nombre de types de véhicules loués
     * @return le nombre de véhicules loués et son indice
     */
    public int obtenirNbVehicules() {
        int nombreVehiculeLoue = 0;

            // Boucle qui parcoure le tableau, si elle trouve un indice null : elle n'incrémentera pas le nombreVehiculeLoue
            // et à l'inverse, s'il est !null, on connaîtra notre indice et le nombre de véhicules loués.
            for (int i = 0; i < vehiculeLoue.length; i++) {
                if (vehiculeLoue[i] != null) {
                    nombreVehiculeLoue++;
                }
            }

        return nombreVehiculeLoue;
    }

    /**
     * Cette méthode sert à ajouter un véhicule loué dans le tableau des véhicules loués en s'assurant de l'ajouter à la
     * prochaine position libre.
     * @param vehicule Un véhicule loué.
     * @return Si le véhicule a été ajouté ou non.
     */
    public boolean ajouterVehiculeLoue(VehiculeLoue vehicule) {
        boolean vehiculeAjouter = false;

        for (int i = 0; i < vehiculeLoue.length && (!vehiculeAjouter); i++) {
            if (vehiculeLoue[i] == null) {
                vehiculeLoue[i] = vehicule;
                vehiculeAjouter = true;
            }
        }
        return vehiculeAjouter;
    }

    /**
     * Cette méthode sert à nous retourner la position auquel se trouvent le type et la grandeur du véhicule dans notre tableau
     * @param typeVehicule Le type de véhicule loué
     * @param grandeurVehicule La grandeur du véhicule loué
     * @return la position du véhicule
     */
    public int obtenirPosition(char typeVehicule, char grandeurVehicule) {

        for (int i = 0; i < vehiculeLoue.length; i++) {
            if (vehiculeLoue[i] != null) {
               Vehicule vehicule = vehiculeLoue[i].getVehiculeLoue();
            if (vehicule.getTypeVehicule() == typeVehicule && vehicule.getGrandeurVehicule() == grandeurVehicule) {
                return i;
                }
            }
        }
        return -1;
    }

}
