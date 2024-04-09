package UD7.proyectoUsuario.services.impl;

import UD7.proyectoUsuario.services.api.BasicLoggerService;

import java.time.LocalDateTime;

public class LoggerService implements BasicLoggerService {

    private GestionFicheroLogger gestion;

    public LoggerService(){
        this.gestion = new GestionFicheroLogger();
    }

    public LoggerService(GestionFicheroLogger gestion){
       this.gestion = gestion;
    }

    @Override
    public boolean logAlta(String idUser) {

        String mensaje = (idUser+";"+LocalDateTime.now()+";Darse de alta");
        anadirFicheroLogger(mensaje);
        return true;
    }

    @Override
    public boolean logLogin(String idUser) {

        String mensaje = (idUser+";"+LocalDateTime.now()+";Iniciar sesión");
        anadirFicheroLogger(mensaje);
        return true;
    }

    @Override
    public void anadirFicheroLogger(String mensaje) {

        this.gestion.anadirFichero(mensaje,"resources/archivosTema7/logs/logs.txt");
    }
}
