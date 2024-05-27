package cl.duoc.poo.tarea2.model;

import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;
import cl.duoc.poo.tarea2.util.ConversorMoneda;

public class CuentaAhorro extends CuentaBase {

    private Integer cantidadGiros;
    private static final Integer CANTIDAD_MAXIMA_GIROS = 5;

    public CuentaAhorro(Integer numeroCorriente) {
        //Cuenta de ahorro en UF
        super(numeroCorriente, Moneda.UF);
        this.cantidadGiros = 0;
    }

    public void deposito(Double monto) throws ErrorDeNegocio {
        Double montoMonedaCuenta = ConversorMoneda.getInstance().convertir(monto, getMonedaCuenta());
        super.deposito(montoMonedaCuenta);
    }

    public void giro(Double monto) throws ErrorDeNegocio {
        if (cantidadGiros > CANTIDAD_MAXIMA_GIROS) {
            throw new ErrorDeNegocio("No se puede efectuar mas de " + CANTIDAD_MAXIMA_GIROS + " giros");
        } else {
            Double montoMonedaCuenta = ConversorMoneda.getInstance().convertir(monto, getMonedaCuenta());
            super.giro(montoMonedaCuenta);
            this.cantidadGiros++;
        }
    }

    @Override
    public void imprimirDatosCuenta() {
        System.out.println("Saldo cuenta ahorro: " + getSaldo() + " UF");
        System.out.println("Giros realizados: " + cantidadGiros + " de un maximo de " + CANTIDAD_MAXIMA_GIROS + " giros permitidos");

    }

    public Integer getCantidadGiros() {
        return cantidadGiros;
    }

    public void setCantidadGiros(Integer cantidadGiros) {
        this.cantidadGiros = cantidadGiros;
    }
}
