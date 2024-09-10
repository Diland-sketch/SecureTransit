/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui;

import com.mycompany.secure.transitgui.entidades.Conductor;
import com.mycompany.secure.transitgui.entidades.Vehiculo;
import com.mycompany.secure.transitgui.logica.LogicaConductor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BusquedaConductorController {
    
    @FXML private TextField placaTextField;
    @FXML private VBox infoConductorVBox;
    @FXML private Button btnBusqueda;
    @FXML private Button btnClose;
    private LogicaConductor logicaConductor;

    public BusquedaConductorController() {
        logicaConductor = new LogicaConductor();
        cargarConductoresDesdeArchivo("conductores.txt");
    }

    @FXML
    void buscarConductor() {
        String placa = placaTextField.getText().trim();

        if (placa.isEmpty()) {
            mostrarError("Por favor, ingrese una placa válida.");
            return;
        }

        Conductor conductor = buscarConductorPorPlaca(placa);

        infoConductorVBox.getChildren().clear();

        if (conductor != null) {
            mostrarInfoConductor(conductor);
        } else {
            mostrarError("No se encontró un conductor con la placa ingresada.");
        }
    }

    private Conductor buscarConductorPorPlaca(String placa) {
        for (Conductor conductor : logicaConductor.getConductores()) {
            if (conductor.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return conductor;
            }
        }
        return null;
    }

private void mostrarInfoConductor(Conductor conductor) {
    Text nombreText = new Text("Nombre: " + conductor.getNombres() + " " + conductor.getApellidos());
    Text placaText = new Text("Placa: " + conductor.getVehiculo().getPlaca());
    Text marcaText = new Text("Marca: " + conductor.getVehiculo().getMarca());
    Text modeloText = new Text("Modelo: " + conductor.getVehiculo().getModelo());
    Text colorText = new Text("Color: " + conductor.getVehiculo().getColor());
    
    // Configurar el estilo del texto
    Font font = new Font("Javanese Text", 20); // Tamaño de fuente 20, ajusta según tus necesidades
    Color textColor = Color.WHITE;
    
    nombreText.setFont(font);
    nombreText.setFill(textColor);
    placaText.setFont(font);
    placaText.setFill(textColor);
    marcaText.setFont(font);
    marcaText.setFill(textColor);
    modeloText.setFont(font);
    modeloText.setFill(textColor);
    colorText.setFont(font);
    colorText.setFill(textColor);
    
    infoConductorVBox.getChildren().addAll(nombreText, placaText, marcaText, modeloText, colorText);
}


    private void mostrarError(String mensaje) {
        Text errorText = new Text(mensaje);
        
        Font font = new Font("Javanese Text", 20); // Tamaño de fuente 20, ajusta según tus necesidades
        Color textColor = Color.WHITE;
        
        errorText.setFont(font);
        errorText.setFill(textColor);
        
        infoConductorVBox.getChildren().add(errorText);
    }

    private void cargarConductoresDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 9) {
                    String nombres = partes[0];
                    String apellidos = partes[1];
                    int id = Integer.parseInt(partes[2]);
                    String correo = partes[3];
                    String sexo = partes[4];
                    String placa = partes[5];
                    String marca = partes[6];
                    String color = partes[7];
                    String modelo = partes[8];

                    Vehiculo vehiculo = new Vehiculo(placa, color, marca, modelo, id);
                    Conductor conductor = new Conductor(nombres, apellidos, id, sexo, correo, vehiculo);
                    logicaConductor.registrar(conductor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void clickBtnClose() {
        System.exit(0);
    }
    
}
