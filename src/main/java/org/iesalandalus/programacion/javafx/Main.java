package org.iesalandalus.programacion.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox();
			raiz.setPadding(new Insets(40));
			raiz.setSpacing(10);
			raiz.setAlignment(Pos.CENTER_LEFT);

			Label lbImagen = new Label();
			Label lbTexto = new Label("Puedes visitar los siguientes enlaces.");
			Hyperlink hlGoogle = new Hyperlink("Google");
			Label lbNombre = new Label("Nombre:");
			Label lbContrasena = new Label("Contrasena:");
			Button btTexto = new Button();
			Button btTextoImagen = new Button();
			Button btImagen = new Button();

			Image imagen = new Image(getClass().getResourceAsStream("/imagenes/pantera-rosa-rumor.jpg"), 200, 200, true, true);
			lbImagen.setGraphic(new ImageView(imagen));

			Image imagenBoton = new Image(getClass().getResourceAsStream("/imagenes/pantera-rosa-rumor.jpg"), 200, 200, true, true);
			btTextoImagen.setGraphic(new ImageView(imagenBoton));
			btTextoImagen.setText("Beber");
			btTextoImagen.setGraphicTextGap(20);
			btTextoImagen.setFont(Font.font("Arial", 30));

			TextField tfNombre = new TextField();
			PasswordField tfContrasena = new PasswordField();

			lbTexto.setText("Elige una opcion: ");
			lbTexto.setFont(Font.font("Comic Sans", 50));
			lbTexto.setMinWidth(150);
			lbTexto.setWrapText(true);
			raiz.getChildren().addAll(lbTexto, lbImagen, hlGoogle, lbNombre, tfNombre, lbContrasena, tfContrasena);

			HBox botones = new HBox();
			botones.setSpacing(10);
			botones.getChildren().addAll(btTexto, btTextoImagen, btImagen);


			hlGoogle.setVisited(true);

			VBox.setMargin(hlGoogle, new Insets(0, 0, 0, 0));

			Scene escena = new Scene(raiz, 800, 800);
			escenarioPrincipal.setTitle("Alejandro");
			escenarioPrincipal.setScene(escena);
			escenarioPrincipal.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
