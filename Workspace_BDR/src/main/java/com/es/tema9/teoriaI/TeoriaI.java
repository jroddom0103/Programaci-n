package com.es.tema9.teoriaI;

import java.sql.*;

public class TeoriaI {

    public static void main(String[] args){

        //1. Establecer la url.
        String url = "jdbc:mysql://localhost:3306/alumnos?user=root&password=";

        try {

            //2. Establecer la conexión
            Connection connection = DriverManager.getConnection(url);

            //3. Crear objeto de tipo Statement
            Statement stmt = connection.createStatement();

            //4. Lanzar Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM estudiantes");

            //5. Leer ResultSet
            while (rs.next()){
                String nombre = rs.getString("nombre");
                System.out.println("Nombre: "+nombre);

            }

            //6. Cerrar conexión
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
