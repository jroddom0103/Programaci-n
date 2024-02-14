package UD5.LoginSession.Clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Session {

    private String nSession;
    private LocalDateTime lastLogin;
    private LocalDateTime sessionExpires;
    private User usuario;

    private Session(String nSession, LocalDateTime lastLogin, LocalDateTime sessionExpires, User usuario){
        this.nSession=nSession;
        this.lastLogin=lastLogin;
        this.sessionExpires = sessionExpires;
        this.usuario = usuario;
    }

    public String getnSession() {
        return nSession;
    }

    public void setnSession(String nSession) {
        this.nSession = nSession;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getSessionExpires() {
        return sessionExpires;
    }

    public void setSessionExpires(LocalDateTime sessionExpires) {
        this.sessionExpires = sessionExpires;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
