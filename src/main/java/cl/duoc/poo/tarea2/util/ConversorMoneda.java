package cl.duoc.poo.tarea2.util;

import cl.duoc.poo.tarea2.model.Moneda;

public class ConversorMoneda {

    private Integer valorUF = 37300;

    private static ConversorMoneda singleton = null;

    private ConversorMoneda(){

    }

    public static ConversorMoneda getInstance(){
        if(singleton == null){
            singleton = new ConversorMoneda();
        }
        return singleton;
    }

    public Double convertir(Double monto, Moneda moneda){
        Double montoConvertido = null;
        switch (moneda) {
            case UF -> montoConvertido = Double.valueOf(monto / valorUF);
            default -> montoConvertido = Double.valueOf(monto);
        }
        return montoConvertido;
    }
}
