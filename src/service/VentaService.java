package service;

import model.Cliente;
import model.Producto;
import model.Venta;
import repository.VentaRepository;
import util.Console;
import util.Validaciones;

public class VentaService {

    private static final String MSG_SIN_VENTA_ACTIVA = "No hay venta activa";
    private static final String MSG_CLIENTE_NO_EXISTE = "Cliente no existe";
    private static final String MSG_PRODUCTO_NO_ENCONTRADO = "Producto no encontrado";
    private static final String MSG_CANTIDAD_INVALIDA = "Cantidad inválida";

    private ClienteService clienteService;
    private ProductoService productoService;
    private VentaRepository ventaRepo;

    private Venta ventaActual;

    public VentaService(ClienteService clienteService, ProductoService productoService, VentaRepository ventaRepo) {
        this.clienteService = clienteService;
        this.productoService = productoService;
        this.ventaRepo = ventaRepo;
    }

    // DRY: único punto de salida para los mensajes de error del servicio.
    private void imprimirError(String msg) {
        Console.error(msg);
    }

    // DRY + SRP: la comprobación de "venta activa" vive en un solo lugar.
    private boolean validarVentaActiva() {
        if (ventaActual == null) {
            imprimirError(MSG_SIN_VENTA_ACTIVA);
            return false;
        }
        return true;
    }

    public void crearVenta(String dniCliente) {

        Cliente cliente = clienteService.buscarCliente(dniCliente);

        if (cliente == null) {
            imprimirError(MSG_CLIENTE_NO_EXISTE);
            return;
        }

        ventaActual = new Venta(cliente);
        Console.info("Venta creada para: " + cliente.getNombre());
    }

    public void agregarProductoVenta(int idProducto, int cantidad) {

        if (!validarVentaActiva()) {
            return;
        }

        Producto producto = productoService.buscarProducto(idProducto);

        if (producto == null) {
            imprimirError(MSG_PRODUCTO_NO_ENCONTRADO);
            return;
        }

        if (!Validaciones.validarCantidad(cantidad)) {
            imprimirError(MSG_CANTIDAD_INVALIDA);
            return;
        }

        ventaActual.agregarDetalle(producto, cantidad);
        Console.info("Producto agregado: " + producto.getNombre() + " x" + cantidad);
    }

    public void finalizarVenta() {

        if (!validarVentaActiva()) {
            return;
        }

        ventaActual.finalizar();
        ventaRepo.guardar(ventaActual);

        Console.info("Venta finalizada. Total: " + ventaActual.calcularTotal());
        ventaActual = null;
    }

    public Venta obtenerVentaActual() {
        return ventaActual;
    }
}
