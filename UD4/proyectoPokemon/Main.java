package UD4.proyectoPokemon;

import UD4.proyectoPokemon.clases.Ataque;
import UD4.proyectoPokemon.clases.Pokemon;
import UD4.proyectoPokemon.clases.Tipo;

public class Main {

    Tipo fuego = new Tipo("Fuego");
    Tipo agua = new Tipo("Agua");
    Tipo planta = new Tipo("Planta");
    Tipo electrico = new Tipo("Eléctrico");
    Tipo normal = new Tipo("Normal");
    Tipo dragon = new Tipo("Dragón");
    Tipo acero = new Tipo("Acero");

    Ataque arañazo = new Ataque("Arañazo",normal,15);
    Ataque ascuas = new Ataque("Ascuas",fuego,15);
    Ataque furia_Dragon = new Ataque("Furia Dragón",dragon,25);
    Ataque garra_Metal = new Ataque("Garra Metal",acero,20);

    Ataque[] ataques_Charmander = {arañazo,ascuas,furia_Dragon,garra_Metal};

    Pokemon charmander = new Pokemon("Charmander","Charmander es un pequeño monstruo bípedo parecido a un lagarto. Sus características de fuego son resaltadas por su color de piel anaranjado y su cola, cuya punta está envuelta en llamas.",fuego,50,ataques_Charmander);
}
