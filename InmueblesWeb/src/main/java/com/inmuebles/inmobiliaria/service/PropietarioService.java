package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.Propietario;
import com.inmuebles.inmobiliaria.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public List<Propietario> listar() {
        return propietarioRepository.findAll();
    }

    public Propietario buscarPorId(Integer id) {
        return propietarioRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        propietarioRepository.deleteById(id);
    }
}
