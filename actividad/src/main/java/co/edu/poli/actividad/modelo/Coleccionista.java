package co.edu.poli.actividad.modelo;

import java.io.Serializable;

/**
 * Representa un coleccionista dentro del sistema de gestión de monedas.
 * Un coleccionista tiene un identificador único, un tipo (por ejemplo,
 * aficionado, profesional), un nivel de experiencia y un nombre.
 * Esta clase permite crear instancias de coleccionistas y acceder o modificar
 * sus atributos principales.
 * * @author Juliana
 * @version 1.0
 */

public class Coleccionista implements Serializable {
	private String idColeccionista;
	private String tipo;
	private String experiencia;
	private String nombre;

	
	/**
	 * Constructor que inicializa todos los atributos del coleccionista.
	 * @param idColeccionista El identificador único del coleccionista.
	 * @param tipo El tipo de coleccionista (ej. aficionado, profesional).
	 * @param experiencia El nivel de experiencia del coleccionista.
	 * @param nombre El nombre completo del coleccionista.
	 */
	public Coleccionista(String idColeccionista, String tipo, String experiencia, String nombre) {
		super();
		this.idColeccionista = idColeccionista;
		this.tipo = tipo;
		this.experiencia = experiencia;
		this.nombre = nombre;
	}

	/**
	 * Obtiene el identificador único del coleccionista.
	 * @return El identificador del coleccionista.
	 */
	public String getIdColeccionista() {
		return idColeccionista;
	}

	/**
	 * Establece un nuevo identificador único para el coleccionista.
	 * @param idColeccionista El nuevo identificador del coleccionista.
	 */
	public void setIdColeccionista(String idColeccionista) {
		this.idColeccionista = idColeccionista;
	}

	/**
	 * Obtiene el tipo de coleccionista.
	 * @return El tipo de coleccionista.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo de coleccionista.
	 * @param tipo El nuevo tipo de coleccionista.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el nivel de experiencia del coleccionista.
	 * @return El nivel de experiencia.
	 */
	public String getExperiencia() {
		return experiencia;
	}

	/**
	 * Establece el nivel de experiencia del coleccionista.
	 * @param experiencia El nuevo nivel de experiencia.
	 */
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * Obtiene el nombre del coleccionista.
	 * @return El nombre del coleccionista.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del coleccionista.
	 * @param nombre El nuevo nombre del coleccionista.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en cadena del objeto Coleccionista.
	 * @return Una cadena que contiene los atributos del coleccionista.
	 */
	@Override
	public String toString() {
		return "Coleccionista [idColeccionista=" + idColeccionista + ", tipo=" + tipo + ", experiencia=" + experiencia
				+ ", nombre=" + nombre + "]";
	}
		
}