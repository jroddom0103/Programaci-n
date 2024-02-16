package UD6.proyectoFiguras.clases.impl;

import UD6.proyectoFiguras.clases.api.iFigura2D;

public class Triángulo implements iFigura2D {

    private double lado1;
    private double lado2;
    private double lado3;
    private double altura;

    public Triángulo(double lado1, double lado2, double lado3, double altura){
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
        this.altura=altura;
    }

    @Override
    public double perimetro() {
        return (lado1+lado2+lado3);
    }

    @Override
    public double area() {
        return ((lado1*h)/2);
    }

    @Override
    public void escalar(double escala) {

    }

    @Override
    public void imprimir() {

    }
}
