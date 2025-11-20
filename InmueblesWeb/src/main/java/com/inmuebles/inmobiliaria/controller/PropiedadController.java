package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Propiedad;
import com.inmuebles.inmobiliaria.service.PropiedadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
@CrossOrigin(origins = "*")
public class PropiedadController {

    private final PropiedadService propiedadService;

    public PropiedadController(PropiedadService propiedadService) {
        this.propiedadService = propiedadService;
    }

    @PostMapping
    public Propiedad crear(@RequestBody Propiedad propiedad) {
        return propiedadService.guardar(propiedad);
    }

    @GetMapping
    public List<Propiedad> listar() {
        return propiedadService.listar();
    }

    @GetMapping("/{id}")
    public Propiedad obtenerPorId(@PathVariable Integer id) {
        return propiedadService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Propiedad actualizar(@PathVariable Integer id, @RequestBody Propiedad propiedad) {
        Propiedad existente = propiedadService.buscarPorId(id);
        if (existente != null) {
            existente.setTipo(propiedad.getTipo());
            existente.setUbicacion(propiedad.getUbicacion());
            existente.setPrecio(propiedad.getPrecio());
            existente.setHabitaciones(propiedad.getHabitaciones());
            existente.setPropietario(propiedad.getPropietario());
            existente.setInmobiliaria(propiedad.getInmobiliaria());
            return propiedadService.guardar(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        propiedadService.eliminar(id);
    }
}
