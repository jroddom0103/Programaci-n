package UD6.proyectoMascotas;

import UD6.proyectoMascotas.Clases.*;

import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) {

        Perro oreo = new Perro("Oreo","Schnautzer",false);
        Perro goku = new Perro("Goku","Yorkshire",false);
        Gato pulga = new Gato("Pulga","Marrón",false);
        Loro pirri = new Loro("Pirri","Granívoro",true,"Sudamérica",true);
        Canario muyayo = new Canario("Muyayo","Granívoro",true,"Amarillo");

        Inventario invent = new Inventario();

        invent.anadirMascota(oreo);
        invent.anadirMascota(goku);
        invent.anadirMascota(pulga);
        invent.anadirMascota(pirri);

        invent.mostrarDatosAnimales();

        invent.eliminarMascota("pulga");

        System.out.println("------------------------------");
        Mascotas mascota1 = new Mascotas("Oreo");
        Mascotas mascota2 = new Mascotas("Goku");
        Mascotas mascota3 = new Mascotas("Pulga");
        Mascotas mascota4 = new Mascotas("Pirri");
        System.out.println("------------------------------");
        invent.mostrarDatosAnimales();
        invent.eliminarMascota("pulga");

        System.out.println("------------------------------");
        invent.mostrarTipoYNombreAnimal();

    }
}
