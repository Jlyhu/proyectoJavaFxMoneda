package co.edu.actividad.servicios;
import co.edu.actividad.modelo.Moneda;

/**
 * Interfaz que define las operaciones de serialización y deserialización
 * para un arreglo de objetos de tipo Moneda.
 */
public interface OperacionArchivo {
    /**
     * Serializa (guarda) un arreglo de monedas en un archivo binario.
     * @param monedas El arreglo de monedas a guardar.
     * @param path Ruta del archivo (puede incluir carpeta).
     * @param name Nombre del archivo (Ej: monedas.dat).
     * @return Mensaje indicando éxito o error.
     */
    String serializar(Moneda[] monedas, String path, String name);

    /**
     * Deserializa (carga) un arreglo de monedas desde un archivo binario.
     * @param path Ruta del archivo (puede incluir carpeta).
     * @param name Nombre del archivo (Ej: monedas.dat).
     * @return Arreglo de monedas cargado desde el archivo.
     */
    Moneda[] deserializar(String path, String name);
}
