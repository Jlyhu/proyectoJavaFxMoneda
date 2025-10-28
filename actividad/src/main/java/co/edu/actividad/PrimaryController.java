package co.edu.actividad;

import java.io.IOException;

import co.edu.actividad.vista.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
