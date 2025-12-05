package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;
import Vista.VistaSimple;

import java.util.ArrayList;
import java.util.List;

public class ControladorConcesionario implements IControlador {

    // Memoria

    private List<CocheDTO> coches;
    private List<ClientesDTO> clientes;
    private List<VentasDTO> ventas;
    private VistaSimple vista;

    // Constructor Controlador

    public ControladorConcesionario(VistaSimple vista) {

        this.vista = vista;
    }


    // funciones ..............................................................................

    public void cargarDatosIniciales() {

        List<CocheDTO> listaCoche = new ArrayList<>();
        listaCoche.add(new CocheDTO("Volkswagen", "Golf 1.6 TDI", "5432-JGL", 14500, 2017, 110000));
        listaCoche.add(new CocheDTO("Opel", "Corsa 1.2T XHL", "4567-MTB", 15200, 2021, 78260));
        listaCoche.add(new CocheDTO("Nissan", "Juke 1.0 DIG-T", "8765-KPD", 17800, 2020, 52980));
        listaCoche.add(new CocheDTO("Renault", "Clio E-Tech", "1234-LMN", 21500, 2022, 25000));
        listaCoche.add(new CocheDTO("Volvo", "XC40 D3 Momentum", "9012-HZX", 26900, 2019, 85000));
        listaCoche.add(new CocheDTO("Volkswagen", "Golf 1.6 TDI", "2222-JKL", 14800, 2017, 105000));
        listaCoche.add(new CocheDTO("Renault", "Clio E-Tech", "9988-PLM", 21800, 2022, 31000));
        listaCoche.add(new CocheDTO("Seat", "Ibiza 1.0 TSI", "5643-HGF", 13900, 2020, 45000));
        listaCoche.add(new CocheDTO("Toyota", "Corolla Hybrid", "6712-KBG", 20500, 2019, 60000));
        listaCoche.add(new CocheDTO("Ford", "Focus 1.0 EcoBoost", "3456-JYT", 16200, 2021, 38000));
        listaCoche.add(new CocheDTO("BMW", "X1 sDrive18d", "7788-KRT", 29500, 2018, 72000));
        listaCoche.add(new CocheDTO("Audi", "A3 Sportback 1.6 TDI", "8899-MZT", 25500, 2017, 90000));
        listaCoche.add(new CocheDTO("Mercedes", "A180 CDI", "1122-LHG", 23900, 2019, 64000));
        listaCoche.add(new CocheDTO("Hyundai", "Tucson 1.6 GDi", "4312-NBV", 21000, 2020, 50000));
        listaCoche.add(new CocheDTO("Kia", "Sportage 1.6 CRDi", "7812-JSP", 22500, 2021, 43000));

        coches = listaCoche;

        List<ClientesDTO> listaCliente = new ArrayList<>();
        listaCliente.add(new ClientesDTO("12345678G", "Maria", 111111111));
        listaCliente.add(new ClientesDTO("12345679V", "Pedro", 1234567789));
        listaCliente.add(new ClientesDTO("98765432L", "Maria", 622111222));
        listaCliente.add(new ClientesDTO("56473829P", "Luis", 644222333));
        listaCliente.add(new ClientesDTO("11223344F", "Ana", 655333444));

        clientes = listaCliente;
    }


    public void anhadirCoche(CocheDTO coche) {

    }

    public void mostrarCoche() {

    }

    public void buscarCoche() {

    }

    public void registrarCliente() {

    }

    public void registrarVenta() {

    }

    public void listarVenta() {

    }

    public void run(){


        int op = vista.menu();
        if (op == 1){

            CocheDTO coche = vista.aniadirCocheMenu();
            anhadirCoche(coche); //aniadirCoche(coche)
            //Mostrar resultado de aniadir coches
            //vista.mostrarError("");
        }

    }
}








