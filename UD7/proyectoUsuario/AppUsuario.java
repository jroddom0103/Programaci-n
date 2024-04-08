package UD7.proyectoUsuario;

import UD7.proyectoUsuario.model.Usuario;
import UD7.proyectoUsuario.services.impl.GestionFicheroUsuario;
import UD7.proyectoUsuario.services.impl.ServiceUser;

import java.util.ArrayList;
import java.util.Scanner;

public class AppUsuario {

    public static void main(String[] args) {

        String ruta="resources/archivosTema7/users/users.txt";
        ServiceUser servicio = new ServiceUser();
        GestionFicheroUsuario gestion = new GestionFicheroUsuario();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        //usuarios.addAll(gestion.leerFicheroUsuario(ruta));
        usuarios = gestion.leerFicheroUsuario(ruta);

        Scanner scan = new Scanner(System.in);
        int opcion;

        while (true){
                System.out.println("1. Dar de alta");
                System.out.println("2. Login");
                opcion = scan.nextInt();
                scan.nextLine();

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
                        System.out.println("Opción no válida. Inténtelo de nuevo.\n");
                        break;
                }
        }
    }
}
