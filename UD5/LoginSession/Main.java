package UD5.LoginSession;

import UD5.LoginSession.Clases.Session;
import UD5.LoginSession.Clases.User;
import UD5.LoginSession.Services.UserSessionService;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        int opcion;
        Scanner scan = new Scanner(System.in);

        System.out.println("""
                
                Te damos la bienvenida:
                
                    1.Login
                    2.Alta
                    0.Salir
                """);
        opcion = scan.nextInt();

        switch (opcion){

            case 1:
                String usuario;
                String contrasena;
                System.out.println("Di tu usuario:");
                usuario = scan.next();



                System.out.println("Di tu contraseña:");
                contrasena = scan.next();
                User usuarioLogin = new User(usuario, contrasena);
                UserSessionService.checkIfUserExists(usuarioLogin);

                break;
            case 2:

            case 0:
                System.out.println("""
                        Adiós
                        Cerrando el programa...""");
                        break;






        }

    }
}
