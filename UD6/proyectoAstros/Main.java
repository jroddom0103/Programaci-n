package UD6.proyectoAstros;

import UD6.proyectoAstros.clases.Planeta;
import UD6.proyectoAstros.clases.Satelite;

public class Main {

    public static void main(String[] args) {

        Planeta tierra = new Planeta(6738.4,23.56,5975,17.18,"Tierra",150000000,365.04,true);
        Satelite luna = new Satelite(3474.8,23.56,7,-96,"Luna",384400,23.56);

        tierra.muestra();
        luna.muestra();

        if (tierra.esMayor(luna)){
            System.out.println("La Tierra es mayor.");
        }else{
            System.out.println("La Luna es mayor");
        }

        //Cread el planeta Jupiter y el satelite Europa

        Planeta Jupiter = new Planeta(69911,9.83, 18981,20000,"Júpiter",750000000,1000,true);
        Satelite Europa = new Satelite(1569,85228344,4.8,-163,"Europa",671100,670900);

        //Métodos
        if (Jupiter.esMayor(tierra)){
            System.out.println("Júpiter es mayor que la Tierra.");
        }else{
            System.out.println("La tierra es más grande que Júpiter.");
        }

        if (Europa.esMayor(luna)){
            System.out.println("Europa es más grande que la Luna.");
        }else{
            System.out.println("La Luna es más grande que Europa.");
        }


    }
}
