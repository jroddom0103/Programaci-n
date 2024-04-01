package UD7.proyectoAirbnb;

import UD7.proyectoAirbnb.services.GestionFicheroAirbnb;

public class AppAirbnb {

    public static void main(String[] args) {

        GestionFicheroAirbnb gestion = new GestionFicheroAirbnb();

        String ruta = ("resources/archivosTema7/airbnb/malaga.csv");

        gestion.leerFicheroAlojamientos(ruta);

    }

}
