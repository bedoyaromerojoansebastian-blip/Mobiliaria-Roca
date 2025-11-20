package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Compra;
import com.inmuebles.inmobiliaria.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra guardar(@RequestBody Compra compra) {
        return compraService.guardar(compra);
    }

    @GetMapping
    public List<Compra> listar() {
        return compraService.listar();
    }

    @GetMapping("/{id}")
    public Compra buscarPorId(@PathVariable Integer id) {
        return compraService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        compraService.eliminar(id);
    }
}
