package UD4.proyectoPokemon.clases;

public class Ataque {

    private String nombre;
    private Tipo tipo;
    private int danio;

    public Ataque(String nombre, Tipo tipo, int danio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.danio = danio;
    }
}
