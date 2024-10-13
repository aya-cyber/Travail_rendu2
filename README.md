Le projet "Gestion de l'État Civil" vise à développer une application permettant de gérer les informations de l'état civil des citoyens d'une province. L'application permet de suivre les mariages, les enfants, et d'autres informations pertinentes pour chaque citoyen. Grâce à une architecture bien définie, les utilisateurs peuvent facilement interagir avec les données et obtenir des rapports sur l'état civil.

Technologies Utilisées
Java : Langage de programmation utilisé pour le développement de l'application.
Hibernate : Framework de gestion de la persistance des données via JPA.
MySQL : Système de gestion de base de données relationnelle utilisé pour stocker les informations des citoyens.
JDBC : API Java pour interagir avec la base de données.
Structure du Projet

A. Couche de Persistance
Classes Entités : Développées dans le package ma.projet.beans, ces classes représentent les objets de la base de données (Homme, Femme, Mariage, etc.). Les annotations telles que @Entity, @Id, @GeneratedValue, @Column, et @Table sont utilisées pour définir les entités.
Fichier de Configuration : hibernate.cfg.xml est créé dans le package ma.projet.config pour configurer la connexion à la base de données.
Classe HibernateUtil : Située dans le package ma.projet.util, elle permet de créer une instance de SessionFactory pour gérer les sessions Hibernate.
Base de Données : La base de données est générée sous MySQL pour stocker les données des citoyens.
B. Couche Service

Interface Générique IDao : Définie dans le package ma.projet.dao, cette interface fournit les méthodes de base pour l'accès aux données.
Classes Services :
HommeService : Gère les opérations liées aux hommes.
FemmeService : Gère les opérations liées aux femmes.
MariageService : Gère les opérations liées aux mariages.

https://github.com/user-attachments/assets/17284a95-9b54-40eb-bd3d-6a5c6a03bf22

