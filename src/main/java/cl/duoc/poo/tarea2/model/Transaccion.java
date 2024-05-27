package cl.duoc.poo.tarea2.model;

import java.util.GregorianCalendar;
import java.util.UUID;

public class Transaccion {

    private Integer numeroCuenta;
    private String codigoTransaccion;
    private TipoOperacion tipoOperacion;
    private Double montoTransaccion;
    private GregorianCalendar fecha;

    public Transaccion(Integer numeroCuenta, TipoOperacion tipoOperacion, Double montoTransaccion) {
        this.numeroCuenta = numeroCuenta;
        this.codigoTransaccion = UUID.randomUUID().toString();
        this.tipoOperacion = tipoOperacion;
        this.montoTransaccion = montoTransaccion;
        this.fecha = new GregorianCalendar();
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(Double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
