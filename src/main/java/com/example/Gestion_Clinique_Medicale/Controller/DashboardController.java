package com.example.Gestion_Clinique_Medicale.Controller;

import com.example.Gestion_Clinique_Medicale.Utilitaire.SessionUtilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML private StackPane contenuPrincipal;
    @FXML private Label labelUtilisateur;
    @FXML private Label labelRole;

    @FXML private HBox btnPatients;
    @FXML private HBox btnRendezVous;
    @FXML private HBox btnConsultations;
    @FXML private HBox btnFacturation;

    // Style bouton ACTIF — bordure verte
    private static final String STYLE_ACTIF =
            "-fx-background-color: white;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-color: #2f855a;" +
                    "-fx-border-radius: 10;" +
                    "-fx-border-width: 2;" +
                    "-fx-cursor: hand;" +
                    "-fx-padding: 0 12 0 12;";

    // Style bouton INACTIF — transparent
    private static final String STYLE_INACTIF =
            "-fx-background-color: transparent;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-color: transparent;" +
                    "-fx-border-radius: 10;" +
                    "-fx-border-width: 2;" +
                    "-fx-cursor: hand;" +
                    "-fx-padding: 0 12 0 12;";


    private static final String TEXTE_ACTIF =
            "-fx-text-fill: #2f855a; -fx-font-size: 13px; -fx-font-weight: bold;";


    private static final String TEXTE_INACTIF =
            "-fx-text-fill: #4a5568; -fx-font-size: 13px;";

    private HBox boutonActif;

    @FXML
    public void initialize() {
        labelUtilisateur.setText("Bienvenue, " + SessionUtilisateur.nomComplet);
        if (SessionUtilisateur.role != null) {
            labelRole.setText(SessionUtilisateur.role.toString());
        }
        ouvrirPatients();
    }

    @FXML
    private void ouvrirPatients() {
        setActif(btnPatients);
        chargerVue("patients.fxml");
    }

    @FXML
    private void ouvrirRendezVous() {
        setActif(btnRendezVous);
        chargerVue("rendezVous.fxml");
    }

    @FXML
    private void ouvrirConsultations() {
        setActif(btnConsultations);
        chargerVue("consultations.fxml");
    }

    @FXML
    private void ouvrirFacturation() {
        setActif(btnFacturation);
        chargerVue("facturation.fxml");
    }

    @FXML
    private void seDeconnecter() {
        try {
            SessionUtilisateur.fermerSession();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/Gestion_Clinique_Medicale/Views/login.fxml")
            );
            Stage stage = (Stage) contenuPrincipal.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Clinique Medicale - Connexion");
            stage.show();
        } catch (IOException e) {
            System.err.println("Erreur deconnexion : " + e.getMessage());
        }
    }

    private void setActif(HBox bouton) {
        // Remettre tous les boutons en inactif
        HBox[] boutons = {btnPatients, btnRendezVous, btnConsultations, btnFacturation};
        for (HBox btn : boutons) {
            btn.setStyle(STYLE_INACTIF);
            // Changer couleur texte label principal
            if (btn.getChildren().size() >= 2) {
                javafx.scene.layout.VBox vbox =
                        (javafx.scene.layout.VBox) btn.getChildren().get(1);
                if (vbox.getChildren().size() >= 1) {
                    ((Label) vbox.getChildren().get(0)).setStyle(TEXTE_INACTIF);
                }
            }
        }
        // Activer le bouton sélectionné
        bouton.setStyle(STYLE_ACTIF);
        if (bouton.getChildren().size() >= 2) {
            javafx.scene.layout.VBox vbox =
                    (javafx.scene.layout.VBox) bouton.getChildren().get(1);
            if (vbox.getChildren().size() >= 1) {
                ((Label) vbox.getChildren().get(0)).setStyle(TEXTE_ACTIF);
            }
        }
    }

    private void chargerVue(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/Gestion_Clinique_Medicale/Views/" + fxmlFile)
            );
            contenuPrincipal.getChildren().clear();
            contenuPrincipal.getChildren().add(loader.load());
        } catch (IOException e) {
            System.err.println("Erreur chargement vue : " + fxmlFile + " - " + e.getMessage());
        }
    }
}