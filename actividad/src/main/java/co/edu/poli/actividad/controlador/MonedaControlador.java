package co.edu.poli.actividad.controlador;
//:)
import java.util.Optional;

import co.edu.poli.actividad.modelo.*;
import co.edu.poli.actividad.servicios.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class MonedaControlador {

    @FXML private Button btt1;
    @FXML private Button btt2;
    @FXML private Button btt3;
    @FXML private Button btt4;
    @FXML private Button btt5;
    
    @FXML private Label lbl1;
    @FXML private Label lbl2;
    
    @FXML private TextField txtSerial, txtMaterial, txtTamano, txtValor;
    @FXML private DatePicker datePickerAnio;
    @FXML private ComboBox<String> cmbTipo, cmbRareza, cmbEpoca, cmbPais, cmbProtector;
    @FXML private RadioButton rbAntigua, rbConmemorativa, rbGriega;
    @FXML private CheckBox chkEdicionLimitada, chkAutenticada, chkConservacion;
    @FXML private TableView<Moneda> tblView;
    @FXML private TableColumn<Moneda, String> columnSerial, columnMaterial, columnTamano, columnValor, columnAnio, columnTipo, columnCategoria, columnPais, columnProtector, columnEdicion;
    
    // ⭐ ESTA ES LA LÍNEA QUE FALTABA ⭐
    @FXML private ToggleGroup categoria;
    
    ObservableList<Moneda> monedas;
    ImplementacionOperacionCRUD crud;
    
    private final String PATH = ".";
    private final String NOMBRE_ARCHIVO = "monedas.dat";

    @FXML
    public void initialize() {
        monedas = FXCollections.observableArrayList();
        crud = new ImplementacionOperacionCRUD();

        // Cargar datos guardados al iniciar
        cargarDatosIniciales();

        // Configurar ComboBoxes
        ObservableList<String> listTipo = FXCollections.observableArrayList(
            "Comercial", "Conmemorativa", "Histórica", "Colección"
        );
        cmbTipo.setItems(listTipo);

        ObservableList<String> listRareza = FXCollections.observableArrayList(
            "Común", "Rara", "Muy rara", "Única"
        );
        cmbRareza.setItems(listRareza);

        ObservableList<String> listEpoca = FXCollections.observableArrayList(
            "Antigua", "Colonial", "Moderna", "Contemporánea"
        );
        cmbEpoca.setItems(listEpoca);

        ObservableList<String> listPais = FXCollections.observableArrayList(
            "Colombia", "México", "España", "Grecia", "Italia", "Otro"
        );
        cmbPais.setItems(listPais);

        ObservableList<String> listProtector = FXCollections.observableArrayList(
            "Plástico-Caja", "Acrílico-Cápsula", "Metal-Estuche", "Ninguno"
        );
        cmbProtector.setItems(listProtector);
        
        // Actualizar contador de registros
        actualizarContador();
    }
    
    private void cargarDatosIniciales() {
        try {
            Moneda[] monedasCargadas = crud.deserializar(PATH, NOMBRE_ARCHIVO);
            if (monedasCargadas != null) {
                crud.setMonedas(monedasCargadas);
                monedas.clear();
                for (Moneda m : crud.read()) {
                    if (m != null) {
                        monedas.add(m);
                    }
                }
                loadTable();
            }
        } catch (Exception e) {
            System.out.println("No hay datos previos: " + e.getMessage());
        }
    }
    
    private void actualizarContador() {
        if (lbl2 != null) {
            lbl2.setText(String.valueOf(monedas.size()));
        }
    }

    @FXML
    void press1(ActionEvent event) {
        Alert a = new Alert(AlertType.CONFIRMATION);
        try {
            if (!validarCampos()) {
                throw new Exception("Por favor complete todos los campos obligatorios");
            }

            RadioButton rbaux = (RadioButton) categoria.getSelectedToggle();
            if (rbaux == null) {
                throw new Exception("Debe seleccionar una categoría");
            }

            // Crear protector y país
            String[] protectorData = cmbProtector.getValue().split("-");
            Protector protector = new Protector("P-" + txtSerial.getText(),
                                               protectorData[0],
                                               protectorData.length > 1 ? protectorData[1] : "");

            Pais pais = new Pais(cmbPais.getValue().substring(0, 3).toUpperCase(),
                                cmbPais.getValue());

            int anio = datePickerAnio.getValue().getYear();

            Moneda nuevaMoneda = null;

            // Crear según categoría seleccionada
            if (rbaux.getText().equals("Antigua")) {
                nuevaMoneda = new Antigua(
                    txtSerial.getText(), txtMaterial.getText(), txtTamano.getText(), txtValor.getText(),
                    cmbTipo.getValue(), cmbRareza.getValue(), cmbEpoca.getValue(),
                    anio, chkAutenticada.isSelected(), protector, pais,
                    "Siglo " + (anio / 100), chkConservacion.isSelected() ? "Excelente" : "Buena"
                );
            } else if (rbaux.getText().equals("Conmemorativa")) {
                nuevaMoneda = new Conmemorativa(
                    txtSerial.getText(), txtMaterial.getText(), txtTamano.getText(), txtValor.getText(),
                    cmbTipo.getValue(), cmbRareza.getValue(), cmbEpoca.getValue(),
                    anio, chkAutenticada.isSelected(), protector, pais,
                    chkEdicionLimitada.isSelected(), "Evento " + anio
                );
            } else if (rbaux.getText().equals("Griega")) {
                nuevaMoneda = new Griega(
                    txtSerial.getText(), txtMaterial.getText(), txtTamano.getText(), txtValor.getText(),
                    cmbTipo.getValue(), cmbRareza.getValue(), cmbEpoca.getValue(),
                    anio, chkAutenticada.isSelected(), protector, pais,
                    "Siglo " + (anio / 100), chkConservacion.isSelected() ? "Excelente" : "Buena",
                    cmbPais.getValue(), "Período clásico"
                );
            }

            if (nuevaMoneda != null) {
                a.setContentText(crud.create(nuevaMoneda));
                monedas.add(nuevaMoneda);
                loadTable();
                actualizarContador();
                clear();
            }

            a.show();

        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText(e.getMessage());
            a.show();
        }
    }

    @FXML
    void press2(ActionEvent event) {
        Alert a = new Alert(AlertType.INFORMATION);
        String mensaje = crud.serializar(crud.read(), PATH, NOMBRE_ARCHIVO);
        a.setContentText(mensaje);
        a.show();
    }

    @FXML
    void press3(ActionEvent event) {
        Alert a = new Alert(AlertType.INFORMATION);
        try {
            Moneda[] monedasCargadas = crud.deserializar(PATH, NOMBRE_ARCHIVO);
            if (monedasCargadas != null) {
                crud.setMonedas(monedasCargadas);
                monedas.clear();
                
                for (Moneda m : crud.read()) {
                    if (m != null) {
                        monedas.add(m);
                    }
                }
                
                loadTable();
                actualizarContador();
                a.setContentText("Archivo cargado exitosamente");
            } else {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("No se encontró el archivo");
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Error al cargar archivo: " + e.getMessage());
        }
        a.show();
    }

    @FXML
    void press4(ActionEvent event) {
        Alert a = new Alert(AlertType.CONFIRMATION);
        try {
            Moneda oldMoneda = tblView.getSelectionModel().getSelectedItem();

            if (oldMoneda == null) {
                throw new Exception("Debe seleccionar una moneda de la tabla");
            }

            RadioButton rbaux = (RadioButton) categoria.getSelectedToggle();
            if (rbaux == null) {
                throw new Exception("Debe seleccionar una categoría");
            }

            // Crear protector y país
            String[] protectorData = cmbProtector.getValue().split("-");
            Protector protector = new Protector("P-" + oldMoneda.getSerial(),
                                               protectorData[0],
                                               protectorData.length > 1 ? protectorData[1] : "");

            Pais pais = new Pais(cmbPais.getValue().substring(0, 3).toUpperCase(),
                                cmbPais.getValue());

            int anio = datePickerAnio.getValue().getYear();

            Moneda monedaActualizada = null;

            if (rbaux.getText().equals("Antigua")) {
                monedaActualizada = new Antigua(
                    oldMoneda.getSerial(), txtMaterial.getText(), txtTamano.getText(), txtValor.getText(),
                    cmbTipo.getValue(), cmbRareza.getValue(), cmbEpoca.getValue(),
                    anio, chkAutenticada.isSelected(), protector, pais,
                    "Siglo " + (anio / 100), chkConservacion.isSelected() ? "Excelente" : "Buena"
                );
            } else if (rbaux.getText().equals("Conmemorativa")) {
                monedaActualizada = new Conmemorativa(
                    oldMoneda.getSerial(), txtMaterial.getText(), txtTamano.getText(), txtValor.getText(),
                    cmbTipo.getValue(), cmbRareza.getValue(), cmbEpoca.getValue(),
                    anio, chkAutenticada.isSelected(), protector, pais,
                    chkEdicionLimitada.isSelected(), "Evento " + anio
                );
            } else if (rbaux.getText().equals("Griega")) {
                monedaActualizada = new Griega(
                    oldMoneda.getSerial(), txtMaterial.getText(), txtTamano.getText(), txtValor.getText(),
                    cmbTipo.getValue(), cmbRareza.getValue(), cmbEpoca.getValue(),
                    anio, chkAutenticada.isSelected(), protector, pais,
                    "Siglo " + (anio / 100), chkConservacion.isSelected() ? "Excelente" : "Buena",
                    cmbPais.getValue(), "Período clásico"
                );
            }

            if (monedaActualizada != null) {
                monedas.set(monedas.indexOf(oldMoneda), monedaActualizada);
                a.setContentText(crud.update(oldMoneda.getSerial(), monedaActualizada));
                loadTable();
                actualizarContador();
                clear();
            }

        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Error: " + e.getMessage());
        }
        a.show();
    }
    
    @FXML
    void press5(ActionEvent event) {
        Alert a = new Alert(AlertType.CONFIRMATION);
        try {
            a.setContentText("¿Desea eliminar el registro?");
            Optional<ButtonType> result = a.showAndWait();
            
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Moneda m = tblView.getSelectionModel().getSelectedItem();
                
                if (m == null) {
                    throw new Exception("Debe seleccionar una moneda");
                }
                
                crud.delete(m.getSerial());
                monedas.remove(m);
                loadTable();
                actualizarContador();
                clear();
                
                a = new Alert(AlertType.INFORMATION);
                a.setContentText("Moneda eliminada exitosamente");
                a.show();
            }
        } catch (Exception e) {
            a = new Alert(AlertType.WARNING);
            a.setContentText("Error: " + e.getMessage());
            a.show();
        }
    }

    void loadTable() {
        columnSerial.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSerial()));
        columnMaterial.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMaterial()));
        columnTamano.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTamano()));
        columnValor.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getValor()));
        columnAnio.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getAnoCreacion())));
        columnTipo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTipo()));
        columnCategoria.setCellValueFactory(cell -> {
            if (cell.getValue() instanceof Griega) return new SimpleStringProperty("Griega");
            if (cell.getValue() instanceof Conmemorativa) return new SimpleStringProperty("Conmemorativa");
            if (cell.getValue() instanceof Antigua) return new SimpleStringProperty("Antigua");
            return new SimpleStringProperty("");
        });
        columnPais.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPais() != null ? cell.getValue().getPais().getNombre() : ""));
        columnProtector.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getProtector() != null ? cell.getValue().getProtector().toString() : ""));
        columnEdicion.setCellValueFactory(cell -> {
            if (cell.getValue() instanceof Conmemorativa) {
                return new SimpleStringProperty(((Conmemorativa) cell.getValue()).isEsEdicionLimitada() ? "Sí" : "No");
            }
            return new SimpleStringProperty("-");
        });
        tblView.setItems(monedas);
    }

    void clear() {
        txtSerial.clear();
        txtMaterial.clear();
        txtTamano.clear();
        txtValor.clear();
        datePickerAnio.setValue(null);
        rbAntigua.setSelected(true);
        cmbTipo.setValue(null);
        cmbRareza.setValue(null);
        cmbEpoca.setValue(null);
        cmbPais.setValue(null);
        cmbProtector.setValue(null);
        chkEdicionLimitada.setSelected(false);
        chkAutenticada.setSelected(false);
        chkConservacion.setSelected(false);
    }
    
    private boolean validarCampos() {
        return txtSerial.getText() != null && !txtSerial.getText().isEmpty() &&
               txtMaterial.getText() != null && !txtMaterial.getText().isEmpty() &&
               txtTamano.getText() != null && !txtTamano.getText().isEmpty() &&
               txtValor.getText() != null && !txtValor.getText().isEmpty() &&
               datePickerAnio.getValue() != null &&
               cmbTipo.getValue() != null &&
               cmbRareza.getValue() != null &&
               cmbEpoca.getValue() != null &&
               cmbPais.getValue() != null &&
               cmbProtector.getValue() != null;
    }
    
    @FXML
    void displaySelected(MouseEvent event) {
        try {
            Moneda moneda = tblView.getSelectionModel().getSelectedItem();

            if (moneda == null) return;

            txtSerial.setText(moneda.getSerial());
            txtMaterial.setText(moneda.getMaterial());
            txtTamano.setText(moneda.getTamano());
            txtValor.setText(moneda.getValor());
            datePickerAnio.setValue(java.time.LocalDate.of(moneda.getAnoCreacion(), 1, 1));
            cmbTipo.setValue(moneda.getTipo());
            cmbRareza.setValue(moneda.getRareza());
            cmbEpoca.setValue(moneda.getEpoca());

            if (moneda.getPais() != null) {
                cmbPais.setValue(moneda.getPais().getNombre());
            }

            if (moneda.getProtector() != null) {
                cmbProtector.setValue(moneda.getProtector().getMaterial() + "-" +
                                     moneda.getProtector().getTipo());
            }

            // Seleccionar categoría
            if (moneda instanceof Griega) {
                categoria.selectToggle(rbGriega);
            } else if (moneda instanceof Conmemorativa) {
                categoria.selectToggle(rbConmemorativa);
                chkEdicionLimitada.setSelected(((Conmemorativa) moneda).isEsEdicionLimitada());
            } else if (moneda instanceof Antigua) {
                categoria.selectToggle(rbAntigua);
            }

            chkAutenticada.setSelected(moneda.isEsAutentica());

        } catch (Exception e) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Error al cargar datos: " + e.getMessage());
            a.show();
        }
    }
}