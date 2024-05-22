package model.db;

import model.classes.User;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConectarDB {

    private String user;
    private String pass;
    private String nombreDB;
    private String url;
    private Connection connection;

    public ConectarDB(String user, String pass, String nombreDB){
        this.user=user;
        this.pass=pass;
        this.nombreDB=nombreDB;
    }

    public void realizarConexion() {

        this.url = "jdbc:mysql://localhost:3306/"+this.nombreDB+"?user="+this.user+"&password="+this.pass;
        try {
            if (this.connection == null){
                this.connection = DriverManager.getConnection(this.url);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void desconectarDB(){
        try {
            if(this.connection!=null){
                this.connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Connection obtenerConexion(){
        return this.connection;
    }
}