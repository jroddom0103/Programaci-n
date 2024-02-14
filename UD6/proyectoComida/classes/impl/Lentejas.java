package UD6.proyectoComida.classes.impl;

import UD6.proyectoComida.classes.api.Comida;

public class Lentejas implements Comida {

    public Lentejas(boolean lasQuieres){
        this.lasQuieres=lasQuieres;
    }

    private boolean lasQuieres = true;
    @Override
    public int addNutricion() {

        if (lasQuieres){
            System.out.println("Te doy +25 de energía y +10 de hierro");
            return 100;
        }else{
            System.out.println("Las dejas");
            return 0;
        }
    }
}
