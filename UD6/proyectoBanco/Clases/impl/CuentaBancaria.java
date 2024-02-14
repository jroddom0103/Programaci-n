package UD6.proyectoBanco.Clases.impl;

import UD6.proyectoBanco.Clases.api.Cuenta;

public abstract class CuentaBancaria implements Cuenta {

    protected String iban;
    protected double saldo;
    protected double interesAnualBasico = 0.02;

    private void añadir(){

    }
    public abstract void calcularIntereses();

    public boolean ingresar(double cantidadAIngresar){
        return false;
    }

    public boolean retirar(double cantARetirar){
        return false;
    }

    public boolean transferir(Cuenta otraCuenta, double cantidadTraspaso){
        return false;
    }

}