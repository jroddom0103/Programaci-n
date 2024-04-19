package UD7.proyecto_UbriCines.services.api;

import UD7.proyecto_UbriCines.model.Butaca;

public interface BasicServiceCine {

    public void mostrarButacas();
    public boolean comprarEntrada();
    public boolean devolverEntrada();

    public boolean checkComprador(String idUser);

    public void leerFicheroCine();
    public void anadirFicheroCine(Butaca b);
    public void modificarFicheroCine();
}
