package model;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private Cliente cliente;
    private List<VentaDetalle> detalles;
    private boolean finalizada;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.finalizada = false;
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        detalles.add(new VentaDetalle(producto, cantidad));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<VentaDetalle> getDetalles() {
        return detalles;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void finalizar() {
        this.finalizada = true;
    }

    public double calcularTotal() {
        double total = 0;
        for (VentaDetalle d : detalles) {
            total += d.calcularSubtotal();
        }
        return total;
    }
}
