package Vista;


import Modelo.CocheDTO;

import java.util.Scanner;

public class VistaSimple implements IVista{
    Scanner sc = new Scanner(System.in);

    @Override
    public int menu(){

        System.out.println("-------------LOGO---------------");

        System.out.println("--------------------------------");
        System.out.println("---------Menu Principal---------");
        System.out.println("--------------------------------");
        System.out.println("1. Añadir Coche");
        System.out.println("2. Mostrar Coche");
        System.out.println("3. Buscar Coche");
        System.out.println("4. Registrar Cliente");
        System.out.println("5. Registrar Venta");
        System.out.println("6. Registrar Venta");
        System.out.println("7. Listar Venta");
        System.out.println("8. Salir");

        int option = -1;

        while(true){
            System.out.println("-Selecciona una opcion-");
            option = sc.nextInt();
            sc.nextLine();

            if (option >= 1 && option <= 7){
                break;
            }

            System.err.println("Introduce una opción valida");

        }

        return option -1;
    }


    public CocheDTO aniadirCocheMenu(){

        System.out.println("Para añadir la un coche se necesitan los siguientes datos: ");

        System.out.println("Marca:");
        String marca = sc.nextLine();

        System.out.println("Modelo:");
        String modelo = sc.nextLine();

        System.out.println("Matricula:");
        String matricula = sc.nextLine();

        System.out.println("Precio: ");
        int precio = sc.nextInt();

        System.out.println("Año del Modelo: ");
        int anho = sc.nextInt();

        System.out.println("Kilometros Totales: ");
        int km = sc.nextInt();



        return new CocheDTO(marca,modelo,matricula,precio,anho,km);
    }


}
