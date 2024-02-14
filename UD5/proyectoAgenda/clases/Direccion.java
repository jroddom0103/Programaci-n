package UD5.proyectoAgenda.clases;

public class Direccion {

    private String calle;
    private int numero;
    private int planta;
    private int puerta;
    private Localidad localidad;

    public Direccion(String calle, int numero, int planta, int puerta, Localidad localidad){

        this.calle=calle;
        this.numero=numero;
        this.planta=planta;
        this.puerta=puerta;
        this.localidad=localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    public void presentacion(){
        System.out.printf("C/ %s, %d ", this.calle, this.numero);
        if (this.planta!=0){
            System.out.printf(", %d (%s)", this.planta, this.puerta);
        }
        System.out.println("\n");
        localidad.presentacion();
    }

    //Creación de las 3 clases
    //Declaración de los atributos
    //Declaración de los getters y setters
    //En los setters pertinentes... hacer comprobación con
    //expresiones regulares.

    //nombre -> que no haya números
    //dni -> formato adecuado
    //cp -> formato adecuado para Andalucia
    //telefono -> formato adecuado
}
