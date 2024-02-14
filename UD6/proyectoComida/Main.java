package UD6.proyectoComida;

import UD6.proyectoComida.classes.api.Comida;
import UD6.proyectoComida.classes.api.Regañeta;
import UD6.proyectoComida.classes.impl.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Energía al principio del día
        int energia = 100;
        Scanner scan = new Scanner(System.in);

        System.out.println("""
                    1. Programación
                    2. Bases de datos
                    3. Sistemas
                    4. Entornos de desarrollo
                    5. Hueso
                    6. Lentejas
                    7. Salchicha
                    8. Tarde
                    9. Parte
                    10. PC
                    0. Salir
                    """);
        System.out.println("Indique el módulo: ");
        int opc = 1;

        do {
            opc = scan.nextInt();
            switch (opc){

                case 1:
                    energia = energia-20;
                    break;

                case 2:
                    energia = energia-30;
                    break;

                case 3:
                    energia = energia-70;
                    break;

                case 4:
                    energia = energia-55;
                    break;

                case 5:
                    Comida huesodePollo = new Hueso();
                    energia = energia + huesodePollo.addNutricion();
                    break;

                case 6:
                    Lentejas platoDeLentejas = new Lentejas(true);
                    energia = energia + platoDeLentejas.addNutricion();
                    break;

                case 7:
                    Salchicha salchichaUP = new Salchicha();
                    energia += salchichaUP.addNutricion();
                    break;

                case 8:
                    Regañeta regañetaTardeDebian = new LlegasTarde();
                    energia = energia - regañetaTardeDebian.reduceEnergia();

                case 9:
                    Regañeta regañetaParteDebian = new Parte();
                    energia = energia - regañetaParteDebian.reduceEnergia();

                case 10:
                    Regañeta regañetaPCDebian = new ShutDownPC();
                    energia = energia - regañetaPCDebian.reduceEnergia();

                case 0:
                    break;

            }
            System.out.println("Energía restante: "+energia);
            System.out.println("Indica otra opción:");

        }while (opc != 0);

        if (energia <= 0){
            System.out.println("Has muerto de cansancio");
        }else{
            System.out.println("Sigues vivo");
        }

    }

}
