package com.example.Gestion_Clinique_Medicale.Controller;

import com.example.Gestion_Clinique_Medicale.Service.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final AuthService authService = new AuthService();

    @FXML
    private void handleLogin() {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs.");
            errorLabel.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        if (authService.login(login, password)) {
            errorLabel.setText("Connexion réussie !");
            errorLabel.setTextFill(javafx.scene.paint.Color.GREEN);

            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/example/Gestion_Clinique_Medicale/Views/dashboard.fxml")
                );
                Stage stage = (Stage) loginField.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setTitle("Clinique Médicale - Dashboard");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                errorLabel.setText("Erreur ouverture dashboard.");
                System.err.println("Erreur : " + e.getMessage());
            }

        } else {
            errorLabel.setText("Identifiants incorrects.");
            errorLabel.setTextFill(javafx.scene.paint.Color.RED);
        }
    }
}