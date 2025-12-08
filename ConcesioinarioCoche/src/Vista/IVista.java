package Vista;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;

import java.util.List;

public interface IVista {

    int menu();

    CocheDTO aniadirCocheMenu();

    void mostrarCoche(CocheDTO coche);

    void mostrarListaCoches(List<CocheDTO> coches);

    String buscarCocheMenu();

    void mostrarCochesEncontrados(List<CocheDTO> coches);

    ClientesDTO registrarClienteMenu();

    void mostrarClienteRegistrado(ClientesDTO cliente);

    Modelo.VentasDTO registrarVentaMenu(List<CocheDTO> cochesDisponibles, List<ClientesDTO> clientes);

    void mostrarListaVentas(List<Modelo.VentasDTO> ventas);

    void mostrarMensaje(String mensaje);

    void mostrarError(String error);
}


