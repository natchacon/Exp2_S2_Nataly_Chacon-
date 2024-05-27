package cl.duoc.poo.tarea2.menu;

import cl.duoc.poo.tarea2.excepciones.SalirIngresoDatos;
import cl.duoc.poo.tarea2.menu.validacion.ValidaRut;
import cl.duoc.poo.tarea2.menu.validacion.Validacion;
import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.transacciones.cliente.TransaccionesClienteImpl;
import cl.duoc.poo.tarea2.transacciones.cliente.TransaccionesClienteInterface;

public class ConsultarCliente extends OpcionMenu {

    private static Validacion VALIDACION_RUT = ValidaRut.getInstance();
    TransaccionesClienteInterface transaccionesCliente = TransaccionesClienteImpl.getInstance();

    public ConsultarCliente(Integer numeroMenu, String nombreMenu) {
        super(numeroMenu, nombreMenu);
    }

    @Override
    public void ejecutar() throws SalirIngresoDatos {
        String rut = solicitarDato("Ingrese el rut del cliente", "Rut incorrecto", VALIDACION_RUT);
        Cliente cliente = transaccionesCliente.buscarClientePorRut(rut);
        if (cliente != null) {
            transaccionesCliente.imprimirCliente(cliente);
        } else {
            System.out.println("Cliente no existe");
        }
    }

}
