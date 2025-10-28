package co.edu.actividad;

import java.io.IOException;

import co.edu.actividad.vista.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}