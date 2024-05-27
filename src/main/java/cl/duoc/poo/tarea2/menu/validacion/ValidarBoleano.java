package cl.duoc.poo.tarea2.menu.validacion;

public class ValidarBoleano implements Validacion {

    private static ValidarBoleano singleton = null;

    private ValidarBoleano() {

    }

    public static ValidarBoleano getInstance() {
        if (singleton == null) {
            singleton = new ValidarBoleano();
        }
        return singleton;
    }

    @Override
    public Boolean validar(String dato) {
        return dato!=null && (dato.equalsIgnoreCase("si") || dato.equalsIgnoreCase("no"));
    }
}
