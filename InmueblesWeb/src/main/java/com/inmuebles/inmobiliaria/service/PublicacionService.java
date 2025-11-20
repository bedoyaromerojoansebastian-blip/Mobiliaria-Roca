package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.Publicacion;
import com.inmuebles.inmobiliaria.repository.PublicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    public Publicacion guardar(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public List<Publicacion> listar() {
        return publicacionRepository.findAll();
    }

    public Publicacion buscarPorId(Integer id) {
        return publicacionRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        publicacionRepository.deleteById(id);
    }
}
