package cl.duoc.poo.tarea2.menu;

import cl.duoc.poo.tarea2.excepciones.SalirIngresoDatos;
import cl.duoc.poo.tarea2.menu.validacion.Validacion;

import java.util.Scanner;

public abstract class OpcionMenu {

    protected Scanner scanner = new Scanner(System.in);
    private Integer numeroMenu;
    private String nombreMenu;

    public OpcionMenu(Integer numeroMenu, String nombreMenu) {
        this.numeroMenu = numeroMenu;
        this.nombreMenu = nombreMenu;
    }

    public Integer getNumeroMenu() {
        return numeroMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    protected String solicitarDato(String textoSolicitud, String textoError, Validacion validacion) throws SalirIngresoDatos {
        Boolean ingresoCorrecto = null;
        String dato = null;
        do {
            System.out.println(textoSolicitud + " (ingrese 'S' para salir y volver al menú principal)");
            dato = scanner.nextLine();
            if (dato.equalsIgnoreCase("s")) {
                throw new SalirIngresoDatos();
            }
            ingresoCorrecto = validacion.validar(dato);
            if (!ingresoCorrecto) {
                System.out.println(textoError);
            }
        } while (!ingresoCorrecto);
        return dato;
    }

    public void ejecutarOpcionMenu() {
        try {
            ejecutar();
        } catch (SalirIngresoDatos e) {
            //continuar y volver al menu principal
        }
    }

    protected abstract void ejecutar() throws SalirIngresoDatos;


}
