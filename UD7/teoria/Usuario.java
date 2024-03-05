package UD7.teoria;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {

        // VAMOS A ESCRIBIR EN UN FICHERO COSAS HASTA QUE SE ESCRIBA FIN

        // 0· Obtener la barra separadora
        String lineaSeparadora = File.separator;

        // 1· Abrir el fichero
        File ficheroPrueba = new File("resources" + lineaSeparadora + "archivosTema7" + lineaSeparadora + "usuario.txt");

        // 2· Comprobar que el fichero existe
        if (ficheroPrueba.exists() && ficheroPrueba.isFile() && ficheroPrueba.canWrite()) {

            // 3· Abrir flujos (en este caso, de escritura) -> Lanza IOException
            FileWriter fw = null;
            try {

                fw = new FileWriter(ficheroPrueba);

                String nombre = "";
                String contraseña = "";
                Scanner scan = new Scanner(System.in);

                while (!nombre.equalsIgnoreCase("fin") && !contraseña.equalsIgnoreCase("fin")) {

                    System.out.println("Dime tu nombre");
                    nombre = scan.nextLine();

                    System.out.println("Dime tu contraseña");
                    contraseña = scan.nextLine();

                    if (!nombre.equalsIgnoreCase("fin") && !contraseña.equalsIgnoreCase("fin")) {
                        //4· Operar con el fichero
                        fw.write(nombre + ":" + contraseña+"\n");
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
                    } catch (Exception ex) {
                        e.printStackTrace();
                    }
                }
            }
        }

        File ficheroLectura = new File("resources/archivosTema7/usuario.txt");

        // 2· Comprobar que el fichero existe
        if (ficheroLectura.exists() && ficheroLectura.isFile() && ficheroLectura.canRead()) {

            // 3· Abrir flujos (en este caso, de escritura) -> Lanza IOException
            FileReader fl = null;
            try {

                fl = new FileReader(ficheroLectura);

                String cadena = "";

                int caracter = fl.read();
                while (caracter != -1){

                    caracter = fl.read();
                    if (caracter != 10){
                        cadena += (char) caracter;
                    }

                }

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