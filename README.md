# Roulons Véhicules Verts



Travail pratique universitaire réalisé pour le cours **INF1120 Programmation I** à l'UQAM.

Le but du projet est de créer un programme Java pour gérer la location et la facturation de véhicules électriques et hybrides.

## Fonctionnalités

Le programme permet de :


- consulter les véhicules disponibles.

- louer un véhicule à un client..

- générer et enregistrer une facture. 

- afficher des statistiques sur les locations.

## Technologies utilisées

- Java
- Programmation orientée objet
- Fichiers CSV
- Tableaux et listes

## Organisation du programme

- **ApplicationPrincipale.java** : point d'entrée  du programme.
- **Vehicule.java**, **VehiculeDisponible.java** et **VehiculeLoue.java** : représentent les véhicules et leur état.
- **GestionVehiculesDisponibles.java** : gère l'inventaire des véhicules disponibles.
- **Locataire.java** et **LocationVehicule.java** : gèrent les clients et les locations.
- **Facture.java** et **ListeDesFactures.java** : créent et gèrent les factures.
- **StatistiquesVehiculesLoues.java** : calcule les statistiques sur les véhicules loués.
- **InventaireVehicules.csv** et **Factures.csv** : enregistrent les données du programmes.

## Exécution

Il faut avoir le JDK Java installé.

Pour compiler le programme :

```bash
javac *.java
```

Pour le lancer :
```bash
java ApplicationPrincipale
```

Les fichiers CSV doivent rester dans le même dossier que les fichiers Java.

## Ce que j'ai appris

Avec ce projet, j'ai mieux compris comment utiliser les classes et les objets en Java. J'ai aussi appris à séparer le programme en plusieurs fichiers, à manipuler des tableaux et à enregistrer des données dans des fichiers CSV.

## Auteur

**Fatima Zahra Ladam**

Etudiante au baccalauréat en informatique et génie logiciel à l'UQAM













