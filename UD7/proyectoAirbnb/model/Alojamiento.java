package UD7.proyectoAirbnb.model;

//Clase Alojamiento
public class Alojamiento implements Comparable<Alojamiento>{

    //Atributos de clase
    private String id;
    private String name;
    private Propietario propietario;
    private double precio;

    //Método constructor de la clase Alojamiento
    public Alojamiento(String id, String name, Propietario p, double precio) {
        setId(id);
        setName(name);
        setPropietario(p);
        setPrecio(precio);
    }

    //Método toString de la clase Alojamiento
    @Override
    public String toString() {
        return "Alojamiento{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", propietario=" + propietario +
                ", precio=" + precio +
                '}';
    }

    //Método equals de la clase Alojamiento
    @Override
    public boolean equals(Object obj){

        if (obj instanceof Alojamiento){
            Alojamiento a = (Alojamiento) obj;
            return a.getId().equalsIgnoreCase(this.getId());
        }
        return false;
    }

    //Método compareTo de la clase Alojamiento
    @Override
    public int compareTo(Alojamiento o){
        if (this.getPrecio()>o.getPrecio()){
            return 1;
        }else if(this.getPrecio()<o.getPrecio()){
            return -1;
        }else{
            return 0;
        }
    }

    //Métodos getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio>=0) {
            this.precio = precio;
        }
    }



}
