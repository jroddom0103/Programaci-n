package UD7.proyectoAirbnb.services;

import UD7.proyectoAirbnb.model.Alojamiento;
import UD7.proyectoAirbnb.model.Propietario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionFicheroAirbnb {

    public ArrayList<Alojamiento> leerFicheroAlojamientos(String ruta){

        ArrayList<Alojamiento> arrDeInformacion = new ArrayList<>();

        System.out.println("RUTA: "+ruta);
        File fichero = new File(ruta);
        if (fichero.exists() && fichero.isFile() && fichero.canRead()){

            FileReader fl;
            BufferedReader bl;

            try {

                fl = new FileReader(fichero);
                bl = new BufferedReader(fl);

                String lineaDelFichero = bl.readLine();
                int i = 0;
                String id;
                String name;
                String host_id;
                String host_name;
                String price;


                while (lineaDelFichero != null) {
                    if (i==0){
                        i++;
                    }else{
                        String[] valores = lineaDelFichero.split(",");
                        id = valores[0];
                        name = valores[1];
                        host_id = valores[2];
                        host_name = valores[3];
                        price = valores[9];
                        price = price.trim();
                        double precio=0;

                        try {
                            precio = Double.parseDouble(price);
                        }catch (NumberFormatException e){
                            e.printStackTrace();
                        }


                        Propietario p = new Propietario(host_id,host_name);
                        Alojamiento a = new Alojamiento(id,name,p,precio);

                        if (!arrDeInformacion.contains(a)) {
                            arrDeInformacion.add(a);
                        }
                    }

                    lineaDelFichero = bl.readLine();
                }


                bl.close();
                fl.close();

            }catch (IOException e){
                e.printStackTrace();
            }
        }


        return arrDeInformacion;
    }

}
