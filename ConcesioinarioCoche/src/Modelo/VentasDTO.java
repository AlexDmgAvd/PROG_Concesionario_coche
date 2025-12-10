package Modelo;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

public class VentasDTO {

    //Atributos
    private int id;
    private String cliente;
    private String cocheCliente;
    private Date fecha;
    private float precioVenta;

    //Constructor
    public VentasDTO(int id, String cliente, String cocheCliente, Date fecha, float precioVenta) {
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
