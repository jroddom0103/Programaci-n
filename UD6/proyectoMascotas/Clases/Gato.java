package UD6.proyectoMascotas.Clases;

import java.time.LocalDate;

public class Gato extends Mascotas {

    private String color;
    private boolean peloLargo;

    public Gato(String nombre, String color, boolean peloLargo) {
        super(nombre);
        this.color = color;
        this.peloLargo = peloLargo;
    }


    @Override
    public void muestra(){

        System.out.println("Miau...");

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public void setPeloLargo(boolean peloLargo) {
        this.peloLargo = peloLargo;
    }
}