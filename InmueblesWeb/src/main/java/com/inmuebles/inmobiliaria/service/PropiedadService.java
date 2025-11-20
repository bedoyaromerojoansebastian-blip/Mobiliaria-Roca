package com.inmuebles.inmobiliaria.service;

import com.inmuebles.inmobiliaria.entity.Propiedad;
import com.inmuebles.inmobiliaria.repository.PropiedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadService {

    private final PropiedadRepository propiedadRepository;

    public PropiedadService(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    public Propiedad guardar(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public List<Propiedad> listar() {
        return propiedadRepository.findAll();
    }

    public Propiedad buscarPorId(Integer id) {
        return propiedadRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        propiedadRepository.deleteById(id);
    }
}
