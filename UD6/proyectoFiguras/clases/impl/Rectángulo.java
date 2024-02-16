package UD6.proyectoFiguras.clases.impl;

import UD6.proyectoFiguras.clases.api.iFigura2D;

public class Rectángulo implements iFigura2D {

    private double lado_Ancho;
    private double lado_Corto;

    public Rectángulo(double lado_Ancho, double lado_Corto){
        this.lado_Ancho=lado_Ancho;
        this.lado_Corto=lado_Corto;
    }

    @Override
    public double perimetro() {

    }

    @Override
    public double area() {

    }

    @Override
    public void escalar(double escala) {

    }

    @Override
    public void imprimir() {

    }
}
