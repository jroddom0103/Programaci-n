package UD6.proyectoFiguras.clases.impl;

import UD6.proyectoFiguras.clases.api.iFigura2D;

public class Triángulo implements iFigura2D {

    private double ladobase;
    private double lado2;
    private double lado3;
    private double altura;

    public Triángulo(double ladobase, double lado2, double lado3, double altura){
        this.ladobase=ladobase;
        this.lado2=lado2;
        this.lado3=lado3;
        this.altura=altura;
    }

    @Override
    public double perimetro() {
        return (ladobase+lado2+lado3);
    }

    @Override
    public double area() {
        return ((ladobase*altura)/2);
    }

    @Override
    public void escalar(double escala) {

    }

    @Override
    public void imprimir() {

    }
}
