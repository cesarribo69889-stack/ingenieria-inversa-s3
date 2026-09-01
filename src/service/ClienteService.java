package service;

import model.Cliente;
import repository.ClienteRepository;
import util.Console;
import util.Validaciones;

public class ClienteService {

    private ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    // BUG intencional: validarDni está mal en util.Validaciones
    public void registrarCliente(String dni, String nombre, String tipo) {

        if (!Validaciones.validarDni(dni)) {
            Console.error("DNI inválido");
            return;
        }

        Cliente cliente = new Cliente(dni, nombre, tipo);
        clienteRepo.guardar(cliente);
        Console.info("Cliente registrado: " + nombre);
    }

    public Cliente buscarCliente(String dni) {
        return clienteRepo.buscarPorDni(dni);
    }
}
