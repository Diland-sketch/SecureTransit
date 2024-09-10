/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.secure.transitgui;

import com.mycompany.secure.transitgui.entidades.Conductor;
import com.mycompany.secure.transitgui.entidades.Servicio;
import com.mycompany.secure.transitgui.entidades.Usuario;
import com.mycompany.secure.transitgui.logica.LogicaConductor;
import com.mycompany.secure.transitgui.logica.LogicaServicio;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class RegistroServicioController {
    
    private LogicaServicio logica = new LogicaServicio();
    private LogicaConductor logicaConductor = new LogicaConductor();
    
    @FXML
    private Button BtnRegistro;

    @FXML
    private TextField descripcionServicio;

    @FXML
    private AnchorPane eseceRegistroServicio;

    @FXML
    private DatePicker fechaServicio;

    @FXML
    private TextField placaServicio;

    @FXML
    private Button btnClose;
    
    @FXML
    private ImageView image; 

    @FXML
    void clickBtnRegistrarServicio(ActionEvent event) {
        int id = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("servicios.txt", true))) {
            String descripcion = descripcionServicio.getText();
            String placa = placaServicio.getText();
            LocalDate fecha = fechaServicio.getValue();
            Servicio servicio = new Servicio(fecha, " ", id);
            logica.registrar(servicio);
            writer.write(descripcion + "," + " " + "," + fecha + "," + placa);
            writer.newLine();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de Registro");
            alert.setHeaderText("Informacion de credenciales registradas");
            alert.setContentText("La informacion del Servicion han registradas correctamente"
                    + "Servicio: " + servicio);
            //System.out.println("Usuarios registrados" + this.logica.listar());
            alert.show();
            clearFields();
            App.setNewScene("Dashboard");
            id++;
        } catch (IOException ex) {
            System.out.println("Error al registrar");
        } catch (NumberFormatException ne) {
            System.out.println("Error");
        }

    }

    @FXML
    private void close() throws IOException {
        App.setNewScene("Dashboard");
    }
    
    private void clearFields() {
        descripcionServicio.setText("");
        fechaServicio.setValue(null);
        placaServicio.setText("");
    }
    
    private Conductor buscarConductorPorPlaca(String placa) {
        for (Conductor conductor : logicaConductor.getConductores()) {
            if (conductor.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return conductor;
            }
        }
        return null;
    }

}
