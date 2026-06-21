package com.service.disponibilidad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.disponibilidad.model.DisponibilidadModelo;
import com.service.disponibilidad.repository.DisponibilidadRepository;

@Service
public class DisponibilidadService 
{
    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    public List<DisponibilidadModelo> obtenerDisponibilidades() {
        return disponibilidadRepository.findAll();
    }

    public DisponibilidadModelo obtenerDisponibilidadPorId(Long id) {
        return disponibilidadRepository.findById(id).get();
    }

    public DisponibilidadModelo guardarDisponibilidad(DisponibilidadModelo disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    public DisponibilidadModelo actualizarDisponibilidad(Long id, DisponibilidadModelo disponibilidad) {
        DisponibilidadModelo disponibilidadActual = disponibilidadRepository.findById(id).get();

        disponibilidadActual.setFecha(disponibilidad.getFecha());
        disponibilidadActual.setHora(disponibilidad.getHora());
        disponibilidadActual.setEstado(disponibilidad.getEstado());

        return disponibilidadRepository.save(disponibilidadActual);
    }

    public void eliminarDisponibilidad(Long id) {
        disponibilidadRepository.deleteById(id);
    }

}
