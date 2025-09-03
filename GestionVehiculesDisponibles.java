import java.io.*;
import java.time.LocalDateTime;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * GestionVehiculesDisponibles : Cette classe gère le nombre de véhicules
 * disponibles pour la location dans l'inventaire des véhicules.
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @since 20 avril 2025
 */
public class GestionVehiculesDisponibles {

    // Déclaration des constantes
    private static final String FIC_VEHICULES_DISPONIBLES = "InventaireVehicules.csv";
    private static VehiculeDisponible[] lesVehiculesDipsonibles = new VehiculeDisponible[6];

    /**
     * Lire les données des différents véhicules disponibles dans le fichier
     * InventaireVehicules.csv. Chaque ligne est composée :
     * - Type du véhicule
     * - Grandeur du véhicule
     * - Prix de la location du véhicule par jour
     * - Prix de l'assurance du véhicule par jour
     * - Nombre de véhicules disponibles
     * <p>
     * La première ligne dans ce fichier est la description des autres lignes et
     * elle doit être ignorée lors de la lecture. Les autres lignes de ce fichier
     * sont composées des données ci-dessus mentionnées séparées entre elles par
     * des points-virgules. Voir le fichier InventaireVehicules.csv pour plus de
     * détails.
     * <p>
     * Chacune de ces lignes doit être lue et découpée pour créer un objet de type
     * VehiculeDisponible, et cet objet doit être ajouté dans le tableau des véhicules
     * disponibles.
     */
    public static void lireFichierVehiculesDisponibles() {
        FileReader fluxConnecteur;
        BufferedReader fluxTampon;
        String ligne;
        String[] attributsVehicules;
        int attributsVehiculesDisponibles = 0;

        try {
            // Création d'un flux connecteur
            fluxConnecteur = new FileReader(FIC_VEHICULES_DISPONIBLES);
            // Création d'un flux tampon
            fluxTampon = new BufferedReader(fluxConnecteur);
            // Lire et ignorer la première ligne
            fluxTampon.readLine();

            // lecture ligne par ligne
            while (fluxTampon.ready()) {

                ligne = fluxTampon.readLine(); // Lecture d'une ligne
                attributsVehicules = ligne.split(";"); // Séparation en utilisant ; comme séparateur

                if (attributsVehicules.length == 5) {

                    int i = 0;
                    char typeVehicule = attributsVehicules[i].trim().charAt(0);

                    i = i + 1;
                    char grandeurVehicule = attributsVehicules[i].trim().charAt(0);

                    i = i + 1;
                    float prixLocation = Float.parseFloat(attributsVehicules[i].trim());

                    i = i + 1;
                    float prixAssurance = Float.parseFloat(attributsVehicules[i].trim());

                    i = i + 1;
                    int nombreVehiculeDisponible = Integer.parseInt(attributsVehicules[i].trim());

                    Vehicule vehiculeLigne = new Vehicule(typeVehicule, grandeurVehicule, prixLocation, prixAssurance);
                    lesVehiculesDipsonibles[attributsVehiculesDisponibles++] = new VehiculeDisponible(vehiculeLigne, nombreVehiculeDisponible);
                }
            }
            // Fermeture d'un fichier
            fluxTampon.close();
            fluxConnecteur.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier non trouvé ");

        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
    }


    /**
     * Obtenir le prix de la location du véhicule par jour. Cette méthode doit trouver
     * le véhicule dans le tableau des véhicules disponibles (lesVehiculesDipsonibles)
     * dont le type et la grandeur sont les mêmes que le type et de la grandeur du véhicule
     * passés en paramètres, ensuite elle doit retourner le prix de la location du véhicule
     * par jour.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @return le prix de la location du véhicule par jour ou 0 si aucun véhicule trouvé
     */
    public static float obtenirPrixLocationVehParJour(char typeVehicule, char grandeurVehicule) {
        float prixLocation = 0;
        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {
            if (lesVehiculesDipsonibles[i] != null) { // Vérification si nous avons des véhicules disponibles d'abord
                if (typeVehicule == lesVehiculesDipsonibles[i].getVehicule().getTypeVehicule() && grandeurVehicule == lesVehiculesDipsonibles[i].getVehicule().getGrandeurVehicule()) {
                    prixLocation= lesVehiculesDipsonibles[i].getVehicule().getPrixLocationJour();
                }
            }
        }
        return prixLocation;
    }

    /**
     * Obtenir le prix de l'assurance du véhicule par jour. Cette méthode doit trouver
     * le véhicule dans le tableau des véhicules disponibles (lesVehiculesDipsonibles)
     * dont le type et la grandeur sont les mémes que le type et de la grandeur du véhicule
     * passés en paramètres, ensuite elle doit retourner le prix de l'assurance du véhicule
     * par jour. Si le paramètre "AssuranceEstZero" est true, le prix de l'assurance doit être
     * 0, sinon la méthode retourne le prix de l'assurance trouvé dans le tableau des véhicules
     * disponibles
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @param assuranceEstZero un indicateur pour savoir s'il faut calculer l'assurance ou la mettre
     *                         à 0 ou non
     * @return le prix de l'assurance du véhicule par jour ou 0 si aucun véhicule trouvé
     */
    public static float obtenirPrixAssuranceVehParJour(char typeVehicule, char grandeurVehicule,
                                                       boolean assuranceEstZero) {
        float prixAssurance = 0;
        if (!assuranceEstZero) { // Si false, le client sera chargé l'assurance selon le type et la grandeur du véhicule

            for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {
                if (lesVehiculesDipsonibles[i] != null) {
                    if (typeVehicule == lesVehiculesDipsonibles[i].getVehicule().getTypeVehicule() && grandeurVehicule == lesVehiculesDipsonibles[i].getVehicule().getGrandeurVehicule()) {
                        prixAssurance= lesVehiculesDipsonibles[i].getVehicule().getPrixAssuranceJour();
                    }
                }
            }
        }
        return prixAssurance;
    }

    /**
     * Diminuer le nombre de véhicules disponibles dans le tableau des véhicules disponibles.
     * <p>
     * La méthode doit trouver le véhicule dans le tableau des véhicules disponibles dont
     * le type et la grandeur sont les mêmes que le type et la grandeur passés en paramètres,
     * ensuite elle fait le nombre de véhicules disponibles moins le nombre de véhicules loués.
     * <p>
     * Elle retourne vrai si la diminution a été effectuée avec succès, sinon faux.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @param nbVehiculesLoues le nombre de véhicules loués
     * @return vrai si la diminution est faite, sinon faux
     */
    public static boolean diminuerNbVehiculesDisponibles(char typeVehicule,
                                                         char grandeurVehicule, int nbVehiculesLoues) {
        boolean ok = false;
        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {
            if (lesVehiculesDipsonibles[i] != null) {
                if (typeVehicule == lesVehiculesDipsonibles[i].getVehicule().getTypeVehicule() && grandeurVehicule == lesVehiculesDipsonibles[i].getVehicule().getGrandeurVehicule()) {
                    // Vérifie si nous avons encore de l'espace pour louer le véhicule de type et grandeur choisi
                    if (lesVehiculesDipsonibles[i].getVehiculeDisponible() >= nbVehiculesLoues) {
                        // Calcul pour set au nouveau nombre de véhicules disponible
                        lesVehiculesDipsonibles[i].setVehiculeDisponible((lesVehiculesDipsonibles[i].getVehiculeDisponible() - nbVehiculesLoues));
                        ok= true;
                    }
                }
            }
        }

        return ok;
    }

    /**
     * Obtenir le nombre de véhicules disponibles. Cette méthode doit trouver le véhicule
     * dans le tableau des véhicules disponibles (lesVehiculesDipsonibles) dont le type et
     * la grandeur sont les mêmes que le type et de la grandeur du véhicule passés en
     * paramètres. Ensuite elle doit retourner le nombre de véhciules disponibles.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @return le nombre de véhicules disponibles ou 0 si aucun véhicule trouvé
     */
    public static int obtenirNbVehiculesDisponibles(char typeVehicule, char grandeurVehicule) {
        int nbVehicule=0;
        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {
            if (lesVehiculesDipsonibles[i] != null) {
                Vehicule vehicule = lesVehiculesDipsonibles[i].getVehicule();
                if (vehicule.getTypeVehicule() == typeVehicule && vehicule.getGrandeurVehicule() == grandeurVehicule) {
                    nbVehicule=nbVehicule+ lesVehiculesDipsonibles[i].getVehiculeDisponible();
                }
            }
        }
        // À COMPLÉTER

        return nbVehicule;
    }


    /**
     * Vérifier la disponibilité des véhicules disponibles (lesVehiculesDipsonibles).
     * <p>
     * La méthode doit trouver le véhicule dans le tableau des véhicules disponibles
     * (lesVehiculesDipsonibles) dont le type et la grandeur sont les mêmes que le type
     * et de la grandeur du véhicule passés en paramètres. Ensuite elle doit retourner
     * vrai si le nombre de véhicules loués passé en paramètre (nbVehciculesLoues) est
     * inférieur ou égal au nombre de véhicules disponibles, sinon faux.
     *
     * @param typeVehicule      le type du véhicule
     * @param grandeurVehicule  la grandeur du véhicule
     * @param nbVehciculesLoues le nombre de véhicules dont la disponibilité doit être vérifiée
     * @return vrai si le nombre de véhicules passé en paramètre est inférieur ou égal au
     * nombre de véhicules disponibles, sinon faux.
     */
    public static boolean estDisponible(char typeVehicule,
                                        char grandeurVehicule, int nbVehciculesLoues) {

        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {
            if (lesVehiculesDipsonibles[i] != null) {
                if (typeVehicule == lesVehiculesDipsonibles[i].getVehicule().getTypeVehicule() && grandeurVehicule == lesVehiculesDipsonibles[i].getVehicule().getGrandeurVehicule()) {
                    if (lesVehiculesDipsonibles[i].getVehiculeDisponible() >= nbVehciculesLoues) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Afficher les différents véhicules disponibles dans le tableau des véhicules disponibles.
     * Pour plus de détails sur l'affichage, voir les exemples de la trace d'exécution du
     * programme fournis avec l'énoncé du Travail pratique 3."
     */
    public static void afficher() {
        LocalDateTime dateActuelle = LocalDateTime.now();

        System.out.println("\n" + "---------------------------------------------------------------------------------");
        System.out.println(Facture.NOM_ENTREPRISE);
        System.out.println(" Adresse :   \t" + Facture.ADRESSE);
        System.out.println(" Téléphone : \t" + Facture.TELEPHONE);
        System.out.println(" Date et Heure : " + dateActuelle.format(Facture.FORMATTER));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\n" + " " + "Nombre de véhicules disponibles dans l'inventaire");
        System.out.println(" *************************************************");
        System.out.println(" Grandeur              Hybride      Électrique");
        System.out.println(" *********************************************");
        System.out.println(" Petit          \t \t  " +  obtenirNbVehiculesDisponibles(Vehicule.HYBRIDE, Vehicule.PETIT) + " \t\t"
                + obtenirNbVehiculesDisponibles(Vehicule.ELECTRIQUE, Vehicule.PETIT));
        System.out.println(" Intermédiaire  \t \t  " + obtenirNbVehiculesDisponibles(Vehicule.HYBRIDE, Vehicule.INTERMEDIAIRE)
                + "  \t\t" + obtenirNbVehiculesDisponibles(Vehicule.ELECTRIQUE, Vehicule.INTERMEDIAIRE));
        System.out.println(" Grand           \t\t  " + obtenirNbVehiculesDisponibles(Vehicule.HYBRIDE, Vehicule.GRAND) + "  \t\t"
                + obtenirNbVehiculesDisponibles(Vehicule.ELECTRIQUE, Vehicule.GRAND));
        System.out.println("---------------------------------------------------------------------------------");
        


    }

}
