package UD6.proyectoBanco.Clases.impl;

import UD6.proyectoBanco.Clases.api.Cuenta;

public class CuentaAhorro implements Cuenta{

    public final double saldoMinimo = 2000;

    @Override
    public boolean ingresar(double cantidadIngresar) {
        return false;
    }

    @Override
    public boolean retirar(double cantidadRetirar) {
        return false;
    }

    @Override
    public boolean transferir(Cuenta otraCuenta, double cantidadTraspaso) {
        return false;
    }

    @Override
    public void calcularIntereses() {


    }
}
