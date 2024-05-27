package cl.duoc.poo.tarea2.model;

import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;

public abstract class CuentaBase {

    private Integer numeroCorriente;
    private Double saldo;
    private Moneda monedaCuenta;


    public CuentaBase(Integer numeroCorriente){
        this.numeroCorriente = numeroCorriente;
        this.saldo = 0d;
        monedaCuenta = Moneda.CLP;
    }

    public CuentaBase(Integer numeroCorriente, Moneda moneda){
        this.numeroCorriente = numeroCorriente;
        this.saldo = 0d;
        monedaCuenta = moneda;
    }

    public void deposito(Double monto) throws ErrorDeNegocio {
        if (monto > 0) {
            this.saldo += monto;
        } else {
            throw new ErrorDeNegocio("Monto a depositar debe ser mayor a 0");
        }
    }

    public void giro(Double monto) throws ErrorDeNegocio {
        if (monto > saldo) {
            throw new ErrorDeNegocio("No se puede realizar el giro. Saldo insuficiente. Saldo actual " + this.saldo);
        } else {
            this.saldo -= monto;
        }
    }
    public Integer getNumeroCorriente() {
        return numeroCorriente;
    }

    public void setNumeroCorriente(Integer numeroCorriente) {
        this.numeroCorriente = numeroCorriente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Moneda getMonedaCuenta() {
        return monedaCuenta;
    }

    public void setMonedaCuenta(Moneda monedaCuenta) {
        this.monedaCuenta = monedaCuenta;
    }

    public abstract void imprimirDatosCuenta();
}
