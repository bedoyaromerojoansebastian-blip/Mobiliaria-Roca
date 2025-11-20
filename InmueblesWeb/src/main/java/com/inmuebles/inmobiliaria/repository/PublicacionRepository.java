package com.inmuebles.inmobiliaria.repository;

import com.inmuebles.inmobiliaria.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
}
