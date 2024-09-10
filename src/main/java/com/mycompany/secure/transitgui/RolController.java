/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author OSMAR LOPEZ
 */
public class RolController implements Initializable{
    
    @FXML private ImageView conductor;
    @FXML private ImageView usuario;
    @FXML private Button btnClose;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void clickImage(){
        conductor.setOnMouseClicked(event -> {
            try {
                App.setNewScene("RegistroConductor");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        usuario.setOnMouseClicked(event -> {
            try {
                App.setNewScene("RegistroUsuario");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    @FXML
    private void close(){
        System.exit(0);
    }
    
    
}
