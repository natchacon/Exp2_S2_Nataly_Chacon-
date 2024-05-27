package cl.duoc.poo.tarea2.menu;

import cl.duoc.poo.tarea2.excepciones.SalirIngresoDatos;
import cl.duoc.poo.tarea2.menu.validacion.*;
import cl.duoc.poo.tarea2.model.Cliente;
import cl.duoc.poo.tarea2.model.CuentaAhorro;
import cl.duoc.poo.tarea2.model.CuentaCorriente;
import cl.duoc.poo.tarea2.model.CuentaCredito;
import cl.duoc.poo.tarea2.transacciones.cliente.TransaccionesClienteImpl;
import cl.duoc.poo.tarea2.transacciones.cliente.TransaccionesClienteInterface;

public class RegistrarCliente extends OpcionMenu {

    private static Validacion VALIDACION_RUT_EXISTE = ValidaRutExiste.getInstance();
    private static Validacion VALIDA_TEXTO_NO_VACIO = ValidarTextoNoVacio.getInstance();

    private static Validacion VALIDA_CUENTA_CORRIENTE = ValidarCuentaCorriente.getInstance();

    private static Validacion VALIDA_MONTO = ValidarNumeroEntero.getInstance();

    private static Validacion VALIDAR_BOLEANO = ValidarBoleano.getInstance();

    TransaccionesClienteInterface transaccionesCliente = TransaccionesClienteImpl.getInstance();

    public RegistrarCliente(Integer numeroMenu, String nombreMenu) {
        super(numeroMenu, nombreMenu);
    }

    @Override
    public void ejecutar() throws SalirIngresoDatos {
        String rut = solicitarDato("Ingrese Rut", "Rut incorrecto o ya existe, reingrese", VALIDACION_RUT_EXISTE);
        String nombre = solicitarDato("Ingrese Nombre", "Nombre no puede ser vacio", VALIDA_TEXTO_NO_VACIO);
        String apellidoPaterno = solicitarDato("Ingrese Apellido Paterno", "Apellido Paterno no puede ser vacio", VALIDA_TEXTO_NO_VACIO);
        String apellidoMaterno = solicitarDato("Ingrese Apellido Materno", "Apellido Materno no puede ser vacio", VALIDA_TEXTO_NO_VACIO);
        String direccion = solicitarDato("Ingrese Direccion", "Direccion no puede ser vacio", VALIDA_TEXTO_NO_VACIO);
        String comuna = solicitarDato("Ingrese Comuna", "Comuna no puede ser vacio", VALIDA_TEXTO_NO_VACIO);
        String telefono = solicitarDato("Ingrese Telefono", "Telefono no puede ser vacio", VALIDA_TEXTO_NO_VACIO);
        String numeroCuenta = solicitarDato("Ingrese numero de cuenta", "Debe ser númerico de largo 9 y no puede repetirse", VALIDA_CUENTA_CORRIENTE);
        String montoLineaCredito = solicitarDato("Ingrese el monto de la linea de credito asociada a la cuenta", "Numero inorrecto", VALIDA_MONTO);

        Cliente cliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, direccion, comuna, telefono, new CuentaCorriente(Integer.valueOf(numeroCuenta), Integer.valueOf(montoLineaCredito)));
        transaccionesCliente.registrarCliente(cliente);

        String deseaCuentaAhorro = solicitarDato("Desea agregar una cuenta de ahorro, ingreso si o no", "Debe ingresar si o no", VALIDAR_BOLEANO);
        if (deseaCuentaAhorro.equalsIgnoreCase("si")) {
            transaccionesCliente.contratarCuentaAhorro(cliente, new CuentaAhorro(Integer.valueOf(numeroCuenta)));
        }
        String deseaCuentaCredito = solicitarDato("Desea agregar una cuenta de credito, ingreso si o no", "Debe ingresar si o no", VALIDAR_BOLEANO);
        if (deseaCuentaCredito.equalsIgnoreCase("si")) {
            transaccionesCliente.contratarCuentaCredito(cliente, new CuentaCredito(Integer.valueOf(numeroCuenta)));
        }
        System.out.println("Cliente registrado existsamente!!!");
    }
}
