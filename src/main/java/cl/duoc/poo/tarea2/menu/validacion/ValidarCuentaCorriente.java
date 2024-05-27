package cl.duoc.poo.tarea2.menu.validacion;

import cl.duoc.poo.tarea2.BankBoston;

public class ValidarCuentaCorriente implements Validacion {

    private static ValidarCuentaCorriente singleton = null;

    private ValidarCuentaCorriente(){

    }

    public static ValidarCuentaCorriente getInstance(){
        if(singleton==null){
            singleton = new ValidarCuentaCorriente();
        }
        return singleton;
    }

    @Override
    public Boolean validar(String dato) {
        try {
            Integer numeroCuente = Integer.valueOf(dato);
            if (numeroCuente >= 1000000000) {
                return false;
            }
            return !BankBoston.getInstance().getClientes().stream().filter(c->c.getCuentaCorriente().getNumeroCorriente().equals(numeroCuente)).findFirst().isPresent();
        } catch (Exception e) {
            return false;
        }
    }
}
