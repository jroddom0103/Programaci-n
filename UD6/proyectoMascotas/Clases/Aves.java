package UD6.proyectoMascotas.Clases;

import java.time.LocalDate;

public class Aves extends Mascotas {

    protected String pico;
    protected boolean vuela;

    public Aves(String nombre, String pico, boolean vuela) {
        super(nombre);

    }


    public void volar(){
        if (this.vuela){
            System.out.println("Passsso que voy volandoooo...");
        }else{
            System.out.println("Pa voladora tú águila calva...");
        }
    }

    public String getPico() {
        return pico;
    }

    public void setPico(String pico) {
        this.pico = pico;
    }

    public boolean isVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }
}
