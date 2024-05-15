package services;

import model.classes.User;
import model.db.ConectarDB;
import utils.CredentialsDB;

public class UserService {

    private ConectarDB conexionDB;

    public UserService(){
        //1. NEW
        this.conexionDB = new ConectarDB(CredentialsDB.USER,CredentialsDB.PASS,CredentialsDB.DB_NAME);
        //2.realizar Conexión
        conexionDB.realizarConexion();
    }

    public boolean checkUserExists(User user){


        return true;
    }

}
