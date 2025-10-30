module co.edu.poli.actividad {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.actividad.vista to javafx.fxml;
    opens co.edu.poli.actividad.controlador to javafx.fxml;

    exports co.edu.poli.actividad.vista;
    exports co.edu.poli.actividad.controlador;
    exports co.edu.poli.actividad.modelo;
    exports co.edu.poli.actividad.servicios;
}
