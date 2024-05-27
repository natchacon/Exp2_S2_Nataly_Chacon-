package cl.duoc.poo.tarea2.menu;

import cl.duoc.poo.tarea2.excepciones.ErrorDeNegocio;
import cl.duoc.poo.tarea2.excepciones.SalirIngresoDatos;
import cl.duoc.poo.tarea2.menu.validacion.ValidaRut;
import cl.duoc.poo.tarea2.menu.validacion.Validacion;
import cl.duoc.poo.tarea2.menu.validacion.ValidarNumeroEntero;
import cl.duoc.poo.tarea2.menu.validacion.ValidarTipoCuenta;
import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.model.CuentaBase;
import cl.duoc.poo.tarea2.transacciones.bancarias.TransaccionBancariaImpl;
import cl.duoc.poo.tarea2.transacciones.bancarias.TransaccionBancariaInterface;
import cl.duoc.poo.tarea2.transacciones.cliente.TransaccionesClienteImpl;
import cl.duoc.poo.tarea2.transacciones.cliente.TransaccionesClienteInterface;

public class Girar extends OpcionMenu {

    private static Validacion VALIDACION_RUT = ValidaRut.getInstance();
    private static Validacion VALIDACION_ENTER0 = ValidarNumeroEntero.getInstance();

    private TransaccionBancariaInterface transaccionBancaria = TransaccionBancariaImpl.getInstance();

    private TransaccionesClienteInterface transaccionesCliente = TransaccionesClienteImpl.getInstance();

    public Girar(Integer numeroMenu, String nombreMenu) {
        super(numeroMenu, nombreMenu);
    }

    @Override
    public void ejecutar() throws SalirIngresoDatos {
        String rut = solicitarDato("Ingrese el rut del cliente", "Rut incorrecto", VALIDACION_RUT);
        Cliente cliente = transaccionesCliente.buscarClientePorRut(rut);
        if (cliente != null) {
            CuentaBase cuentaDelgiro = null;
            String tipoCuenta = solicitarDato("Ingrese el tipo de cuenta en la cual desea girar (corriente, ahorro, credito)", "Debe escribir corriente, ahorro, credito", new ValidarTipoCuenta(cliente));
            if (tipoCuenta.equalsIgnoreCase("corriente")) {
                cuentaDelgiro = cliente.getCuentaCorriente();
            } else if (tipoCuenta.equalsIgnoreCase("ahorro")) {
                cuentaDelgiro = cliente.getCuentaAhorro();
            } else if (tipoCuenta.equalsIgnoreCase("credito")) {
                cuentaDelgiro = cliente.getCuentaCredito();
            }
            String monto = solicitarDato("Ingrese monto a girar de la cuenta " + cliente.getCuentaCorriente().getNumeroCorriente() + " del cliente " + cliente.getNombre() + " " + cliente.getApellidoPaterno(), "Monto debe ser entero", VALIDACION_ENTER0);
            try {
                transaccionBancaria.girarDinero(cliente, cuentaDelgiro, Double.valueOf(monto));
                System.out.println("Giro realizado con exito!!!");
            } catch (ErrorDeNegocio e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Cliente no existe");
        }
    }
}
