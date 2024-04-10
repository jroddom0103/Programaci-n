package UD7.proyectoUsuario.services.impl;
import UD7.proyectoUsuario.model.Usuario;
import UD7.proyectoUsuario.services.api.BasicServiceUser;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceUser implements BasicServiceUser{

    // ATRIBUTOS
    ArrayList<Usuario> users; //Contiene todos los registros del fichero users.txt
    GestionFicheroUsuario gestion; //Gestión es un objeto para poder llamar a los métodos de GestionFicheroUser
    LoggerService servicioLogger = new LoggerService();

    public ServiceUser(){
        this.users=new ArrayList<>();
        this.gestion=new GestionFicheroUsuario();
        this.users = gestion.leerFicheroUsuario("usuario.getUser().equalsIgnoreCase(idUser) && usuario.getPassword().equals(password)");

    }

    @Override
    public boolean altaUsuario() {
        Scanner scan = new Scanner(System.in);

        String idUsuario;
        String passwordUsuario;
        String nombreUsuario;

        System.out.println("Introduce un id:");
        idUsuario = scan.nextLine();
        if (userExists(idUsuario)){
            System.out.print("Esta id ya existe en el sistema.\n");
            return false;
        }else{
            System.out.println("Introduce un nombre de usuario:");
            nombreUsuario = scan.nextLine();
            System.out.println("Introduce una contraseña:");
            passwordUsuario = scan.nextLine();

            Usuario u = new Usuario(idUsuario,nombreUsuario,passwordUsuario,false);
            anadirFicheroUsers(u,"resources/archivosTema7/users/users.txt");
            users.add(u);
            servicioLogger.logAlta(u.getId());
        }
        return true;
    }

    @Override
    public boolean loginUsuario() {
        users.addAll(gestion.leerFicheroUsuario("leerFicheroUsers()"));
        Scanner scan = new Scanner(System.in);

        String idUsuario;
        String passwordUsuario;

        System.out.print("Introduzca su idUsuario: ");
        idUsuario = scan.nextLine();

        // Comprobamos en el fichero si el idUser existe
        if (userExists(idUsuario)){
            System.out.print("Introduzca su contraseña: ");
            passwordUsuario = scan.nextLine();

            if (checkUser(idUsuario,passwordUsuario)){
                servicioLogger.logLogin(idUsuario);
                System.out.println("Te damos la bienvenida.");
                return true;
            }else{
                System.out.println("Creedenciales incorrectas.");
                return false;
            }
        }else{
            System.out.println("\nEl usuario no existe en el sistema.");
            return false;
        }
    }

    @Override
    public boolean checkUser(String idUser, String password) {

        // 1º manera de hacerlo
        for (int i=0;i<this.users.size();i++){
            Usuario usuario = this.users.get(i); //usuario es el elemento de la posición i de users
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getContrasena().equals(password)){
                return true;
            }
        }

        /*
        // 2º manera de hacerlo
        for (User usuario:this.users){
            if (usuario.getUser().equalsIgnoreCase(idUser) && usuario.getPassword().equals(password)){
                return true;
            }
        }
        */

        /* 3º manera de hacerlo
        return this.users.stream()
                .filter(usuario->usuario.getUser().equalsIgnoreCase(idUser) && usuario.getPassword().equals(password))
                .findFirst()
                .isEmpty();
        */
        return false;
    }

    @Override
    public boolean userExists(String idUser) {
        for (int i=0;i<this.users.size();i++){
            Usuario usuario = this.users.get(i); //usuario es el elemento de la posición i de users
            if (usuario.getId().equals(idUser)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void leerFicheroUsers() {
        this.users = gestion.leerFicheroUsuario("resources/archivosTema7/users/users.txt");
    }


    @Override
    public void anadirFicheroUsers(Usuario u, String r) {
        gestion.anadirFicheroUsuarios(u,"resources/archivosTema7/users/users.txt");
    }

    @Override
    public void modificarFicheroUsers(ArrayList<Usuario> users) {
        gestion.modificarFicheroUsuarios(this.users);
    }
}
