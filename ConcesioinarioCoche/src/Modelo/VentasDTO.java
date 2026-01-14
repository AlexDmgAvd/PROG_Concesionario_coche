package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase que representa una Venta hacia un cliente en el sistema del concesionario.
 * Implementa el patrón DTO para transportar datos del cliente.
 *
 * @author Alexandre Domínguez Avendaño
 */
public class VentasDTO {

    //Atributos
    private int id;
    private String cliente;
    private String cocheCliente;
    private Date fecha;
    private float precioVenta;

    //Constructor

    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param id           Identificador principal de la venta
     * @param cliente      Nombre del cliente
     * @param cocheCliente Coche elegido por el cliente
     * @param fecha        fecha en la que se realízo la venta
     * @param precioVenta  Precio al que se vendió el coche
     */
    public VentasDTO(int id, String cliente, String cocheCliente, LocalDate fecha, float precioVenta) {
        this.id = id;
        this.cliente = cliente;
        this.cocheCliente = cocheCliente;
        this.fecha = fecha;
        this.precioVenta = precioVenta;
    }

    //Getter
    public int getId() {
        return id;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCocheCliente() {
        return cocheCliente;
    }

    public void setCocheCliente(String cocheCliente) {
        this.cocheCliente = cocheCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
}
