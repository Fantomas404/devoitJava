package com.example.Gestion_Clinique_Medicale.DAO;

import com.example.Gestion_Clinique_Medicale.Model.Medecin;

public class MedecinRepository extends BaseRepositoryImpl<Medecin> {

    public MedecinRepository() {
        super(Medecin.class);
    }
}