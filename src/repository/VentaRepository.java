package repository;

import model.Venta;
import java.util.ArrayList;
import java.util.List;

public class VentaRepository {

    private List<Venta> ventas;

    public VentaRepository() {
        this.ventas = new ArrayList<>();
    }

    public void guardar(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> listar() {
        return ventas;
    }

    public int contarVentas() {
        return ventas.size();
    }
}
