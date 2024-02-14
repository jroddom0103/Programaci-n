package UD6.proyectoBanco.Clases.impl;

import UD6.proyectoBanco.Clases.api.Cuenta;
import UD6.proyectoBanco.Clases.impl.CuentaBancaria;

public class CuentaCorriente extends CuentaBancaria {

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
