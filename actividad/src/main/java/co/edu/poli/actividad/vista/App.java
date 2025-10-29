package co.edu.poli.actividad.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App - Sistema de Gestión de Monedas
 * 
 * @author Juliana
 * @version 1.0
 */
public class App extends Application {
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML del formulario de monedas
    	scene = new Scene(loadFXML("MonedaFormulario"), 900, 700);
        stage.setTitle("Sistema de Gestión de Monedas - CRUD");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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