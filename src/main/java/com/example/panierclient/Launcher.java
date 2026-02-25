package com.example.panierclient;

import javafx.application.Application;

package sn.famata.gestion_librerie;

import javafx.application.Application;

import sn.famata.gestion_librerie.config.FactoryJPA;

import javax.persistence.EntityManager;

public class Launcher {

    public static void main(String[] args){

         Test connexion JPA AVANT JavaFX
         EntityManager em = FactoryJPA.getManager();
         System.out.println("Connexion OK, tables créées si inexistantes.");
         em.close();
         Lancement JavaFX
        Application.launch(HelloApplication.class,args);

}

}
