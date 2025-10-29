package co.edu.poli.actividad.modelo;

import java.io.Serializable;

/**
 * Clase que representa un protector utilizado para resguardar una moneda.
 * Contiene información sobre el identificador del protector, el material del que está hecho
 * y el tipo de protector (por ejemplo, cápsula, sobre, caja, etc.).
 * * @author Juliana
 * @version 1.0
 */


public class Protector implements Serializable {
    private String idProtector; // Identificador único del protector
    private String material;    // Material del protector (plástico, vidrio, etc.)
    private String tipo;        // Tipo de protector

    /**
     * Constructor que inicializa los atributos del protector.
     * @param idProtector Identificador único del protector
     * @param material    Material del protector
     * @param tipo        Tipo de protector
     */
    public Protector(String idProtector, String material, String tipo) {
        super();
        this.idProtector = idProtector;
        this.material = material;
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador único del protector.
     * @return el identificador del protector 
     */
    public String getIdProtector() {
        return idProtector;
    }

    /**
     * Establece el nuevo identificador único del protector.
     * @param idProtector el nuevo identificador del protector 
     */
    public void setIdProtector(String idProtector) {
        this.idProtector = idProtector;
    }

    /**
     * Obtiene el material del protector.
     * @return el material del protector 
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el nuevo material del protector.
     * @param material el nuevo material del protector 
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene el tipo de protector (cápsula, sobre, etc.).
     * @return el tipo de protector 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el nuevo tipo de protector.
     * @param tipo el nuevo tipo de protector 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una representación en cadena del protector.
     * @return una cadena con la información del protector
     */
    @Override
    public String toString() {
        return "Protector [idProtector=" + idProtector + ", material=" + material + ", tipo=" + tipo + "]";
    }
}