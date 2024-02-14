package UD5.proyectoAgenda.clases;

import UD5.proyectoAgenda.utils.AgendaUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {

    private String nombre;
    private String dni;
    private int edad;
    private String email;
    private String telefono;
    private Direccion direccion;

    public Persona(String nombre, String dni, int edad, String email, String telefono, Direccion direccion){
        this.nombre=nombre;
        this.dni=dni;
        this.edad=edad;
        this.email=email;
        this.telefono=telefono;
        this.direccion=direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (AgendaUtils.checkNombre(nombre)){
            this.nombre = nombre;
        }

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {

        if (AgendaUtils.checkDNI(dni)){
            this.dni = dni;
        }

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad>0){
            this.edad = edad;
        }else{
            System.out.println("La edad no puede ser menor que 0.");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (AgendaUtils.checkEmail(email)){
            this.email = email;
        }

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (AgendaUtils.checkTLFN(telefono)){
            this.telefono = telefono;
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void presentacion(){
        System.out.printf("Hola, me llamo %s, con dni %s y tengo %d años", this.nombre, this.dni, this.edad);
        System.out.printf("Puedes contactarme en %s o en mi teléfono %s", this.email, this.telefono);

        System.out.println("Si quieres visitarme, ven a ");
        direccion.presentacion();
    }
}