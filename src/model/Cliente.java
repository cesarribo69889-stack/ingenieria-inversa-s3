package model;

public class Cliente {

    private String dni;
    private String nombre;
    private String tipo; // NORMAL, VIP, EMPRESA, ESTUDIANTE (para OCP)

    public Cliente(String dni, String nombre, String tipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
