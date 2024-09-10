/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui;

import com.mycompany.secure.transitgui.entidades.Persona;
import com.mycompany.secure.transitgui.entidades.Usuario;
import com.mycompany.secure.transitgui.logica.LogicaUsuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author OSMAR LOPEZ
 */
public class RegistroUsuarioController implements Initializable {

    private LogicaUsuario logica = new LogicaUsuario();

    @FXML
    private Hyperlink hyperLink;

    @FXML
    private TextField apellido;

    @FXML
    private Button btnRegistro;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private TextField nombre;

    @FXML
    private RadioButton femenino;

    @FXML
    private RadioButton masculino;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private ToggleGroup group;
    
    @FXML
    private Button btnClose;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void registrar() {
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt",true))) {
            String name = nombre.getText();
            String surname = apellido.getText();
            int iden = Integer.parseInt(id.getText());
            String emei = email.getText();
            String user = username.getText();
            String contraseña = password.getText();
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String genderText = selectedRadioButton.getText();
            char gender = genderText.charAt(0);
            Usuario usuario = new Usuario(name, surname, iden, user, emei, contraseña, user);
            logica.registrar(usuario);
            writer.write(user + "," + contraseña + "," + emei + "," + name + "," + surname + "," + gender);
            writer.newLine();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de Registro");
            alert.setHeaderText("Informacion de credenciales registradas");
            alert.setContentText("Las credenciales registradas han sido guardadas correctamente" +
                    "Usuario: " + user);
            System.out.println("Usuarios registrados" + this.logica.listar());
            
            alert.show();
            clearFields();
            App.setNewScene("Login");
        } catch (IOException ex) {
            System.out.println("Error al registrar");
        }catch(NumberFormatException ne){
            System.out.println("Error");
        }
    }

    @FXML
    private void clickLink() {
        hyperLink.setOnMouseClicked(event -> {
            try {
                App.setNewScene("Login");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void clearFields() {
        nombre.setText("");
        apellido.setText("");
        id.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        group.selectToggle(null); // Desseleccionar los RadioButtons
    }
    
    @FXML
    private void clickBtnClose() throws IOException{
        App.setNewScene("Rol");
    }
}
