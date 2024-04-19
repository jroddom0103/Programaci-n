package UD7.proyecto_UbriCines.services.api;

import UD5.LoginSession.Clases.User;
import UD7.proyectoUsuario.model.Usuario;

import java.util.ArrayList;

public interface BasicServiceUser {

    /**
     * Método altaUsuario.
     * Mete la información introducida en una variable de tipo Usuario y las mete en un ArrayList de usuarios.
     * Además, registra en el archivo logs.txt el usuario que se ha dado de alta y cuándo lo hizo.
     * @return true si se realizó con éxito el alta | false si no se pudo hacer.
     */
    public boolean altaUsuario();

    /**
     * Método loginUsuario
     * Este método se encarga de verificar si la información proporcionada coincide con la información
     * en los datos. Si coincide, te lleva a la zona del cine. Si no coincide, te devuelve al menú principal.
     * @return true si se logró el iniciar sesión | false si no se pudo conseguir.
     */
    public boolean loginUsuario();

    /**
     Método checkUser.
     * Método que comprueba si el id y la contraseña introducida coinciden con sus respectivos datos en el ArrayList users.
     * @param idUser Id del usuario a comprobar.
     * @param password Contraseña del usuario a comprobar.
     * @return true si coinciden | false si no coinciden.
     */
    public boolean checkUser(String idUser, String password);

    /**
     * Método userExists.
     * Método que comprueba si la id que pasa por parámetros coincide con la id del ArrayList<Usuario> users.
     * @param idUser Id del usuario a comprobar.
     * @return true si coinciden | false si no coinciden.
     */
    public boolean userExists(String idUser);

    /**
     * Método leerFicheroUsers.
     * Método que llama al método leerFicheroUsuario y almacena el ArrayList que devuelve en el ArrayList users.
     */
    public void leerFicheroUsers();

    /**
     * Método anadirFicheroUsers.
     * Método que llama al método anadirFicheroUsuarios y le pasa un usuario y una ruta.
     * @param u Usuario.
     * @param r Ruta.
     */
    public void anadirFicheroUsers(Usuario u, String r);

    /**
     * Método modificarFicheroUsers.
     * Método que pasa un array de usuarios al método modificarFicheroUsers.
     * @param users Array de usuarios.
     */
    public void modificarFicheroUsers(ArrayList<Usuario> users);

}
