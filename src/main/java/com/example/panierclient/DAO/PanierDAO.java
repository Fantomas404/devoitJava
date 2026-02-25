package com.example.panierclient.DAO;

import com.example.panierclient.Service.PanierService;

import javax.persistence.EntityManager;

public class PanierDAO {

    public void ajoutPanier(PanierService l, EntityManager em) {
        //EntityManager em= FactoryJPA.getManager();
        // em.getTransaction().begin();
        em.persist(l);
        // em.getTransaction().commit();
    }
}
