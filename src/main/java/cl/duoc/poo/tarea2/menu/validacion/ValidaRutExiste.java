package cl.duoc.poo.tarea2.menu.validacion;

import cl.duoc.poo.tarea2.BankBoston;

public class ValidaRutExiste implements Validacion {

    private static ValidaRutExiste singleton = null;

    private ValidaRutExiste(){

    }

    public static ValidaRutExiste getInstance(){
        if(singleton==null){
            singleton = new ValidaRutExiste();
        }
        return singleton;
    }


    private Boolean rutExiste(String rut) {
        return BankBoston.getInstance().getClientes().stream().filter(c -> c.getRut().equals(rut)).findFirst().isPresent();
    }

    @Override
    public Boolean validar(String dato) {
        if (dato != null && !dato.equals("")) {
            Boolean rutCorrecto = ValidaRut.getInstance().validar(dato);
            if (rutCorrecto) {
                return !rutExiste(dato);
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

}
