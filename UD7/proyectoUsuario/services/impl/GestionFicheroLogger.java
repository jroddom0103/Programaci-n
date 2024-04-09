package UD7.proyectoUsuario.services.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GestionFicheroLogger {

    public void anadirFichero(String mensaje, String ruta){

        try {
            //Aquí se escribe en el fichero
            File archivo = new File(ruta);
            FileWriter fe = new FileWriter(archivo,true);
            BufferedWriter be = new BufferedWriter(fe);

            be.write(mensaje);
            be.write("\n");

            //Con .close se cierran los flujos
            be.close();
            fe.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
