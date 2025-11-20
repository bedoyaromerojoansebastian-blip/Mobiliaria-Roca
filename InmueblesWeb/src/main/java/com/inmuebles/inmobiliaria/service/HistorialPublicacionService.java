package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.HistorialPublicacion;
import com.inmuebles.inmobiliaria.repository.HistorialPublicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialPublicacionService {

    private final HistorialPublicacionRepository historialRepository;

    public HistorialPublicacionService(HistorialPublicacionRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public HistorialPublicacion guardar(HistorialPublicacion historial) {
        return historialRepository.save(historial);
    }

    public List<HistorialPublicacion> listar() {
        return historialRepository.findAll();
    }

    public HistorialPublicacion buscarPorId(Integer id) {
        return historialRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        historialRepository.deleteById(id);
    }
}
