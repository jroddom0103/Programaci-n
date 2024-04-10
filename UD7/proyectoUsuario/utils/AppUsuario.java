package UD7.proyectoUsuario.utils;
import UD7.proyectoUsuario.services.impl.ServiceUser;
import java.util.InputMismatchException;

import java.util.Scanner;

public class AppUsuario {

    public static void main(String[] args) {

        ServiceUser servicio = new ServiceUser();
        servicio.leerFicheroUsers();
        Scanner scan = new Scanner(System.in);
        int opcion;

        while (true){
                System.out.println("\n1. Dar de alta");
                System.out.println("2. Login");
                try {
                    opcion = scan.nextInt();
                    scan.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("\nValor inválido. Por favor, seleccione un número entero.");
                    scan.nextLine();
                    continue;
                }

                switch (opcion){

                    case 1:
                        servicio.altaUsuario();

                        break;
                    case 2:
                        servicio.loginUsuario();
                        break;

                    case 0:
                        System.out.println("Cerrando programa...");
                        return;
                    default:
                        System.out.println("\nOpción no válida. Inténtelo de nuevo.");
                        break;
                }
        }
    }
}
