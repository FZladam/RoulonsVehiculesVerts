import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 *
 * ListeDesFactures : Cette classe gère toutes les factures des différentes locations de
 * véhicules.
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @since 19 avril 2025
 */
public class ListeDesFactures {

    // Déclaration des constantes
    private static final String ENTETE = "Facture No;Date et Heure;"
        + "Prénom et nom;Téléphone;Permis de conduire;"
        + "Mode de paiement;Type de la carte de crédit;"
        + "Numéro de la carte de crédit;Type du véhicule;"
        + "Grandeur du véhicule;Nombre de véhicules loués;" + "Nombre de jours de location;"
        + "Date de location;Date de retour;Prix de la location par jour;"
        + "Rabais sur le prix de location;"
        + "Prix de l'assurance par jour;Montant de la location;"
        + "Montant de l'assurance;Sous-total; Montant TPS;" + "Montant TVQ;Montant total";

    private static final String FIC_FACTURES = "Factures.csv";
    private static final int NB_MAX_FACTURES = 50;

    // Déclaration des variables de classee
    private static int nbFactures = 0;
    private static Facture[] lesFactures = new Facture[NB_MAX_FACTURES];

    /**
     * Ajouter la facture à la prochaine position libre du tableau des factures (lesFactures).
     * Cette position libre doit être inférieure à la taille du tableau des factures. Le nombre
     * courant de factures doit être incrémenter.
     *
     * @param facture la facture à ajouter
     * @return vrai si la facture a été ajouté, sinon faux
     */
    public static boolean ajouterFacture(Facture facture) {
        boolean estAjoute = false;

        if (nbFactures < NB_MAX_FACTURES) {
            lesFactures[nbFactures] = facture;
            nbFactures++;
            estAjoute= true;
        }
        return estAjoute;
    }

    /**
     * Écrire les données de toutes les factures dans le fichier Factures.csv.
     *
     * Les données de chaque ligne doivent être separées entre elles par des
     * points-virgules. Chaque facture doit être affichée sur :
     *   - une seule ligne si le tableau des véhicules loués contient un seul élément.
     *   - 2 lignes si le tableau des véhicules loués contient 2 éléments.
     *   - Ainsi de suite.
     *
     * Les nouvelles données des factures doivent remplacer les anciennes données.
     *
     * Pour plus de détails, voir l'exemple de Factures.csv fourni avec l'énoncé du travail
     * pratique 3.
     *
     */
    public static void ecrireFacture() {
        PrintWriter fluxPrintWriter;

        try {
            fluxPrintWriter = new PrintWriter(FIC_FACTURES);
            String ligne;
            // Écrire l'entête
            fluxPrintWriter.println(ENTETE);

            for (int i = 0; i < nbFactures; i++) {
                Facture facture = lesFactures[i];
                VehiculeLoue[] vehiculesLoues = facture.getLocationVehicule().getVehiculeLoue();

                for (int j = 0; j < vehiculesLoues.length; j++) {
                    if (vehiculesLoues[j] != null) {
                        VehiculeLoue vehiculeLoue = vehiculesLoues[j];
                        Vehicule vehicule = vehiculeLoue.getVehiculeLoue();
                        ligne=facture.getNumeroFacture() + ";" +
                            facture.getDateHeureFacture().format(Facture.FORMATTER) + ";" +
                            facture.getLocationVehicule().getLocataire().getPrenom() + " " +
                            facture.getLocationVehicule().getLocataire().getNom() + ";" +
                            facture.getLocationVehicule().getLocataire().getNumTelephone() + ";" +
                            facture.getLocationVehicule().getLocataire().getNumPermisDeConduire() + ";" +
                            facture.descriptionModeDePaiement() + ";" +
                            (facture.getModePaiement() == Facture.CREDIT ? facture.descriptionTypeDePaiement() : "") + ";" +
                            (facture.getModePaiement() == Facture.CREDIT ? facture.getNumeroCarteCredit() : "") + ";" +
                            vehicule.obtenirTypeVehicule() + ";" +
                            vehicule.obtenirGrandeurVehicule() + ";" +
                            vehiculeLoue.getNbrVehiculeLoue() + ";" +
                            vehiculeLoue.getNbrJoursLocation() + ";" +
                            vehiculeLoue.getDateDeLocation().format(Facture.FORMATTER) + ";" +
                            vehiculeLoue.calculerDateRetour().format(Facture.FORMATTER) + ";" +
                            String.format("%.2f", vehicule.getPrixLocationJour()) + ";" +
                            String.format("%.2f", vehiculeLoue.calculerRabais()) + ";" +
                            String.format("%.2f", vehicule.getPrixAssuranceJour()) + ";" +
                            String.format("%.2f", (vehicule.getPrixLocationJour() - vehiculeLoue.calculerRabais()) *
                            vehiculeLoue.getNbrJoursLocation() * vehiculeLoue.getNbrVehiculeLoue()) + ";" +
                            String.format("%.2f", vehicule.getPrixAssuranceJour() * 
                            vehiculeLoue.getNbrJoursLocation() * vehiculeLoue.getNbrVehiculeLoue()) + ";" +
                            String.format("%.2f", facture.getSousTotal()) + ";" +
                            String.format("%.2f", facture.getMontantTPS()) + ";" +
                            String.format("%.2f", facture.getMontantTVQ()) + ";" +
                            String.format("%.2f", facture.getMontantTotal());
                             fluxPrintWriter.println(ligne);
                    }
                }
            }

            fluxPrintWriter.close();
        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
    }

    // À COMPLÉTER

    /**
     * La méthode doit afficher toutes les factures qui sont dans le tableau des factures.
     * Pour plus de détails sur l'affichage, voir les exemples de la trace d'exécution du
     * programme fournis avec l'énoncé du Travail pratique 3.
     */
    public static void afficher() {

        if (nbFactures==0) {
            System.out.println("\nAucune facture à afficher...");

        }else{
            for (int i = 0; i < nbFactures; i++) {
                lesFactures[i].afficherFacture(); 
                if (i < (nbFactures - 1)) {
                    System.out.print("\nAppuyer sur <ENTREE> pour continuer l'affichage des factures...");
                    Clavier.lireString(); 
                }
            }       
        }

        // À COMPLÉTER

    }
}

