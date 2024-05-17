package com.es.tema9.teoriaII;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeoriaII {

    public static void main(String[] args) {

        // 1- Establecer la url
        String url = "jdbc:mysql://localhost:3306/bdempleados?user=root&password=";

        try {

            // 2- Conectarse a la BASE DE DATOS
            Connection con = DriverManager.getConnection(url);

            // 3- Crear un objeto Statement
            Statement st = con.createStatement();

            // 4- Lanzar una QUERY
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");

            // 5- Recorrer RESULTSET
            while (rs.next()){

                // Visualizar los registros (cada celda)
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String edad = rs.getString("edad");
                String isAdmin = rs.getString("isAdmin");

                // souts
                System.out.println("\nid: "+id);
                System.out.println("\tnombre: "+nombre);
                System.out.println("\tcorreo: "+correo);
                System.out.println("\tedad: "+edad);
                System.out.println("\tisAdmin: "+isAdmin);

            }


            // PRUEBA

            ResultSet rs2 = st.executeQuery("SELECT * FROM empleados WHERE edad<30");
            while (rs2.next()){

                // Visualizar los registros (cada celda)
                String id = rs2.getString("id");
                String nombre = rs2.getString("nombre");
                String correo = rs2.getString("correo");
                String edad = rs2.getString("edad");
                String isAdmin = rs2.getString("isAdmin");

                // souts
                System.out.println("\nid: "+id);
                System.out.println("\tnombre: "+nombre);
                System.out.println("\tcorreo: "+correo);
                System.out.println("\tedad: "+edad);
                System.out.println("\tisAdmin: "+isAdmin);

            }

            //CONSULTA PARA OBTENER LOS REGISTROS DE LOS EMPLEADOS CON NOMBRE GUMERSINDO

            ResultSet rs3 = st.executeQuery("SELECT * FROM empleados WHERE nombre LIKE 'GUMERSINDO'");
            while (rs3.next()){

                // Visualizar los registros (cada celda)
                String id = rs3.getString("id");
                String nombre = rs3.getString("nombre");
                String correo = rs3.getString("correo");
                String edad = rs3.getString("edad");
                String isAdmin = rs3.getString("isAdmin");

                // souts
                System.out.println("\nid: "+id);
                System.out.println("\tnombre: "+nombre);
                System.out.println("\tcorreo: "+correo);
                System.out.println("\tedad: "+edad);
                System.out.println("\tisAdmin: "+isAdmin);

            }

            //Visualizar empleados mayores de 30

            ResultSet rs4 = st.executeQuery("SELECT * FROM empleados WHERE edad>30");
            while (rs4.next()){

                // Visualizar los registros (cada celda)
                String id = rs4.getString("id");
                String nombre = rs4.getString("nombre");
                String correo = rs4.getString("correo");
                String edad = rs4.getString("edad");
                String isAdmin = rs4.getString("isAdmin");

                // souts
                System.out.println("\nid: "+id);
                System.out.println("\tnombre: "+nombre);
                System.out.println("\tcorreo: "+correo);
                System.out.println("\tedad: "+edad);
                System.out.println("\tisAdmin: "+isAdmin);

            }

            //Visualizar empleados mayores de 30 y que sean admin

            ResultSet rs5 = st.executeQuery("SELECT * FROM empleados WHERE edad>30 & isAdmin=1");
            while (rs5.next()){

                // Visualizar los registros (cada celda)
                String id = rs5.getString("id");
                String nombre = rs5.getString("nombre");
                String correo = rs5.getString("correo");
                String edad = rs5.getString("edad");
                String isAdmin = rs5.getString("isAdmin");

                // souts
                System.out.println("\nid: "+id);
                System.out.println("\tnombre: "+nombre);
                System.out.println("\tcorreo: "+correo);
                System.out.println("\tedad: "+edad);
                System.out.println("\tisAdmin: "+isAdmin);

            }

            //Insertar 1 registro
            //-> "emp8","Patri","patri@patri.com",24,true

            st.execute("INSERT INTO empleados VALUES('emp10','Patri10','patri10@patri10.com',24,1)");
            ResultSet rsInsert = st.executeQuery("SELECT * FROM empleados WHERE id=emp10");
            while (rsInsert.next()){

                // Visualizar los registros (cada celda)
                String id = rsInsert.getString("id");
                String nombre = rsInsert.getString("nombre");
                String correo = rsInsert.getString("correo");
                String edad = rsInsert.getString("edad");
                String isAdmin = rsInsert.getString("isAdmin");

                // souts
                System.out.println("\nid: "+id);
                System.out.println("\tnombre: "+nombre);
                System.out.println("\tcorreo: "+correo);
                System.out.println("\tedad: "+edad);
                System.out.println("\tisAdmin: "+isAdmin);

            }

            //CERRAR LA CONEXIÓN
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
