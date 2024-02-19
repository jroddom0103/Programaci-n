package UD6.proyectoEmpresa;

public class Proveedor {

    private String id;
    private String nombre;
    private String cif;

    // Constructor
    public Proveedor(String id, String nombre, String cif) {
        setId(id);
        setNombre(nombre);
        setcif(cif);
    }

    // Métodos

    @Override
    public String toString(){
        String cadenaAMostrar = "";

        cadenaAMostrar += "ID del Proveedor: "+this.id+"\n";
        cadenaAMostrar += "Nombre del Proveedor: "+this.nombre+"\n";
        cadenaAMostrar += "cif: "+this.cif;

        return cadenaAMostrar;
    }

    @Override
    public boolean equals(Object prov){

        if (prov instanceof Proveedor){
            Proveedor proveedor = (Proveedor) prov;
            if (this.cif.equalsIgnoreCase(proveedor.cif)){
                return true;
            } else {
                return false;
            }

        }else{
            return false;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcif() {
        return cif;
    }

    public void setcif(String cif) {
        this.cif = cif;
    }
}
