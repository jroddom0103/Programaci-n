package UD7.proyecto_UbriCines.services.impl;

//Bibliotecas
import UD7.proyecto_UbriCines.model.Butaca;
import UD7.proyecto_UbriCines.services.api.BasicServiceCine;

import java.util.Scanner;

public class ServiceCine implements BasicServiceCine {

    String ruta = "C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\UD7\\proyecto_UbriCines\\resources\\entradasVendidas.txt";
    private String nombreCine;
    private static final int NFILAS = 10;
    private static final int NASIENTOS = 10;
    private Butaca[][] salaDeCine;
    private GestionFicheroCine gestion;

    //Constructor
    public ServiceCine(String nombreCine){

        this.nombreCine = nombreCine;
        this.gestion = new GestionFicheroCine();
        this.salaDeCine = new Butaca[NFILAS][NASIENTOS]; //Aquí tendríamos un array bidimensional de Butaca, lleno de nulls.

        /*
        [null,null,null]
        [null,null,null]
        [null,null,null]
         */

        this.salaDeCine = gestion.leerFicheroCine("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\UD7\\proyecto_UbriCines\\resources\\entradasVendidas.txt"); //Aquí vamos a leer el fichero para llenar el array de Butaca.

    }


    @Override
    public void mostrarButacas() {
        for (int i = 0; i < salaDeCine.length; i++) {
            for (int j = 0; j < salaDeCine[i].length; j++) {
                if (salaDeCine[i][j] == null) {
                    System.out.print("__ ");
                } else {
                    System.out.print("XX ");
                }
            }
            System.out.println();
        }
    }


    @Override
    public boolean comprarEntrada() {

        Scanner scan = new Scanner(System.in);
        int fila;
        int asiento;

        System.out.println("Selecciona fila:");
        fila = scan.nextInt();
        System.out.println("Selecciona asiento:");
        asiento = scan.nextInt();

        for (int i = 0; i < salaDeCine.length; i++) {
            for (int j = 0; j < salaDeCine[i].length; j++) {
                if (salaDeCine[fila][asiento]==salaDeCine[i][j] && salaDeCine[i][j].getIdUser()==null) {

                } else {

                }
            }

        }

        return false;
    }

    @Override
    public boolean devolverEntrada() {
        return false;
    }

    @Override
    public boolean checkComprador(String idUser) {
        return false;
    }

    @Override
    public void leerFicheroCine() {

    }

    @Override
    public void anadirFicheroCine(Butaca b) {

    }

    @Override
    public void modificarFicheroCine() {

    }
}
