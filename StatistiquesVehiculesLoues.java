import java.time.LocalDateTime;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * StatistiqueVentes : Cette classe contient le nombre de
 * véhicules hybrides et électriques loués
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @since 20 avril 2025
 */
public class StatistiquesVehiculesLoues {

    // Déclaration des variables de classe
    private static VehiculeLoue[] lesVehiculesLoues = new VehiculeLoue[6];


    /**
     * Augmenter le nombre de véhicules loués par type et par grandeur de véhicule.
     * <p>
     * La méthode doit trouver le véhicule loué dans le tableau des véhicules loués
     * (lesVehiculesLoues) dont le type et la grandeur sont les mêmes que le type
     * et la grandeur du véhicule loué passé en paramètre, ensuite elle doit ajouter
     * le nombre de véhicules loués du véhicule loué passé en paramètre au nombre de véhicule
     * loué dans le tableau des véhicules loués.
     * <p>
     * Si aucun véhicule loué n'est trouvé dans le tableau des véhicules loués qui
     * correspond au véhicule loué passé en paramètre, le véhicule loué passé en
     * paramètre est ajouté dans le tableau des véhicules loués à la prochaine position
     * libre.
     *
     * @param vehiculeLoue le véhicule loué
     */
    public static void augmenterNbVehiculesLoues(VehiculeLoue vehiculeLoue) {
boolean trouveVehiculeLoue=false;
        // Dans le cas où nous avons trouvé la correspondence entre le type et la grandeur du véhicule
        for (int i = 0; i < lesVehiculesLoues.length; i++) {
            if (lesVehiculesLoues[i] != null) {
                if (vehiculeLoue.getVehiculeLoue().getTypeVehicule() == 
                lesVehiculesLoues[i].getVehiculeLoue().getTypeVehicule() && 
                vehiculeLoue.getVehiculeLoue().getGrandeurVehicule() == 
                lesVehiculesLoues[i].getVehiculeLoue().getGrandeurVehicule()) {
                    lesVehiculesLoues[i].setNbrVehiculeLoue((lesVehiculesLoues[i].getNbrVehiculeLoue()+ vehiculeLoue.getNbrVehiculeLoue() ));
trouveVehiculeLoue=true;
                }
            }
        }
        // Si aucun véhicule loué n'est trouvé, nous le rajoutons
        if(!(trouveVehiculeLoue)){
         int i = 0;
    while (i < lesVehiculesLoues.length && lesVehiculesLoues[i] != null) {
        i++;
    }
    if (i < lesVehiculesLoues.length) {
        lesVehiculesLoues[i] = vehiculeLoue;
    }
        }

}

    /**
     * Obtenir le nombre de véhicules loués.
     * <p>
     * La méthode doit trouver le véhicule loué dans le tableau des véhicules loués
     * (lesVehiculesLoues) dont le type et la grandeur sont les mêmes que le type
     * et la grandeur passés en paramètres. Ensuite, elle doit retourner le nombre de
     * véhicules disponibles.
     *
     * @param typeVehicule     le type du véhicule loué
     * @param grandeurVehicule la grandeur du véhicule loué
     * @return le nombre de véhicules disponibles ou 0 si aucun véhicule trouvé
     */
    public static int obtenirNbVehiculesLoues(char typeVehicule, char grandeurVehicule) {
int nbr=0;
        for (int i = 0; i < lesVehiculesLoues.length; i++) {
            if (lesVehiculesLoues[i] != null) {
                // Vérification si nous avons des véhicules disponibles d'abord
                if (typeVehicule == lesVehiculesLoues[i].getVehiculeLoue().getTypeVehicule()
                        && grandeurVehicule == lesVehiculesLoues[i].getVehiculeLoue().getGrandeurVehicule()) {
                    nbr= lesVehiculesLoues[i].getNbrVehiculeLoue();
                }
            }
                   
    }
return nbr;
}

    /**
     * La méthode doit afficher le nombre de véhicules hybrides et électriques
     * loués par type et par grandeur. Pour plus de détails sur l'affichage,
     * voir les exemples de la trace d'exécution du programme fournis avec
     * l'énoncé du Travail pratique 3.
     */
    public static void afficherNbVehiculesLoues() {
        LocalDateTime dateActuelle = LocalDateTime.now();

        System.out.println("\n" + "-----------------------------------------------------------");
        System.out.println(Facture.NOM_ENTREPRISE);
        System.out.println(" Adresse : \t" + Facture.ADRESSE);
        System.out.println(" Téléphone : \t " + Facture.TELEPHONE);
        System.out.println(" Date et Heure : " + dateActuelle.format(Facture.FORMATTER));
        System.out.println("-----------------------------------------------------------");
        System.out.println("\n" + " Nombre de véhicules loués par type et par catégorie");
        System.out.println(" ***************************************************");
        System.out.println(" Grandeur              Hybride      Électrique");
        System.out.println(" *********************************************");
        System.out.println(" Petit         \t \t  " + obtenirNbVehiculesLoues(Vehicule.HYBRIDE, Vehicule.PETIT) + " \t\t"
                + obtenirNbVehiculesLoues(Vehicule.ELECTRIQUE, Vehicule.PETIT));
        System.out.println(" Intermédiaire \t \t  " + obtenirNbVehiculesLoues(Vehicule.HYBRIDE, Vehicule.INTERMEDIAIRE) + " \t\t"
                + obtenirNbVehiculesLoues(Vehicule.ELECTRIQUE, Vehicule.INTERMEDIAIRE));
        System.out.println(" Grand         \t \t  " + obtenirNbVehiculesLoues(Vehicule.HYBRIDE, Vehicule.GRAND) + " \t\t"
                + obtenirNbVehiculesLoues(Vehicule.ELECTRIQUE, Vehicule.GRAND));
        System.out.println("-----------------------------------------------------------");


    }
 }



