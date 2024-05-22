package services;

import model.classes.User;
import model.db.ConectarDB;
import utils.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    // ATRIBUTOS
    private ServiceLogger logger;

    public UserService() {

        this.logger = new ServiceLogger();
    }


    public boolean checkLogin(String id, String pass){
        ConectarDB conectarDB = new ConectarDB(DBUtils.USER, DBUtils.PASS, DBUtils.DB_NAME);
        conectarDB.realizarConexion();

        try {
            // Comprueba si el usuario ha introducido correctamente sus credenciales
            PreparedStatement pst = conectarDB.obtenerConexion().prepareStatement(DBUtils.QUERY_LOGIN);
            pst.setString(1, id);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Bienvenid@.");
                // Si se han introducido correctamente, se procede a cargar el panelOpciones
                return true;

            } else {
                return false;

            }

        } catch (SQLException r) {
            r.printStackTrace();
            return false;
        }finally {
            conectarDB.desconectarDB();
        }
    }

}