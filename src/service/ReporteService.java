package service;

import model.Venta;
import model.VentaDetalle;
import repository.VentaRepository;
import util.Console;

import java.util.List;

public class ReporteService {

    private VentaRepository ventaRepo;

    public ReporteService(VentaRepository ventaRepo) {
        this.ventaRepo = ventaRepo;
    }

    // Code smell: método largo
    public void mostrarReporteVentas() {

        List<Venta> ventas = ventaRepo.listar();

        Console.info("=== REPORTE DE VENTAS ===");

        int i = 1;
        for (Venta v : ventas) {
            Console.info("Venta #" + i + " Cliente: " + v.getCliente().getNombre());

            for (VentaDetalle d : v.getDetalles()) {
                Console.info("- " + d.getProducto().getNombre()
                        + " x " + d.getCantidad()
                        + " = " + d.calcularSubtotal());
            }

            Console.info("TOTAL: " + v.calcularTotal());
            Console.info("-----------------------------");
            i++;
        }
    }

    // BUG intencional: si no hay ventas, no informa nada
    public void mostrarResumen() {
        int totalVentas = ventaRepo.contarVentas();
        Console.info("TOTAL VENTAS: " + totalVentas);
    }
}
