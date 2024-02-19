package UD6.proyectoFiguras.clases.impl;

import UD6.proyectoFiguras.clases.api.iFigura2D;

public class Círculo implements iFigura2D {

    private double radio;
    @Override
    public double perimetro() {
        double perimetro;
        perimetro = 2*3.14*radio;
        return perimetro;
    }

    @Override
    public double area() {
        double area;
        area = 3.14*Math.pow(radio,2);
        return area;
    }

    @Override
    public void escalar(double escala) {

    }

    @Override
    public void imprimir() {

    }
}
