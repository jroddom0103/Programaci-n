package model.classes;

import java.util.Objects;

public class User {

    private String id;
    private String correo;
    private String pass;
    private boolean isAdmin;


    public User(String id, String correo, String pass, boolean isAdmin){
        this.id = id;
        this.correo = correo;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo(){return correo;}

    public void setUser(String correo){this.correo = correo;}

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean getisAdmin(){
        return isAdmin;
    }

    public void setisAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "El user tiene el correo "+this.correo+" con id: "+this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correo, pass, isAdmin);
    }

}