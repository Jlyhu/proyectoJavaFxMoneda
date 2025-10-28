package co.edu.actividad.modelo;

import java.io.Serializable;

/**
 * Clase que representa una valoración realizada sobre una moneda.
 * Contiene información sobre el identificador de la valoración, el tipo de valoración,
 * el nivel de precisión y la moneda a la que se le aplica dicha valoración.
 * * @author Juliana
 * @version 1.0
 */


public class Valoracion implements Serializable {
    private String idValoracion; // Identificador único de la valoración
    private String tipo;         // Tipo de valoración (histórica, económica, estética, etc.)
    private String presicion;    // Nivel de precisión de la valoración
    private Moneda moneda;       // Moneda a la que se le aplica la valoración

    /**
     * Constructor que inicializa todos los atributos de la clase Valoracion.
     * @param idValoracion Identificador único de la valoración
     * @param tipo         Tipo de valoración
     * @param presicion    Nivel de precisión de la valoración
     * @param moneda       Moneda valorada
     */
    public Valoracion(String idValoracion, String tipo, String presicion, Moneda moneda) {
        super();
        this.idValoracion = idValoracion;
        this.tipo = tipo;
        this.presicion = presicion;
        this.moneda = moneda;
    }

    /**
     * Obtiene el identificador único de la valoración.
     * @return el identificador de la valoración 
     */
    public String getIdValoracion() {
        return idValoracion;
    }

    /**
     * Establece un nuevo identificador único para la valoración.
     * @param idValoracion el nuevo identificador de la valoración 
     */
    public void setIdValoracion(String idValoracion) {
        this.idValoracion = idValoracion;
    }

    /**
     * Obtiene el tipo de valoración.
     * @return el tipo de valoración 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el nuevo tipo de valoración.
     * @param tipo el nuevo tipo de valoración 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el nivel de precisión de la valoración.
     * @return el nivel de precisión de la valoración 
     */
    public String getPresicion() {
        return presicion;
    }

    /**
     * Establece el nivel de precisión de la valoración.
     * @param presicion el nuevo nivel de precisión de la valoración 
     */
    public void setPresicion(String presicion) {
        this.presicion = presicion;
    }

    /**
     * Obtiene la moneda a la que se le aplicó esta valoración.
     * @return la moneda valorada 
     */
    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * Establece la nueva moneda a la que se aplicará la valoración.
     * @param moneda la nueva moneda valorada 
     */
    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Devuelve una representación en cadena de la valoración.
     * @return una cadena con la información de la valoración
     */
    @Override
    public String toString() {
        return "Valoracion [idValoracion=" + idValoracion + ", tipo=" + tipo + ", presicion=" + presicion + ", moneda="
                + moneda + "]";
    }
}