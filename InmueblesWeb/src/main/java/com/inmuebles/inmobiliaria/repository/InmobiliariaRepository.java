package com.inmuebles.inmobiliaria.repository;

import com.inmuebles.inmobiliaria.entity.Inmobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmobiliariaRepository extends JpaRepository<Inmobiliaria, Integer> {
}
