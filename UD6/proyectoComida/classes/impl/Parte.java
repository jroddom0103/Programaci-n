package UD6.proyectoComida.classes.impl;

import UD6.proyectoComida.classes.api.Regañeta;

public class Parte implements Regañeta {

    private int energia;
    @Override
    public int reduceEnergia() {
        energia = 40;
        return energia;
    }
}
