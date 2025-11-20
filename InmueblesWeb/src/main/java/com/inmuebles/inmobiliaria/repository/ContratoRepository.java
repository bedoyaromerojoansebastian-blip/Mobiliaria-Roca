package com.inmuebles.inmobiliaria.repository;

import com.inmuebles.inmobiliaria.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
