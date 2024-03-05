package UD7.teoria;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RutasFicheros {

    public static void main(String[] args) {

        // Para conocer la línea separadora hacemos uso de
        String lineaSeparadora = File.separator;
        System.out.println("La línea separadora es "+lineaSeparadora);

        //Rutas absolutas vs Rutas relativas
        File fichAbsoluto = new File("C:"+lineaSeparadora+lineaSeparadora+"Users"+lineaSeparadora+lineaSeparadora+"jroddom0103"+lineaSeparadora+lineaSeparadora+"Desktop"+lineaSeparadora+lineaSeparadora+"1-DAW"+lineaSeparadora+lineaSeparadora+"Programacion_Bien"+lineaSeparadora+lineaSeparadora+"src"+lineaSeparadora+lineaSeparadora+"resources"+lineaSeparadora+lineaSeparadora+"archivosTema7"+lineaSeparadora+lineaSeparadora+"fich.txt");
        System.out.println("¿El fichero existe? "+fichAbsoluto.exists());

        File fichRelativo = new File("resources"+lineaSeparadora+"archivosTema7"+lineaSeparadora+"fich.txt");
        System.out.println("¿El fichero existe? "+fichRelativo.exists());

        // LECTURA EN FICHERO
        //0* Primero comprobamos que exista el fichero
        if (fichRelativo.exists()){
            //1* Abrir el flujo de lectura -> Al leer/escribir en ficheros, se lanzan excepciones
            //esas excepciones son de IOException y FileNotFoundException
            FileReader fl = null;
            try{
                // Aquí abrimos el flujo de lectura en sí al crear un objeto de tipo FileReader
                fl = new FileReader(fichRelativo);

                //2* Operar con el fichero... en este caso, leemos la información
                int caracter = fl.read();
                while (caracter != -1){
                    System.out.print((char) caracter);
                    caracter=fl.read();
                }

                //3* Cerrar el flujo
                fl.close();

            }catch(IOException e){
                e.printStackTrace();
            }

            // ESCRITURA EN FICHERO

            if (fichRelativo.exists() && fichRelativo.isFile()){
                //1* Abrir el flujo de escritura
                FileWriter fw = null;
                try{
                    fw = new FileWriter(fichRelativo);

                    Scanner scan = new Scanner(System.in);
                    System.out.println("\nDime tu nombre:");
                    String nombre = scan.next();
                    System.out.println("Dime tu edad");
                    int edad = scan.nextInt();
                    //2* Operar con el fichero
                    fw.write("Hola, mi nombre es "+nombre+".\n");
                    fw.append("Tengo "+edad+" años.\n");
                    fw.append("dkjakljsjk");
                    //3* Cerrar el flujo
                    fw.close();

                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
