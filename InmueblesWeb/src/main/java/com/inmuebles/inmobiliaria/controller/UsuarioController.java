package com.inmuebles.inmobiliaria.controller;

import com.inmuebles.inmobiliaria.entity.Usuario;
import com.inmuebles.inmobiliaria.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // CREATE
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    // READ ALL
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    // READ ONE BY ID
    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        // opción simple: fijar id y reutilizar guardar
        usuario.setIdUsuario(id);
        return usuarioService.guardar(usuario);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado correctamente";
    }
}

