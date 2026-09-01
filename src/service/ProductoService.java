package service;

import model.Producto;
import repository.ProductoRepository;
import util.Console;
import util.Validaciones;

public class ProductoService {

    private ProductoRepository productoRepo;

    public ProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    // BUG intencional: Validaciones.validarPrecio acepta 0 y negativos
    public void registrarProducto(int id, String nombre, double precio) {

        if (!Validaciones.validarPrecio(precio)) {
            Console.error("Precio inválido");
            return;
        }

        Producto producto = new Producto(id, nombre, precio);
        productoRepo.guardar(producto);

        Console.info("Producto registrado: " + nombre);
    }

    public Producto buscarProducto(int id) {
        return productoRepo.buscarPorId(id);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        return productoRepo.buscarPorNombre(nombre);
    }
}
