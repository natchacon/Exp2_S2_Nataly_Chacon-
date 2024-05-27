package cl.duoc.poo.tarea2.menu.validacion;

public class ValidarNumeroEntero implements Validacion {

    private static ValidarNumeroEntero singleton = null;

    private ValidarNumeroEntero(){

    }

    public static ValidarNumeroEntero getInstance(){
        if(singleton==null){
            singleton = new ValidarNumeroEntero();
        }
        return singleton;
    }

    @Override
    public Boolean validar(String dato) {
        try {
            Integer.valueOf(dato);
            return Boolean.TRUE;
        }
        catch (Exception e){
            return Boolean.FALSE;
        }
    }
}
