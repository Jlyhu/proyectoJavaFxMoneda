package co.edu.actividad.modelo;

import java.io.Serializable;

/**
 * Clase que representa una moneda antigua.
 * Extiende la clase abstracta Moneda y añade características específicas
 * para monedas históricas antiguas.
 * 
 * @author Juliana
 * @version 1.0
 */

public class Antigua extends Moneda implements Serializable {
    private String siglo;
    private String estadoConservacion;

    /**
     * Constructor parametrizado de la clase Antigua.
     * 
     * @param serial Número de serie único de la moneda
     * @param material Material de fabricación
     * @param tamano Tamaño de la moneda
     * @param valor Valor monetario
     * @param tipo Tipo de moneda
     * @param rareza Nivel de rareza
     * @param epoca Época de creación
     * @param anoCreacion Año de creación
     * @param esAutentica Indica si es auténtica
     * @param protector Protector asociado
     * @param pais País de origen
     * @param siglo Siglo al que pertenece
     * @param estadoConservacion Estado de conservación actual
     */
    public Antigua(String serial, String material, String tamano, String valor, String tipo, String rareza, 
                  String epoca, int anoCreacion, boolean esAutentica, Protector protector, Pais pais,
                  String siglo, String estadoConservacion) {
        super(serial, material, tamano, valor, tipo, rareza, epoca, anoCreacion, esAutentica, protector, pais);
        this.siglo = siglo;
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    protected String mostrarInformacion() {
        return "Moneda Antigua - Siglo: " + siglo + ", Estado: " + estadoConservacion + 
               ", Año: " + anoCreacion + ", País: " + (pais != null ? pais.getNombre() : "N/A");
    }

    @Override
    protected String mostrarInformacion(String detalleExtra) {
        return mostrarInformacion() + " - Detalle: " + detalleExtra;
    }

    // Getters y Setters
    
    /**
     * Obtiene el siglo al que pertenece la moneda antigua.
     * @return El siglo de la moneda.
     */
    
    public String getSiglo() { return siglo; }
    
    /**
     * Establece el siglo al que pertenece la moneda antigua.
     * @param siglo El nuevo siglo de la moneda.
     */
    
    public void setSiglo(String siglo) { this.siglo = siglo; }
    
    /**
     * Obtiene el estado de conservación de la moneda.
     * @return El estado de conservación.
     */
    public String getEstadoConservacion() { return estadoConservacion; }
    
    /**
     * Establece el estado de conservación de la moneda.
     * @param estadoConservacion El nuevo estado de conservación.
     */
    public void setEstadoConservacion(String estadoConservacion) { this.estadoConservacion = estadoConservacion; }
}