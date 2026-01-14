package Vista;


import Controlador.ControladorConcesionario;
import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import java.util.List;
import java.util.Scanner;

/**
 * Implementación de la Vista en el patrón MVC.
 * Gestiona toda la interacción con el usuario a través de la consola.
 *
 * @author Alexandre Domínguez Avendaño
 *
 */
public class VistaConcesionario implements IVista {
    Scanner sc = new Scanner(System.in);


    //funciones----------------------------------------------------------------------------------------------------------------


    @Override
    public void imprimirLogo() {
        System.out.println("\n");
        System.out.println("|^^^^^^^^^^^\\||____\n" +
                "| RODOVIGO  |||\"\"'|\"\"\\__,_\n" +
                "| _____________ l||__|__|__|)\n" +
                "..|(@)@)\"\"\"\"\"\"\"**|(@)(@)**|(@)\n");
        System.out.println("\n");
    }

    @Override
    public int menu() {

        imprimirLogo();

        System.out.println("-----------------------------------------");
        System.out.println("--------------Menu Principal-------------");
        System.out.println("-----------------------------------------");
        System.out.println("|| 1. Añadir Coche                     ||");
        System.out.println("|| 2. Mostrar Todos los Coches         ||");
        System.out.println("|| 3. Buscar por Marca                 ||");
        System.out.println("|| 4. Buscar por precio                ||");
        System.out.println("|| 5. Buscar por año de fabricacion    ||");
        System.out.println("|| 6. Mostrar Todos los Clientes       ||");
        System.out.println("|| 7. Registrar Cliente                ||");
        System.out.println("|| 8. Registrar Venta                  ||");
        System.out.println("|| 9. Listar Ventas                    ||");
        System.out.println("|| 10. Salir                           ||");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        int option = -1;

        while (true) {
            System.out.println("\n");
            System.out.println("-Selecciona una opcion-");
            option = sc.nextInt();
            sc.nextLine();

            if (option >= 1 && option <= 10) {
                break;
            }

            System.err.println("Introduce una opción valida");

        }

        return option;
    }

    @Override
    public int mostrarSubmenuPreciosCoche() {

        System.out.println("-----------------------------------------");
        System.out.println("--------------Menu Precios---------------");
        System.out.println("-----------------------------------------");
        System.out.println("|| 1. De 12.000 a 16.000 €             ||");
        System.out.println("|| 2. De 16.000 a 20.000 €             ||");
        System.out.println("|| 3. De 20.000 a 30.000 €             ||");
        System.out.println("|| 4. De 30.000 a 50.000 €             ||");
        System.out.println("|| 5. Cancelar                         ||");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        int option = -1;

        while (true) {
            System.out.println("\n");
            System.out.println("-Selecciona una opcion-");
            option = sc.nextInt();
            sc.nextLine();

            if (option >= 1 && option <= 5) {
                break;
            }

            System.err.println("Introduce una opción valida");

        }

        return option;

    }

    @Override
    public CocheDTO aniadirCocheMenu() {

        System.out.println("Para añadir la un coche se necesitan los siguientes datos: ");

        String marca;
        while (true) {
            System.out.println("Marca:");
            marca = sc.nextLine();

            if (marca.isBlank()) {
                mostrarError("Se debe introducir una marca");
            } else {
                mostrarMensaje("Marca introducida correctamente");
                break;
            }
        }

        String modelo;
        while (true) {
            System.out.println("Modelo:");
            modelo = sc.nextLine();

            if (modelo.isBlank()) {
                mostrarError("Se debe introducir un modelo");
            } else {
                mostrarMensaje("Modelo introducido correctamente");
                break;
            }
        }

        String matricula;
        while (true) {
            System.out.println("Matricula:");
            matricula = sc.nextLine();

            if (matricula.isBlank()) {
                mostrarError("Se debe introducir una matricula");
            } else if (ControladorConcesionario.existeMatricula(matricula)) {
                mostrarError("La matrícula " + matricula + " ya existe en el sistema");
            } else {
                mostrarMensaje("Matricula introducida correctamente");
                break;
            }
        }

        float precio = 0;
        while (true) {
            System.out.print("Precio (€): ");

            precio = sc.nextFloat();
            sc.nextLine();

            if (precio >= 0) {

                System.out.println("Precio introducido correctamente");
                break;
            }

            System.err.println("El precio debe ser mayor a 0");

            System.err.println("Introduce un número válido");
            sc.nextLine();
        }

        int anho = 0;
        while (true) {
            System.out.println("Año del Modelo: ");

            anho = sc.nextInt();
            sc.nextLine();

            if (anho >= 1900 && anho <= 2025) {

                System.out.println("Año introducido correctamente");
                break;
            }


            System.err.println("Año no válido");
            System.err.println("Introduce un número válido");
            sc.nextLine();
        }

        int km = 0;
        while (true) {
            System.out.println("Kilometros Totales: ");

            km = sc.nextInt();
            sc.nextLine();

            if (km >= 0) {

                System.out.println("Kilometros introducidos correctamente");
                break;
            }


            System.err.println("Los km no pueden ser menores que cero");
            System.err.println("Introduce un número válido");
            sc.nextLine();
        }

        boolean disponible = true;


        System.out.println("Nuevo coche añadido a expositor");
        return new CocheDTO(marca, modelo, matricula, precio, anho, km, disponible);
    }

    @Override
    public void mostrarCoche(CocheDTO coche) {

        System.out.println("------------------------------------");
        System.out.println("Marca: " + coche.getMarca());
        System.out.println("Modelo: " + coche.getModelo());
        System.out.println("Matrícula: " + coche.getMatricula());
        System.out.println("Precio: " + coche.getPrecio() + " €");
        System.out.println("Año: " + coche.getAnho());
        System.out.println("Kilómetros: " + coche.getKm() + " km");
        System.out.println("Disponible: " + coche.isDisponible());
        System.out.println("------------------------------------");


    }

    @Override
    public void mostrarListaCoches(List<CocheDTO> coches) {

        System.out.println("Total de coches en el expositor: " + coches.size());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < coches.size(); i++) {
            CocheDTO coche = coches.get(i);
            System.out.println((i + 1) + " - MARCA: " + coche.getMarca() + " - MODELO: " + coche.getModelo() +
                    " - MATRÍCULA: " + coche.getMatricula() +
                    " - PRECIO: " + coche.getPrecio() + " €" +
                    " - AÑO: " + coche.getAnho() +
                    " - DISPONIBLE: " + coche.isDisponible());
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public String buscarCochePorMarca() {

        System.out.println("Introduce la marca del coche buscado:");
        return sc.nextLine();
    }

    @Override
    public float buscarCochePorPrecio() {

        System.out.println("Introduce un precio estimado para el coche:");

        int opcion = 0;

        opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    @Override
    public int buscarCochePorAnho() {

        System.out.println("Introduce el año de fabricacion del coche buscado:");
        return sc.nextInt();
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
        return new ClientesDTO(dni, nombre, telefono);
    }

    @Override
    public void mostrarListaClientes(List<ClientesDTO> clientes) {

        System.out.println("Total de coches en el expositor: " + clientes.size());
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < clientes.size(); i++) {
            ClientesDTO cliente = clientes.get(i);
            System.out.println((i + 1) + "- DNI: " + cliente.getDni() + "- NOMBRE: " + cliente.getNombre() +
                    " - TELEFONO: " + cliente.getTelefono());
        }

        System.out.println("-------------------------------------------------------");
    }

    @Override
    public VentasDTO registrarVentaMenu(List<CocheDTO> cochesDisponibles, List<ClientesDTO> clientes, List<VentasDTO> ventas) {


        // Mostrar los coches .................................................
        for (int i = 0; i < cochesDisponibles.size(); i++) {
            CocheDTO coche = cochesDisponibles.get(i);
            System.out.println((i + 1) + " - MARCA: " + coche.getMarca() + " - MODELO: " + coche.getModelo() + " - PRECIO: " + coche.getPrecio() + "€");
        }

        System.out.print("Selecciona coche: ");
        int cocheSeleccionado = sc.nextInt() - 1;
        sc.nextLine();


        // Mostrar los clientes ........................................
        for (int i = 0; i < clientes.size(); i++) {
            ClientesDTO cliente = clientes.get(i);
            System.out.println((i + 1) + " - NOMBRE: " + cliente.getNombre() + " - DNI: " + cliente.getDni());
        }

        System.out.print("Selecciona cliente: ");
        int clienteSeleccionado = sc.nextInt() - 1;
        sc.nextLine();


        // Crear la venta
        CocheDTO coche = cochesDisponibles.get(cocheSeleccionado);
        ClientesDTO cliente = clientes.get(clienteSeleccionado);

        int Id = ventas.size();
        return new VentasDTO(Id, cliente.getNombre(), coche.getMarca() + coche.getModelo(), new java.util.Date(), coche.getPrecio());
    }


    @Override
    public void mostrarListaVentas(List<VentasDTO> ventas) {

        System.out.println("Total de ventas en el expositor: " + ventas.size());
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < ventas.size(); i++) {
            VentasDTO venta = ventas.get(i);
            System.out.println((i + 1) + " ID: " + venta.getId() +
                    " - Cliente: " + venta.getCliente() +
                    " - Coche: " + venta.getCocheCliente() +
                    " - Precio: " + venta.getPrecioVenta() + "€");
        }
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);

    }

    @Override
    public void mostrarError(String error) {
        System.err.println(error);

    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Gracias por utilizar nuestra aplicacion");
        System.out.println("¡¡Hasta la proxima!!");

        imprimirLogo();
    }


}
