package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Inmobiliaria;
import com.inmuebles.inmobiliaria.service.InmobiliariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/inmobiliarias")
@CrossOrigin(origins = "*")
public class InmobiliariaController {

    @Autowired
    private InmobiliariaService inmobiliariaService;

    // POST: Crear una nueva Inmobiliaria
    @PostMapping
    public ResponseEntity<Inmobiliaria> guardar(@RequestBody Inmobiliaria inmobiliaria) {
        // Validación básica de la relación (Usuario)
        if (inmobiliaria.getUsuario() == null || inmobiliaria.getUsuario().getIdUsuario() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Inmobiliaria nuevaInmobiliaria = inmobiliariaService.guardar(inmobiliaria);
        return new ResponseEntity<>(nuevaInmobiliaria, HttpStatus.CREATED);
    }

    // GET: Listar todas las Inmobiliarias
    @GetMapping
    public List<Inmobiliaria> listar() {
        return inmobiliariaService.listar();
    }

    // GET: Buscar Inmobiliaria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inmobiliaria> buscarPorId(@PathVariable Integer id) {
        Inmobiliaria inmobiliaria = inmobiliariaService.buscarPorId(id);
        if (inmobiliaria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inmobiliaria, HttpStatus.OK);
    }

    // PUT: Editar una Inmobiliaria existente
    @PutMapping("/{id}")
    public ResponseEntity<Inmobiliaria> actualizar(@PathVariable Integer id, @RequestBody Inmobiliaria inmobiliariaDetalles) {
        Inmobiliaria inmobiliariaExistente = inmobiliariaService.buscarPorId(id);

        if (inmobiliariaExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualiza los campos (ID y Usuario no se actualizan con PUT/PATCH)
        inmobiliariaExistente.setNombre(inmobiliariaDetalles.getNombre());
        inmobiliariaExistente.setDireccion(inmobiliariaDetalles.getDireccion());
        inmobiliariaExistente.setTelefono(inmobiliariaDetalles.getTelefono());

        Inmobiliaria inmobiliariaActualizada = inmobiliariaService.guardar(inmobiliariaExistente);
        return new ResponseEntity<>(inmobiliariaActualizada, HttpStatus.OK);
    }

    // DELETE: Eliminar una Inmobiliaria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Inmobiliaria inmobiliaria = inmobiliariaService.buscarPorId(id);
        if (inmobiliaria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        inmobiliariaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}