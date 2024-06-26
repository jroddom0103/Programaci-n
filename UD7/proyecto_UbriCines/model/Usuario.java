package UD7.proyectoUsuario.model;

import java.util.Objects;

//Clase Usuario.
public class Usuario {

    //Declaración de variables de Usuario.
    private String id;
    private String nombre;
    private String contrasena;
    private boolean esAdmin;

    //Método constructor de la clase Usuario.
    public Usuario(String id, String nombre, String contrasena, boolean esAdmin) {
        setId(id);
        setNombre(nombre);
        setContrasena(contrasena);
        setEsAdmin(esAdmin);
    }

    //Clase equals.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    //Clase toString.
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }

    //Getters y setters.
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

}
