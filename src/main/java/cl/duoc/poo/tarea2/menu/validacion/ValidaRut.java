package cl.duoc.poo.tarea2.menu.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaRut implements Validacion {

    private static ValidaRut singleton = null;

    private ValidaRut() {

    }

    public static ValidaRut getInstance() {
        if (singleton == null) {
            singleton = new ValidaRut();
        }
        return singleton;
    }

    private Boolean validaRut(String rut) {
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if (matcher.matches() == false) return false;
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
    }

    private String dv(String rut) {
        Integer M = 0, S = 1, T = Integer.parseInt(rut);
        for (; T != 0; T = (int) Math.floor(T /= 10))
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        return (S > 0) ? String.valueOf(S - 1) : "k";
    }

    @Override
    public Boolean validar(String dato) {
        if (dato != null && !dato.equals("")) {
            return validaRut(dato);
        }
        return Boolean.FALSE;
    }

}
