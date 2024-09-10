package com.mycompany.secure.transitgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("Rol"));
        stage.setScene(scene);

        scene.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

            stage.setOpacity(.8);
        });

        scene.setOnMouseReleased((MouseEvent event) -> {
            stage.setOpacity(1);
        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.sizeToScene();

        stage.show();
    }

    public static void setNewScene(String fxml) throws IOException {
        Window ventana = scene.getWindow();
        Stage stage = (Stage) ventana;
        setRoot(fxml);
        stage.sizeToScene();
    }

    // Lee un componente a partir de un archivo FXML y lo retorna como nodo
    public static Node loadComponent(String fxml) throws IOException {
        return (Node) loadFXML(fxml);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
