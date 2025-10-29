package co.edu.poli.actividad.controlador;

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
    
    @FXML private TextField txt1; // Serial
    @FXML private TextField txt2; // Material
    @FXML private TextField txt3; // Tamaño
    @FXML private TextField txt4; // Valor
    @FXML private TextField txt5; // Año Creación
    
    @FXML private RadioButton rb1; // Antigua
    @FXML private RadioButton rb2; // Conmemorativa
    @FXML private RadioButton rb3; // Griega
    @FXML private ToggleGroup categoria;
    
    @FXML private ComboBox<String> cmb1; // Tipo
    @FXML private ComboBox<String> cmb2; // Rareza
    @FXML private ComboBox<String> cmb3; // Época
    @FXML private ComboBox<String> cmbPais;
    @FXML private ComboBox<String> cmbProtector;
    
    @FXML private CheckBox chkbox1;
    @FXML private CheckBox chkbox2;
    @FXML private CheckBox chkbox3;
    @FXML private Group GroupChkBox;
    
    @FXML private TableColumn<Moneda, String> column1;
    @FXML private TableColumn<Moneda, String> column2;
    @FXML private TableColumn<Moneda, String> column3;
    @FXML private TableColumn<Moneda, String> column4;
    @FXML private TableColumn<Moneda, String> column5;
    @FXML private TableColumn<Moneda, String> column6;
    @FXML private TableColumn<Moneda, String> column7;
    
    @FXML private TableView<Moneda> tblView;
    
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
        cmb1.setItems(listTipo);
        
        ObservableList<String> listRareza = FXCollections.observableArrayList(
            "Común", "Rara", "Muy rara", "Única"
        );
        cmb2.setItems(listRareza);
        
        ObservableList<String> listEpoca = FXCollections.observableArrayList(
            "Antigua", "Colonial", "Moderna", "Contemporánea"
        );
        cmb3.setItems(listEpoca);
        
        ObservableList<String> listPais = FXCollections.observableArrayList(
            "Colombia", "México", "España", "Grecia", "Italia", "Otro"
        );
        cmbPais.setItems(listPais);
        
        ObservableList<String> listProtector = FXCollections.observableArrayList(
            "Plástico-Caja", "Acrílico-Cápsula", "Metal-Estuche", "Ninguno"
        );
        cmbProtector.setItems(listProtector);
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
            Protector protector = new Protector("P-" + txt1.getText(), 
                                               protectorData[0], 
                                               protectorData.length > 1 ? protectorData[1] : "");
            
            Pais pais = new Pais(cmbPais.getValue().substring(0, 3).toUpperCase(), 
                                cmbPais.getValue());
            
            int anio = Integer.parseInt(txt5.getText());
            
            Moneda nuevaMoneda = null;
            
            // Crear según categoría seleccionada
            if (rbaux.getText().equals("Antigua")) {
                nuevaMoneda = new Antigua(
                    txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(),
                    cmb1.getValue(), cmb2.getValue(), cmb3.getValue(),
                    anio, chkbox2.isSelected(), protector, pais,
                    "Siglo " + (anio/100), chkbox3.isSelected() ? "Excelente" : "Buena"
                );
            } else if (rbaux.getText().equals("Conmemorativa")) {
                nuevaMoneda = new Conmemorativa(
                    txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(),
                    cmb1.getValue(), cmb2.getValue(), cmb3.getValue(),
                    anio, chkbox2.isSelected(), protector, pais,
                    chkbox1.isSelected(), "Evento " + anio
                );
            } else if (rbaux.getText().equals("Griega")) {
                nuevaMoneda = new Griega(
                    txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(),
                    cmb1.getValue(), cmb2.getValue(), cmb3.getValue(),
                    anio, chkbox2.isSelected(), protector, pais,
                    "Siglo " + (anio/100), chkbox3.isSelected() ? "Excelente" : "Buena",
                    cmbPais.getValue(), "Período clásico"
                );
            }
            
            if (nuevaMoneda != null) {
                a.setContentText(crud.create(nuevaMoneda));
                monedas.add(nuevaMoneda);
                loadTable();
                clear();
            }
            
            a.show();
            
        } catch (NumberFormatException e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("El año debe ser un número válido");
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
            
            int anio = Integer.parseInt(txt5.getText());
            
            Moneda monedaActualizada = null;
            
            if (rbaux.getText().equals("Antigua")) {
                monedaActualizada = new Antigua(
                    oldMoneda.getSerial(), txt2.getText(), txt3.getText(), txt4.getText(),
                    cmb1.getValue(), cmb2.getValue(), cmb3.getValue(),
                    anio, chkbox2.isSelected(), protector, pais,
                    "Siglo " + (anio/100), chkbox3.isSelected() ? "Excelente" : "Buena"
                );
            } else if (monedaActualizada instanceof Conmemorativa) {
                monedaActualizada = new Conmemorativa(
                    oldMoneda.getSerial(), txt2.getText(), txt3.getText(), txt4.getText(),
                    cmb1.getValue(), cmb2.getValue(), cmb3.getValue(),
                    anio, chkbox2.isSelected(), protector, pais,
                    chkbox1.isSelected(), "Evento " + anio
                );
            } else if (rbaux.getText().equals("Griega")) {
                monedaActualizada = new Griega(
                    oldMoneda.getSerial(), txt2.getText(), txt3.getText(), txt4.getText(),
                    cmb1.getValue(), cmb2.getValue(), cmb3.getValue(),
                    anio, chkbox2.isSelected(), protector, pais,
                    "Siglo " + (anio/100), chkbox3.isSelected() ? "Excelente" : "Buena",
                    cmbPais.getValue(), "Período clásico"
                );
            }
            
            if (monedaActualizada != null) {
                monedas.set(monedas.indexOf(oldMoneda), monedaActualizada);
                a.setContentText(crud.update(oldMoneda.getSerial(), monedaActualizada));
                loadTable();
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
        column1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSerial()));
        column2.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMaterial()));
        column3.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTamano()));
        column4.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getValor()));
        column5.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getAnoCreacion())));
        column6.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTipo()));
        column7.setCellValueFactory(cell -> {
            String categoria = "";
            if (cell.getValue() instanceof Griega) categoria = "Griega";
            else if (cell.getValue() instanceof Conmemorativa) categoria = "Conmemorativa";
            else if (cell.getValue() instanceof Antigua) categoria = "Antigua";
            return new SimpleStringProperty(categoria);
        });
        
        tblView.setItems(monedas);
    }

    void clear() {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        rb1.setSelected(true);
        cmb1.setValue(null);
        cmb2.setValue(null);
        cmb3.setValue(null);
        cmbPais.setValue(null);
        cmbProtector.setValue(null);
        chkbox1.setSelected(false);
        chkbox2.setSelected(false);
        chkbox3.setSelected(false);
    }
    
    private boolean validarCampos() {
        return txt1.getText() != null && !txt1.getText().isEmpty() &&
               txt2.getText() != null && !txt2.getText().isEmpty() &&
               txt3.getText() != null && !txt3.getText().isEmpty() &&
               txt4.getText() != null && !txt4.getText().isEmpty() &&
               txt5.getText() != null && !txt5.getText().isEmpty() &&
               cmb1.getValue() != null &&
               cmb2.getValue() != null &&
               cmb3.getValue() != null &&
               cmbPais.getValue() != null &&
               cmbProtector.getValue() != null;
    }

    @FXML
    void displaySelected(MouseEvent event) {
        try {
            Moneda moneda = tblView.getSelectionModel().getSelectedItem();
            
            if (moneda == null) return;
            
            txt1.setText(moneda.getSerial());
            txt2.setText(moneda.getMaterial());
            txt3.setText(moneda.getTamano());
            txt4.setText(moneda.getValor());
            txt5.setText(String.valueOf(moneda.getAnoCreacion()));
            cmb1.setValue(moneda.getTipo());
            cmb2.setValue(moneda.getRareza());
            cmb3.setValue(moneda.getEpoca());
            
            if (moneda.getPais() != null) {
                cmbPais.setValue(moneda.getPais().getNombre());
            }
            
            if (moneda.getProtector() != null) {
                cmbProtector.setValue(moneda.getProtector().getMaterial() + "-" + 
                                     moneda.getProtector().getTipo());
            }
            
            // Seleccionar categoría
            if (moneda instanceof Griega) {
                categoria.selectToggle(rb3);
            } else if (moneda instanceof Conmemorativa) {
                categoria.selectToggle(rb2);
                chkbox1.setSelected(((Conmemorativa)moneda).isEsEdicionLimitada());
            } else if (moneda instanceof Antigua) {
                categoria.selectToggle(rb1);
            }
            
            chkbox2.setSelected(moneda.isEsAutentica());
            
        } catch (Exception e) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Error al cargar datos: " + e.getMessage());
            a.show();
        }
    }
}