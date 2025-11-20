package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Propietario;
import com.inmuebles.inmobiliaria.service.PropietarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
@CrossOrigin(origins = "*")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping
    public Propietario crear(@RequestBody Propietario propietario) {
        return propietarioService.guardar(propietario);
    }

    @GetMapping
    public List<Propietario> listar() {
        return propietarioService.listar();
    }

    @GetMapping("/{id}")
    public Propietario obtenerPorId(@PathVariable Integer id) {
        return propietarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Propietario actualizar(@PathVariable Integer id, @RequestBody Propietario propietario) {
        Propietario existente = propietarioService.buscarPorId(id);
        if (existente != null) {
            existente.setNombre(propietario.getNombre());
            existente.setTelefono(propietario.getTelefono());
            existente.setCorreo(propietario.getCorreo());
            existente.setUsuario(propietario.getUsuario());
            return propietarioService.guardar(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        propietarioService.eliminar(id);
    }
}
