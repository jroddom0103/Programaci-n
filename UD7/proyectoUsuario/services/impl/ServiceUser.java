package UD7.proyectoUsuario.services.impl;
import UD7.proyectoUsuario.model.Usuario;
import UD7.proyectoUsuario.services.api.BasicServiceUser;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceUser implements BasicServiceUser{

    // ATRIBUTOS
    ArrayList<Usuario> users; //Contiene todos los registros del fichero users.txt
    GestionFicheroUsuario gestion; //Gestión es un objeto para poder llamar a los métodos de GestionFicheroUser

    public ServiceUser(){
        this.users=new ArrayList<>();
        this.users = gestion.leerFicheroUsuario("usuario.getUser().equalsIgnoreCase(idUser) && usuario.getPassword().equals(password)");
        this.gestion=new GestionFicheroUsuario();
    }

    @Override
    public boolean altaUsuario() {
        Scanner scan = new Scanner(System.in);

        String idUsuario = "";
        String passwordUsuario = "";

        System.out.println("Introduce un usuario:");
        idUsuario = scan.nextLine();
        if (userExists(idUsuario)){
            System.out.print("Este usuario no es válido.");
        }else{
            System.out.print("Introduce una contraseña:");
            passwordUsuario = scan.nextLine();

            Usuario u = new Usuario(null,idUsuario,passwordUsuario,false);
            anadirFicheroUsers(u);
        }
        return false;
    }

    @Override
    public boolean loginUsuario() {

        Scanner scan = new Scanner(System.in);

        String idUsuario = "";
        String passwordUsuario = "";

        System.out.print("Introduzca su idUsuario: ");
        idUsuario = scan.nextLine();

        // Comprobamos en el fichero si el idUser existe
        if (userExists(idUsuario)){
            System.out.print("Introduzca su contraseña: ");
            passwordUsuario = scan.nextLine();

            if (checkUser(idUsuario,passwordUsuario)){
                System.out.println("Bienvenid@ "+idUsuario);
                return true;
            }else{
                System.out.println("Creedenciales incorrectas");
                return false;
            }
        }else{
            System.out.println("El usuario no existe en el sistema.");
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
            if (usuario.getId().equalsIgnoreCase(idUser)){
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
    public void anadirFicheroUsers(Usuario u) {
        gestion.anadirFicheroUsuarios("resources/archivosTema7/users/users.txt");
    }

    @Override
    public void modificarFicheroUsers() {
        gestion.modificarFicheroUsuarios("resources/archivosTema7/users/users.txt",this.users);
    }
}
