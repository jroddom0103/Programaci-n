package UD7.proyectoAirbnb.model;

//Clase Propietario
public class Propietario {

    //Atributos de clase
    private String host_id;
    private String host_name;

    //Método constructor de Propietario
    public Propietario(String host_id,String host_name){
        this.host_id=host_id;
        this.host_name=host_name;
    }

    //Método equals de la clase Propietario
    @Override
    public boolean equals(Object obj){

        if (obj instanceof Propietario){
            Propietario p = (Propietario) obj;
            return p.getHost_id().equalsIgnoreCase(getHost_id());
        }
        return false;
    }

    //Método toString de la clase Propietario
    @Override
    public String toString() {
        return "Propietario{" +
                "host_id='" + host_id + '\'' +
                ", host_name='" + host_name + '\'' +
                '}';
    }

    //Getters y setters
    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }
}
