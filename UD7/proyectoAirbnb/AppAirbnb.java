package UD7.proyectoAirbnb;
import UD7.proyectoAirbnb.services.GestionFicheroAirbnb;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Clase Main
public class AppAirbnb {


    //Método principal
    public static void main(String[] args) throws IOException {

        //Declaración de objeto de tipo Scanner
        Scanner scan = new Scanner(System.in);

        //Instancia de objeto de tipo GestionFicheroAirbnb que permite usar los métodos de la clase
        GestionFicheroAirbnb gestion = new GestionFicheroAirbnb();

        //Ruta del archivo con los datos
        String ruta = ("resources/archivosTema7/airbnb/malaga.csv");

        //Ruta del archivo donde se escribirán los datos
        String ruta2 = ("resources/archivosTema7/airbnb/datos_malaga.csv");

        //Llamada a método que escribe los datos
        gestion.escribirFichero(ruta2,gestion.leerFicheroAlojamientos(ruta));

        //Declaración de variable de opción para el menú
        int opcion;


            //Menú con bucle while infinito hasta que se decida salir
            while (true) {

                System.out.println("\nVisualizador de datos:");
                System.out.println("1. Mostrar 20 alojamientos más baratos");
                System.out.println("2. Mostrar 20 alojamientos más caros");
                System.out.println("3. Mostrar alojamientos por presupuesto");
                System.out.println("0. Salir");

                //Estructura condicional que repite el bucle si se introduce un dato que no sea de tipo entero y lo continua si el tipo coincide
                if (scan.hasNextInt()) {
                    opcion = scan.nextInt();
                    scan.nextLine();
                } else {
                    System.out.println("Introduzca un valor numérico.");
                    scan.nextLine();
                    continue;
                }

                //Estructura condicional switch
                switch (opcion){

                    //Muestra los alojamientos más baratos
                    case 1:
                        gestion.mostrarAlojamientosMasBaratos(gestion.leerFicheroAlojamientos(ruta));
                        break;
                    //Muestra los alojamientos más caros
                    case 2:
                        gestion.mostrarAlojamientosMasCaros(gestion.leerFicheroAlojamientos(ruta));
                        break;
                    //Muestra los alojamientos que cumplen con el presupuesto
                    case 3:
                        gestion.mostrarAlojamientosPorPresupuesto(gestion.leerFicheroAlojamientos(ruta));
                        break;
                    //Cierra el programa
                    case 0:
                        System.out.println("Cerrando programa...");
                        return;
                    //Repite el bucle si es un número entero distinto de las opciones anteriores
                    default:
                        System.out.println("Opción no válida, vuelve a introducir su elección.");

                }

            }


    }

}
