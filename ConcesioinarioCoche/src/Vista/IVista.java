package Vista;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import java.util.List;

/**
 * Interfaz que define las operaciones de la Vista en el patrón MVC.
 * Especifica todos los métodos que la vista debe implementar para interactuar con el usuario.
 *
 * @author Alexandre Domínguez Avendaño
 */
public interface IVista {


    /**
     * Muestra el logo de la empresa al usuario.
     */
    void imprimirLogo();

    /**
     * Muestra el menú principal y obtiene la selección del usuario.
     *
     * @return Opción seleccionada por el usuario (1-10)
     */
    int menu();

    /**
     * Muestra el submenú de rangos de precios para búsqueda.
     *
     * @return Opción seleccionada del submenú de precios (1-5)
     */
    int mostrarSubmenuPreciosCoche();

    /**
     * Solicita al usuario los datos para añadir un nuevo coche.
     *
     * @return Nuevo objeto CocheDTO con los datos ingresados por el usuario
     */
    CocheDTO aniadirCocheMenu();

    /**
     * Muestra la información detallada de un coche.
     *
     * @param coche Coche a mostrar
     */
    void mostrarCoche(CocheDTO coche);

    /**
     * Muestra una lista de todos los coches disponibles.
     *
     * @param coches Lista de coches a mostrar
     */
    void mostrarListaCoches(List<CocheDTO> coches);

    /**
     * Solicita al usuario una marca para buscar coches.
     *
     * @return Marca ingresada por el usuario
     */
    String buscarCochePorMarca();

    /**
     * Solicita al usuario un precio para buscar coches.
     *
     * @return Precio ingresado por el usuario
     */
    float buscarCochePorPrecio();

    /**
     * Solicita al usuario un año para buscar coches.
     *
     * @return Año ingresado por el usuario
     */
    int buscarCochePorAnho();

    /**
     * Muestra los resultados de una búsqueda de coches.
     *
     * @param coches Lista de coches encontrados
     */
    void mostrarCochesEncontrados(List<CocheDTO> coches);


    /**
     * Solicita al usuario los datos para registrar un nuevo cliente.
     *
     * @return Objeto ClientesDTO con los datos ingresados
     */
    ClientesDTO registrarClienteMenu();

    /**
     * Muestra una lista de todos los clientes registrados.
     *
     * @param clientes Lista de clientes a mostrar
     */
    void mostrarListaClientes(List<ClientesDTO> clientes);

    /**
     * Solicita al usuario los datos para registrar una nueva venta.
     *
     * @param cochesDisponibles Lista de coches disponibles para la venta
     * @param clientes          Lista de clientes registrados
     * @param ventas            Lista de ventas existentes (para generar nuevo ID)
     * @return Objeto VentasDTO con los datos de la venta, o null si se cancela
     */
    Modelo.VentasDTO registrarVentaMenu(List<CocheDTO> cochesDisponibles, List<ClientesDTO> clientes, List<VentasDTO> ventas);

    /**
     * Muestra una lista de todas las ventas registradas.
     *
     * @param ventas Lista de ventas a mostrar
     */
    void mostrarListaVentas(List<Modelo.VentasDTO> ventas);

    /**
     * Muestra un mensaje informativo al usuario.
     *
     * @param mensaje Mensaje a mostrar
     */
    void mostrarMensaje(String mensaje);

    /**
     * Muestra un mensaje de error al usuario.
     *
     * @param error Mensaje de error a mostrar
     */
    void mostrarError(String error);

    /**
     * Muestra un mensaje de despedida al usuario.
     */
    void mostrarDespedida();
}


