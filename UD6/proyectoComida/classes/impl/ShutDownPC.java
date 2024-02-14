package UD6.proyectoComida.classes.impl;

import UD6.proyectoComida.classes.api.Regañeta;

public class ShutDownPC implements Regañeta {

    private int energia;
    @Override
    public int reduceEnergia() {
        energia = 30;
        return energia;
    }
}
