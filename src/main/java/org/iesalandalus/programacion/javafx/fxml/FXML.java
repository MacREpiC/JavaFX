package org.iesalandalus.programacion.javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXML extends Application {
    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        Parent raiz = FXMLLoader.load(getClass().getResource("/vistas/gridPanel.fxml"));
        Scene escena = new Scene(raiz);
        // escena.getStylesheets().add(getClass().getResource("estilos/aplicacion.css").toExternalForm());
        escenarioPrincipal.setTitle("Alejandro");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}