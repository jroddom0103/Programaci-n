package UD5.proyectoAgenda;

import UD5.proyectoAgenda.clases.Direccion;
import UD5.proyectoAgenda.clases.Localidad;
import UD5.proyectoAgenda.clases.Persona;

public class Main {

    public static void main(String[] args) {


        Localidad localidad1 = new Localidad("11600","Ubrique","Cádiz");
        Direccion direccion1 = new Direccion("Patos",7,2,4,localidad1);

        Persona persona1 = new Persona("Pepe","85719371A",20,"pepe@gmail.com","672839201",direccion1);
    }
}
