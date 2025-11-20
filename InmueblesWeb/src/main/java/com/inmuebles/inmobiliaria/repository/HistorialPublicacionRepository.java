package com.inmuebles.inmobiliaria.repository;

import com.inmuebles.inmobiliaria.entity.HistorialPublicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPublicacionRepository extends JpaRepository<HistorialPublicacion, Integer> {
}
