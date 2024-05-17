package model.classes;

import java.util.Objects;

public class User {

    private String id;
    private String user;
    private String pass;
    private boolean isAdmin;


    public User(String id, String user, String pass){
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser(){return user;}

    public void setUser(String user){this.user = user;}

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "El user se llama "+this.user+" con id: "+this.id;
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
        return Objects.hash(id, user, pass);
    }

}