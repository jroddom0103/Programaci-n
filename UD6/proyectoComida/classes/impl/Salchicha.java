package UD6.proyectoComida.classes.impl;

import UD6.proyectoComida.classes.api.Comida;

public class Salchicha implements Comida {
    @Override
    public int addNutricion() {
        System.out.println("Soy una salchicha, te doy +10 de energía");
        return 10;
    }
}
