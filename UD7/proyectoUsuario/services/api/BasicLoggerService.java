package UD7.proyectoUsuario.services.api;

//Interfaz BasicLoggerService
public interface BasicLoggerService {

    /**
     * Método logAlta.
     * Método que manda un mensaje con la id del usuario y el tiempo en el que se dio de alta en la cuenta al método anadirFicheroLogger.
     * @param idUser id del usuario.
     * @return true cuando se añade al log.
     */
    public boolean logAlta(String idUser);

    /**
     * Método logLogin.
     * Método que manda un mensaje con la id del usuario y el tiempo en el que inició sesión en la cuenta al método anadirFicheroLogger.
     * @param idUser id del usuario.
     * @return true cuando se añade al log.
     */
    public boolean logLogin(String idUser);

    /**
     * Método anadirFicheroLogger.
     * Método que pasa por parámetros el mensaje y la ruta del archivo de logs al método anadirFichero.
     * @param mensaje mensaje que se escribe en el log.
     */
    public void anadirFicheroLogger(String mensaje);

}
