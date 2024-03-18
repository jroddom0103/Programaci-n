package UD7.teoria.ejemplos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {

        /*
        Enunciado
        Crear un programa que lea un fichero de texto plano y cuenta las palabras que hay en él.
        El programa debe mostrar el número de palabras que hay.
        (Opcional) Mostrar las palabras también.
         */

        String lineaSeparadora = File.separator;

        // 1· Abrir el fichero
        File ficheroPrueba = new File("resources" + lineaSeparadora + "archivosTema7" + lineaSeparadora + "archivosEjemplos" + lineaSeparadora + "fich_ejemplo1.txt");

        // 2· Comprobar que el fichero existe
        if (ficheroPrueba.exists() && ficheroPrueba.isFile() && ficheroPrueba.canWrite()) {

            // 3· Abrir flujos (en este caso, de escritura) -> Lanza IOException
            FileReader fl = null;
            try {

                fl = new FileReader(ficheroPrueba);

                int caracter = 0;
                int contador = 0;

                while (caracter!=-1){
                    caracter=fl.read();
                    System.out.print((char) caracter);
                    if (caracter==32 || caracter==-1){
                        contador++;
                    }
                }
                System.out.println("Hay "+contador+" palabras.");

                FileWriter fw = new FileWriter(ficheroPrueba);


                //5· Cerrar los flujos
                fl.close();


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al operar con el fichero");
                // Para cerrar el flujo en caso de error
                if (fl != null) {
                    try {
                        fl.close();
                    } catch (Exception ex) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
