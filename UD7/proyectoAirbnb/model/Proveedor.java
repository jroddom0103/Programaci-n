package UD7.proyectoAirbnb.model;

import java.util.Objects;

//Clase Proveedor
public class Proveedor {

    //Atributos de clase
    private String host_id;
    private String host_name;

    //Método constructor de la clase Proveedor
    public Proveedor(String host_id, String host_name) {
        getHost_id(host_id);
        getHost_name(host_name);
    }

    //Métodos getters y setters
    public String getHost_id(String host_id) {
        return this.host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getHost_name(String host_name) {
        return this.host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    //Método toString de la clase Proveedor
    @Override
    public String toString() {
        return "Proveedor{" +
                "host_id='" + host_id + '\'' +
                ", host_name='" + host_name + '\'' +
                '}';
    }

    //Método equals de la clase Proveedor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(host_id, proveedor.host_id) && Objects.equals(host_name, proveedor.host_name);
    }

}
