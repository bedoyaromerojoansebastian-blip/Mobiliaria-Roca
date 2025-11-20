package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Contrato;
import com.inmuebles.inmobiliaria.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public Contrato guardar(@RequestBody Contrato contrato) {
        return contratoService.guardar(contrato);
    }

    @GetMapping
    public List<Contrato> listar() {
        return contratoService.listar();
    }

    @GetMapping("/{id}")
    public Contrato buscarPorId(@PathVariable Integer id) {
        return contratoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        contratoService.eliminar(id);
    }
}

