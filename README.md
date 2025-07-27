# Simulateur_de_particules

Cette application simule un système de particules en mouvement perpétuel dans un environnement discret.

## ⚙️ Fonctionnalités

- **Particules** :
  - Forme : cercle
  - Rayon : fixe (identique pour toutes les particules)
  - Couleur : générée aléatoirement
  - Position initiale : aléatoire
  - Direction : aléatoire selon le **voisinage de Moore** (8 directions possibles)

- **Comportement** :
  - À chaque cycle :
    - La particule avance dans sa direction actuelle
    - Si elle atteint un bord, elle **réapparaît de l'autre côté** de l'environnement (effet de torus)
    - Si elle entre en collision avec une autre particule, elle **change de direction** aléatoirement

## 🛠️ Technologies

- **Langage** : Scala
- **Outil de build** : [sbt](https://www.scala-sbt.org/)

## 🚀 Lancement

1. Cloner ou télécharger le projet.
2. Ouvrir un terminal et se positionner dans le dossier du projet.
3. Exécuter la commande suivante :

```bash
sbt run
