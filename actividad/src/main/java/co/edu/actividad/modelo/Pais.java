package co.edu.actividad.modelo;

import java.io.Serializable;

/**
 * Clase que representa un país con un identificador único y un nombre.
 * Esta clase se utiliza para asociar monedas u otros elementos con su país de origen.
 * * @author Juliana
 * @version 1.0
 */

public class Pais implements Serializable{
    private String idPais; // Identificador único del país
    private String nombre; // Nombre del país

    /**
     * Constructor que inicializa los atributos del país.
     * @param idPais Identificador único del país
     * @param nombre Nombre del país
     */
    public Pais(String idPais, String nombre) {
        super();
        this.idPais = idPais;
        this.nombre = nombre;
    }

    /** 
     * Obtiene el identificador único del país.
     * @return el identificador del país 
     */
    public String getIdPais() {
        return idPais;
    }

    /** 
     * Establece el nuevo identificador único del país.
     * @param idPais el nuevo identificador del país 
     */
    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    /**
     * Obtiene el nombre del país.
     * @return el nombre del país 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nuevo nombre del país.
     * @param nombre el nuevo nombre del país 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representación en cadena del país.
     * @return una cadena con la información del país
     */
    @Override
    public String toString() {
        return "Pais [idPais=" + idPais + ", nombre=" + nombre + "]";
    }
}