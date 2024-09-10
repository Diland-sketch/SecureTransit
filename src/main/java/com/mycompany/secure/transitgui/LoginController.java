/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.secure.transitgui;

import com.mycompany.secure.transitgui.logica.LogicaUsuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author OSMAR LOPEZ
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btnLogin;
    @FXML private Button btnClose;  
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    private LogicaUsuario logicaUsuario = new LogicaUsuario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void clickBtnLogin() throws IOException {
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        System.out.println("Usuarios registrados: "+ this.logicaUsuario.listar());
        if (this.logicaUsuario.login(username, password)) {
            // App.setStage("home");
            App.setNewScene("Dashboard");
        } else {
            // Genera mensaje de notificacion
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje de Login");
            alert.setHeaderText("Información de credenciales incorrecta");
            alert.setContentText("Las credenciales ingresadas no son correctas, intente nuevamente.");
            alert.show();
        }
        try(BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))){
            String line;
            boolean isAutenticado = false;
            while((line = reader.readLine()) != null){
                String[] userDetails = line.split(",");
                if(userDetails.length == 6 && userDetails[0].equals(username) && userDetails[1].equals(password)){
                    isAutenticado = true;
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("ERROOOOOR");
        }
        
    }
    
    @FXML
    private void close() throws IOException{
       App.setNewScene("RegistroUsuario");
    }
    
}
