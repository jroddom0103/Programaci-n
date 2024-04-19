package UD7.proyecto_UbriCines.services.impl;

//Bibliotecas
import UD7.proyectoUsuario.model.Usuario;
import UD7.proyecto_UbriCines.services.api.BasicServiceUser;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ServiceUser.
 * Se encarga de ofrecer servicios a nivel de usuarios.
 * Implementa la interfaz BasicServiceUser.
 */
public class ServiceUser implements BasicServiceUser{

    //Declaración de variables
    ArrayList<Usuario> users; //Contiene todos los registros del fichero users.txt.
    GestionFicheroUsuario gestion; //gestion es un objeto para poder llamar a los métodos de GestionFicheroUser.
    LoggerService servicioLogger = new LoggerService(); //servicioLogger es un objeto para llamar a los métodos de LoggerService.

    // Método constructor de la clase ServiceUser.
    public ServiceUser(){
        this.users=new ArrayList<>();
        this.gestion=new GestionFicheroUsuario();
        this.users = gestion.leerFicheroUsuario("resources/archivosTema7/users/users.txt");

    }

    /**
     * Método altaUsuario.
     * Mete la información introducida en una variable de tipo Usuario y las mete en un ArrayList de usuarios.
     * Además, registra en el archivo logs.txt el usuario que se ha dado de alta y cuándo lo hizo.
     * @return true si se realizó con éxito el alta | false si no se pudo hacer.
     */
    @Override
    public boolean altaUsuario() {

        //Inicialización y declaración de objeto de tipo Scanner
        Scanner scan = new Scanner(System.in);

        //Declaración de variables de usuarios
        String idUsuario;
        String passwordUsuario;
        String nombreUsuario;

        System.out.println("Introduce un id:");
        idUsuario = scan.nextLine();

        //Estructura condicional que if que llama al método que comprueba si la id ya está registrada, y si lo hace, devuelve
        //un mensaje de que no se puede dar de alta con esa id y se retorna falso.
        if (userExists(idUsuario)){
            System.out.print("Esta id ya existe en el sistema.\n");
            return false;
        //Si no coincide con la id de ningún usuario, entonces se permite continuar agregando datos.
        }else{
            System.out.println("Introduce un nombre de usuario:");
            nombreUsuario = scan.nextLine();
            System.out.println("Introduce una contraseña:");
            passwordUsuario = scan.nextLine();

            //Inicialización y declaración de objeto de tipo Usuario con los datos introducidos anteriormente.
            Usuario u = new Usuario(idUsuario,nombreUsuario,passwordUsuario,false);
            //Llamada a método que almacena los datos del usuario en el fichero users.txt.
            anadirFicheroUsers(u,"resources/archivosTema7/users/users.txt");
            //Se recoge el usuario creado en el ArrayList<Usuario> llamado users.
            users.add(u);
            //Se llama al método logAlta de la clase servicioLogger para que almacene la información
            //con respecto a quién y en qué momento se realizó el alta del usuario.
            servicioLogger.logAlta(u.getId());
        }
        return true;
    }

    /**
     * Método loginUsuario
     * Este método se encarga de verificar si la información proporcionada coincide con la información
     * en los datos. Si coincide, te lleva a la zona del cine. Si no coincide, te devuelve al menú principal.
     * @return true si se logró el iniciar sesión | false si no se pudo conseguir.
     */
    @Override
    public boolean loginUsuario() {
        //Este código permite pasar la información del ArrayList<Usuario> formado por los usuarios registrados en el txt
        //que devuelve leerFicheroUsuario al ArrayList<Usuario> users.
        //users.addAll(gestion.leerFicheroUsuario("leerFicheroUsers()"));

        //Inicialización y declaración de objeto de tipo Scanner.
        Scanner scan = new Scanner(System.in);

        //Declaración de variables.
        String idUsuario;
        String passwordUsuario;

        System.out.print("Introduzca su idUsuario: ");
        idUsuario = scan.nextLine();

        //Estructura condicional if que llama al método que comprueba si el idUsuario existe en el ArrayList<Usuario> users.
        if (userExists(idUsuario)){
            System.out.print("Introduzca su contraseña: ");
            passwordUsuario = scan.nextLine();

            //Estructura condicional if que llama al método que comprueba si el idUsuario y la contraseña existen en el
            //ArrayList<Usuario> users.
            if (checkUser(idUsuario,passwordUsuario)){
                //Método de la clase servicioLogger que guarda quién y cuándo hizo login un usuario del sistema.
                servicioLogger.logLogin(idUsuario);
                System.out.println("\nSesión iniciada.");
                return true;
            }else{
                System.out.println("Creedenciales incorrectas.");
                return false;
            }
        //Si no coincide, se retorna falso.
        }else{
            System.out.println("\nEl usuario no existe en el sistema.");
            return false;
        }
    }

    /**
     * Método checkUser.
     * Método que comprueba si el id y la contraseña introducida coinciden con sus respectivos datos en el ArrayList users.
     * @param idUser Id del usuario a comprobar.
     * @param password Contraseña del usuario a comprobar.
     * @return true si coinciden | false si no coinciden.
     */
    @Override
    public boolean checkUser(String idUser, String password) {

        //Estructura de bucle for que compara la id con la contraseña de todos los usuarios del ArrayList<Usuario> users.
        for (int i=0;i<this.users.size();i++){
            //Declaración e inicialización de objeto de tipo Usuario.
            Usuario usuario = this.users.get(i);
            //Estructura condicional que iguala la id y la contraseña del usuario seleccionado con la i.
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getContrasena().equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método userExists.
     * Método que comprueba si la id que pasa por parámetros coincide con la id del ArrayList<Usuario> users.
     * @param idUser Id del usuario a comprobar.
     * @return true si coinciden | false si no coinciden.
     */
    @Override
    public boolean userExists(String idUser) {
        //Estructura de bucle for que va comparando la id de cada usuario del ArrayList con la id que se pasa por parámetros.
        for (int i=0;i<this.users.size();i++){
            //Declaración e inicialización de objeto de tipo Usuario.
            Usuario usuario = this.users.get(i);
            //Estructura condicional que iguala la id del usuario seleccionado con la i.
            if (usuario.getId().equals(idUser)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método leerFicheroUsers.
     * Método que llama al método leerFicheroUsuario y almacena el ArrayList que devuelve en el ArrayList users.
     */
    @Override
    public void leerFicheroUsers() {
        this.users = gestion.leerFicheroUsuario("resources/archivosTema7/users/users.txt");
    }

    /**
     * Método anadirFicheroUsers.
     * Método que llama al método anadirFicheroUsuarios y le pasa un usuario y una ruta.
     * @param u Usuario.
     * @param r Ruta.
     */
    @Override
    public void anadirFicheroUsers(Usuario u, String r) {
        gestion.anadirFicheroUsuarios(u,r);
    }

    /**
     * Método modificarFicheroUsers.
     * Método que pasa un array de usuarios al método modificarFicheroUsers.
     * @param users Array de usuarios.
     */
    @Override
    public void modificarFicheroUsers(ArrayList<Usuario> users) {
        gestion.modificarFicheroUsuarios(this.users);
    }
}
