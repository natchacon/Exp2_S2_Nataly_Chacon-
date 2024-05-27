package cl.duoc.poo.tarea2.menu.validacion;

import cl.duoc.poo.tarea2.model.Cliente;

public class ValidarTipoCuenta implements Validacion {

    private Cliente cliente = null;
    public ValidarTipoCuenta(Cliente cliente) {
        this.cliente = cliente;
    }



    @Override
    public Boolean validar(String dato) {
        Boolean datoCorrecto = dato!=null && (dato.equalsIgnoreCase("corriente") || dato.equalsIgnoreCase("ahorro") || dato.equalsIgnoreCase("credito"));
        if(datoCorrecto){
            if(dato.equalsIgnoreCase("corriente")){
                return cliente.getCuentaCorriente()!=null;
            }
            else if(dato.equalsIgnoreCase("credito")){
                if(cliente.getCuentaCredito()==null){
                    System.out.println("Cliente No tiene cuenta de credito");
                    return Boolean.FALSE;
                }
            }
            else if(dato.equalsIgnoreCase("ahorro")){
                if(cliente.getCuentaAhorro()==null){
                    System.out.println("Cliente No tiene cuenta de ahorro");
                    return Boolean.FALSE;
                }
            }
        }
        return datoCorrecto;
    }
}
