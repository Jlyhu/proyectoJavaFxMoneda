package co.edu.actividad.modelo;

import java.io.Serializable;

/**
 * Representa un certificado de autenticidad o validación asociado a una moneda.
 * <p>
 * Contiene información como el ID del certificado, fecha de emisión, entidad emisora
 * y la moneda certificada.
 * </p>
 * 
 * @author Juliana
 * @version 1.0
 */
public class Certificado implements Serializable {

    /**
     * Identificador único del certificado.
     */
    private String idCertificado;

    /**
     * Fecha de emisión del certificado.
     */
    private String fecha;

    /**
     * Entidad que emite el certificado.
     */
    private String entidad;

    /**
     * Moneda asociada al certificado.
     */
    private Moneda moneda;

    /**
     * Constructor que inicializa todos los atributos del certificado.
     *
     * @param idCertificado Identificador del certificado
     * @param fecha Fecha de emisión
     * @param entidad Entidad emisora
     * @param moneda Moneda certificada
     */
    public Certificado(String idCertificado, String fecha, String entidad, Moneda moneda) {
        super();
        this.idCertificado = idCertificado;
        this.fecha = fecha;
        this.entidad = entidad;
        this.moneda = moneda;
    }

    /**
     * Obtiene el ID del certificado.
     *
     * @return ID del certificado
     */
    public String getIdCertificado() {
        return idCertificado;
    }

    /**
     * Establece el ID del certificado.
     *
     * @param idCertificado Nuevo ID
     */
    public void setIdCertificado(String idCertificado) {
        this.idCertificado = idCertificado;
    }

    /**
     * Obtiene la fecha de emisión del certificado.
     *
     * @return Fecha del certificado
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de emisión del certificado.
     *
     * @param fecha Nueva fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la entidad emisora del certificado.
     *
     * @return Entidad emisora
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * Establece la entidad emisora del certificado.
     *
     * @param entidad Nueva entidad
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * Obtiene la moneda asociada al certificado.
     *
     * @return Moneda certificada
     */
    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * Establece la moneda asociada al certificado.
     *
     * @param moneda Nueva moneda
     */
    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Devuelve una representación en texto del certificado.
     *
     * @return Cadena con los datos del certificado
     */
    @Override
    public String toString() {
        return "Certificado [idCertificado=" + idCertificado + ", fecha=" + fecha + ", entidad=" + entidad + ", moneda="
                + moneda + "]";
    }
}