package UD6.proyectoAstros.clases;

public class Astro {

    protected double radioEcuatorial;
    protected double rotacion;
    protected double masa;
    protected double temperaturaMedia;
    protected String nombre;

    public void muestra(){

        System.out.println("Nombre: "+this.nombre+".");
        System.out.println("Con un radio de "+this.radioEcuatorial+".");
        System.out.println("Y una temperatura de "+temperaturaMedia+".");
    }

    public boolean esMayor(Astro a){

        return this.masa > a.masa;

    }

}
