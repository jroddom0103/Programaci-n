package UD7.proyecto_UbriCines.services.impl;

//Bibliotecas
import UD7.proyectoUsuario.model.Butaca;

import java.io.*;

public class GestionFicheroCine{

    private static final int NFILAS = 10;
    private static final int NASIENTOS = 10;

    public Butaca[][] leerFicheroCine(String ruta){


        Butaca[][] butacas = new Butaca[NFILAS][NASIENTOS];
        //Estructura de control de incidencias
        try {
            //1º Abrir archivo
            File fichero = new File(ruta);

            if (fichero.exists() && fichero.isFile() && fichero.canRead()){
                //2º Abrir flujos
                FileReader fl = new FileReader(fichero);
                BufferedReader bl = new BufferedReader(fl);

                //3º Operar con el fichero

                //Línea para usarlo de salto de línea.
                String linea = bl.readLine();

                //Estructura condicional bucle que no terminará hasta que haya una línea vacía.
                while (linea!=null){

                    //Declaración de variables del usuario
                    String fila;
                    String asiento;
                    String id_user;

                    //Se separa cada campo por :
                    String[] valores = linea.split(":");

                    //Se asigna a cada variable uno de los campos separados por :
                    fila = valores[0];
                    asiento = valores[1];
                    id_user = valores[2];


                    //Se cambia esAdmin de String, pues se tiene que poder leer del archivo, a boolean.
                    int filaint = Integer.parseInt(fila);
                    int asientoint = Integer.parseInt(asiento);

                    //Creación del nuevo usuario
                    UD7.proyectoUsuario.model.Butaca b = new UD7.proyectoUsuario.model.Butaca(filaint,asientoint,id_user);

                    //Se añade el usuario al Array
                    butacas[filaint][asientoint] = b;

                    //Se pasa a la siguiente línea
                    linea = bl.readLine();

                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return butacas;
    }

    public void modificarFicheroCine(Butaca[][] salaDeCine){

        try {

            //Se crea el archivo
            File fichero = new File("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\UD7\\proyecto_UbriCines\\resources\\entradasVendidas.txt");

            //Se comprueba si existe, si es de tipo archivo y si se puede escribir.
            if (fichero.exists() && fichero.isFile() && fichero.canWrite()){

                //Se abren los flujos de escritura
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);

                //Se usa un bucle for que recorrerá el arrayList de alojamientos e irá escribiendo en el archivo.
                for (int i=0;i<20;i++){
                    for (int j=0;j<20;i++) {
                        bw.write(salaDeCine[i][j].getFila() + ":" + salaDeCine[i][j].getAsiento() + ":" + salaDeCine[i][j].getIdUser() + ":");
                        bw.write("\n");

                    }
                }

                //Con .close se cierran los flujos.
                bw.close();
                fw.close();
            }

            //Se capturan las excepciones
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void anadirFicheroCine(Butaca b){

        try {

            //Se crea el archivo
            File fichero = new File("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\UD7\\proyecto_UbriCines\\resources\\entradasVendidas.txt");

            //Se comprueba si existe, si es de tipo archivo y si se puede escribir.
            if (fichero.exists() && fichero.isFile() && fichero.canWrite()) {

                //Se abren los flujos de escritura
                FileWriter fw = new FileWriter(fichero, true);
                BufferedWriter bw = new BufferedWriter(fw);

                //Se usa un bucle for que recorrerá el arrayList de alojamientos e irá escribiendo en el archivo

                //Método write para escribir
                bw.write("\n");
                bw.write(b.getFila() + ":" + b.getAsiento() + ":" + b.getIdUser() + ":");

                //Con .close se cierran los flujos
                bw.close();
                fw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
