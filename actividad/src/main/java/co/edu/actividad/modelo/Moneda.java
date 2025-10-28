package co.edu.actividad.modelo;
import java.io.Serializable;

/**
 * Clase abstracta que representa una moneda en el sistema de gestión.
 * Sirve como clase base para diferentes tipos específicos de monedas.
 * Contiene los atributos y métodos comunes a todas las monedas.
 * *@author Juliana
 * @version 1.0
 */


public abstract class Moneda implements Serializable {
    protected String serial;
    protected String material;
    protected String tamano;
    protected String valor;
    protected String tipo;
    protected String rareza;
    protected String epoca;
    protected int anoCreacion;
    protected boolean esAutentica;
    protected Protector protector;
    protected Pais pais;

    /**
     * Constructor parametrizado de la clase Moneda.
     * 
     * @param serial Número de serie único de la moneda
     * @param material Material de fabricación de la moneda
     * @param tamano Tamaño físico de la moneda
     * @param valor Valor monetario de la moneda
     * @param tipo Tipo o categoría de la moneda
     * @param rareza Nivel de rareza de la moneda
     * @param epoca Época histórica de la moneda
     * @param anoCreacion Año de creación de la moneda
     * @param esAutentica Indica si la moneda es auténtica
     * @param protector Protector asociado a la moneda
     * @param pais País de origen de la moneda
     */
    public Moneda(String serial, String material, String tamano, String valor, String tipo, String rareza, String epoca,
            int anoCreacion, boolean esAutentica, Protector protector, Pais pais) {
        super();
        this.serial = serial;
        this.material = material;
        this.tamano = tamano;
        this.valor = valor;
        this.tipo = tipo;
        this.rareza = rareza;
        this.epoca = epoca;
        this.anoCreacion = anoCreacion;
        this.esAutentica = esAutentica;
        this.protector = protector;
        this.pais = pais;
    }

    /**
     * Obtiene el número de serie de la moneda.
     * @return serial de la moneda
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Establece el número de serie de la moneda.
     * @param serial nuevo serial de la moneda
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Obtiene el material de la moneda.
     * @return material de fabricación
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material de la moneda.
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene el tamaño de la moneda.
     * @return tamaño de la moneda
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * Establece el tamaño de la moneda.
     * @param tamano nuevo tamaño
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * Obtiene el valor de la moneda.
     * @return valor monetario
     */
    public String getValor() {
        return valor;
    }

    /**
     * Establece el valor de la moneda.
     * @param valor nuevo valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el tipo de la moneda.
     * @return tipo de moneda
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la moneda.
     * @param tipo nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la rareza de la moneda.
     * @return nivel de rareza
     */
    public String getRareza() {
        return rareza;
    }

    /**
     * Establece la rareza de la moneda.
     * @param rareza nueva rareza
     */
    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    /**
     * Obtiene la época de la moneda.
     * @return época histórica
     */
    public String getEpoca() {
        return epoca;
    }

    /**
     * Establece la época de la moneda.
     * @param epoca nueva época
     */
    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    /**
     * Obtiene el año de creación de la moneda.
     * @return año de creación
     */
    public int getAnoCreacion() {
        return anoCreacion;
    }

    /**
     * Establece el año de creación de la moneda.
     * @param anoCreacion nuevo año de creación
     */
    public void setAnoCreacion(int anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    /**
     * Verifica si la moneda es auténtica.
     * @return true si es auténtica, false en caso contrario
     */
    public boolean isEsAutentica() {
        return esAutentica;
    }

    /**
     * Establece la autenticidad de la moneda.
     * @param esAutentica nueva autenticidad
     */
    public void setEsAutentica(boolean esAutentica) {
        this.esAutentica = esAutentica;
    }

    /**
     * Obtiene el protector de la moneda.
     * @return protector asociado
     */
    public Protector getProtector() {
        return protector;
    }

    /**
     * Establece el protector de la moneda.
     * @param protector nuevo protector
     */
    public void setProtector(Protector protector) {
        this.protector = protector;
    }

    /**
     * Obtiene el país de origen de la moneda.
     * @return país de origen
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * Establece el país de origen de la moneda.
     * @param pais nuevo país
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Moneda [serial=" + serial + ", material=" + material + ", tamano=" + tamano + ", valor=" + valor
                + ", tipo=" + tipo + ", rareza=" + rareza + ", epoca=" + epoca + ", anoCreacion=" + anoCreacion
                + ", esAutentica=" + esAutentica + ", protector=" + protector + ", pais=" + pais + "]";
    }

    /**
     * Método abstracto para mostrar información específica de cada tipo de moneda.
     * Debe ser implementado por las clases hijas.
     * 
     * @return String con información específica de la moneda
     */
    protected abstract String mostrarInformacion();

    /**
     * Método abstracto para mostrar información con detalle extra.
     * Debe ser implementado por las clases hijas.
     * 
     * @param detalleExtra información adicional a mostrar
     * @return String con información detallada de la moneda
     */
    protected abstract String mostrarInformacion(String detalleExtra);

    /**
     * Obtiene información básica de la moneda llamando al método mostrarInformacion.
     * 
     * @return String con información de la moneda
     */
    public String obtenerInformacion() {
        return mostrarInformacion();
    }

    /**
     * Obtiene información de la moneda con detalle extra.
     * 
     * @param detalleExtra información adicional
     * @return String con información detallada
     */
    public String obtenerInformacion(String detalleExtra) {
        return mostrarInformacion(detalleExtra);
    }

    /**
     * Calcula la edad actual de la moneda basada en el año de creación.
     * 
     * @return edad de la moneda en años
     */
    public int calcularEdadActual() {
        int anoActual = java.time.Year.now().getValue();
        return anoActual - this.anoCreacion;
    }
}
