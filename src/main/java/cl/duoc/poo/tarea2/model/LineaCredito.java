package cl.duoc.poo.tarea2.model;

public class LineaCredito extends CuentaBase {
    public LineaCredito(Integer numeroCorriente, Integer montoLineaCredito) {
        super(numeroCorriente);
        setSaldo(Double.valueOf(montoLineaCredito));
    }

    @Override
    public void imprimirDatosCuenta() {
        System.out.println("Linea de crédito disponible " + getSaldo());
    }
}
