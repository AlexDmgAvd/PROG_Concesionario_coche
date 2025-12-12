package Modelo;

/**
 * Clase que representa un Cliente en el sistema del concesionario.
 * Implementa el patrón DTO para transportar datos del cliente.
 *
 * @author Alexandre Domínguez Avendaño
 */
public class ClientesDTO {

    //Atributos
    private String dni;
    private String nombre;
    private int telefono;

    //Constructor
    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param dni Documento Nacional de Identidad del cliente
     * @param nombre Nombre del cliente
     * @param telefono Número de teléfono de contacto
     */
    public ClientesDTO(String dni, String nombre, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //Getters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
