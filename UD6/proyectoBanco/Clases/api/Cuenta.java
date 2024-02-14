package UD6.proyectoBanco.Clases.api;

public interface Cuenta {

    public boolean ingresar(double cantidadIngresar);
    public boolean retirar(double cantidadRetirar);
    public boolean transferir(Cuenta otraCuenta, double cantidadTraspaso);
    public void calcularIntereses();

}
