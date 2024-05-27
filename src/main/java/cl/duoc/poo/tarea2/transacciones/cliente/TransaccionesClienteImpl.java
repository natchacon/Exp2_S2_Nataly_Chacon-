package cl.duoc.poo.tarea2.transacciones.cliente;

import cl.duoc.poo.tarea2.BankBoston;
import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.model.CuentaAhorro;
import cl.duoc.poo.tarea2.model.CuentaCredito;

import java.util.Optional;

public class TransaccionesClienteImpl implements TransaccionesClienteInterface {

    private static TransaccionesClienteImpl singleton = null;

    private TransaccionesClienteImpl() {

    }

    public static TransaccionesClienteImpl getInstance() {
        if (singleton == null) {
            singleton = new TransaccionesClienteImpl();
        }
        return singleton;
    }

    @Override
    public Cliente buscarClientePorRut(String rut) {
        Optional<Cliente> clienteOptional = BankBoston.getInstance().getClientes().stream().filter(c -> c.getRut().equals(rut)).findFirst();
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void imprimirCliente(Cliente cliente) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                        Cliente");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Rut: " + cliente.getRut());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido Paterno: " + cliente.getApellidoPaterno());
        System.out.println("Apellido Materno: " + cliente.getApellidoMaterno());
        System.out.println("Direccion: " + cliente.getDireccion());
        System.out.println("Comuna: " + cliente.getComuna());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Cuenta Corriente: " + cliente.getCuentaCorriente().getNumeroCorriente());
        if (cliente.getCuentaAhorro() != null) {
            System.out.println("Tiene Cuenta Ahorro: " + cliente.getCuentaAhorro() != null ? "Si" : "No");
        }
        if (cliente.getCuentaCredito() != null) {
            System.out.println("Tiene Cuenta Crédito: " + cliente.getCuentaCredito() != null ? "Si" : "No");
        }
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        BankBoston.getInstance().getClientes().add(cliente);
    }

    @Override
    public void contratarCuentaCredito(Cliente cliente, CuentaCredito cuentaCredito) {
        cliente.setCuentaCredito(cuentaCredito);
    }

    @Override
    public void contratarCuentaAhorro(Cliente cliente, CuentaAhorro cuentaAhorro) {
        cliente.setCuentaAhorro(cuentaAhorro);
    }
}
