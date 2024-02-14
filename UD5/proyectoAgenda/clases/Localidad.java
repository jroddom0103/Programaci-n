package UD5.proyectoAgenda.clases;

import UD5.proyectoAgenda.utils.AgendaUtils;

import java.sql.SQLOutput;

public class Localidad {

    private String municipio;
    private String provincia;
    private String cp;
    private Direccion direccion;
    public Localidad(String cp, String municipio, String provincia){

        this.cp=cp;
        this.municipio=municipio;
        this.provincia=provincia;

    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        if (AgendaUtils.checkCP(cp)){
            this.cp = cp;
        }

    }

    public void presentacion(){
        System.out.printf("%s (%s) %s", this.municipio, this.provincia, this.cp);
    }
}
