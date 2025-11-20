package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.Contrato;
import com.inmuebles.inmobiliaria.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public Contrato guardar(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public List<Contrato> listar() {
        return contratoRepository.findAll();
    }

    public Contrato buscarPorId(Integer id) {
        return contratoRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        contratoRepository.deleteById(id);
    }
}
