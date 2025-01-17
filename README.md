# Projet-final-jee
On souhaite créer une application qui permet de gérer des comptes bancaires. chaque compte appartient à un client. un compte peut subir plusieurs opérations de type DEBIT ou CREDIT. Il existe deux types de comptes : Comptes courants et comptes épargnes.


Partie 1 : Backend

1. Créer un projet Spring Boot
2. Créer les entités JPA : Customer, BankAccount, Saving Account, CurrentAccount, AccountOperation
3. Créer les interfaces JPA Repository basées sur Spring Data
4. Tester la couche DAO
   5 Couche service, DTOs
6. RestController
7. Tester les web services Restful


pour Swagger, avec Spring boot 3 voici la dépendance à utiliser :

<dependency> 
   <groupId>org.springdoc</groupId> 
   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId> 
   <version>2.1.0</version> 
 </dependency>

Partie 2 : Client Angular :

Partie 3 : Sécuriser l'application avec un système d'authentification basé sur Spring Security et Json Web Token


Fonctionnalités à ajouter  :

- Ajouter des fonctionnalisés supplémentaires à votre projet comme :
    - La gestion des clients (saisie, ajout, suppression, édition, recherche , etc.)
    - La gestion des comptes (Ajout des comptes, recherche et administration des comptes)
    - Pour chaque client, compte, opération enregistrée, il faut enregistrer avec l'enregistrement l'identifiant de l'utilisateur authentifié qui a effectué l'opération
    - Gestion des comptes et des mot de passes des utilisateurs avec la possibilité qu'un utilisateur change son mot de passe
    - Partie Dash Board : En utilisant ChartJS (ng-chart), créer la partie dashboard de l'application montrant des graphiques et des statistiques utiles pour les prises de décision
    - Autres fonctionnalisés supplémentaires