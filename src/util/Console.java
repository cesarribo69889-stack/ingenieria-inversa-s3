package util;

public class Console {

    // Code smell intencional: métodos muy simples, luego se puede expandir a logger real
    public static void info(String msg) {
        System.out.println(msg);
    }

    public static void error(String msg) {
        System.out.println("ERROR: " + msg);
    }

    public static void warning(String msg) {
        System.out.println("WARNING: " + msg);
    }
}
