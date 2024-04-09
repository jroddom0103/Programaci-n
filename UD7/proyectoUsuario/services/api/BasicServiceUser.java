package UD7.proyectoUsuario.services.api;

import UD5.LoginSession.Clases.User;
import UD7.proyectoUsuario.model.Usuario;

import java.util.ArrayList;

public interface BasicServiceUser {

    public boolean altaUsuario();
    public boolean loginUsuario();
    public boolean checkUser(String idUser, String password);
    public boolean userExists(String idUser);
    public void leerFicheroUsers();
    public void anadirFicheroUsers(Usuario u, String ruta);

    public void modificarFicheroUsers(ArrayList<Usuario> users);

}
