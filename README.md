# Système de Gestion de Bibliothèque

Un système de gestion de bibliothèque développé en Java qui implémente diverses structures de données et algorithmes pour gérer une collection de livres.

## 📋 Fonctionnalités

### Gestion des Livres
- **Ajouter des livres** : Ajout de nouveaux livres avec titre, auteur, ISBN, année de publication et genre
- **Supprimer des livres** : Suppression de livres par ISBN
- **Modifier des livres** : Mise à jour des informations d'un livre existant
- **Lister tous les livres** : Affichage de la collection complète

### Recherche
- **Recherche linéaire** : Recherche par titre, auteur ou ISBN
- **Recherche binaire** : Recherche optimisée (nécessite un tri préalable)

### Tri
Trois algorithmes de tri implémentés :
- **Tri à bulles** (Bubble Sort)
- **Tri par sélection** (Selection Sort)
- **Tri rapide** (Quick Sort)

Critères de tri disponibles :
- Par titre
- Par auteur
- Par année de publication

### Système d'Emprunt
- **Emprunter des livres** : Enregistrement des emprunts avec nom de l'emprunteur
- **Historique des emprunts** : Suivi des emprunts pour chaque livre

### Suivi des Activités
- **Pile d'activités** : Enregistrement de toutes les actions effectuées
- **Consultation de l'historique** : Visualisation des activités récentes

## 🏗️ Architecture

### Classes Principales

#### `Book`
Représente un livre avec ses propriétés :
- Titre, auteur, ISBN, année de publication, genre
- Historique des emprunts associé

#### `Library`
Classe principale gérant :
- Collection de livres (ArrayList)
- Algorithmes de recherche et tri
- Gestion des emprunts
- Pile d'activités

#### `BorrowingHistory`
Implémente une liste chaînée pour stocker l'historique des emprunts de chaque livre.

#### `ActivityStack`
Pile pour enregistrer toutes les activités effectuées dans le système.

#### `Main`
Interface utilisateur en ligne de commande avec menu interactif.

## 🚀 Utilisation

### Prérequis
- Java 8 ou version supérieure
- IDE Java (IntelliJ IDEA, Eclipse, etc.) ou compilateur Java

### Compilation et Exécution

```bash
# Compilation
javac src/*.java

# Exécution
java -cp src Main
```

### Menu Principal

Le système propose un menu interactif avec les options suivantes :

1. **Ajouter un livre** - Saisie des informations du nouveau livre
2. **Supprimer un livre** - Suppression par ISBN
3. **Modifier un livre** - Mise à jour des informations
4. **Recherche linéaire** - Recherche par titre, auteur ou ISBN
5. **Recherche binaire** - Recherche optimisée
6. **Trier les livres** - Choix de l'algorithme et du critère
7. **Emprunter un livre** - Enregistrement d'un emprunt
8. **Voir les activités récentes** - Historique des actions
9. **Voir l'historique d'emprunt** - Emprunts d'un livre spécifique
10. **Lister tous les livres** - Affichage de la collection
11. **Quitter** - Fermeture du programme

## 📚 Livres Pré-chargés

Le système démarre avec quatre livres classiques :
- *The Great Gatsby* - F. Scott Fitzgerald (1925)
- *To Kill a Mockingbird* - Harper Lee (1960)
- *1984* - George Orwell (1949)
- *Pride and Prejudice* - Jane Austen (1813)

## 🔧 Structures de Données Utilisées

- **ArrayList** : Stockage principal des livres
- **Liste chaînée** : Historique des emprunts (implémentation personnalisée)
- **Pile** : Suivi des activités (implémentée avec ArrayList)

## 📊 Algorithmes Implémentés

### Recherche
- **Linéaire** : O(n) - Parcours séquentiel
- **Binaire** : O(log n) - Recherche dichotomique sur liste triée

### Tri
- **Bubble Sort** : O(n²) - Comparaisons et échanges adjacents
- **Selection Sort** : O(n²) - Sélection du minimum à chaque itération
- **Quick Sort** : O(n log n) moyenne - Tri par partition récursive

## 🎯 Objectifs Pédagogiques

Ce projet illustre :
- L'implémentation de structures de données fondamentales
- Les algorithmes de recherche et de tri classiques
- La programmation orientée objet en Java
- La gestion d'une interface utilisateur simple
- L'organisation modulaire du code

## 📝 Notes Techniques

- Recherche insensible à la casse pour les titres et auteurs
- Tri automatique avant recherche binaire
- Enregistrement de toutes les activités dans la pile
- Gestion des erreurs pour les entrées invalides

## 🔄 Améliorations Possibles

- Persistance des données (fichiers/base de données)
- Interface graphique
- Gestion des dates d'emprunt et de retour
- Système de réservation
- Recherche par mots-clés partiels
- Export des données