package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import java.util.List;

/**
 * Interfaz que define las operaciones del Controlador en el patrón MVC.
 * Especifica todos los métodos que el controlador debe implementar.
 *
 * @author Alexandre Domínguez Avendaño
 */
public interface IControlador {

    /**
     * Añade Coches, Clientes y Ventas para cargar datos predeterminados.
     */
    void cargarDatosIniciales();

    /**
     * Añade un nuevo coche a la lista de coches disponibles.
     *
     * @param coche Coche a añadir
     */
    void anhadirCocheCTRLDR(CocheDTO coche);

    /**
     * Muestra todos los coches disponibles en el sistema.
     */
    void mostrarTodosLosCocheCTRLDR();

    /**
     * Busca coches por marca y muestra los resultados.
     */
    void buscarCochePorMarcaCTRLDR();

    /**
     * Busca coches por rango de precio y muestra los resultados.
     */
    void buscarCochePorPrecioCTRLDR();

    /**
     * Busca coches por año de fabricación y muestra los resultados.
     */
    void buscarCochePorAnhoCTRLDR();

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente Cliente a registrar
     */
    void registrarClienteCTRLDR(ClientesDTO cliente);

    /**
     * Muestra todos los clientes registrados en el sistema.
     */
    void mostrarTodosLosClientesCTRLDR();

    /**
     * Registra una nueva venta en el sistema.
     *
     * @param coches Lista de todos los coches
     * @param clientes Lista de todos los clientes
     * @param ventas Lista de todas las ventas
     */
    void registrarVentaCTRLDR(List<CocheDTO> coches, List<ClientesDTO> clientes, List<VentasDTO> ventas);

    /**
     * Muestra todas las ventas registradas en el sistema.
     */
    void listarVentaCTRLDR();

    /**
     * Filtra y devuelve solo los coches disponibles.
     */
    List<CocheDTO> filtrarCochesDisponibles();

    /**
     * Verifica si una matrícula ya existe en el sistema.
     */
    boolean existeMatricula(String matricula);

    /**
     * Ejecuta el bucle principal de la aplicación.
     * Gestiona el programa según las selecciones del usuario.
     */
    void run();
}
