package UD5.LoginSession.Services;

import UD5.LoginSession.Clases.Session;
import UD5.LoginSession.Clases.User;

import java.util.ArrayList;

public class UserSessionService {

    static ArrayList<User> usersRegistered;
    static ArrayList<Session> activeSessions;

    public static boolean checkIfUserExists(User user){
        boolean usuarioExiste = false;

        for (int i = 0; i<usersRegistered.size();i++){
            if (usersRegistered.get(i) == user){
                usuarioExiste = true;
            }
        }

        return usuarioExiste;
    }
    public static boolean checkIfUserlsDuplicate(String user){
        boolean usuarioDuplicado = false;

        for (int i = 0; i<usersRegistered.size();i++){
            if (!usersRegistered.get(i).getUser().equals(user)){
                usuarioDuplicado = true;
            }
        }

        return usuarioDuplicado;
    }
    public static boolean checkIfSessionIsActive(String user){
        boolean sesionEsActiva = false;
        for (int i=0; i< activeSessions.size();i++){
            if (activeSessions.get(i).getUsuario().equals(user)){
                sesionEsActiva = true;
            }
        }

        return sesionEsActiva;

    }
    public static boolean addUser(User user){
        boolean usuarioAgregado = false;

        if (!checkIfUserlsDuplicate(user.getUser())){
            usersRegistered.add(user);
            usuarioAgregado=true;
        }

        return usuarioAgregado;
    }
    public static boolean addSession(User user){

        if (!checkIfSessionIsActive(user.getUser())){

            System.out.println("");
        }

        return false;
    }
}

