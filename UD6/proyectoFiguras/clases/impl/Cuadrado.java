package UD6.proyectoFiguras.clases.impl;

import UD6.proyectoFiguras.clases.api.iFigura2D;

public class Cuadrado implements iFigura2D {

    private double lado;

   public Cuadrado(double lado){
       this.lado = lado;
   }

    @Override
    public double perimetro() {
        return (Math.pow(this.lado,2));
    }

    @Override
    public double area() {
        return this.lado*this.lado;
    }

    @Override
    public void escalar(double escala) {

    }

    @Override
    public void imprimir() {
        System.out.println("El lado es "+this.lado+".");
        System.out.println("El área es de "+this.area()+".");
        System.out.println("El perímetro es de "+this.perimetro()+".");
    }

}
