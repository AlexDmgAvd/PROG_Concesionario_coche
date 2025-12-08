package Vista;


import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import java.util.List;
import java.util.Scanner;

public class VistaSimple implements IVista {
    Scanner sc = new Scanner(System.in);


    //funciones----------------------------------------------------------------------------------------------------------------

    @Override
    public int menu() {

        System.out.println("\n");
        System.out.println("--\uD83D\uDE97 CONCESIONARIO RODOVIGO \uD83D\uDE97--");
        System.out.println("\n");

        System.out.println("---------------------------------");
        System.out.println("----------Menu Principal---------");
        System.out.println("---------------------------------");
        System.out.println("|| 1. Añadir Coche             ||");
        System.out.println("|| 2. Mostrar Todos los Coches ||");
        System.out.println("|| 3. Buscar por Matrícula     ||");
        System.out.println("|| 4. Registrar Cliente        ||");
        System.out.println("|| 5. Registrar Venta          ||");
        System.out.println("|| 6. Listar Ventas            ||");
        System.out.println("|| 7. Salir                    ||");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");

        int option = -1;

        while (true) {
            System.out.println("\n");
            System.out.println("-Selecciona una opcion-");
            option = sc.nextInt();
            sc.nextLine();

            if (option >= 1 && option <= 7) {
                break;
            }

            System.err.println("Introduce una opción valida");

        }

        return option - 1;
    }

    @Override
    public CocheDTO aniadirCocheMenu() {

        System.out.println("Para añadir la un coche se necesitan los siguientes datos: ");

        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Modelo:");
        String modelo = sc.nextLine();

        System.out.println("Matricula:");
        String matricula = sc.nextLine();

        float precio = 0;
        while (true) {
            System.out.print("Precio (€): ");

            precio = sc.nextFloat();
            sc.nextLine();

            if (precio >= 0)
                break;
            System.err.println("El precio debe ser mayor a 0");

            System.err.println("Introduce un número válido");
            sc.nextLine();
        }

        int anho = 0;
        while (true) {
            System.out.println("Año del Modelo: ");

            anho = sc.nextInt();
            sc.nextLine();

            if (anho >= 1900 && anho <= 2025)
                break;

            System.err.println("Año no válido");
            System.err.println("Introduce un número válido");
            sc.nextLine();
        }

        int km = 0;
        while (true) {
            System.out.println("Kilometros Totales: ");

            km = sc.nextInt();
            sc.nextLine();

            if (km >= 0)
                break;

            System.err.println("Los km no pueden ser menores que cero");
            System.err.println("Introduce un número válido");
            sc.nextLine();

        }
        System.out.println("Nuevo coche añadido a expositor");
        return new CocheDTO(marca, modelo, matricula, precio, anho, km);
    }

    @Override
    public void mostrarCoche(CocheDTO coche) {

        System.out.println("Marca: " + coche.getMarca());
        System.out.println("Modelo: " + coche.getModelo());
        System.out.println("Matrícula: " + coche.getMatricula());
        System.out.println("Precio: " + coche.getPrecio() + " €");
        System.out.println("Año: " + coche.getAnho());
        System.out.println("Kilómetros: " + coche.getKm() + " km");

    }

    @Override
    public void mostrarListaCoches(List<CocheDTO> coches) {

        System.out.println("Total de coches en el expositor: " + coches.size());
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < coches.size(); i++) {
            CocheDTO coche = coches.get(i);
            System.out.println((i + 1) + ". " + coche.getMarca() + " " + coche.getModelo() +
                    " - Matrícula: " + coche.getMatricula() +
                    " - Precio: " + coche.getPrecio() + " €");
        }

    }

    @Override
    public String buscarCocheMenu() {

        System.out.println("Introduce la matricula del coche buscado:");
        return sc.nextLine().toUpperCase();
    }

    @Override
    public void mostrarCochesEncontrados(List<CocheDTO> coches) {

        if (coches.isEmpty()) {
            System.err.println("No se encontraron coches con esa matrícula.");
        } else {
            System.out.println("Se encontraron " + coches.size() + " coche(s):");
            for (CocheDTO coche : coches) {
                mostrarCoche(coche);
            }
        }

    }

    @Override
    public ClientesDTO registrarClienteMenu() {


        System.out.println("Para añadir ha un nuevo cliente  se necesitan los siguientes datos: ");

        System.out.println("Dni:");
        String dni = sc.nextLine();

        System.out.println("Nombre:");
        String nombre = sc.nextLine();

        int telefono = 0;
        while (true) {
            System.out.println("Telefono del Modelo: ");

            telefono = sc.nextInt();
            sc.nextLine();

            if (telefono >= 100000000 && telefono <= 999999999)
                break;

            System.err.println("Telefono no válido");
            System.err.println("Introduce un número válido");
            sc.nextLine();
        }

        System.out.println("Nuevo cliente añadido a expositor");
        return new ClientesDTO(dni,nombre,telefono);
    }

    @Override
    public void mostrarClienteRegistrado(ClientesDTO cliente) {

    }

    @Override
    public VentasDTO registrarVentaMenu(List<CocheDTO> cochesDisponibles, List<ClientesDTO> clientes) {
        return null;
    }

    @Override
    public void mostrarListaVentas(List<VentasDTO> ventas) {

    }

    @Override
    public void mostrarMensaje(String mensaje) {

    }

    @Override
    public void mostrarError(String error) {

    }


}
