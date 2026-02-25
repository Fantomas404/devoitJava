package com.example.panierclient.DAO;

import com.example.panierclient.Model.LignePanier;

import javax.persistence.EntityManager;

public class LignePanierDAO {
    public void ajoutLignePanier(LignePanier e, EntityManager em){
        em.persist(e);
    }
}



