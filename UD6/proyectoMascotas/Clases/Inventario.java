package UD6.proyectoMascotas.Clases;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Mascotas> mascotas;

    public Inventario(){
        mascotas = new ArrayList<>();


    }

    public void mostrarDatosAnimales(){

        //1* Recorrer el arraylist para poder mostrar los datos de todos los animales
        for (int i=0;i<mascotas.size();i++){
            mascotas.get(i).muestra();
        }

    }

    public void anadirMascota(Mascotas m){
        mascotas.add(m);
    }

    public boolean eliminarMascota(String nombre){

        boolean mascotaEliminada = false;
        for (int i=0;i< mascotas.size();i++){

            //Comparamos el nombre de la mascota del arraylist con el nombre que nos viene por parámetros
            if (mascotas.get(i).nombre.equals(nombre)){
                mascotas.remove(i);
                mascotaEliminada = true;
                break;
            }
        }
        return mascotaEliminada;
    }

    public void mostrarDatosDeUnAnimal(String nombre){

        //1* Declarar un ob
        Mascotas mas = null;

        for (int i=0;i<mascotas.size();i++){
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre)){
                mas = mascotas.get(i);
                break;
            }
        }

        /*
        2 casos:

        1er caso. Que no haya encontrado la mascota
        -> mas sería null
        -> Cuando un objeto es null... *no tiene* ningún atributo, ni ningún método... nada...
        -> Entonces, si se intenta acceder a un método que no existe... saltaría una NullPointerException
         */

        try{

        }catch(NullPointerException e){
            System.out.println("Mascota no encontrada...");
        }

    }

    public void vaciarInventario(){
        mascotas.clear();
    }

    public void mostrarTipoYNombreAnimal(){

        for (int i=0;i<mascotas.size();i++){
            Mascotas m = mascotas.get(i);

            //Hay que preguntarse si m es de tipo Perro o tipo Gato o tipo Canario etc...
            String tipo = "";
            if (m instanceof Perro){
                tipo = "Perro";
            } else if (m instanceof Gato){
                tipo = "Gato";
            }else if (m instanceof Canario){
                tipo = "Canario";
            }else if (m instanceof Loro){
                tipo = "Loro";
            }else{
                tipo = "Mascota";
            }

            System.out.println(m.getNombre()+": "+tipo);

        }



    }

}
