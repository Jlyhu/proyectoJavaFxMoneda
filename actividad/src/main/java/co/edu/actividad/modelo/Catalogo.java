package co.edu.actividad.modelo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Representa un catálogo de monedas en el sistema.
 * <p>
 * Contiene información como ID, fecha de publicación, precio, tipo de catálogo
 * y un arreglo de objetos {@link Moneda}.
 * </p>
 * 
 * @author Juliana
 * @version 1.0
 */
public class Catalogo implements Serializable {

    /**
     * Identificador único del catálogo.
     */
    private String idCatalogo;

    /**
     * Fecha de publicación del catálogo.
     */
    private String fecha;

    /**
     * Precio total del catálogo.
     */
    private double precio;

    /**
     * Tipo de catálogo (por ejemplo: digital, físico, histórico).
     */
    private String tipo;

    /**
     * Arreglo de monedas incluidas en el catálogo.
     */
    private Moneda[] moneda;

    /**
     * Constructor que inicializa todos los atributos del catálogo.
     *
     * @param idCatalogo Identificador del catálogo
     * @param fecha Fecha de publicación
     * @param precio Precio total
     * @param tipo Tipo de catálogo
     * @param moneda Arreglo de monedas incluidas
     */
    public Catalogo(String idCatalogo, String fecha, double precio, String tipo, Moneda[] moneda) {
        super();
        this.idCatalogo = idCatalogo;
        this.fecha = fecha;
        this.precio = precio;
        this.tipo = tipo;
        this.moneda = moneda;
    }

    /**
     * Obtiene el ID del catálogo.
     *
     * @return ID del catálogo
     */
    public String getIdCatalogo() {
        return idCatalogo;
    }

    /**
     * Establece el ID del catálogo.
     *
     * @param idCatalogo Nuevo ID
     */
    public void setIdCatalogo(String idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    /**
     * Obtiene la fecha de publicación del catálogo.
     *
     * @return Fecha del catálogo
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de publicación del catálogo.
     *
     * @param fecha Nueva fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el precio del catálogo.
     *
     * @return Precio total
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del catálogo.
     *
     * @param precio Nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo de catálogo.
     *
     * @return Tipo del catálogo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de catálogo.
     *
     * @param tipo Nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el arreglo de monedas del catálogo.
     *
     * @return Arreglo de monedas
     */
    public Moneda[] getMoneda() {
        return moneda;
    }

    /**
     * Establece el arreglo de monedas del catálogo.
     *
     * @param moneda Nuevo arreglo de monedas
     */
    public void setMoneda(Moneda[] moneda) {
        this.moneda = moneda;
    }

    /**
     * Devuelve una representación en texto del catálogo.
     *
     * @return Cadena con los datos del catálogo
     */
    @Override
    public String toString() {
        return "Catalogo [idCatalogo=" + idCatalogo + ", fecha=" + fecha + ", precio=" + precio + ", tipo=" + tipo
                + ", moneda=" + Arrays.toString(moneda) + "]";
    }

    /**
     * Muestra la información de todas las monedas incluidas en el catálogo.
     * Si no hay monedas, muestra un mensaje indicándolo.
     */
    public void documentarMonedas() {
        if (moneda != null) {
            for (Moneda m : moneda) {
                System.out.println(m.mostrarInformacion());
            }
        } else {
            System.out.println("No hay monedas en el catálogo.");
        }
    }
}