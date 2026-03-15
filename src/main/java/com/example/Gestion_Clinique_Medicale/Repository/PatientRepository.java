package com.example.Gestion_Clinique_Medicale.DAO;

import com.example.Gestion_Clinique_Medicale.Model.Patient;

public class PatientRepository extends BaseRepositoryImpl<Patient> {

    public PatientRepository() {
        super(Patient.class);
    }
}