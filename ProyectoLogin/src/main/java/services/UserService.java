package services;

import model.classes.User;
import model.db.ConectarDB;
import utils.CredentialsDB;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class UserService {

    // ATRIBUTOS
    private ArrayList<User> users; // Contiene todos los registros del fichero users.txt
    private GestionFicheroUser gestionUser; // gestion es un objeto para poder llamar a los métodos de GestionFicheroUser
    private ServiceLogger logger;

    private String ruta = "src/main/resources/users/users.txt";

    public UserService() {
        this.users = new ArrayList<>();
        this.gestionUser = new GestionFicheroUser();
        leerFicheroUsers();
        this.logger = new ServiceLogger();
    }


    public boolean checkUserExists(String correo, String pass) {
        for (int i = 0; i < this.users.size(); i++) {
            User usuario = this.users.get(i); // usuario es el elemento de la posicion i de users
            if (usuario.getCorreo().equals(correo) && usuario.getPass().equals(pass)) {
                this.logger.registrarLog(usuario.getId(), "LOGIN", "OK");
                return true;
            }
        }
        System.out.println("No se hizo adecuadamente.");
        return false;
    }

    public boolean userExists(String idUser) {
        return this.users.stream().anyMatch(user -> user.getId().equalsIgnoreCase(idUser));
    }

    public void leerFicheroUsers() {
        this.users = gestionUser.leerFichero(this.ruta);
    }

    public void anadirFicheroUsers(User u) {
        gestionUser.anadirFichero(u, this.ruta);
    }

    public void modificarFicheroUsers() {
        gestionUser.modificarFichero(this.users, this.ruta);
    }

    public boolean altaUsuario(User usuario){

        if (usuario.getId().length()<=20){
            try {
                if (!userExists(usuario.getId())){
                    this.logger.registrarLog(usuario.getId(), "Alta", "OK");
                    anadirFicheroUsers(usuario);
                    return true;
                }
            }catch (InputMismatchException e){
                e.printStackTrace();
                System.out.println("El formato es inválido.");
            }
        }else{
            System.out.println("El nombre debe ser menor a 20 letras.");
        }

        return false;
    }

    public UserService obtenerUsuario(UserService serviceUser){
        return serviceUser;
    }

}