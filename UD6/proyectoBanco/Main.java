package UD6.proyectoBanco;

import UD5.proyectoPeliculas.utils.JsonReaderUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opcion;

        System.out.println("""
                1. Consultar
                2. Movimientos
                0. Salir
                """);
        opcion = scan.nextInt();

        switch (opcion){

            case 1:


            case 2:
                System.out.println("""
                1. Ingresar dinero.
                2. Retirar dinero.
                3. Traspasar dinero de una cuenta a otra.
                0. Atrás
                """);
                opcion = scan.nextInt();

                switch (opcion){
                    case 1:



                    case 2:

                    case 3:

                    case 0:
                        break;
                }


            case 3:
                break;

        }
    }
}
