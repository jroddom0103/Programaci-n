package UD6.proyectoComida.classes.impl;
import UD6.proyectoComida.classes.api.Comida;

public class Hueso implements Comida {

    private int cantEnergia = 5;
    @Override
    public int addNutricion() {
        System.out.println("Te doy 5 de energía");
        return this.cantEnergia;
    }
}
