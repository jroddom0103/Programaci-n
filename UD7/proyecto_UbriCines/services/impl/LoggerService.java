package UD7.proyecto_UbriCines.services.impl;

//Bibliotecas
import UD7.proyecto_UbriCines.services.api.BasicLoggerService;
import java.time.LocalDateTime;

//Clase LoggerService, que implementa la interfaz BasicLoggerService
public class LoggerService implements BasicLoggerService {

    //Declaración de objeto de tipo GestionFicheroLogger
    private GestionFicheroLogger gestion;

    //Método constructor que no recibe nada por parámetros
    public LoggerService(){
        this.gestion = new GestionFicheroLogger();
    }

    //Método constructor que recibe objeto de tipo GestionFicheroLogger
    public LoggerService(GestionFicheroLogger gestion){
       this.gestion = gestion;
    }

    /**
     * Método logAlta.
     * Método que manda un mensaje con la id del usuario y el tiempo en el que se dio de alta en la cuenta al método anadirFicheroLogger.
     * @param idUser id del usuario.
     * @return true cuando se añade al log.
     */
    @Override
    public boolean logAlta(String idUser) {

        String mensaje = (idUser+";"+LocalDateTime.now()+";Darse de alta");
        anadirFicheroLogger(mensaje);
        return true;
    }

    /**
     * Método logLogin.
     * Método que manda un mensaje con la id del usuario y el tiempo en el que inició sesión en la cuenta al método anadirFicheroLogger.
     * @param idUser id del usuario.
     * @return true cuando se añade al log.
     */
    @Override
    public boolean logLogin(String idUser) {

        String mensaje = (idUser+";"+LocalDateTime.now()+";Iniciar sesión");
        anadirFicheroLogger(mensaje);
        return true;
    }

    /**
     * Método anadirFicheroLogger.
     * Método que pasa por parámetros el mensaje y la ruta del archivo de logs al método anadirFichero.
     * @param mensaje mensaje que se escribe en el log.
     */
    @Override
    public void anadirFicheroLogger(String mensaje) {

        this.gestion.anadirFichero(mensaje,"C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\UD7\\proyecto_UbriCines\\resources\\logs.txt");
    }
}
