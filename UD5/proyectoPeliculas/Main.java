package UD5.proyectoPeliculas;


import UD5.proyectoPeliculas.clases.Pelicula;
import UD5.proyectoPeliculas.utils.JsonReaderUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pelisPath = "IMDB-api/Top250Movies.json";
        ArrayList<Pelicula> peliculas = JsonReaderUtil.loadJsonFile(pelisPath);
        Scanner scan = new Scanner(System.in);
        int opcion;

        System.out.println("Elige la opción que desees:");
        System.out.println("1. Imprimir las películas de mayor a menor nota.");
        System.out.println("2. Imprimir las películas de menor a mayor nota.");
        System.out.println("3. Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad.");
        System.out.println("4. Imprimir las películas cuyo año sea del 2000 hasta la actualidad que tengan una nota por encima del 8.8 (incluído)");
        System.out.println("5. Imprimir las películas cuyo año de publicación sea del 2000 hasta la actualidad que tengan una nota por encima de una nota que diga el usuario por teclado.");
        System.out.println("6. Imprimir por pantalla una película que el usuario introduce por teclado.");
        System.out.println("7. Imprimir por pantalla las películas de un director que el usuario introduce por teclado.");
        opcion = scan.nextInt();
        System.out.println();

        switch (opcion) {

            case 1:

                for (int i = 0; i < peliculas.size(); i++) {

                    System.out.println(peliculas.get(i).getFullTitle());

                }
                break;

            case 2:
                for (int i = peliculas.size() - 1; i >= 0; i--) {
                    System.out.println(peliculas.get(i).getFullTitle());
                }
                break;

            case 3:
                for (int i = 0; i < peliculas.size(); i++) {
                    if (Integer.parseInt(peliculas.get(i).getYear()) >= 2000) {
                        System.out.println(peliculas.get(i).getFullTitle() + ": " + peliculas.get(i).getYear());
                    }
                }
                System.out.println();
                break;

            case 4:
                for (int i = 0; i < peliculas.size(); i++) {
                    if (Integer.parseInt(peliculas.get(i).getYear()) >= 2000 && Double.parseDouble(peliculas.get(i).getImDbRating()) >= 8.8) {
                        System.out.println(peliculas.get(i).getFullTitle() + ": " + peliculas.get(i).getYear() + ": " + peliculas.get(i).getImDbRating());
                    }
                }
                break;
            case 5:
                double nota;
                System.out.println("Di la nota que quieres, y se te darán películas con esa nota para arriba:");
                nota = scan.nextDouble();
                for (int i = 0; i < peliculas.size(); i++) {
                    if (Integer.parseInt(peliculas.get(i).getYear()) >= 2000 && Double.parseDouble(peliculas.get(i).getImDbRating()) >= nota) {
                        System.out.println(peliculas.get(i).getFullTitle() + ": " + peliculas.get(i).getYear() + ": " + peliculas.get(i).getImDbRating());
                    }
                }
                break;
            case 6:
                String nombrePelicula;
                System.out.println("Di el nombre de la película:");
                nombrePelicula = scan.next();
                for (int i = 0; i < peliculas.size(); i++) {
                    if (peliculas.get(i).getTitle().equalsIgnoreCase(nombrePelicula)) {
                        System.out.println("Título completo: " + peliculas.get(i).getFullTitle());
                        System.out.println("Clasificación: " + peliculas.get(i).getRank());
                        System.out.println("Puntuación: " + peliculas.get(i).getImDbRating());
                    }
                }
                break;
            case 7:
                String director;
                System.out.println("Dime el nombre de un director:");
                director = scan.next();
                System.out.println("\nPelículas en las que su director es: " + director + ".");
                for (int i = 0; i < peliculas.size(); i++) {
                    if (director.equalsIgnoreCase(peliculas.get(i).getCrew())) {
                        System.out.println("Director: " + peliculas.get(i).getCrew());
                        System.out.println("Título completo: " + peliculas.get(i).getFullTitle());
                        System.out.println("Clasificación: " + peliculas.get(i).getRank());
                        System.out.println("Puntuación: " + peliculas.get(i).getImDbRating());
                    }
                }
                break;

        }

    }
    

}
