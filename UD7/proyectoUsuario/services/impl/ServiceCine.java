package UD7.proyectoUsuario.services.impl;

//Bibliotecas
import UD7.proyectoUsuario.model.Butaca;
import UD7.proyectoUsuario.services.api.BasicServiceCine;

public class ServiceCine implements BasicServiceCine {

    String ruta = "resources/archivosTema7/entradasVendidas/entradasVendidas.txt";
    private String nombreCine;
    private static final int NFILAS = 10;
    private static final int NASIENTOS = 10;
    private Butaca[][] salaDeCine;
    private GestionFicheroCine gestion;

    //Constructor
    public ServiceCine(String nombreCine){

        this.nombreCine = nombreCine;
        this.gestion = new GestionFicheroCine();
        this.salaDeCine = new Butaca[NFILAS][NASIENTOS]; //Aquí tendríamos un array bidimensional de Butaca, lleno de nulls.

        /*
        [null,null,null]
        [null,null,null]
        [null,null,null]
         */

        this.salaDeCine = gestion.leerFicheroCine("resources/archivosTema7/entradasVendidas/entradasVendidas.txt"); //Aquí vamos a leer el fichero para llenar el array de Butaca.

    }


    @Override
    public void mostrarButacas() {
        for (int i = 0; i<salaDeCine.length;i++){
            for (int j=0;i<salaDeCine.length;i++){
                if (salaDeCine[i][j]==null){
                    System.out.println("__");
                }else{
                    System.out.println("XX");
                }
            }

        }
    }

    @Override
    public boolean comprarEntrada() {
        return false;
    }

    @Override
    public boolean devolverEntrada() {
        return false;
    }

    @Override
    public boolean checkComprador(String idUser) {
        return false;
    }

    @Override
    public void leerFicheroCine() {

    }

    @Override
    public void anadirFicheroCine(Butaca b) {

    }

    @Override
    public void modificarFicheroCine() {

    }
}
