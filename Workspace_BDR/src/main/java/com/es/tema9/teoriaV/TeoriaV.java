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


                PreparedStatement pst2 = conectarBDTv.obtenerConexion().prepareStatement(DBUtils.QUERY_CHECK_USER_IN_ACCESOS);
                pst2.setString(1,user);

                ResultSet rs2 = pst2.executeQuery();
                if (rs2.next()){
                    PreparedStatement pst3 = conectarBDTv.obtenerConexion().prepareStatement(DBUtils.QUERY_UPDATE_NACCESOS);
                    pst3.setString(1,user);
                    int nfilas = pst3.executeUpdate();

                    if (nfilas>0){
                        System.out.println("Registro actualizado correctamente.");
                    }else{
                        System.out.println("ID no encontrado");
                    }
                }else{
                    PreparedStatement pst4 = conectarBDTv.obtenerConexion().prepareStatement(DBUtils.QUERY_INSERT_USER_IN_ACCESOS);
                    pst4.setString(1,user);
                    pst4.setInt(2,0);
                    int nfilas = pst4.executeUpdate();
                    if (nfilas>0){
                        System.out.println("Registro insertado correctamente.");
                    }else{
                        System.out.println("Fallo al insertar.");
                    }
                    PreparedStatement pst5 = conectarBDTv.obtenerConexion().prepareStatement(DBUtils.QUERY_UPDATE_NACCESOS);
                    pst5.setString(1,user);
                    int nfilasUpdate = pst5.executeUpdate();
                    if (nfilasUpdate>0){
                        System.out.println("Se actualizó el registro con éxito");
                    }else{
                        System.out.println("Hubo un fallo al actualizar");
                    }
                }
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