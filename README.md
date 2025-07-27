# Simulateur_de_particules

Cette application simule un système de particules en mouvement perpétuel dans un environnement discret.

## ⚙️ Fonctionnalités

- **Particules** :
  - Forme : cercle
  - Rayon : fixe (identique pour toutes les particules)
  - Couleur : 

https://github.com/user-attachments/assets/cf6cdbff-e783-4eec-89d9-17cf733350f1


  - Position initiale : aléatoire
  - Direction : aléatoire selon le **voisinage de Moore** (8 directions possibles)

- **Comportement** :
  - À chaque cycle :
    - La particule avance dans sa direction actuelle
    - Si elle entre en collision avec une autre particule, elle **change de direction** 

## 🛠️ Technologies

- **Langage** : Scala
- **Outil de build** : [sbt](https://www.scala-sbt.org/)

## 🚀 Lancement

1. Cloner ou télécharger le projet.
2. Ouvrir un terminal et se positionner dans le dossier du projet.
3. Exécuter la commande suivante :

```bash
sbt run


