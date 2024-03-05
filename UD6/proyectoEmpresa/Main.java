package UD6.proyectoEmpresa;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Proveedor proveedor1 = new Proveedor("1","Paco","1234");
        Proveedor proveedor2 = new Proveedor("2","Ignacio","1234");
        Articulo vaper = new Articulo("1", "Vaper melocotón", proveedor1, 5, 100);
        Articulo vaper2 = new Articulo("2", "Vaper de piña", proveedor2, 5, 200);
        Articulo vaper3 = new Articulo("3", "Vaper melocotón", proveedor1,5,50);
        Articulo vaper4 = new Articulo("4", "Vaper naranja", proveedor1,10, 17);
        Articulo vaper5 = new Articulo("5", "Vaper fresa", proveedor2,6, 11);
        Articulo vaper6 = new Articulo("6", "Vaper plátano", proveedor1,7, 21);
        Articulo vaper7 = new Articulo("7", "Vaper manzana", proveedor1,5, 93);
        Articulo vaper8 = new Articulo("8", "Vaper uva", proveedor2,4, 34);

        ArrayList<Articulo> articulos = new ArrayList<>();

        // Estamos añadiendo un vaper que ya existe
        // Queremos añadir vaper2
        for (int i=0;i<articulos.size();i++){
            if(vaper2.equals(articulos.get(i))){
                articulos.get(i).setStock(vaper2.getStock());
                break;
            }
        }


        if (articulos.contains(vaper3)){
            articulos.get(articulos.indexOf(vaper3)).setStock(vaper3.getStock());
        }



        // Crear 5 Artículos más.
        // Los vais a añadir al arrayList
        // Vais a mostrar la lista de artículos
        // ¿La lista está ordenada?
        // ORDENA LA LISTA

        articulos.add(vaper);
        articulos.add(vaper2);
        articulos.add(vaper8);
        articulos.add(vaper5);
        articulos.add(vaper3);
        articulos.add(vaper4);
        articulos.add(vaper7);
        articulos.add(vaper6);

        for (int i=0;i<articulos.size();i++){
            System.out.println(articulos.get(i));
        }

        Collections.sort(articulos);
        System.out.println("\n");

        for (int i=0;i<articulos.size();i++){
            System.out.println(articulos.get(i));
        }
        
    }

}
