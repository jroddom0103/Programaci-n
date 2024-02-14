package UD6.proyectoComida.classes.impl;

import UD6.proyectoComida.classes.api.Regañeta;

public class LlegasTarde implements Regañeta {

    private int energia;
    @Override
    public int reduceEnergia() {
        energia = 10;
        return energia;
    }
}
