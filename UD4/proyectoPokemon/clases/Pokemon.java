package UD4.proyectoPokemon.clases;

public class Pokemon {

    private String nombre;
    private String lore;
    private Tipo tipo;
    private int vida;
    private Ataque[] ataques;

    public Pokemon(String nombre, String lore, Tipo tipo, int vida, Ataque[] ataques) {
        this.nombre = nombre;
        this.lore = lore;
        this.tipo = tipo;
        this.vida = vida;
        this.ataques = ataques;
    }

}
