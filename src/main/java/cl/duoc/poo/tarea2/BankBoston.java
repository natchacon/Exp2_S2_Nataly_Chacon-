package cl.duoc.poo.tarea2;

import cl.duoc.poo.tarea2.menu.*;
import cl.duoc.poo.tarea2.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class BankBoston {

    private static BankBoston singleton = null;
    private MenuPrincipal menuPrincipal;
    private List<Cliente> clientes;

    private BankBoston() {
        menuPrincipal = new MenuPrincipal();
        menuPrincipal.addOpcionMenu(new RegistrarCliente(1, "Registrar Cliente"));
        menuPrincipal.addOpcionMenu(new ConsultarCliente(2, "Consultar Cliente"));
        menuPrincipal.addOpcionMenu(new Depositar(3, "Depositar"));
        menuPrincipal.addOpcionMenu(new Girar(4, "Girar"));
        menuPrincipal.addOpcionMenu(new ConsultarSaldo(5, "Consulta Saldo"));
        menuPrincipal.addOpcionMenu(new Salir(6, "Salir"));
        clientes = new ArrayList<>();
    }

    public static BankBoston getInstance() {
        if (singleton == null) {
            singleton = new BankBoston();
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("...::: Bienvenido a BankBoston :::...");
        do {

            BankBoston bankBoston = BankBoston.getInstance();
            bankBoston.menuPrincipal.imprimirMenu();
            OpcionMenu opcionMenu = bankBoston.menuPrincipal.seleccinarOpcionMenu();
            opcionMenu.ejecutarOpcionMenu();
        } while (true);

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}
