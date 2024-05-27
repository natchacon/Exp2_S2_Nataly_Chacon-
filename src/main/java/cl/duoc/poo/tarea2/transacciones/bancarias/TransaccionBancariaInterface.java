package cl.duoc.poo.tarea2.transacciones.bancarias;

import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;
import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.model.CuentaBase;

public interface TransaccionBancariaInterface {

    public void consultarSaldosCuenta(Cliente cliente);

    public void girarDinero(Cliente cliente, CuentaBase cuenta, Double monto) throws ErrorDeNegocio;

    public void depositarDinero(Cliente cliente, CuentaBase cuenta, Double monto) throws ErrorDeNegocio;

}
