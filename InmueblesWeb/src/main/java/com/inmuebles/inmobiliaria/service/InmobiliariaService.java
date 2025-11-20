package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.Inmobiliaria;
import com.inmuebles.inmobiliaria.repository.InmobiliariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InmobiliariaService {

    private final InmobiliariaRepository inmobiliariaRepository;

    public InmobiliariaService(InmobiliariaRepository inmobiliariaRepository) {
        this.inmobiliariaRepository = inmobiliariaRepository;
    }

    public Inmobiliaria guardar(Inmobiliaria inmobiliaria) {
        return inmobiliariaRepository.save(inmobiliaria);
    }

    public List<Inmobiliaria> listar() {
        return inmobiliariaRepository.findAll();
    }

    public Inmobiliaria buscarPorId(Integer id) {
        return inmobiliariaRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        inmobiliariaRepository.deleteById(id);
    }
}
