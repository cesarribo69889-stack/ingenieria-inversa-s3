package model;

public class VentaDetalle {

    private Producto producto;
    private int cantidad;

    public VentaDetalle(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubtotal() {
        // BUG intencional: si cantidad negativa, subtotal negativo (no valida)
        return producto.getPrecio() * cantidad;
    }
}
