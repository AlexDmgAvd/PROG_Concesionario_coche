package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import java.util.List;

public interface IControlador {

    void anhadirCocheCTRLDR(CocheDTO coche);

    void mostrarTodosLosCocheCTRLDR();

    void buscarCochePorMarcaCTRLDR();

    void buscarCochePorPrecioCTRLDR();

    void buscarCochePorAnhoCTRLDR();

    void registrarClienteCTRLDR(ClientesDTO cliente);

    void mostrarTodosLosClientesCTRLDR();

    void registrarVentaCTRLDR(List<CocheDTO> coches, List<ClientesDTO> clientes, List<VentasDTO> ventas);

    void listarVentaCTRLDR();

    void run();
}
