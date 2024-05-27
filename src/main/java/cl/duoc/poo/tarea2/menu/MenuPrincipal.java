package cl.duoc.poo.tarea2.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuPrincipal {

    private List<OpcionMenu> opcionesMenu;
    private Scanner scanner = new Scanner(System.in);

    public MenuPrincipal() {
        this.opcionesMenu = new ArrayList<>();
    }

    public void addOpcionMenu(OpcionMenu opcionMenu) {
        this.opcionesMenu.add(opcionMenu);
    }

    public void imprimirMenu() {
        System.out.println("\r");
        System.out.println("Opciones de menu:");
        opcionesMenu.forEach(opcion -> {
            System.out.println("[" + opcion.getNumeroMenu() + "] " + opcion.getNombreMenu());
        });
    }

    public OpcionMenu seleccinarOpcionMenu() {
        OpcionMenu opcionMenu = null;
        do {
            String opcionMenuIngresada = scanner.nextLine();
            if (opcionMenuEsEntero(opcionMenuIngresada)) {
                Optional<OpcionMenu> opcionMenuOptional = this.opcionesMenu.stream().filter(o -> o.getNumeroMenu().equals(Integer.valueOf(opcionMenuIngresada))).findFirst();
                if (opcionMenuOptional.isPresent()) {
                    opcionMenu = opcionMenuOptional.get();
                } else {
                    System.out.println("Opcion de menu no valida, favor reingrese");
                }
            }
        } while (opcionMenu == null);
        return opcionMenu;
    }

    private Boolean opcionMenuEsEntero(String opcionMenu) {
        try {
            Integer opcionMenuSeleccionada = Integer.valueOf(opcionMenu);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("opcion de menu inválida. Debe ingresar un numero entero entre 1 y 6. Reingrese");
            return Boolean.FALSE;
        }
    }


}
