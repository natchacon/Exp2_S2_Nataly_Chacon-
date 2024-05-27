package cl.duoc.poo.tarea2.menu;

import cl.duoc.poo.tarea2.excepciones.SalirIngresoDatos;

public class Salir extends OpcionMenu {

    public Salir(Integer numeroMenu, String nombreMenu) {
        super(numeroMenu, nombreMenu);
    }

    @Override
    public void ejecutar() throws SalirIngresoDatos {
        System.exit(1);
    }
}
