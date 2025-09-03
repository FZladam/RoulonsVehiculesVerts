import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * INF1120
 *
 * Cette classe gère tout ce qui touche à la facture (calcul, affichage)
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @version 13/04/2025
 */
public class Facture {

    // Déclarations des constantes.
    public static final char DEBIT = 'D';
    public static final char CREDIT = 'C';
    public static final String INFO_DEBIT = "Débit";
    public static final String INFO_CREDIT = "Credit";
    public static final char MASTERCARD = 'M';
    public static final char VISA = 'V';
    public static final String INFO_MASTERCARD = "Mastercard";
    public static final String INFO_VISA = "Visa";
    public static final float TAUX_TPS = 0.05f;
    public static final float TAUX_TVQ = 0.09975f;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public static final String NOM_ENTREPRISE = " Roulons les Véhicules Verts (RVV)";
    public static final String ADRESSE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7";
    public static final String TELEPHONE = "(438) 222-1111";
    public static final String DEVISE = "$";

    // Déclarations des variables.
    private static int compteurFacture = 1;
    private int numeroFacture;
    private char modePaiement;
    private char typeCarteCredit;
    private String numeroCarteCredit;
    private LocalDateTime dateHeureFacture;
    private LocationVehicule locationVehicule;
    private float sousTotal;
    private float montantTPS;
    private float montantTVQ;
    private float montantTotal;

    /**
     * Constructeur de la classe Facture
     * @param dateHeureFacture : Date et l'heure de la transaction
     * @param locationVehicule : Information locataire et véhicule
     * @param modePaiement : Mode de paiement
     */
    public Facture(LocalDateTime dateHeureFacture, LocationVehicule locationVehicule, char modePaiement) {
        this.dateHeureFacture = dateHeureFacture;
        this.locationVehicule = locationVehicule;
        this.modePaiement = modePaiement;
        numeroFacture = compteurFacture++;
    }

    public void setTypeCarteCredit(char typeCarteCredit) {
        this.typeCarteCredit = typeCarteCredit;
    }

    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    public LocalDateTime getDateHeureFacture() {
        return dateHeureFacture;
    }

    public LocationVehicule getLocationVehicule() {
        return locationVehicule;
    }

    public char getModePaiement() {
        return modePaiement;
    }

    public char getTypeCarteCredit() {
        return typeCarteCredit;
    }

    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    public float getSousTotal() {
        return sousTotal;
    }

    public float getMontantTPS() {
        return montantTPS;
    }

    public float getMontantTVQ() {
        return montantTVQ;
    }

    public float getMontantTotal() {
        return montantTotal;
    }
    
    public float getNumeroFacture() {
        return numeroFacture;
    }

    /**
     * Cette méthode sert à obtenir la description du mode de paiement
     *
     * @return Description du mode de paiement
     */
    public String descriptionModeDePaiement() {
        String description;
        char modePaiement = getModePaiement();

        if (modePaiement == DEBIT) {
            description = INFO_DEBIT;
        } else {
            description = INFO_CREDIT;
        }
        return description;
    }

    /**
     * Cette méthode sert à obtenir la description du type de paiement
     *
     * @return Description de la méthode de paiement
     */
    public String descriptionTypeDePaiement() {
        String description;
        char methodePaiement = getTypeCarteCredit();

        if (methodePaiement == MASTERCARD) {
            description = INFO_MASTERCARD;
        } else {
            description = INFO_VISA;
        }
        return description;
    }

    /**
     * Cette méthode sert à calculer le sous-total de la facture en faisant appeler
     * à nos autres classes : VehiculeLoue, LocationVehicule et Vehicule.
     */
    public void calculerSousTotalFacture() {
        float sousTotal = 0;
        float montantLocation = 0;
        float montantAssurance = 0;
        float prixLocation = 0;
        float prixAssuranceJour=0;
        float rabais = 0;
        int nombreJours = 0;
        int nombreVehicules = 0;

        
        VehiculeLoue[] vehiculeLoue = locationVehicule.getVehiculeLoue();

        for (int i = 0; i < vehiculeLoue.length; i++) {
            if (vehiculeLoue[i] != null) {
                Vehicule vehicule = vehiculeLoue[i].getVehiculeLoue();
                prixLocation = vehicule.getPrixLocationJour();
                prixAssuranceJour=vehicule.getPrixAssuranceJour();
                rabais = vehiculeLoue[i].calculerRabais();
                nombreJours = vehiculeLoue[i].getNbrJoursLocation();
                nombreVehicules = vehiculeLoue[i].getNbrVehiculeLoue();
                montantLocation = ((prixLocation - rabais) * nombreJours) * nombreVehicules;
                montantAssurance = (prixAssuranceJour * nombreJours) * nombreVehicules;
                sousTotal += (montantLocation + montantAssurance);
            }
        }
        this.sousTotal = sousTotal; 
    }

    /**
     * Cette méthode sert à calculer le montant de TPS à payer sur le sous-total
     * et l'affecter à l'attribut montantTPS.
     */
    public void calculerMontantTPS() {

        this.montantTPS = TAUX_TPS * sousTotal;
    }

    /**
     * Cette méthode sert à calculer le montant de TVQ à payer sur le sous-total
     * et l'affecter à l'attribut montantTVQ.
     */
    public void calculerMontantTVQ() {
        this.montantTVQ = TAUX_TVQ * sousTotal;
    }

    /**
     * Cette méthode sert à calculer le montant total de la facture et à
     * l'affecter à l'attribut montantTotal
     */
    public void calculerMontantTotal() {
        this.montantTotal = (montantTPS + montantTVQ + sousTotal);
    }

    public void afficherFacture() {
        VehiculeLoue[] vehiculeLoue = locationVehicule.getVehiculeLoue();
        float prixLocation = 0;
        float prixAssurance = 0;
        float montantRabais = 0;
        int nombreJours = 0;
        int nombreVehicule = 0;

                System.out.println("--------------------------------------------------------");
        System.out.println(NOM_ENTREPRISE);
        System.out.println(" Adresse : " + ADRESSE);
        System.out.println(" Téléphone : " + TELEPHONE);
        System.out.println(" Date et heure : " + dateHeureFacture.format(FORMATTER));
        System.out.println(" Facture No : " + numeroFacture);
        System.out.println("--------------------------------------------------------");

        System.out.println("\n" + " Prénom et nom : " + getLocationVehicule().getLocataire().getPrenom() + " " + getLocationVehicule().getLocataire().getNom());
        System.out.println(" Téléphone : " + getLocationVehicule().getLocataire().getNumTelephone());
        System.out.println(" Permis de conduire : " + getLocationVehicule().getLocataire().getNumPermisDeConduire());

        System.out.println("\n" + " Mode de paiement : " + descriptionModeDePaiement());
        if (modePaiement == CREDIT) {
            System.out.println(" Type de la carte de crédit : " + descriptionTypeDePaiement());
            System.out.println(" Numéro de la carte de crédit  XXXX XXXX XXXX: " + numeroCarteCredit.substring(15)+ "\n");
        }

        for (int i = 0; i < vehiculeLoue.length; i++) {
            if (vehiculeLoue[i] != null) {
                Vehicule vehicule = vehiculeLoue[i].getVehiculeLoue();
                prixLocation = vehicule.getPrixLocationJour();
                prixAssurance = vehicule.getPrixAssuranceJour();
                montantRabais = vehiculeLoue[i].calculerRabais();
                nombreJours = vehiculeLoue[i].getNbrJoursLocation();
                nombreVehicule = vehiculeLoue[i].getNbrVehiculeLoue();

                System.out.println("\n" + " Type de véhicule :\t\t  \t" + vehicule.obtenirTypeVehicule());
                System.out.println(" Grandeur du véhicule:\t\t \t " + vehicule.obtenirGrandeurVehicule());
                System.out.println(" Nombre de véhicules loués:\t " + vehiculeLoue[i].getNbrVehiculeLoue());
                System.out.println(" Nombre de jour de location : \t " + vehiculeLoue[i].getNbrJoursLocation());
                System.out.println(" Date de location : " + vehiculeLoue[i].getDateDeLocation().format(FORMATTER));
                System.out.println(" Date de retour : " + vehiculeLoue[i].calculerDateRetour().format(FORMATTER));
                System.out.printf(" Prix de location par jour :\t %2.2f%s \n", vehicule.getPrixLocationJour(), DEVISE);
                if (montantRabais > 0) { // Si notre client est éligible au rabais, on l'affiche dans la facture
                    System.out.printf(" Prix de l'assurance par jour \t :   %2.2f%s\n", vehicule.getPrixAssuranceJour(), DEVISE);
                    
                } else { // Dans le cas contraire, nous affichons seulement le prix de l'assurance
                    System.out.printf(" Prix de l'assurance par jour : %2.2f%s\n", vehicule.getPrixAssuranceJour(), DEVISE);
                }
                System.out.printf(" Montant de location :\t \t %2.2f%s\n",((prixLocation - montantRabais) * nombreJours * nombreVehicule) , DEVISE);
                System.out.printf(" Montant de l'assurance :\t %2.2f%s\n\n", (prixAssurance * nombreJours * nombreVehicule), DEVISE);
            if (montantRabais > 0){
                System.out.printf(" Rabais sur le prix de location : %2.2f%s\n", vehiculeLoue[i].calculerRabais(), DEVISE);

            }
            }
        }

        System.out.printf("\n Sous-total :\t\t \t %2.2f%s\n", sousTotal, DEVISE);
        System.out.printf(" Montant TPS :\t\t \t %2.2f%s\n", montantTPS, DEVISE);
        System.out.printf(" Montant TVQ :\t\t \t %2.2f%s\n", montantTVQ, DEVISE);
        System.out.printf(" Montant Total :\t\t \t %2.2f%s\n", montantTotal, DEVISE);
        System.out.println("--------------------------------------------------------");
        System.out.println(" Merci pour votre confiance !");
        
    }
    

}

