module com.example.panierclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.persistence;
    requires javafx.base;
    requires javafx.graphics;

    opens com.example.panierclient to javafx.fxml;
    exports com.example.panierclient;

    // 1. Autorise JavaFX (FXML) à injecter des composants dans vos contrôleurs
    opens com.example.panierclient to javafx.fxml;

    // 2. Autorise JavaFX (Base) à lire vos objets Livre pour la TableView
    // ET autorise Hibernate à accéder à vos entités via la réflexion
    opens com.example.panierclient to javafx.base, javafx.fxml, org.hibernate.orm.core;

    // 3. Si vous avez des fichiers FXML à la racine du projet
    opens com.example.panierclient to javafx.fxml;

    // Exportation pour permettre l'exécution du Launcher
    exports com.example.panierclient;
}