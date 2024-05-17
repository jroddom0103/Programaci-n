package com.es.tema9.teoriaV;

import com.es.tema9.teoriaV.model.ConectarBD_TV;
import com.es.tema9.teoriaV.utils.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TeoriaV {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("user: ");
        String user = scan.nextLine();

        System.out.println("Pass: ");
        String pass = scan.nextLine();

        // 2º REALIZAR LA CONEXION
        // A) Establecer la url
        ConectarBD_TV conectarBDTv = new ConectarBD_TV(DBUtils.USER,DBUtils.PASS,DBUtils.DB_NAME);
        // B) Establecer la conexión
        conectarBDTv.realizarConexion();

        try {
            // C) Crear un objeto Statement con la QUERY
            PreparedStatement pst = conectarBDTv.obtenerConexion().prepareStatement(DBUtils.QUERY_LOGIN);

            // METER LOS PARAMETROS
            // (el número del parámetro, y el parámetro en sí)
            pst.setString(1,user);
            pst.setString(2,pass);

            // D) EJECUTAR LA QUERY
            ResultSet rs = pst.executeQuery();

            // E) LEER RESULTADOS
            if (rs.next()){
                System.out.println("Bienvenid@.");
              }else{
                System.out.println("No estás registrado.");
            }

            // F) Cerrar CONEXIÓN
            conectarBDTv.realizarDesconexion();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}