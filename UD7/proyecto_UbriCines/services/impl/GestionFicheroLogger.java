package UD7.proyecto_UbriCines.services.impl;

//Bibliotecas
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GestionFicheroLogger {

    public void anadirFichero(String mensaje, String ruta){

        //Se controlan las excepciones
        try {
            //Aquí se escribe en el fichero
            File archivo = new File(ruta);
            FileWriter fe = new FileWriter(archivo,true);
            BufferedWriter be = new BufferedWriter(fe);
            be.write("\n");
            be.write(mensaje);


            //Con .close se cierran los flujos
            be.close();
            fe.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
