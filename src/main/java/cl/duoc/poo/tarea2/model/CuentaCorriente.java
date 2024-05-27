package cl.duoc.poo.tarea2.model;


import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;

public class CuentaCorriente extends CuentaBase {

    private LineaCredito lineaCredito;

    public CuentaCorriente(Integer numeroCtaCorriente, Integer montoLineaCredito) {
        super(numeroCtaCorriente);
        this.lineaCredito = new LineaCredito(numeroCtaCorriente, montoLineaCredito);

    }

    public void giro(Double monto) throws ErrorDeNegocio {
        if (monto > getSaldo() + lineaCredito.getSaldo()) {
            throw new ErrorDeNegocio("No se puede realizar el giro. Saldo insuficiente. Saldo actual: " + getSaldo() + " Saldo linea credito: " + lineaCredito.getSaldo());
        } else if (monto > getSaldo()) {
            lineaCredito.setSaldo(lineaCredito.getSaldo() - (monto - getSaldo()));
            setSaldo(0d);
        } else {
            super.giro(monto);
        }
    }

    @Override
    public void imprimirDatosCuenta() {
        System.out.println("Saldo cuenta corriente: " + getSaldo());
        lineaCredito.imprimirDatosCuenta();
    }

    public LineaCredito getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(LineaCredito lineaCredito) {
        this.lineaCredito = lineaCredito;
    }
}
