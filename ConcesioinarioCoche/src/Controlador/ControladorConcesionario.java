package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;
import Vista.VistaConcesionario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControladorConcesionario implements IControlador {

    // Memoria

    private List<CocheDTO> coches;
    private List<ClientesDTO> clientes;
    private List<VentasDTO> ventas;
    private VistaConcesionario vista;

    // Constructor Controlador

    public ControladorConcesionario(VistaConcesionario vista) {

        this.vista = vista;
        this.coches = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();

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

        List<VentasDTO> listaVentas = new ArrayList<>();
        listaVentas.add(new VentasDTO(1, "Maria", "Kia", new Date(125, 12, 04), 20500));
        listaVentas.add(new VentasDTO(2, "Ana", "Mercedes", new Date(125, 7, 21), 21500));
        listaVentas.add(new VentasDTO(3, "Pedro", "Mercedes", new Date(125, 2, 05), 26900));
        listaVentas.add(new VentasDTO(4, "Maria", "Volkswagen", new Date(125, 12, 20), 14800));

        ventas = listaVentas;

    }


    public void anhadirCocheCTRLDR(CocheDTO coche) {

        coches.add(coche);

    }

    public void mostrarTodosLosCocheCTRLDR() {

        vista.mostrarListaCoches(coches);

    }

    public void buscarCochePorMarcaCTRLDR() {

        String busqueda = vista.buscarCochePorMarca();
        boolean seEncontroAlgunCoche = false;
        for (CocheDTO coche : coches ){

            if (coche.getMarca().equals(busqueda)){
                vista.mostrarCoche(coche);
                seEncontroAlgunCoche = true;
            }
        }

        if(!seEncontroAlgunCoche) vista.mostrarError("La Marca introducida no esta registrada");


    }

    public void buscarCochePorPrecioCTRLDR() {

        int op = vista.mostrarSubmenuPreciosCoche();
        int min = 0, max = 0;
        boolean seEncontroAlgunCoche = false;

        if(op == 1){
            min = 12000;
            max = 16000;
        }

        if (op == 2){
            min = 16000;
            max = 20000;
        }

        if (op == 3){
            min = 20000;
            max = 30000;
        }

        if (op == 4){
            min = 30000;
            max = 50000;
        }

        if (op == 5){
            return;
        }

        for (CocheDTO coche : coches ){

            if (coche.getPrecio() >= min && coche.getPrecio() <= max){
                vista.mostrarCoche(coche);
                seEncontroAlgunCoche = true;
            }
        }

        if(!seEncontroAlgunCoche) vista.mostrarError("El precio introducido no esta registrada");



    }

    public void buscarCochePorAnhoCTRLDR() {



    }


    public void registrarClienteCTRLDR() {

    }

    public void registrarVentaCTRLDR() {

    }

    public void listarVentaCTRLDR() {

    }

    public void run() {

        while (true) {

            int op = vista.menu();
            if (op == 1) {
                CocheDTO coche = vista.aniadirCocheMenu();
                anhadirCocheCTRLDR(coche);
            }

            if (op == 2) {
                mostrarTodosLosCocheCTRLDR();
            }

            if (op == 3){
                buscarCochePorMarcaCTRLDR();
            }

            if (op == 4){
                buscarCochePorPrecioCTRLDR();
            }




        }
    }
}








