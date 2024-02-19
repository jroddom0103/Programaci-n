package UD6.proyectoEmpresa;

import java.util.ArrayList;
import java.util.UUID;


public class Main {

    public static void main(String[] args) {

        Proveedor proveedor1 = new Proveedor("1","Paco","1234");
        Proveedor proveedor2 = new Proveedor("2","Ignacio","1234");
        Articulo vaper = new Articulo("1", "Vaper de melocotón", proveedor1, 5, 100);
        Articulo vaper2 = new Articulo("1", "Vaper de melocotón", proveedor2, 5, 200);

        System.out.println(vaper.toString()+"\n");
        System.out.println(vaper2.toString()+"\n");
        System.out.println(proveedor1.toString()+"\n");
        System.out.println(proveedor2.toString()+"\n");

        System.out.println(proveedor1.equals(proveedor2));

        ArrayList<Articulo> articulos = new ArrayList<>();

        articulos.add(vaper);

        // Estamos añadiendo un vaper que ya existe
        // Queremos añadir vaper2
        System.out.println(articulos.get(0));
        for (int i=0;i<articulos.size();i++){
            if(vaper2.equals(articulos.get(i))){
                articulos.get(i).setStock(articulos.get(i).getStock()+vaper2.getStock());
                break;
            }
        }
        System.out.println(articulos.get(0));

    }

}
