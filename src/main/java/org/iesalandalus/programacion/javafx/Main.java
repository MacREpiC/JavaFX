package org.iesalandalus.programacion.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static class Clientes {
        private String nombre;
        private String apellidos;

        private Clientes(String nombre, String apellidos) {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

    }

    private static final ObservableList<Clientes> CLIENTES = FXCollections.observableArrayList(
            new Clientes("Pepito", "Grillo"),
            new Clientes("Bob", "Esponja"),
            new Clientes("Juan", "Sin Miedo"),
            new Clientes("Perico", "De Los Palotes"),
            new Clientes("Juana", "La Loca"));

    @Override
    public void start(Stage escenarioPrincipal) {
        VBox raiz = new VBox();
        raiz.setPadding(new Insets(40));
        raiz.setSpacing(10);
        raiz.setAlignment(Pos.CENTER);

        Label lbImagen = new Label();
        Label lbTexto = new Label("Esto programa lo ha hecho Alejandro");
        Hyperlink hlGoogle = new Hyperlink("Google");

        Label lbNombre = new Label("Nombre:");
        Label lbContrasena = new Label("Contraseña:");

        /*ToggleButton btTexto = new ToggleButton("Pulsar");
        ToggleButton btTextoImagen = new ToggleButton("Beber");
        ToggleButton btImagen = new ToggleButton();*/

        Image imagen = new Image(getClass().getResourceAsStream("/imagenes/pantera-rosa-rumor.jpg"), 200, 200, true, true);
        lbImagen.setGraphic(new ImageView(imagen));

        hlGoogle.setVisited(true);

        /*Image imagenBotonTexto = new Image(getClass().getResourceAsStream("/imagenes/cerveza.png"), 200, 200, true, true);
        btTextoImagen.setGraphic(new ImageView(imagenBotonTexto));
        btTextoImagen.setGraphicTextGap(5);
        btTextoImagen.setFont(Font.font("Ani", 30));

        Image imagenBoton = new Image(getClass().getResourceAsStream("/imagenes/apagado.png"), 200, 200, true, true);
        btImagen.setGraphic(new ImageView(imagenBoton));*/

        TextField tfNombre = new TextField();
        PasswordField tfContrasena = new PasswordField();

        lbTexto.setFont(Font.font("Comic Sans", 20));
        lbTexto.setMinWidth(150);
        lbTexto.setWrapText(true);

        /*HBox botones = new HBox();
        botones.setSpacing(10);
        botones.getChildren().addAll(btTexto, btTextoImagen, btImagen);
        botones.setAlignment(Pos.CENTER);*/

		Label lbElige = new Label("Elige los extras: ");
		lbElige.setFont(Font.font(20));

		ComboBox<String> cbExtras = new ComboBox<>();
		cbExtras.setVisibleRowCount(2);
		cbExtras.setItems(FXCollections.observableArrayList("Navegador", "Manos libres", "Lunas tintadas"));

        /*Label lbSelecciona  = new Label("Elige los extras: ");
        lbElige.setFont(Font.font(20));

        Separator separador = new Separator();
        ListView<Object> lvComplementos   = new ListView<>(FXCollections.observableArrayList("Pendientes", "Collar", separador, "Felpa", "Bolsa de mano"));
        lvComplementos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		VBox cajasEleccionScroll = new VBox();
		cajasEleccionScroll.setPadding(new Insets(40));
		cajasEleccionScroll.getChildren().addAll(lbElige, cbExtras, lbSelecciona, lvComplementos );
		cajasEleccionScroll.setAlignment(Pos.CENTER);*/

        Label lbEligeDeslizador = new Label("Elige el porcentaje: ");
        lbEligeDeslizador.setFont(Font.font(20));

        Tooltip infoPorcentaje = new Tooltip("Elige un número entre el 0 y el 100.");
        infoPorcentaje.setFont(Font.font("Arial", 15));
        infoPorcentaje.setWrapText(true);
        Slider porcentaje = new Slider();
        porcentaje.setMin(0);
        porcentaje.setMax(100);
        porcentaje.setValue(50);
        porcentaje.setShowTickLabels(true);
        porcentaje.setShowTickLabels(true);
        porcentaje.setShowTickMarks(true);
        porcentaje.setMajorTickUnit(50);
        porcentaje.setMinorTickCount(4);
        porcentaje.setBlockIncrement(10);
        porcentaje.setSnapToTicks(true);
        porcentaje.setTooltip(infoPorcentaje);

        HBox deslizador = new HBox();
        raiz.setPadding(new Insets(40));
        deslizador.getChildren().addAll(lbEligeDeslizador, porcentaje);
        deslizador.setAlignment(Pos.CENTER);

        Label lbPersonajes = new Label("Personajes:");
        TableView<Clientes> tvPersonajes = new TableView<>();
        TableColumn<Clientes, String> columnaNombre = new TableColumn<>("Nombre");
        TableColumn<Clientes, String> columnaApellidos = new TableColumn<>("Apellidos");
        tvPersonajes.getColumns().add(columnaNombre);
        tvPersonajes.getColumns().add(columnaApellidos);
        tvPersonajes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        columnaNombre.setMinWidth(100);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidos.setMinWidth(100);
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        tvPersonajes.setItems(CLIENTES);

        VBox tablaPersonajes = new VBox();
        tablaPersonajes.setPadding(new Insets(40));
        tablaPersonajes.getChildren().setAll(lbPersonajes, tvPersonajes);
        tablaPersonajes.setAlignment(Pos.CENTER);

        Label lbPersonajesArbol = new Label("Personajes:");
        TreeItem<String> tiRaiz = new TreeItem<> ("Personajes");
        tiRaiz.setExpanded(true);
        TreeItem<String> tiMasculinos = new TreeItem<> ("Masculinos");
        tiRaiz.getChildren().add(tiMasculinos);
        TreeItem<String> ti1 = new TreeItem<> ("Pepito Grillo");
        tiMasculinos.getChildren().add(ti1);
        TreeItem<String> ti2 = new TreeItem<> ("Bob Esponja");
        tiMasculinos.getChildren().add(ti2);
        TreeItem<String> ti3 = new TreeItem<> ("Juan Sin Miedo");
        tiMasculinos.getChildren().add(ti3);
        TreeItem<String> ti4 = new TreeItem<> ("Perico De Los Palotes");
        tiMasculinos.getChildren().add(ti4);
        TreeItem<String> tiFemeninos = new TreeItem<> ("Femeninos");
        tiRaiz.getChildren().add(tiFemeninos);
        TreeItem<String> ti5 = new TreeItem<> ("Juana La Loca");
        tiFemeninos.getChildren().add(ti5);
        TreeView<String> tvPersonajesArbol = new TreeView<> (tiRaiz);

        tvPersonajes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox vistaArbol = new VBox();
        vistaArbol.setPadding(new Insets(40));
        vistaArbol.setSpacing(10);
        vistaArbol.getChildren().addAll(lbPersonajesArbol, tvPersonajesArbol);

        MenuBar mbPrincipal = new MenuBar();
        Menu mFichero = new Menu("Fichero");
        MenuItem miAbrir = new MenuItem("Abrir");
        MenuItem miGuardar = new MenuItem("Guardar");
        SeparatorMenuItem separador = new SeparatorMenuItem();
        MenuItem miSalir = new MenuItem("Salir");
        mFichero.getItems().addAll(miAbrir, miGuardar, separador, miSalir);
        Menu mAyuda = new Menu("Ayuda");
        MenuItem miAcercaDe = new MenuItem("Acerca de...");
        mAyuda.getItems().add(miAcercaDe);
        mbPrincipal.getMenus().addAll(mFichero, mAyuda);

        VBox.setMargin(hlGoogle, new Insets(0, 0, 0, 0));
        raiz.getChildren().addAll(mbPrincipal, lbTexto, lbImagen, hlGoogle, lbNombre, tfNombre, lbContrasena, tfContrasena /*botones, cajasEleccionScroll*/, deslizador, tablaPersonajes, vistaArbol);

        Scene escena = new Scene(raiz, 800, 900);
        escenarioPrincipal.setTitle("Alejandro");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}