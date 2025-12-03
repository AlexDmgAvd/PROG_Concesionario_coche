package Vista;


import java.util.Scanner;

public class VistaSimple {
    Scanner sc = new Scanner(System.in);

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



}
