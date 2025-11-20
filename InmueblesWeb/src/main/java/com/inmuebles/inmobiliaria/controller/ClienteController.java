package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Cliente;
import com.inmuebles.inmobiliaria.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // CREATE
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    // READ ALL
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    // READ ONE BY ID
    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        return clienteService.guardar(cliente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return "Cliente eliminado correctamente";
    }
}
