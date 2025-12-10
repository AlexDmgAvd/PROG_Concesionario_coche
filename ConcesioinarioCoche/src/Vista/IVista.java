package Vista;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;

import java.util.List;

public interface IVista {

    int menu();

    int mostrarSubmenuPreciosCoche();

    CocheDTO aniadirCocheMenu();

    void mostrarCoche(CocheDTO coche);

    void mostrarListaCoches(List<CocheDTO> coches);

    String buscarCochePorMarca();

    float buscarCochePorPrecio();

    int buscarCochePorAnho();

    void mostrarCochesEncontrados(List<CocheDTO> coches);

    ClientesDTO registrarClienteMenu();

    void mostrarClienteRegistrado(ClientesDTO cliente);

    Modelo.VentasDTO registrarVentaMenu(List<CocheDTO> cochesDisponibles, List<ClientesDTO> clientes);

    void mostrarListaVentas(List<Modelo.VentasDTO> ventas);

    void mostrarMensaje(String mensaje);

    void mostrarError(String error);
}


