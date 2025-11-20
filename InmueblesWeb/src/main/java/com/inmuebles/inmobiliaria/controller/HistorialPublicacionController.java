package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.HistorialPublicacion;
import com.inmuebles.inmobiliaria.service.HistorialPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historialpublicaciones")
@CrossOrigin(origins = "*")
public class HistorialPublicacionController {

    @Autowired
    private HistorialPublicacionService historialService;

    @PostMapping
    public HistorialPublicacion guardar(@RequestBody HistorialPublicacion historial) {
        return historialService.guardar(historial);
    }

    @GetMapping
    public List<HistorialPublicacion> listar() {
        return historialService.listar();
    }

    @GetMapping("/{id}")
    public HistorialPublicacion buscarPorId(@PathVariable Integer id) {
        return historialService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        historialService.eliminar(id);
    }
}
