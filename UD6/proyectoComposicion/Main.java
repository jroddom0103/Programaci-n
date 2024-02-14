package UD6.proyectoComposicion;

import UD6.proyectoComposicion.clases.Volk;
import UD6.proyectoComposicion.clases.Wagen;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        // Concesionario
        Wagen audi = new Wagen("a4", "audi", null);

        // Se lo compra
        ArrayList<Wagen> cochesDeRaquel = new ArrayList<>();
        cochesDeRaquel.add(audi);

        Volk raquel = new Volk("Raquel", cochesDeRaquel);

        audi.setPropietario(raquel);


        System.out.println("");



    }
}
