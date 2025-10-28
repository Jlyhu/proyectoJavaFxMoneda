package co.edu.actividad.servicios;
import co.edu.actividad.modelo.Antigua;
import co.edu.actividad.modelo.Pais;
import co.edu.actividad.modelo.Protector;

/**
 * Representa una moneda griega antigua.
 * <p>
 * Esta clase es <b>final</b>, por lo tanto no puede ser heredada.
 * Hereda de {@link Antigua} y añade atributos específicos como región y periodo histórico.
 * </p>
 * 
 * @author Juliana
 * @version 1.0
 */
public final class Griega extends Antigua {

    /**
     * Región de origen de la moneda griega.
     * Este atributo es <b>final</b>, por lo tanto no puede ser modificado.
     */
    private final String region;

    /**
     * Periodo histórico al que pertenece la moneda griega.
     */
    private String periodoHistorico;

    /**
     * Constructor para crear una moneda griega con todos sus atributos.
     *
     * @param serial Código serial de la moneda.
     * @param material Material de fabricación.
     * @param tamano Tamaño físico.
     * @param valor Valor estimado.
     * @param tipo Tipo de moneda.
     * @param rareza Nivel de rareza.
     * @param epoca Época histórica.
     * @param anoCreacion Año de creación.
     * @param esAutentica Indica si la moneda es auténtica.
     * @param protector Objeto que representa el protector de la moneda.
     * @param pais País de origen.
     * @param siglo Siglo de creación.
     * @param estadoConservacion Estado de conservación.
     * @param region Región de origen.
     * @param periodoHistorico Periodo histórico.
     */
    public Griega(String serial, String material, String tamano, String valor, String tipo, String rareza, String epoca,
                  int anoCreacion, boolean esAutentica, Protector protector, Pais pais,
                  String siglo, String estadoConservacion,
                  String region, String periodoHistorico) {
        super(serial, material, tamano, valor, tipo, rareza, epoca, anoCreacion, esAutentica, protector, pais,
              siglo, estadoConservacion);
        this.region = region;
        this.periodoHistorico = periodoHistorico;
    }

    /**
     * Obtiene la región de origen de la moneda griega.
     *
     * @return Región de origen.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Obtiene el periodo histórico de la moneda griega.
     *
     * @return Periodo histórico.
     */
    public String getPeriodoHistorico() {
        return periodoHistorico;
    }

    /**
     * Establece el periodo histórico de la moneda griega.
     *
     * @param periodoHistorico Nuevo periodo histórico.
     */
    public void setPeriodoHistorico(String periodoHistorico) {
        this.periodoHistorico = periodoHistorico;
    }

    /**
     * Muestra un mensaje indicando que este método no puede ser sobrescrito.
     * <p>
     * Este método es <b>final</b>.
     * </p>
     */
    public final void mostrarMensajeFinal() {
        System.out.println("Este método no puede ser sobrescrito.");
    }

    /**
     * Muestra la información básica de la moneda griega.
     *
     * @return Cadena con la información principal.
     */
    @Override
    protected String mostrarInformacion() {
        return "Moneda Griega de la región " + region + ", periodo histórico: " + periodoHistorico +
               ", siglo: " + getSiglo() + ", estado: " + getEstadoConservacion();
    }

    /**
     * Muestra la información de la moneda griega con un detalle adicional.
     *
     * @param detalleExtra Información adicional a mostrar.
     * @return Cadena con la información completa.
     */
    @Override
    protected String mostrarInformacion(String detalleExtra) {
        return mostrarInformacion() + ", Detalle adicional: " + detalleExtra;
    }
}