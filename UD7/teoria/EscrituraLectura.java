package UD7.teoria;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscrituraLectura {

    public static void main(String[] args) {

        // VAMOS A ESCRIBIR EN UN FICHERO COSAS HASTA QUE SE ESCRIBA FIN

        // 0· Obtener la barra separadora
        String lineaSeparadora = File.separator;

        // 1· Abrir el fichero
        File ficheroPrueba = new File("resources"+lineaSeparadora+"archivosTema7"+lineaSeparadora+"fichero_prueba.txt");

        // 2· Comprobar que el fichero existe
        if (ficheroPrueba.exists() && ficheroPrueba.isFile() && ficheroPrueba.canWrite()){

            // 3· Abrir flujos (en este caso, de escritura) -> Lanza IOException
            FileWriter fw = null;
            try {

                fw = new FileWriter(ficheroPrueba);

                String cadenaAEscribir = "";
                Scanner scan = new Scanner(System.in);

                while (!cadenaAEscribir.equalsIgnoreCase("fin")){

                    System.out.println("Oh Elron, dime algo bonito...");
                    cadenaAEscribir = scan.nextLine();

                    if (!cadenaAEscribir.equalsIgnoreCase("fin")){
                        //4· Operar con el fichero
                        fw.write(cadenaAEscribir+"\s");
                    }
                }

                //5· Cerrar los flujos
                fw.close();


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al operar con el fichero");
                // Para cerrar el flujo en caso de error
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (Exception ex){
                        e.printStackTrace();
                    }
                }
            }
        }

        //AHORA LECTURA DE FICHERO
        // 1· Abrir el fichero

        File ficheroParaLeer = new File("resources/archivosTema7/ficheroParaLeer");

        //2· Comprobar que existe

        if (ficheroParaLeer.exists() && ficheroParaLeer.isFile() && ficheroParaLeer.canRead()){

            //3· Abrir flujos de lectura -> Lanza IOException
            FileReader fr = null;
            try {
                fr = new FileReader(ficheroParaLeer);

                //4· Operar con el fichero
                int caracter = 0;
                while (caracter != -1){ //Mientras el carácter sea distinto de -1... seguimos leyendo
                    caracter = fr.read(); //fr.read() devuelve un entero... EL CARACTER EN UNICODE

                    System.out.println((char) caracter); //Aquí... el (char) caracter lo que hace es
                    // cambiar de número a caracter... obtiene caracter correspondiente del código UNICODE
                }

                //5· Cerrar los flujos
                fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}