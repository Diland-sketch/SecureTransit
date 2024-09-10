package com.mycompany.secure.transitgui;

import com.mycompany.secure.transitgui.logica.LogicaServicio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DashboardController implements Initializable {

    private LogicaServicio logica = new LogicaServicio();

    @FXML
    private AnchorPane plantillaOpciones;
    
    private AnchorPane panelRegistro;
    private AnchorPane panelBusqueda;
    
    @FXML
    private AnchorPane panelConsulta;

    @FXML
    private Button btnApartadoReseñas;
    //@FXML private Button btnBuscarConductor;
    @FXML
    private Button btnListaServicio;
    @FXML
    private Button btnRegistro;
    @FXML
    private Button btnClose;
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.panelBusqueda = (AnchorPane) App.loadComponent("BusquedaConductor");
            this.panelBusqueda.setVisible(false);
            System.out.println("Panel Registro cargado correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al cargar RegistroServicio: " + ioe.getMessage());
            ioe.printStackTrace();
        }

        try {
            this.panelRegistro = (AnchorPane) App.loadComponent("RegistroServicio");
            this.panelRegistro.setVisible(false);
            System.out.println("Panel Búsqueda Conductor cargado correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al cargar BusquedaConductor: " + ioe.getMessage());
            ioe.printStackTrace();
        }

        // Agregar el primer panel de inicio
        this.plantillaOpciones.getChildren().clear();
        if (this.panelBusqueda != null) {
            this.plantillaOpciones.getChildren().add(panelBusqueda);
        }
    }

    @FXML
    void clickBtnApartados() {
        System.out.println("Apartado de reseñas");
    }

    @FXML
    void clickBtnBuscarConductor() {
        if (this.panelBusqueda != null) {
            image.setVisible(false);
            btnClose.setDisable(true);
            btnClose.setVisible(false);
            this.panelBusqueda.setVisible(true);
            this.panelRegistro.setVisible(false);
            this.plantillaOpciones.getChildren().clear();
            this.plantillaOpciones.getChildren().add(panelBusqueda);
        }
        System.out.println("funciona boton");
    }

    @FXML
    void clickBtnListar() {
        System.out.println("Listar servicio");
    }

    @FXML
    void clickBtnRegistro() {
        if (this.panelRegistro != null) {
            image.setVisible(false);
            btnClose.setDisable(true);
            btnClose.setVisible(false);
            this.panelRegistro.setVisible(true);
            this.panelBusqueda.setVisible(false);
            this.plantillaOpciones.getChildren().clear();
            this.plantillaOpciones.getChildren().add(panelRegistro);
        }
    }

    @FXML
    void clickBtnClose() {
        System.exit(0);
    }
}
