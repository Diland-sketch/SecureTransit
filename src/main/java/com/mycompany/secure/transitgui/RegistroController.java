package com.mycompany.secure.transitgui;

import com.mycompany.secure.transitgui.entidades.Conductor;
import com.mycompany.secure.transitgui.entidades.Usuario;
import com.mycompany.secure.transitgui.entidades.Vehiculo;
import com.mycompany.secure.transitgui.logica.LogicaConductor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegistroController implements Initializable {

    @FXML
    private TextField apeconductor;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnregistrarconductor;

    @FXML
    private TextField colorvehiculo;

    @FXML
    private TextField emailconductor;

    @FXML
    private ToggleGroup group;

    @FXML
    private TextField idconductor;

    @FXML
    private TextField marcavehiculo;

    @FXML
    private TextField modelovehiculo;

    @FXML
    private TextField nomconductor;

    @FXML
    private TextField numplaca;

    private LogicaConductor logica = new LogicaConductor();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void clickBtnConductor() {
        int id = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conductores.txt", true))) {
            String name = nomconductor.getText();
            String surname = apeconductor.getText();
            int iden = Integer.parseInt(idconductor.getText());
            String emei = emailconductor.getText();
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String genderText = selectedRadioButton.getText();
            char gender = genderText.charAt(0);
            String placa = numplaca.getText();
            String marca = marcavehiculo.getText();
            String modelo = modelovehiculo.getText();
            String color = colorvehiculo.getText();
            Vehiculo vehiculo = new Vehiculo(placa, color, marca, modelo, id);
            Conductor conductor = new Conductor(name, surname, iden, null, emei, vehiculo);
            logica.registrar(conductor);
            writer.write(name + "," + surname + "," + iden + "," + emei + "," + gender + "," + vehiculo.getPlaca() + "," + vehiculo.getMarca() + "," + vehiculo.getColor() + "," + vehiculo.getModelo());
            writer.newLine();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de Registro");
            alert.setHeaderText("Informacion de credenciales registradas");
            alert.setContentText("Las credenciales registradas han sido guardadas correctamente"
                    + "Conductor: " + name);
            System.out.println("Conductores registrados" + this.logica.listar());

            alert.show();
            clearFields();
            App.setNewScene("Rol");
            id++;
        } catch (IOException ex) {
            System.out.println("Error al registrar");
        } catch (NumberFormatException ne) {
            System.out.println("Error");
        }
    }

    @FXML
    private void close() throws IOException {
        App.setNewScene("Rol");
    }

    private void clearFields() {
        nomconductor.setText("");
        apeconductor.setText("");
        idconductor.setText("");
        emailconductor.setText("");
        marcavehiculo.setText("");
        colorvehiculo.setText("");
        modelovehiculo.setText("");
        numplaca.setText("");
        group.selectToggle(null); // Desseleccionar los RadioButtons
    }

}
