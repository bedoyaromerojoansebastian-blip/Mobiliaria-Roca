package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Publicacion;
import com.inmuebles.inmobiliaria.service.PublicacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
@CrossOrigin(origins = "*")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public Publicacion crear(@RequestBody Publicacion publicacion) {
        return publicacionService.guardar(publicacion);
    }

    @GetMapping
    public List<Publicacion> listar() {
        return publicacionService.listar();
    }

    @GetMapping("/{id}")
    public Publicacion obtenerPorId(@PathVariable Integer id) {
        return publicacionService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Publicacion actualizar(@PathVariable Integer id, @RequestBody Publicacion publicacion) {
        Publicacion existente = publicacionService.buscarPorId(id);
        if (existente != null) {
            existente.setPropiedad(publicacion.getPropiedad());
            existente.setUsuario(publicacion.getUsuario());
            existente.setEstado(publicacion.getEstado());
            existente.setFechaPublicacion(publicacion.getFechaPublicacion());
            existente.setDescripcion(publicacion.getDescripcion());
            return publicacionService.guardar(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        publicacionService.eliminar(id);
    }
}
