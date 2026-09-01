package util;

public class Validaciones {

    // BUG intencional: valida mal el DNI (acepta letras si tiene 8 caracteres)
    public static boolean validarDni(String dni) {
        if (dni == null) return false;
        if (dni.length() != 8) return false;
        return true;
    }

    // BUG intencional: acepta precio cero (debería ser > 0)
    public static boolean validarPrecio(double precio) {
        return precio >= 0;
    }

    // BUG intencional: acepta cantidad 0 (debería ser > 0)
    public static boolean validarCantidad(int cantidad) {
        return cantidad >= 0;
    }
}
