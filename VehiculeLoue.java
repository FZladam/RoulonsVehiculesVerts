import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * I N F 1 1 2 0
 * <p>
 * VehiculeLoue
 * Cette classe Représente la location d’un véhicules avec des methodes pour calculer le rabais et
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM Ali
 * @author LADF17289101    / CHEA82090206
 * @version 03/04/2025
 */
public class VehiculeLoue {
    public static final float RABAIS = 0.2f;
    public static final byte NBR_JOURS_RABAIS = 15;
    public static final char ELECTRIQUE = 'E';
    public static final char PETIT = 'P';
    public static final char INTERMEDIAIRE = 'I';

    private Vehicule vehiculeLoue;
    private int nbrVehiculeLoue;
    private int nbrJoursLocation;
    private LocalDateTime dateDeLocation = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /**
     * Constructeur de l'objet VehiculeLoué avec 4 paramètres
     *
     * @param vehiculeLoue     : Le véhicule loué
     * @param dateDeLocation   : Date de location
     * @param nbrVehiculeLoue  : Le nombre de véhicule loués
     * @param nbrJoursLocation : Nombre de jour de location
     */
    public VehiculeLoue(Vehicule vehiculeLoue, LocalDateTime dateDeLocation, int nbrVehiculeLoue, int nbrJoursLocation) {
        this.vehiculeLoue = vehiculeLoue;
        this.dateDeLocation = dateDeLocation;
        this.nbrVehiculeLoue = nbrVehiculeLoue;
        this.nbrJoursLocation = nbrJoursLocation;
    }

    //Getteur et setteur

    public Vehicule getVehiculeLoue() {
        return vehiculeLoue;
    }

    public int getNbrVehiculeLoue() {
        return nbrVehiculeLoue;
    }

    public void setNbrVehiculeLoue(int nbrVehiculeLoue) {
        this.nbrVehiculeLoue = nbrVehiculeLoue;
    }

    public int getNbrJoursLocation() {
        return nbrJoursLocation;
    }

    public LocalDateTime getDateDeLocation() {
        return dateDeLocation;
    }

    /**
     * Méthode pour calculer la date de retour en ajoutant le nombre de jours de location à la date de location.
     * @return La date de retour du véhicule
     */
    public LocalDateTime calculerDateRetour() {
        LocalDateTime dateRetour = dateDeLocation.plusDays(nbrJoursLocation).plusHours(3);
        return dateRetour;
    }

    /**
     * Méthode pour calculer un rabais de 20% sur le prix de la location du véhicule par jour si le nombre de jours de location est > 15 jours,
     * le type de vehicule choisi est électrique et la grandeur du véhicule choisi est petit ou intermédiaire
     * @return le rabais 
     */
    public float calculerRabais() {
        float rabaisPrix = 0;
        if (nbrJoursLocation > NBR_JOURS_RABAIS && vehiculeLoue.getTypeVehicule() == ELECTRIQUE &&
                (vehiculeLoue.getGrandeurVehicule() == INTERMEDIAIRE || vehiculeLoue.getGrandeurVehicule() == PETIT)) {
            rabaisPrix = vehiculeLoue.getPrixLocationJour() * RABAIS;
        }
        return rabaisPrix;
    }

}
