package Modelo;

/**
 * Clase que representa un Coche en el sistema del concesionario.
 * Implementa el patrón DTO para transportar datos del Coche.
 *
 * @author Alexandre Domínguez Avendaño
 */
public class CocheDTO {

    //Atributos
    private String marca;
    private String modelo;
    private String matricula;
    private float precio;
    private int anho;
    private int km;
    private boolean disponible;

    // Constructor

    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param marca Marca del coche
     * @param modelo modelo del coche
     * @param matricula Matrícula del coche
     * @param precio Precio del coche
     * @param anho Año de fabricacion del coche
     * @param km Kilometros totales recorridos
     * @param disponible representa si el coche ha sido vendido o no
     */
    public CocheDTO(String marca, String modelo, String matricula, float precio, int anho, int km, boolean disponible) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
        this.anho = anho;
        this.km = km;
        this.disponible = disponible;
    }

    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}


