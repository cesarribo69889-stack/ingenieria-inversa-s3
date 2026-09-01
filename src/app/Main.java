package app;

import repository.ClienteRepository;
import repository.ProductoRepository;
import repository.VentaRepository;
import service.ClienteService;
import service.ProductoService;
import service.ReporteService;
import service.VentaService;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        ProductoRepository productoRepository = new ProductoRepository();
        VentaRepository ventaRepository = new VentaRepository();

        ClienteService clienteService = new ClienteService(clienteRepository);
        ProductoService productoService = new ProductoService(productoRepository);
        VentaService ventaService = new VentaService(clienteService, productoService, ventaRepository);
        ReporteService reporteService = new ReporteService(ventaRepository);

        System.out.println("=== SISTEMA DE VENTAS - BASELINE v0.1.0 (16 SEMANAS) ===");

        // Datos iniciales
        clienteService.registrarCliente("12345678", "Juan Perez", "VIP");
        clienteService.registrarCliente("87654321", "Maria Lopez", "NORMAL");
        clienteService.registrarCliente("ABCD5678", "Cliente Bug", "NORMAL"); // DNI inválido pero pasa por bug

        productoService.registrarProducto(1, "Laptop", 2500);
        productoService.registrarProducto(2, "Mouse", 50);
        productoService.registrarProducto(3, "Teclado", 120);
        productoService.registrarProducto(4, "Monitor", 900);
        productoService.registrarProducto(5, "Producto Bug", -100); // precio negativo permitido por bug

        // Venta 1
        ventaService.crearVenta("12345678");
        ventaService.agregarProductoVenta(1, 1);
        ventaService.agregarProductoVenta(2, 2);
        ventaService.finalizarVenta();

        // Venta 2 (bug: cantidad 0 permitida)
        ventaService.crearVenta("87654321");
        ventaService.agregarProductoVenta(3, 0);
        ventaService.agregarProductoVenta(4, 1);
        ventaService.finalizarVenta();

        // Reporte
        reporteService.mostrarReporteVentas();
        reporteService.mostrarResumen();

        System.out.println("=== FIN ===");
    }
}
