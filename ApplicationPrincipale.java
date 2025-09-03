
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * Classe ApplicationPrincipale contient les méthodes d'affichage de menus, de saisies et de
 * validations. Également elle contient la méthode "main". Cette classe permet de tester toutes
 * les autres classes en créant des objets et en appelant leurs méthodes lors de l'application
 * des règles d'affaires liées aux différentes options du menu principal.
 *
 * @author LADAM FATIMA ZAHRA et CHEMAM ALI
 * @author LADF17289101 / CHEA82090206
 * @since 20 avril 2025
 */

public class ApplicationPrincipale {

    public static final String MSG_ANNULATION = "\n  La location des véhicules de type %c et de grandeur %c est annulée...\n";

    // TOUTES LES CONSTANTES SONT DISTRIBUÉES DANS LES DIFFÉRENTES
    // CLASSES. ICI JE VEUX JUSTE VOIR LES CONSTANTES SUIVANTES :
    //  - LES VALEURS ENTIÈRES POUR VALIDER LE CHOIX DU MENU.
    //  - LES VALEURS ENTIÈRES POUR VALIDER LA SAISIE DU NOM, DU PRÉNOM, DU NUMÉRO DE TÉLÉPHONE DU LOCATAIRE .
    //  - LES VALEURS ENTIÈRES POUR VALIDER LA SAISIE DU NOMBRE DE JOURS DE LOCATION ET DU NOMBRE DE VÉHICULES À LOUER.
    public static final int MIN_CHOIX = 1;
    public static final int MAX_CHOIX = 5;
    public static final int MIN_NOM_PRE = 2;
    public static final int MAX_NOM_PRE = 30;
    public static final int MAX_TEL = 14;
    public static final int MIN_JOUR = 0;
    public static final int MAX_JOUR = 30;
    public static final int MIN_NBR_VEH = 0;
    public static final int MAX_NBR_VEH = 5;

    // *** À COMPLÉTER

    /****************************************************************************************************
    AJOUTEZ TOUTES VOS MÉTHODES "public" et "static" SUIVANTES DÉFINIES DANS LE TRAVAIL PRATIQUE 2.
    1)  Affichage du message de bienvenue
    2)  Saisie et validation de l’option choisie par l’utilisateur
    3)  Saisie et validation du prénom du locataire
    4)  Saisie et validation du nom du locataire
    5)  Saisie et validation du numéro de téléphone du locataire
    6)  Saisie et validation du numéro de permis de conduire
    7)  Saisie et validation du type de véhicule
    8)  Saisie et validation de la grandeur du véhicule
    9)  Saisie et validation du nombre de jours de location
    10) Saisie et validation du mode de paiement
    11) Saisie et validation du type de la carte de crédit
    12) Saisie et validation du numéro de la carte de crédit
    13) Saisie et validation de la réponse de la question si le locataire veut une assurance
    14) Saisie et validation du nombre de véhicules loués
    15) Saisie et validation de la réponse de la question si le locataire veut louer un autre
    type et une autre grandeur de véhicule
    16) Demander à l’utilisateur d’appuyer sur <ENTRÉE> pour réafficher le menu principal
     *********************************************************************************************************/
    // *** À COMPLÉTER
    //

    //Afficher le message de bienvenue
    public static void afficherLeMessageDeBienvenue() {

        System.out.println("\n_____________________________________________________________________________" +
            "\nBienvenue dans le système de facturation de Roulons des véhicules verts (RVV)" +
            "\n_____________________________________________________________________________");
    }

    //Afficher le menu et valider le choix de l'utilisateur
    public static int saisirEtValider() {
        String msgErreur = "L’option choisie est invalide! ";
        String menu = "\n*** Menu de choix *** " +
            "\n1.Facturer la location d'un véhicule " +
            "\n2.Afficher le nombre de véhicules hybrides et électriques loués " +
            "\n3.Afficher l'inventaire des véhicules " +
            "\n4.Afficher toutes les factures" +
            "\n5.Quitter le programme" +
            "\n\n" +
            "\nEntrez votre choix :  ";

        int choixMenu = 0;
        System.out.print("\n" + menu);
        try {
            choixMenu = Clavier.lireInt();
            while (choixMenu < MIN_CHOIX || choixMenu > MAX_CHOIX) {
                System.out.println("\n" + msgErreur + "\n");
                System.out.print(menu);
                choixMenu = Clavier.lireInt();

            }
        } catch (NumberFormatException e) {
            System.out.println("\n" + msgErreur + "\n");
        }
        return choixMenu;

    }

    public static String saisirEtValiderLePrenom() {
        String msgErreur = "Le prénom est invalide!";
        String prenom;
        String demanderPrenom = "Entrez le prénom du locataire (entre 2 et 30 caractères inclusivement):";

        System.out.print("\n" +demanderPrenom);
        prenom = Clavier.lireString();
        if (prenom != null) {
            prenom = prenom.trim();
        }
        System.out.println("\n");
        while (prenom == null || prenom.length() < MIN_NOM_PRE || prenom.length() > MAX_NOM_PRE) {
            System.out.println("\n" + msgErreur);
            System.out.print(demanderPrenom);
            prenom = Clavier.lireString();
            if (prenom != null) {
                prenom = prenom.trim();
            }
            System.out.println("\n");
        }
        return prenom;
    }

    /**
     * Saisit et valide le nom du client.
     *
     * @return le nom valide
     */
    public static String saisirEtValideLeNom() {
        String msgErreur = "Le nom est invalide!";
        String nom;
        String demanderNom = "Entrez le nom du locataire (entre 2 et 30 caractères inclusivement):";
        System.out.print(demanderNom);
        nom = Clavier.lireString();
        if (nom != null) {
            nom = nom.trim();
        }
        System.out.println("\n");
        while (nom == null || nom.length() < MIN_NOM_PRE || nom.length() > MAX_NOM_PRE) {
            System.out.println("\n" + msgErreur);
            System.out.print(demanderNom);
            nom = Clavier.lireString();
            if (nom != null) {
                nom = nom.trim();
            }
            System.out.println("\n");
        }
        return nom;
    }

    /**
     * Saisit et valide le numero de telephone du client.
     *
     * @return le numero de telephone valide
     */
    public static String saisirEtValiderLeNuméroDeTelephone() {
        String msgErreur = "Le numéro de téléphone est invalide!";
        String num;
        String demanderTel = "Entrez le numéro de téléphone du locataire (Exemple : (514) 784-6589): ";
        System.out.print(demanderTel);
        num = Clavier.lireString();
        if (num != null) {
            num = num.trim();
        }
        System.out.println("\n");
        while (num == null || num.length() != MAX_TEL || num.charAt(0) != '(' || num.charAt(4) != ')'
        || validerNumTel(num) == false || num.charAt(5) != ' ' || num.charAt(9) != '-') {
            System.out.print("\n" + msgErreur+"\n");
            System.out.print("\n" + demanderTel);
            num = Clavier.lireString();
            if (num != null) {
                num = num.trim();
            }
            System.out.println("\n");
        }
        return num;
    }

    /**
     * Saisit et valide le numero de permis de conduire du client.
     *
     * @return le numero de permis de conduire valide
     */
    public static String saisieEtValidationDuNuméroDePermisDeConduire() {
        String msgErreur = "Le numéro de permis de conduire est invalide!";
        String demanderPermis = "Entrez le numéro de permis de conduire du locataire (Exemple : D1234-567891-23): ";

        String numPermis;

        System.out.print(demanderPermis);
        numPermis = Clavier.lireString();
        if (numPermis != null) {
            numPermis = numPermis.trim();
        }
        System.out.println("\n");
        while (numPermis == null || numPermis.length() != 15 || !Character.isLetter(numPermis.charAt(0))
        || validerNumPermis(numPermis) == false || numPermis.charAt(5) != '-' || numPermis.charAt(12) != '-') {
            System.out.print("\n" + msgErreur+"\n");
            System.out.print("\n" + demanderPermis);
            numPermis = Clavier.lireString();
            if (numPermis != null) {
                numPermis = numPermis.trim();
            }
            System.out.println("\n");
        }
        return numPermis;
    }

    /**
     * Saisit et valide le type de vehicule.
     *
     * @return le type de vehicule valide
     */
    public static char saisirEtValiderLeTypeDeVehicule() {

        String msgErreur = "Le type de véhicule est invalide!";
        String demanderType = "Entrez le type du véhicule à louer" +
            "\n(H ou h pour Hybride, et E ou e pour Électrique) :   ";
        char typeVehicule;
        System.out.print("\n" + demanderType);
        typeVehicule = Clavier.lireCharLn();
        typeVehicule = Character.toUpperCase(typeVehicule);
        //System.out.println("\n");
        while (typeVehicule != 'E' && typeVehicule != 'H') {
            System.out.print("\n" + msgErreur+"\n");
            System.out.print("\n" + demanderType);
            typeVehicule = Clavier.lireCharLn();
            typeVehicule = Character.toUpperCase(typeVehicule);
            System.out.println("\n");
        }
        return typeVehicule;
    }

    /**
     * Saisit et valide la grandeur de vehicule.
     *
     * @return la grandeur de vehicule valide
     */
    public static char saisirEtValiderLaGrandeurDuVehicule() {
        String msgErreur = "La grandeur de véhicule est invalide!";
        String demanderGrandeur = "Entrez la grandeur du véhicule à louer" +
            "\n (P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :   ";
        char grandeurVehicule;
        System.out.print("\n"+demanderGrandeur);
        grandeurVehicule = Clavier.lireCharLn();
        grandeurVehicule = Character.toUpperCase(grandeurVehicule);

        while (grandeurVehicule != 'P' && grandeurVehicule != 'I' && grandeurVehicule != 'G') {
            System.out.print("\n" + msgErreur);
            System.out.print("\n \n " + demanderGrandeur);
            grandeurVehicule = Clavier.lireCharLn();
            grandeurVehicule = Character.toUpperCase(grandeurVehicule);
            System.out.println("\n");
        }
        return grandeurVehicule;
    }

    public static int saisirEtValiderLeNombreDeJoursDeLocation() {
        String msgErreur = "Le nombre de jours de location est invalide!";
        String demanderNbrJourLocation = " Entrez le nombre de jours de location" +
            "\n(supérieur à 0 et inférieur ou égal à 30) :   ";

        int nbrJoursLocation = 0;
        do {
            System.out.print("\n" +demanderNbrJourLocation);

            try {
                nbrJoursLocation = Clavier.lireInt();
                System.out.println("\n");
                while (nbrJoursLocation <= MIN_JOUR || nbrJoursLocation > MAX_JOUR) {
                    System.out.println("\n" + msgErreur);
                    System.out.print("\n" +demanderNbrJourLocation);
                    nbrJoursLocation = Clavier.lireInt();
                    System.out.println("\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n" + msgErreur + "\n");
            }
        } while (nbrJoursLocation <= MIN_JOUR || nbrJoursLocation > MAX_JOUR);

        return nbrJoursLocation;
    }

    /**
     * Saisit et valide le mode de paiement.
     *
     * @return le mode de paiement valide
     */
    public static char saisirEtValiderLeModeDePaiement() {
        String msgErreur = "Le mode de paiement est invalide!";
        String demanderModePaiement = " Entrez le mode de paiement" +
            "\n(D ou d pour Débit, C ou c pour Crédit):   ";

        char modePaiement;
        System.out.print(demanderModePaiement);
        modePaiement = Clavier.lireCharLn();
        modePaiement = Character.toUpperCase(modePaiement);
        System.out.println("\n");
        while (modePaiement != 'D' && modePaiement != 'C') {
            System.out.println("\n" + msgErreur);
            System.out.print("\n" + demanderModePaiement);
            modePaiement = Clavier.lireCharLn();
            modePaiement = Character.toUpperCase(modePaiement);
            System.out.println("\n");
        }
        return modePaiement;
    }

    /**
     * Saisit et valide le type de la carte credit.
     *
     * @return le type de la carte credit valide
     */
    public static char saisirEtValiderLeTypeDeLaCarteDeCredit() {
        String msgErreur = "Le type de la carte de crédit est invalide!";
        String demanderTypeCarte = "Entrez le type de la carte de crédit" +
            "\n (V ou v pour Visa, et M ou m pour MasterCard):   ";

        char typeCarte;
        System.out.println(demanderTypeCarte);
        typeCarte = Clavier.lireCharLn();
        typeCarte = Character.toUpperCase(typeCarte);
        System.out.println("\n");
        while (typeCarte != 'V' && typeCarte != 'M') {
            System.out.println("\n" + msgErreur);
            System.out.print("\n" + demanderTypeCarte);
            typeCarte = Clavier.lireCharLn();
            typeCarte = Character.toUpperCase(typeCarte);
            System.out.println("\n");
        }
        return typeCarte;
    }

    /**
     * Saisit et valide le numero de la carte credit.
     *
     * @return le numero de la carte credit valide
     */
    public static String saisirEtValiderLeNumeroDeLaCarteDeCredit() {
        String msgErreur = "Le numéro de la carte de crédit est invalide!";
        String demanderNumCarte = "Entrez le numéro de la carte de crédit (Exemple : 1234 5678 9123 4567) :   ";
        String numCarte;
        System.out.print(demanderNumCarte);
        numCarte = Clavier.lireString();
        if (numCarte != null) {
            numCarte = numCarte.trim();
        }
        System.out.println("\n");
        while (numCarte.length() != 19 || validerNumCarte(numCarte) == false || numCarte.charAt(4) != ' ' || numCarte.charAt(9) != ' '
        || numCarte.charAt(14) != ' ') {
            System.out.print("\n" + msgErreur);
            System.out.print("\n" + demanderNumCarte);
            numCarte = Clavier.lireString();
            if (numCarte != null) {
                numCarte = numCarte.trim();
            }
            System.out.println("\n");
        }
        return numCarte;
    }

    /**
     * Saisit et valide le choix de l'assurance.
     *
     * @return le choix de l'assurance valide
     */
    public static char saisirEtValiderLaReponseAutreVehicule() {
        String msgErreur = " La réponse est invalide!";
        String demanderAutreVehicule = "Désirez-vous louer d'autres véhicules\n" +
            "  (O ou o pour Oui, N ou n pour Non) ? :   ";
        char choixAutreVehicule;
        System.out.print("\n" + demanderAutreVehicule);
        choixAutreVehicule = Clavier.lireCharLn();
        choixAutreVehicule = Character.toUpperCase(choixAutreVehicule);

        while (choixAutreVehicule != 'O' && choixAutreVehicule != 'N') {
            System.out.println("\n" + msgErreur);
            System.out.print("\n" + demanderAutreVehicule);
            choixAutreVehicule = Clavier.lireCharLn();
            choixAutreVehicule = Character.toUpperCase(choixAutreVehicule);
            System.out.println("\n");
        }
        return choixAutreVehicule;
    }

    public static int saisirEtValiderNbrDeVehiculeALoue(char typeVehicule, char grandeurVehicule) {
        String msgErreur = "Le nombre de véhicules à louer est invalide!";
        String demanderNbrVehiculeLoue = "Entrez le nombre de véhicules à louer\n" +
            "  (0 à 5 inclusivement) :   ";

        int nbrDeVehiculeALoue = -1;
        boolean valide;

        do {

            try {
                do{
                    valide=false;

                    System.out.print("\n" + demanderNbrVehiculeLoue);
                    nbrDeVehiculeALoue = Clavier.lireInt();
                    while (nbrDeVehiculeALoue < MIN_NBR_VEH || nbrDeVehiculeALoue > MAX_NBR_VEH) {
                        System.out.println("\n" + msgErreur + "\n");
                        System.out.print(demanderNbrVehiculeLoue);
                        nbrDeVehiculeALoue = Clavier.lireInt();

                    }
                    if (nbrDeVehiculeALoue > GestionVehiculesDisponibles.obtenirNbVehiculesDisponibles(typeVehicule, grandeurVehicule)) {
                        System.out.println("\n  Le nombre de véhicules à louer (" + nbrDeVehiculeALoue + ") est supérieur au nombre de véhicules disponibles(" +
                            GestionVehiculesDisponibles.obtenirNbVehiculesDisponibles(typeVehicule, grandeurVehicule) + ")\n");
                        valide=true;
                    }
                }while (nbrDeVehiculeALoue != 0 && (valide));
            } catch (NumberFormatException e) {
                System.out.println("\n" + msgErreur + "\n");
                valide=true;
            }
        }while ((nbrDeVehiculeALoue <0 || nbrDeVehiculeALoue > 5)&&(valide));
        return nbrDeVehiculeALoue;
    } 

    public static boolean saisirEtValiderLaReponseAssurance() {
        String msgErreur = " La réponse est invalide!";
        String demanderAssurance = "Désirez-vous prendre l'assurance" +
            "\n(O ou o pour Oui, N ou n pour Non) ? :   ";
        char choixAssurance;
        boolean assuranceEstZero = true;
        System.out.print("\n" + demanderAssurance);
        choixAssurance = Clavier.lireCharLn();
        choixAssurance = Character.toUpperCase(choixAssurance);
        System.out.println("\n");
        while (choixAssurance != 'O' && choixAssurance != 'N') {
            System.out.println("\n" + msgErreur);
            System.out.print("\n" + demanderAssurance);
            choixAssurance = Clavier.lireCharLn();
            choixAssurance = Character.toUpperCase(choixAssurance);
            System.out.println("\n");
        }
        if (choixAssurance == 'O') {
            assuranceEstZero = false;
        }
        return assuranceEstZero;
    }

    public static void demanderReafficherMenu() {
        System.out.print("\nAppuyer sur <ENTREE> pour réafficher le menu...");
        Clavier.lireString();
    }

    private static boolean validerNumTel(String num) {
        boolean valide = true;
        if (num.length() == MAX_TEL) {
            for (int i = 1; i <= 3; i++) {
                if (!Character.isDigit(num.charAt(i)))
                    valide = false;
            }
            for (int i = 6; i <= 8; i++) {
                if (!Character.isDigit(num.charAt(i)))
                    valide = false;
            }
            for (int i = 10; i <= 13; i++) {
                if (!Character.isDigit(num.charAt(i)))
                    valide = false;
            }
        } else {
            valide = false;
        }
        return valide;
    }

    /**
     * Verifier et valider le numero du permis de conduire
     *
     * @return true si le numero est valide sinon false
     */
    private static boolean validerNumPermis(String numPermis) {
        boolean valide = true;
        if (numPermis.length() == 15) {
            for (int i = 1; i <= 4; i++) {
                if (!Character.isDigit(numPermis.charAt(i)))
                    valide = false;
            }
            for (int i = 6; i <= 11; i++) {
                if (!Character.isDigit(numPermis.charAt(i)))
                    valide = false;
            }
            for (int i = 13; i <= 14; i++) {
                if (!Character.isDigit(numPermis.charAt(i)))
                    valide = false;
            }
        }
        return valide;
    }

    /**
     * Verifier et valider le numero de la carte credit
     *
     * @return true si le numero est valide sinon false
     */
    private static boolean validerNumCarte(String num) {
        boolean valide = true;
        for (int i = 0; i <= 3; i++) {
            if (!Character.isDigit(num.charAt(i)))
                valide = false;
        }
        for (int i = 5; i <= 8; i++) {
            if (!Character.isDigit(num.charAt(i)))
                valide = false;
        }
        for (int i = 10; i <= 13; i++) {
            if (!Character.isDigit(num.charAt(i)))
                valide = false;
        }
        for (int i = 15; i <= 18; i++) {
            if (!Character.isDigit(num.charAt(i)))
                valide = false;
        }
        return valide;
    }

    public static void main(String[] args) {
        // Déclaration des variables
        boolean sortie;
        int choixMenu;
        int nbVehiculesALouer;
        char typeVehicule;
        char grandeurVehicule;
        char reponse = ' ';

        Locataire locataire;
        VehiculeLoue vehiculeLoue;
        LocationVehicule locationVehicule;
        LocalDateTime dateFacture;
        Facture facture;

        // AJOUTEZ LES VARIABLES LOCALES MANQUANTES
        // *** À COMPLÉTER

        boolean deminuerNbrDeVehiculeALoue;
        boolean choixAssurance;
        boolean vehiculeAjouter;
        int nbrJoursLocation;
        float prixLocationJour;
        float prixAssurance;
        char modePaiement;
        char typeCarte;
        String prenomLocataire;
        String nomLocataire;
        String numTel;
        String numPermis;
        String numCarte;

        // Lire les données des véhicules disponibles dans l'inventaire
        GestionVehiculesDisponibles.lireFichierVehiculesDisponibles();

        // APPELEZ LA MÉTHODE QUI AFFICHE LE MESSAGE DE BIENVENUE
        afficherLeMessageDeBienvenue();

        // *** À COMPLÉTER

        /***************************************************
         * Début du programme
         **************************************************/

        sortie = false;

        do {

            // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE L'OPTION CHOISIE PAR L'UTILISATEUR.
            // *** À COMPLÉTER
            choixMenu = 0;
            choixMenu = saisirEtValider();

            switch (choixMenu) {

                case 1:

                    // CRÉEZ UN OBJET DE TYPE LocationVehicule AVEC LE CONSTRUCTEUR SANS PARAMÈTRE
                    // *** À COMPLÉTER
                    locationVehicule = new LocationVehicule();

                    // CRÉEZ LA DATE DE LA FACTURE
                    // *** À COMPLÉTER
                    dateFacture = LocalDateTime.now();

                    // Saisir les données
                    do {

                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE TYPE DU VÉHICULE.
                        // *** À COMPLÉTER
                        typeVehicule = saisirEtValiderLeTypeDeVehicule();

                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LA GRANDEUR DU VÉHICULE.
                        // *** À COMPLÉTER
                        grandeurVehicule = saisirEtValiderLaGrandeurDuVehicule();
                        

                        if (locationVehicule.obtenirPosition(typeVehicule, grandeurVehicule) != -1) {
                            System.out.print("\n  Vous avez déjà loué un ou des véhicules de ce type et de cette grandeur...\n");

                        } else {

                            // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NOMBRE DE VÉHICULES À LOUER.
                            // *** À COMPLÉTER
                            nbVehiculesALouer = saisirEtValiderNbrDeVehiculeALoue(typeVehicule, grandeurVehicule);

                            if (nbVehiculesALouer == 0) {
                                System.out.printf(MSG_ANNULATION, typeVehicule, grandeurVehicule);

                            } else {

                                // APPELEZ LA MÉTHODE diminuerNbVehiculesDisponibles DE LA CLASSE GestionVehiculesDisponibles
                                // POUR DIMINUER LE NOMBRE DE VÉHICULES À LOUER DE CE TYPE ET DE CETTE GRANDEUR DANS L'INVENTAIRE
                                // *** À COMPLÉTER
                                deminuerNbrDeVehiculeALoue = GestionVehiculesDisponibles.diminuerNbVehiculesDisponibles(typeVehicule, grandeurVehicule, nbVehiculesALouer);

                                // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NOMBRE DE JOURS DE LOCATION.
                                // *** À COMPLÉTER
                                nbrJoursLocation = saisirEtValiderLeNombreDeJoursDeLocation();

                                // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LA RÉPONSE DE LA QUESTION
                                // SI L'UTILISATEUR DÉSIRE PRENDRE UNE ASSURANCE.
                                choixAssurance = saisirEtValiderLaReponseAssurance();

                                // *** À COMPLÉTER

                                // APPELEZ LA MÉTHODE obtenirPrixLocationVehParJour DE LA CLASSE GestionVehiculesDisponibles
                                // POUR OBTENIR LE PRIX DE LA LOCATION PAR JOUR POUR CE TYPE ET DE CETTE GRANDEUR DE VÉHICULE.
                                // *** À COMPLÉTER
                                prixLocationJour = GestionVehiculesDisponibles.obtenirPrixLocationVehParJour(typeVehicule, grandeurVehicule);

                                // APPELEZ LA MÉTHODE obtenirPrixAssuranceVehParJour DE LA CLASSE GestionVehiculesDisponibles
                                // POUR OBTENIR LE PRIX DE L'ASSURANCE PAR JOUR POUR CE TYPE ET DE CETTE GRANDEUR DE VÉHICULE.
                                // *** À COMPLÉTER
                                prixAssurance = GestionVehiculesDisponibles.obtenirPrixAssuranceVehParJour(typeVehicule, grandeurVehicule, choixAssurance);

                                // CRÉEZ UN OBJET DE TYPE vehicule AVEC LES PARAMÈTRES SUIVANTS :
                                // LE TYPE DE VÉHICULE, LA GRANDEUR DU VÉHICULE, LE PRIX DE LA LOCATION PAR JOUR,
                                // LE PRIX DE L'ASSURANCE PAR JOUR.
                                // *** À COMPLÉTER
                                Vehicule vehicule = new Vehicule(typeVehicule, grandeurVehicule, prixLocationJour, prixAssurance);

                                // CRÉEZ UN OBJET DE TYPE vehiculeLoue AVEC LES PARAMÈTRES SUIVANTS :
                                // LE VÉHICULE, LA DATE DE LA FACTURE + 3 HEURES, LE NOMBRE DE VÉHICULES À LOUER,
                                // LE NOMBRE DE JOURS DE LOCATION,
                                // *** À COMPLÉTER
                                vehiculeLoue = new VehiculeLoue(vehicule, dateFacture.plusHours(3), nbVehiculesALouer, nbrJoursLocation);

                                // APPELEZ LA MÉTHODE ajouterVehiculeLoue DE L'OBJET locationVehicule
                                // POUR AJOUTER LE VÉHICULE LOUÉ DANS LE TABLEAU DES VÉHICULES LOUÉS
                                // *** À COMPLÉTER
                                vehiculeAjouter = locationVehicule.ajouterVehiculeLoue(vehiculeLoue);

                                // APPELEZ LA MÉTHODE augmenterNbVehiculesLoues DE LA CLASSE StatistiquesVehiculesLoues
                                // POUR METTRE À JOUR LE NOMBRE DE VÉHICULES LOUÉS DE CE TYPE ET DE CETTE GRANDEUR DE VÉHICULE.
                                // *** À COMPLÉTER
                                if(vehiculeAjouter){
                                StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(vehiculeLoue);
                            }
                            }
                        }

                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LA RÉPONSE DE LA QUESTION
                        // SI LE LOCATAIRE DÉSIRE LOUER D'AUTRES VÉHICULES.
                        // *** À COMPLÉTER
                        reponse = saisirEtValiderLaReponseAutreVehicule();

                        // TANT QUE LE LOCATAIRE DÉSIRE LOUER D'AUTRES VÉHICULES
                        // *** À COMPLETER LA BOUCLE WHILE CI-DESSOUS
                    } while (reponse == 'O');

                    if (locationVehicule.obtenirNbVehicules() > 0) {

                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE PRÉNOM DU LOCATAIRE.
                        // *** À COMPLÉTER
                        prenomLocataire = saisirEtValiderLePrenom();
                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NOM DU LOCATAIRE.
                        // *** À COMPLÉTER
                        nomLocataire = saisirEtValideLeNom();
                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NUMÉRO DE TÉLÉPHONE DU LOCATAIRE.
                        // *** À COMPLÉTER
                        numTel=saisirEtValiderLeNuméroDeTelephone();
                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NUMÉRO DE PERMIS DE CONDUIRE DU LOCATAIRE.
                        // *** À COMPLÉTER
                        numPermis=saisieEtValidationDuNuméroDePermisDeConduire();
                        // CRÉEZ UN OBJET DE TYPE Locataire AVEC LES PARAMÈTRES SUIVANTS :
                        // LE NOM, LE PRÉNOM, LE NUMÉRO DE TÉLÉPHONE ET LE NUMÉRO DE PERMIS DE CONDUIRE.
                        // *** À COMPLÉTER
                        locataire= new Locataire(nomLocataire,prenomLocataire,numTel,numPermis);
                        // APPELEZ LA MÉTHODE setLocataire DE L'OBJET locationVehicule
                        // AVEC LE PARAMÈTRE LOCATAIRE POUR modifier le locataire
                        // *** À COMPLÉTER
                        locationVehicule.setLocataire(locataire);
                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE MODE DE PAIEMENT.
                        // *** À COMPLÉTER
                        modePaiement=saisirEtValiderLeModeDePaiement();
                        // CRÉEZ UN OBJET DE TYPE Facture AVEC LES PARAMÈTRES SUIVANTS :
                        // LA DATE DE LA FACTURE, LOCATIONVEHICULE ET LE MODE DE PAIEMENT.
                        // *** À COMPLÉTER
                        facture=new Facture(dateFacture,locationVehicule,modePaiement);
                        // SI LE MODE DE PAIEMENT EST CRÉDIT
                        // *** À COMPLÉTER LE IF
                        if (modePaiement == 'C') {


                            // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE TYPE DE LA CARTE DE CRÉDIT.
                            // *** À COMPLÉTER
                            typeCarte=saisirEtValiderLeTypeDeLaCarteDeCredit();
                            // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NUMÉRO DE LA CARTE DE CRÉDIT.
                            // *** À COMPLÉTER
                            numCarte=saisirEtValiderLeNumeroDeLaCarteDeCredit();
                            // APPELEZ LA MÉTHODE setTypeCarteCredit DE DE L'OBJET facture
                            // POUR MODIFIER LE TYPE DE LA CARTE DE CRÉDIT.
                            // *** À COMPLÉTER
                            facture.setTypeCarteCredit(typeCarte);
                            // APPELEZ LA MÉTHODE setNumeroCarteCredit DE DE L'OBJET facture
                            // POUR MODIFIER LE NUMÉRO DE LA CARTE DE CRÉDIT.
                            // *** À COMPLÉTER
                            facture.setNumeroCarteCredit(numCarte);
                        }

                        // APPELEZ LES MÉTHODES DE L'OBJET facture DANS L'ORDRE SUIVANT :
                        //    - Calcul du sous-total de la facture
                        //    - Calcul du montant TPS
                        //    - Calcul du montant TVQ
                        //    - Calcul du montant total de la facture
                        //    - Afficher la facture
                        // *** À COMPLÉTER
                        facture.calculerSousTotalFacture();
                        facture.calculerMontantTPS();
                        facture.calculerMontantTVQ();
                        facture.calculerMontantTotal();
                        facture.afficherFacture();
                        // APPELEZ LA MÉTHODE ajouterFacture DE LA CLASSE ListeDesFactures
                        // POUR AJOUTER LA FACTURE COURANTE (l'objet facture) DANS LE TABLEAU
                        // DES FACTURES.
                        // *** À COMPLÉTER

ListeDesFactures.ajouterFacture(facture);

                    }

                    // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
                    // D'AFFICHER LE MENU PRINCIPAL.
                    // *** À COMPLÉTER
                    demanderReafficherMenu();
                    break;

                case 2:
                    // APPELEZ LA MÉTHODE afficherNbVehiculesLoues DE LA CLASSE StatistiquesVehiculesLoues
                    // POUR AFFICHER LE NOMBRE DE VÉHICULES LOUÉS PAR TYPE ET GRANDEUR DE VÉHICULE

                    // *** À COMPLÉTER
                    StatistiquesVehiculesLoues.afficherNbVehiculesLoues();

                    // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
                    // D'AFFICHER LE MENU PRINCIPAL.
                    // *** À COMPLÉTER
                    demanderReafficherMenu();

                    break;

                case 3:
                    // APPELEZ LA MÉTHODE afficher DE LA CLASSE GestionVehiculesDisponibles
                    // POUR AFFICHER LA LISTE DES VÉHICULES DISPONIBLES
                    // *** À COMPLÉTER
                    GestionVehiculesDisponibles.afficher();
                    // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
                    // D'AFFICHER LE MENU PRINCIPAL.
                    // *** À COMPLÉTER
                    demanderReafficherMenu();

                    break;

                case 4:

                    // APPELEZ LA MÉTHODE afficher DE LA CLASSE ListeDesFactures
                    // POUR AFFICHER TOUTES LES FACTURES CRÉÉES
                    // *** À COMPLÉTER
                    ListeDesFactures.afficher();

                    // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
                    // D'AFFICHER LE MENU PRINCIPAL.
                    // *** À COMPLÉTER
                    demanderReafficherMenu();

                    break;

                case 5:

                    // APPELEZ LA MÉTHODE ecrireFacture DE LA CLASSE ListeDesFactures
                    // POUR ÉCRIRE LES DONNÉES DE TOUTES LES FACTURES DANS LE FICHIER Factures.csv.
                    // *** À COMPLÉTER
                    ListeDesFactures.ecrireFacture();
                    // APPELEZ LE MESSAGE DE REMERCIEMENT
                    System.out.println("\n\n  Merci et à la prochaine ! ");

                    sortie = true;

            }

        } while (!sortie);

    }
}
