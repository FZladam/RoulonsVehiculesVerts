/**
 * INF1120
 *
 * Cette classe permet de connaître les véhicules disponbles.
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @version 03/04/2025
 */
public class VehiculeDisponible {

    private Vehicule vehicule;
    private int vehiculeDisponible;

    /**
     * Constructeur de l'objet Véhicule Disponible avec deux paramètres
     * @param vehicule : Le type de véhicule
     * @param vehiculeDisponible : Le nombre de véhicule disponible
     */
    public VehiculeDisponible(Vehicule vehicule, int vehiculeDisponible) {
        this.vehicule = vehicule;
        this.vehiculeDisponible = vehiculeDisponible;
    }

    // Getteur et setters 
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public int getVehiculeDisponible() {
        return vehiculeDisponible;
    }

    public void setVehiculeDisponible(int vehiculeDisponible) {
        this.vehiculeDisponible = vehiculeDisponible;
    }
}
