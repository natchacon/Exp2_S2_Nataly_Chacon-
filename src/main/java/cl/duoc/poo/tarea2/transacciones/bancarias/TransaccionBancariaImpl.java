package cl.duoc.poo.tarea2.transacciones.bancarias;

import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;
import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.model.CuentaBase;
import cl.duoc.poo.tarea2.model.TipoOperacion;
import cl.duoc.poo.tarea2.model.Transaccion;

public class TransaccionBancariaImpl implements TransaccionBancariaInterface {

    private static TransaccionBancariaImpl singleton = null;

    private TransaccionBancariaImpl() {
    }

    public static TransaccionBancariaImpl getInstance() {
        if (singleton == null) {
            singleton = new TransaccionBancariaImpl();
        }
        return singleton;
    }

    private void registrarTransaccion(Cliente cliente, CuentaBase cuenta, TipoOperacion tipoOperacion, Double montoTransaccion){
        cliente.getTransaccionesCliente().add(new Transaccion(cuenta.getNumeroCorriente(), tipoOperacion, montoTransaccion));
    }


    @Override
    public void consultarSaldosCuenta(Cliente cliente) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                        Cliente");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Rut: " + cliente.getRut());
        System.out.println("Cuenta Número: " + cliente.getCuentaCorriente().getNumeroCorriente());
        System.out.println("---------------------------------------------------------------");
        System.out.println("                        Cuenta Corriente");
        System.out.println("---------------------------------------------------------------");
        cliente.getCuentaCorriente().imprimirDatosCuenta();
        if (cliente.getCuentaAhorro() != null) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("                        Cuenta Ahorro");
            System.out.println("---------------------------------------------------------------");
            cliente.getCuentaAhorro().imprimirDatosCuenta();
        }
        if (cliente.getCuentaCredito() != null) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("                        Cuenta Crédito");
            System.out.println("---------------------------------------------------------------");
            cliente.getCuentaCredito().imprimirDatosCuenta();
        }
    }

    @Override
    public void girarDinero(Cliente cliente, CuentaBase cuenta, Double monto) throws ErrorDeNegocio {
        cuenta.giro(monto);
        registrarTransaccion(cliente, cuenta, TipoOperacion.GIRO, monto);
    }

    @Override
    public void depositarDinero(Cliente cliente, CuentaBase cuenta, Double monto) throws ErrorDeNegocio {
        cuenta.deposito(monto);
        registrarTransaccion(cliente, cuenta, TipoOperacion.DEPOSITO, monto);
    }
}
