package UD6.proyectoAstros.clases;

import UD6.proyectoAstros.clases.Astro;

public class Satelite extends Astro{

    private double distanciaPlaneta;
    private double orbitaPlanetaria;

    @Override
    public void muestra(){

    }

    public Satelite(double radioEcuatorial, double rotacion, double masa, double temperaturaMedia, String nombre, double distanciaPlaneta, double orbitaPlanetaria) {

        this.distanciaPlaneta=distanciaPlaneta;
        this.orbitaPlanetaria=orbitaPlanetaria;
    }

}
