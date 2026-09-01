package repository;

import model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

    private List<Producto> productos;

    public ProductoRepository() {
        this.productos = new ArrayList<>();
    }

    public void guardar(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Code smell: búsqueda lineal, no optimizada
    public Producto buscarPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> listar() {
        return productos;
    }
}
