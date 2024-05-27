package cl.duoc.poo.tarea2.transacciones.cliente;

import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.model.CuentaAhorro;
import cl.duoc.poo.tarea2.model.CuentaCredito;

public interface TransaccionesClienteInterface {

    public Cliente buscarClientePorRut(String rut);
    public void imprimirCliente(Cliente cliente);
    public void registrarCliente(Cliente cliente);
    public void contratarCuentaCredito(Cliente cliente, CuentaCredito cuentaCredito);
    public void contratarCuentaAhorro(Cliente cliente, CuentaAhorro cuentaAhorro);
}
