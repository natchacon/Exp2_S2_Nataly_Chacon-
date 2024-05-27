package cl.duoc.poo.tarea2.menu.validacion;

public class ValidarTextoNoVacio implements Validacion {

    private static ValidarTextoNoVacio singleton = null;

    private ValidarTextoNoVacio(){

    }

    public static ValidarTextoNoVacio getInstance(){
        if(singleton==null){
            singleton = new ValidarTextoNoVacio();
        }
        return singleton;
    }

    @Override
    public Boolean validar(String dato) {
        return (dato!=null && !dato.equals(""));
    }
}
