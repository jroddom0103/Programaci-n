package UD6.proyectoAstros.clases;

import UD6.proyectoAstros.clases.Astro;

public class Planeta extends Astro {

    private double distanciaSol;
    private double orbitaSol;
    private boolean tieneSatelites;


    @Override
    public void muestra(){
        System.out.println("Nombre del planeta: "+this.nombre+".");
        System.out.println("Con un radio de "+this.radioEcuatorial+".");
        System.out.println("Y una temperatura de "+temperaturaMedia+".");
        System.out.println("Y tarda en darle la vuelta al sol"+this.orbitaSol+".");

    }

    public Planeta(double radioEcuatorial, double rotacion, double masa, double temperaturaMedia, String nombre, double distanciaSol, double orbitaSol, boolean tieneSatelites) {

        this.distanciaSol=distanciaSol;
        this.orbitaSol=orbitaSol;
        this.tieneSatelites=tieneSatelites;
    }
}
