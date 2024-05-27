package cl.duoc.poo.tarea2.model;

import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;

public class CuentaCredito extends CuentaBase {

    private static final Double INTERES_POR_GIRO = 0.01;
    private Double intereses = 0d;

    public CuentaCredito(Integer numeroCorriente) {
        super(numeroCorriente);
    }

    public void giro(Double monto) throws ErrorDeNegocio {
        this.intereses = monto * INTERES_POR_GIRO;
        super.giro(monto);
    }

    @Override
    public void imprimirDatosCuenta() {
        System.out.println("Saldo cuenta credito: " + getSaldo());
        System.out.println("Intereses: " + intereses);
    }

    public Double getIntereses() {
        return intereses;
    }

}
