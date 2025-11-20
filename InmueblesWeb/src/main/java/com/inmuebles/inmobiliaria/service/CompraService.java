package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.Compra;
import com.inmuebles.inmobiliaria.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra guardar(Compra compra) {
        return compraRepository.save(compra);
    }

    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    public Compra buscarPorId(Integer id) {
        return compraRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        compraRepository.deleteById(id);
    }
}
