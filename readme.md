# Prise de rendez-vous

## Description

Le projet est une application back-end développée avec Spring Boot, un framework Java facilitant la création d'applications Java basées sur le principe de convention plutôt que de configuration. 
Ce projet vise à fournir une solution évolutive pour la gestion des rendez-vous.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants sur votre machine :

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (version recommandée)
- [Maven](https://maven.apache.org/download.cgi)

## Configuration

En utilisant une base de données MySQL, assurez vous qu'elle correspond à la configuration citée dans le fichier Application.properties du projet :

spring.datasource.url=jdbc:mysql://localhost:3306/medDB
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database=MYSQL
spring.jpa.hibernate.ddl-auto=create

Il suffit donc de créer une base de données avec ce nom et la création des tables se fera automatiquement.

Pour ne pas avoir à supprimer et recréer les tables à chaque fois, il suffit de changer la ligne :
spring.jpa.hibernate.ddl-auto=update

## Installation

Après avoir installer le projet :
Compilez le projet avec Maven : en utilisant la commande
    mvn clean install

## Exécution

Suivez ces étapes pour exécuter le projet localement :

1. Exécutez l'application Spring Boot :
 En utilisant la commande
    mvn spring-boot:run

2. Vous pouvez tester le fonctionnement des controllers à l'aide de Postman et en utilisant les urls et rqs http.
