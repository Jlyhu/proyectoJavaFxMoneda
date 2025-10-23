module co.edu.actividad {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.actividad to javafx.fxml;
    exports co.edu.actividad;
}
