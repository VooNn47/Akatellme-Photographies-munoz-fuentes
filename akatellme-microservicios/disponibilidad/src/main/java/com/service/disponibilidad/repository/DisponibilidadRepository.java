package com.service.disponibilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.disponibilidad.model.DisponibilidadModelo;
@Repository
public interface DisponibilidadRepository extends JpaRepository<DisponibilidadModelo, Long>
{

}
