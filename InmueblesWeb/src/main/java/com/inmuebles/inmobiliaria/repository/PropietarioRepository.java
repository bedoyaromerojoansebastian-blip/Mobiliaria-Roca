package com.inmuebles.inmobiliaria.repository;

import com.inmuebles.inmobiliaria.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
}
