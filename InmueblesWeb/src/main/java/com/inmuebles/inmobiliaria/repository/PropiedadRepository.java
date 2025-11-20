package com.inmuebles.inmobiliaria.repository;

import com.inmuebles.inmobiliaria.entity.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Integer> {
}
