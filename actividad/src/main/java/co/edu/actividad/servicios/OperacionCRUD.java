package co.edu.actividad.servicios;

import co.edu.actividad.modelo.Moneda;

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) 
 * para objetos de tipo Moneda, permitiendo la gestión básica de datos.
 */
public interface OperacionCRUD {
    
    /**
     * Crea o guarda un nuevo objeto Moneda en el sistema de almacenamiento.
     * @param objeto La instancia de Moneda a guardar.
     * @return Un mensaje de confirmación o el ID del objeto creado.
     */
    String create(Moneda objeto);
    
    /**
     * Lee y retorna todos los objetos Moneda existentes en el sistema.
     * @return Un arreglo de objetos Moneda.
     */
    Moneda[] read();
    
    /**
     * Lee y retorna un objeto Moneda específico basándose en su identificador único.
     * @param id El identificador (serial) de la Moneda a buscar.
     * @return El objeto Moneda encontrado, o null si no existe.
     */
    Moneda readId(String id);
    
    /**
     * Actualiza la información de un objeto Moneda existente.
     * @param id El identificador (serial) de la Moneda a actualizar.
     * @param objeto La nueva instancia de Moneda con los datos actualizados.
     * @return Un mensaje de confirmación de la actualización.
     */
    String update(String id, Moneda objeto);
    
    /**
     * Elimina un objeto Moneda del sistema basándose en su identificador único.
     * @param id El identificador (serial) de la Moneda a eliminar.
     * @return El objeto Moneda que fue eliminado.
     */
    Moneda delete(String id);
}