package co.edu.actividad.servicios;

import java.io.*;
import co.edu.actividad.modelo.Moneda;

/**
 * Implementación de las operaciones CRUD y de archivo sobre un arreglo de tipo Moneda.
 * <p>
 * Esta clase permite gestionar objetos Moneda en memoria y también guardarlos/cargarlos
 * desde un archivo binario mediante serialización.
 * </p>
 * 
 * @author Juliana
 * @version 2.0
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    /**
     * Arreglo de monedas que actúa como almacenamiento en memoria.
     */
    private Moneda[] monedas;

    /**
     * Capacidad inicial del arreglo.
     */
    private int capacidadInicial = 3;

    /**
     * Constructor que inicializa el arreglo con la capacidad inicial.
     */
    public ImplementacionOperacionCRUD() {
        monedas = new Moneda[capacidadInicial];
    }

    // -------------------- MÉTODOS CRUD --------------------

    @Override
    public String create(Moneda objeto) {
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] == null) {
                monedas[i] = objeto;
                return "Moneda agregada en posición " + i;
            }
        }
        // Expandir arreglo si está lleno
        Moneda[] nuevoArreglo = new Moneda[monedas.length + capacidadInicial];
        System.arraycopy(monedas, 0, nuevoArreglo, 0, monedas.length);
        nuevoArreglo[monedas.length] = objeto;
        monedas = nuevoArreglo;
        return "Moneda agregada en nueva posición " + monedas.length;
    }

    @Override
    public Moneda[] read() {
        return monedas;
    }

    @Override
    public Moneda readId(String id) {
        for (Moneda m : monedas) {
            if (m != null && m.getSerial().equals(id)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public String update(String id, Moneda objeto) {
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != null && monedas[i].getSerial().equals(id)) {
                monedas[i] = objeto;
                return "Moneda actualizada en posición " + i;
            }
        }
        return "Moneda con serial " + id + " no encontrada.";
    }

    @Override
    public Moneda delete(String id) {
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != null && monedas[i].getSerial().equals(id)) {
                Moneda eliminada = monedas[i];
                monedas[i] = null;
                return eliminada;
            }
        }
        return null;
    }

    /**
     * Reemplaza el arreglo de monedas interno. Se utiliza para cargar datos desde un archivo.
     * 
     * @param nuevasMonedas El nuevo arreglo de monedas que reemplazará al existente.
     */
    public void setMonedas(Moneda[] nuevasMonedas) {
        this.monedas = nuevasMonedas;
    }

    // -------------------- MÉTODOS DE ARCHIVO --------------------

    @Override
    public String serializar(Moneda[] monedas, String path, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.separator + name))) {
            oos.writeObject(monedas);
            return ">> Archivo '" + name + "' guardado exitosamente en '" + path + "'";
        } catch (IOException e) {
            return "Error al guardar el archivo: " + e.getMessage();
        }
    }

    @Override
    public Moneda[] deserializar(String path, String name) {
        File archivo = new File(path + File.separator + name);
        if (!archivo.exists()) {
            System.out.println(">> El archivo no existe. Se comenzará con una lista vacía.");
            return new Moneda[10];
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Moneda[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
            return null;
        }
    }
}