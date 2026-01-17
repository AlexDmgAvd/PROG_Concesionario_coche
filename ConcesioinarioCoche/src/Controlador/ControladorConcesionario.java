package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;
import Vista.VistaConcesionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del Controlador en el patrón MVC.
 * Gestiona toda la lógica de negocio del concesionario y coordina
 * las interacciones entre la Vista y el Modelo.
 *
 * @author Alexandre Domínguez Avendaño
 *
 */
public class ControladorConcesionario implements IControlador {

    // Memoria

    private List<CocheDTO> coches;
    private List<ClientesDTO> clientes;
    private List<VentasDTO> ventas;
    private VistaConcesionario vista;

    // Constructor Controlador

    /**
     * Constructor que inicializa el controlador con una vista.
     * Crea las listas vacías de coches, clientes y ventas.
     *
     * @param vista Instancia de la vista a utilizar
     */
    public ControladorConcesionario(VistaConcesionario vista) {

        this.vista = vista;
        this.coches = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();

    }


    // funciones ..............................................................................

    @Override
    public void cargarDatosIniciales() {

        List<CocheDTO> listaCoche = new ArrayList<>();
        listaCoche.add(new CocheDTO("Volkswagen", "Golf 1.6 TDI", "5432-JGL", 14500, 2017, 110000, true));
        listaCoche.add(new CocheDTO("Opel", "Corsa 1.2T XHL", "4567-MTB", 15200, 2021, 78260, true));
        listaCoche.add(new CocheDTO("Nissan", "Juke 1.0 DIG-T", "8765-KPD", 17800, 2020, 52980, true));
        listaCoche.add(new CocheDTO("Renault", "Clio E-Tech", "1234-LMN", 21500, 2022, 25000, true));
        listaCoche.add(new CocheDTO("Volvo", "XC40 D3 Momentum", "9012-HZX", 26900, 2019, 85000, true));
        listaCoche.add(new CocheDTO("Volkswagen", "Golf 1.6 TDI", "2222-JKL", 14800, 2017, 105000, true));
        listaCoche.add(new CocheDTO("Renault", "Clio E-Tech", "9988-PLM", 21800, 2022, 31000, true));
        listaCoche.add(new CocheDTO("Seat", "Ibiza 1.0 TSI", "5643-HGF", 13900, 2020, 45000, true));
        listaCoche.add(new CocheDTO("Toyota", "Corolla Hybrid", "6712-KBG", 20500, 2019, 60000, true));
        listaCoche.add(new CocheDTO("Ford", "Focus 1.0 EcoBoost", "3456-JYT", 16200, 2021, 38000, true));
        listaCoche.add(new CocheDTO("BMW", "X1 sDrive18d", "7788-KRT", 29500, 2018, 72000, true));
        listaCoche.add(new CocheDTO("Audi", "A3 Sportback 1.6 TDI", "8899-MZT", 25500, 2017, 90000, true));
        listaCoche.add(new CocheDTO("Mercedes", "A180 CDI", "1122-LHG", 23900, 2019, 64000, true));
        listaCoche.add(new CocheDTO("Hyundai", "Tucson 1.6 GDi", "4312-NBV", 21000, 2020, 50000, true));
        listaCoche.add(new CocheDTO("Kia", "Sportage 1.6 CRDi", "7812-JSP", 22500, 2021, 43000, true));

        coches = listaCoche;

        List<ClientesDTO> listaCliente = new ArrayList<>();
        listaCliente.add(new ClientesDTO("12345678G", "Maria", 111111111));
        listaCliente.add(new ClientesDTO("12345679V", "Pedro", 1234567789));
        listaCliente.add(new ClientesDTO("98765432L", "Maria", 622111222));
        listaCliente.add(new ClientesDTO("56473829P", "Luis", 644222333));
        listaCliente.add(new ClientesDTO("11223344F", "Ana", 655333444));

        clientes = listaCliente;

        List<VentasDTO> listaVentas = new ArrayList<>();
        listaVentas.add(new VentasDTO(1, "Maria", "Kia", LocalDate.of(2025, 12, 4), 20500));
        listaVentas.add(new VentasDTO(2, "Ana", "Mercedes", LocalDate.of(2025, 7, 21), 21500));
        listaVentas.add(new VentasDTO(3, "Pedro", "Mercedes", LocalDate.of(2025, 2, 5), 26900));
        listaVentas.add(new VentasDTO(4, "Maria", "Volkswagen", LocalDate.of(2025, 12, 20), 14800));

        ventas = listaVentas;

    }


    @Override
    public void anhadirCocheCTRLDR(CocheDTO coche) {

        if (existeMatricula(coche.getMatricula())) {
            vista.mostrarError("La matrícula " + coche.getMatricula() + " ya existe en el sistema");
            return;
        }

        coches.add(coche);
        vista.mostrarMensaje("Coche añadido correctamente al sistema");
    }

    @Override
    public void mostrarTodosLosCocheCTRLDR() {

        List<CocheDTO> disponibles = filtrarCochesDisponibles();
        vista.mostrarListaCoches(disponibles);
    }

    @Override
    public void buscarCochePorMarcaCTRLDR() {

        String busqueda = vista.buscarCochePorMarca();
        boolean seEncontroAlgunCoche = false;
        for (CocheDTO coche : coches) {

            if (coche.isDisponible() && coche.getMarca().equals(busqueda)) {
                vista.mostrarCoche(coche);
                seEncontroAlgunCoche = true;
            }
        }

        if (!seEncontroAlgunCoche) vista.mostrarError("La marca introducida no esta registrada");


    }

    @Override
    public void buscarCochePorPrecioCTRLDR() {

        int op = vista.mostrarSubmenuPreciosCoche();
        int min = 0, max = 0;
        boolean seEncontroAlgunCoche = false;

        if (op == 1) {
            min = 12000;
            max = 16000;
        }

        if (op == 2) {
            min = 16000;
            max = 20000;
        }

        if (op == 3) {
            min = 20000;
            max = 30000;
        }

        if (op == 4) {
            min = 30000;
            max = 50000;
        }

        if (op == 5) {
            return;
        }

        for (CocheDTO coche : coches) {

            if (coche.isDisponible() && coche.getPrecio() >= min && coche.getPrecio() <= max) {
                vista.mostrarCoche(coche);
                seEncontroAlgunCoche = true;
            }
        }


        if (!seEncontroAlgunCoche) vista.mostrarError("El precio introducido no esta registrado");


    }

    @Override
    public void buscarCochePorAnhoCTRLDR() {

        int busqueda = vista.buscarCochePorAnho();
        boolean seEncontroAlgunCoche = false;

        for (CocheDTO coche : coches) {
            if (coche.getAnho() >= busqueda) {
                vista.mostrarCoche(coche);
                seEncontroAlgunCoche = true;
            }
        }

        if (!seEncontroAlgunCoche) vista.mostrarError("No se encontraron coches del año " + busqueda + " o más nuevos");
    }

    @Override
    public void registrarClienteCTRLDR(ClientesDTO cliente) {

        // No añade el cliente
        if (existeDNI(cliente.getDni())) {
            vista.mostrarError("ERROR: El DNI " + cliente.getDni() + " ya está registrado");
            return;
        }

        clientes.add(cliente);
        vista.mostrarMensaje("Cliente registrado correctamente");
    }

    @Override
    public void mostrarTodosLosClientesCTRLDR() {

        vista.mostrarListaClientes(clientes);
    }

    @Override
    public void registrarVentaCTRLDR(List<CocheDTO> coches, List<ClientesDTO> clientes, List<VentasDTO> ventas) {

        // Solo se pueden vender coches disponibles
        List<CocheDTO> cochesDisponibles = new ArrayList<>();

        for (CocheDTO coche : coches) {
            if (coche.isDisponible()) {
                cochesDisponibles.add(coche);
            }
        }

        if (cochesDisponibles.isEmpty()) {
            vista.mostrarError("No hay coches disponibles");
            return;
        }

        if (clientes.isEmpty()) {
            vista.mostrarError("No hay clientes en el expositor");
            return;
        }

        VentasDTO venta = vista.registrarVentaMenu(cochesDisponibles, clientes, ventas);

        if (venta != null) {
            // Marcar coche como vendido
            for (CocheDTO coche : coches) {

                String infoCoche = coche.getMarca() + " " + coche.getModelo();

                if (infoCoche.equals(venta.getCocheCliente())) {
                    coche.setDisponible(false);
                    break;
                }
            }

            ventas.add(venta);
            vista.mostrarMensaje("Venta realizada");
        }

    }

    @Override
    public void listarVentaCTRLDR() {

        vista.mostrarListaVentas(ventas);

    }

    @Override
    public List<CocheDTO> filtrarCochesDisponibles() {
        List<CocheDTO> disponibles = new ArrayList<>();
        for (CocheDTO coche : coches) {
            if (coche.isDisponible()) {
                disponibles.add(coche);
            }
        }
        return disponibles;
    }

    @Override
    public boolean existeMatricula(String matricula) {
        for (CocheDTO coche : coches) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeDNI(String dni) {
        for (ClientesDTO cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    @Override
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

            if (op == 3) {
                buscarCochePorMarcaCTRLDR();
            }

            if (op == 4) {
                buscarCochePorPrecioCTRLDR();
            }

            if (op == 5) {
                buscarCochePorAnhoCTRLDR();
            }


            if (op == 6) {
                mostrarTodosLosClientesCTRLDR();
            }

            if (op == 7) {
                ClientesDTO cliente = vista.registrarClienteMenu();
                registrarClienteCTRLDR(cliente);
            }

            if (op == 8) {

                registrarVentaCTRLDR(coches, clientes, ventas);
            }

            if (op == 9) {
                listarVentaCTRLDR();
            }

            if (op == 10) {
                vista.mostrarDespedida();
                break;
            }
        }
    }
}








