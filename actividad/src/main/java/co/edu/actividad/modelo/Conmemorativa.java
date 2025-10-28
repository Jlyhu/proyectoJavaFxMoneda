package co.edu.actividad.modelo;

/**
 * Clase que representa una moneda conmemorativa.
 * Extiende la clase abstracta Moneda y añade características específicas
 * para monedas que conmemoran eventos especiales.
 * * @author Juliana
 * @version 1.0
 */
public class Conmemorativa extends Moneda {
    private boolean esEdicionLimitada;
    private String evento;

    /**
     * Constructor parametrizado de la clase Conmemorativa.
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
     * @param esEdicionLimitada Indica si es edición limitada
     * @param evento Evento que conmemora
     */
    public Conmemorativa(String serial, String material, String tamano, String valor, String tipo, String rareza, 
                        String epoca, int anoCreacion, boolean esAutentica, Protector protector, Pais pais,
                        boolean esEdicionLimitada, String evento) {
        super(serial, material, tamano, valor, tipo, rareza, epoca, anoCreacion, esAutentica, protector, pais);
        this.esEdicionLimitada = esEdicionLimitada;
        this.evento = evento;
    }

    @Override
    protected String mostrarInformacion() {
        String edicion = esEdicionLimitada ? "Edición Limitada" : "Edición Regular";
        return "Evento: " + evento + 
        		"\n(" + edicion + ")" + 
               "\nPaís: " + (pais != null ? pais.getNombre() : "N/A")+
               "\nSerial: " + serial +
               "\nMaterial: " + material +
               "\nTamaño: " + tamano +
               "\nValor: " + valor +
               "\nAño de creación: " + anoCreacion;

    }

    @Override
    protected String mostrarInformacion(String detalleExtra) {
        return mostrarInformacion() + " - Detalle: " + detalleExtra;
    }

    // Getters y Setters
    
    /**
     * Verifica si la moneda conmemorativa es una edición limitada.
     * @return true si es edición limitada, false en caso contrario.
     */
    public boolean isEsEdicionLimitada() { return esEdicionLimitada; }
    
    /**
     * Establece si la moneda conmemorativa es una edición limitada.
     * @param esEdicionLimitada El nuevo estado de edición limitada.
     */
    public void setEsEdicionLimitada(boolean esEdicionLimitada) { this.esEdicionLimitada = esEdicionLimitada; }
    
    /**
     * Obtiene la descripción del evento que conmemora la moneda.
     * @return El evento conmemorado.
     */
    public String getEvento() { return evento; }
    
    /**
     * Establece el evento que conmemora la moneda.
     * @param evento El nuevo evento conmemorado.
     */
    public void setEvento(String evento) { this.evento = evento; }
}