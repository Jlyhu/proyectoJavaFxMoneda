package co.edu.poli.actividad.modelo;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que representa una colección de monedas perteneciente a un coleccionista.
 * Contiene información sobre el identificador de la colección, el tipo de acceso,
 * el tipo de colección, las monedas que la componen y el coleccionista propietario.
 * 
 * @author Juliana
 * @version 1.0
 */

public class Coleccion implements Serializable {
    private String idColeccion; // Identificador único de la colección
    private String acceso; // Tipo de acceso (público, privado, etc.)
    private String tipo; // Tipo de colección (temática, histórica, etc.)
    private Moneda[] moneda; // Arreglo de objetos Moneda que pertenecen a la colección
    private Coleccionista coleccionista; // Coleccionista propietario de la colección

    /**
     * Constructor que inicializa todos los atributos de la clase Coleccion.
     * 
     * @param idColeccion   Identificador de la colección
     * @param acceso        Tipo de acceso de la colección
     * @param tipo          Tipo de colección
     * @param moneda        Arreglo de monedas que pertenecen a la colección
     * @param coleccionista Coleccionista propietario de la colección
     */
    
    public Coleccion(String idColeccion, String acceso, String tipo, Moneda[] moneda, Coleccionista coleccionista) {
        super();
        this.idColeccion = idColeccion;
        this.acceso = acceso;
        this.tipo = tipo;
        this.moneda = moneda;
        this.coleccionista = coleccionista;
    }

    /**
     * Retorna el identificador único de la colección.
     * @return el identificador de la colección 
     */
    
    public String getIdColeccion() {
        return idColeccion;
    }

    /**
     * Establece un nuevo identificador único para la colección.
     * @param idColeccion el nuevo identificador de la colección 
     */
    public void setIdColeccion(String idColeccion) {
        this.idColeccion = idColeccion;
    }


    /**
     * Retorna el tipo de acceso de la colección (público, privado, etc.).
     * @return el tipo de acceso de la colección 
     */
    public String getAcceso() {
        return acceso;
    }

    /**
     * Establece el tipo de acceso de la colección.
     * @param acceso el nuevo tipo de acceso de la colección 
     */
    
    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    /**
     * Retorna el tipo o tema de la colección.
     * @return el tipo de colección 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo o tema de la colección.
     * @param tipo el nuevo tipo de colección 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el arreglo de objetos Moneda que componen la colección.
     * @return el arreglo de monedas de la colección 
     */
    public Moneda[] getMoneda() {
        return moneda;
    }

    /**
     * Establece el arreglo de objetos Moneda de la colección.
     * @param moneda el nuevo arreglo de monedas de la colección 
     */
    public void setMoneda(Moneda[] moneda) {
        this.moneda = moneda;
    }

    /**
     * Establece el coleccionista propietario de esta colección.
     * @param coleccionista el nuevo coleccionista propietario de la colección 
     */
    public void setColeccionista(Coleccionista coleccionista) {
        this.coleccionista = coleccionista;
    }
    
    /**
     * Devuelve una representación en cadena de la colección, incluyendo sus atributos.
     * @return una cadena con la información de la colección
     */
    @Override
    public String toString() {
        return "Coleccion [idColeccion=" + idColeccion + ", acceso=" + acceso + ", tipo=" + tipo + ", moneda="
                + Arrays.toString(moneda) + ", coleccionista=" + coleccionista + "]";
    }

    /**
     * Busca una moneda en la colección por su identificador (serial).
     * @param idMoneda el identificador de la moneda a buscar
     * @return la información de la moneda si se encuentra, o un mensaje indicando que no fue encontrada
     */
    public String buscarMoneda(String idMoneda) {
        for (Moneda m : moneda) {
            if (m.getSerial().equals(idMoneda)) {
                return m.mostrarInformacion();
            }
        }
        return "Moneda no encontrada.";
    }
}