package UD7.proyectoUsuario.model;

public class Butaca {

    private int fila;
    private int asiento;
    private String idUser;

    public Butaca(int fila, int asiento, String idUser) {
        this.fila = fila;
        this.asiento = asiento;
        this.idUser = idUser;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return fila + ":" + asiento + ":" + idUser;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Butaca) {
            Butaca b = (Butaca) o;
            return b.getFila() == this.fila && b.getAsiento() == this.asiento;
        } else {
            return false;
        }
    }
}