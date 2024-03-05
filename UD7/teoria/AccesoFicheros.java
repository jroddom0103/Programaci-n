package UD7.teoria;

import java.io.File;
import java.io.IOException;

public class AccesoFicheros {

    public static void main(String[] args) {



        //Para crear un objeto de tipo File, debemos llamar al constructor de la clase File.
        File fichero1 = new File("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\resources\\archivosTema7\\fichNoExiste.txt");

        //En este punto, ya tenemos un objeto de tipo File... que en este caso, es el fichero que hemos creado
        if (fichero1.exists()){
            System.out.println("El fichero existe y tiene de nombre "+fichero1.getName());
        }else{
            System.out.println("El fichero no existe.");

        try{
            fichero1.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al crear el fichero.");
        }
        }

        try{
            System.out.println("Nombre fichero: "+fichero1.getName());
            System.out.println("Padre del fichero: "+fichero1.getParent());
            System.out.println("Ruta absoluta del fichero: "+fichero1.getAbsolutePath());
            System.out.println("Ruta relativa del fichero: "+fichero1.getCanonicalPath());

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al obtener los datos del fichero.");
        }

        //Vamos a intentar borrar el fichero
        fichero1.delete();

        if (fichero1.delete()){
            System.out.println("Se ha eliminado el fichero");
        }else{
            System.out.println("No se ha eliminado el fichero");
        }

        // Ejercicio Clase
        //Teneis que acceder al directorio alumnos
        File directorioAlumnos = new File("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\resources\\archivosTema7\\alumnos");

        //Teneis que preguntar si existe
        if (directorioAlumnos.exists()){
            //Si sí existe, teneis que listar todos los ficheros que contenga el directorio
            File[] ficherosDelDirectorio = directorioAlumnos.listFiles();
            //.listFiles() te devuelve un array con todos los Files contenidos en el directorio

            //Tenemos que recorrer el array
            for (int i=0;i<ficherosDelDirectorio.length;i++){
                //accedemos a cada elemento del array directamente con [i]
                String nombreDelFichero = ficherosDelDirectorio[i].getName();
                System.out.println("Nombre: "+nombreDelFichero);
            }

        }else{
            System.out.println("No existe.");
        }

    }

}
