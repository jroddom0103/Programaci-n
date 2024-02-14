package UD5.proyectoPeliculas;

import UD5.proyectoPeliculas.clases.Pelicula;
import UD5.proyectoPeliculas.services.PeliculasService;
import UD5.proyectoPeliculas.utils.JsonReaderUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCreacion {

    public static ArrayList<Pelicula> peliculas = null;

    public static void main(String[] args) {
        String pelisPath = "IMDB-api/Top250Movies.json";
        peliculas = JsonReaderUtil.loadJsonFile(pelisPath);

        /*
        Es hacer un menú para dar la opción de crear un nuevo registro
         */

        Scanner scan = new Scanner(System.in);


        try {
            int opc = 1;

            while (opc != 0) {
                System.out.print("""
                        Bienvenid@ al CRUD de Peliculas
                                        
                        1. Insertar pelicula
                        2. Mostrar peliculas de mayor a menor
                        3. Mostrar peliculas de menor a mayor
                        4. Eliminar pelicula
                        0. Salir
                                        
                        Escoja una opcion:
                        """);
                opc = scan.nextInt();

                switch (opc) {

                    case 1:
                        PeliculasService.addPelicula();
                        break;
                    case 2:
                        PeliculasService.mostrarPeliculasDesc();
                        break;
                    case 3:
                        PeliculasService.mostrarPeliculasAsc();
                        break;
                    case 4:
                        PeliculasService.eliminarPelicula();
                        break;
                    case 0:
                        System.out.println("Adios...");
                        break;

                    default:
                        System.out.println("Opcion no valida\n");
                        break;
                }
            }


        } catch (InputMismatchException e) {
            System.out.println("Opcion incorrecta... eliminando todos sus archivos");
        }


    }
}