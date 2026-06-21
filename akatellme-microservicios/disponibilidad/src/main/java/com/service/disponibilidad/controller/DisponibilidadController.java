package com.service.disponibilidad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.disponibilidad.model.DisponibilidadModelo;
import com.service.disponibilidad.service.DisponibilidadService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/disponibilidades")
@CrossOrigin(origins = "*")
@Tag(name = "Gestión de Disponibilidades",
     description = "Permite administrar los horarios disponibles")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadService disponibilidadService;

    @GetMapping
    @Operation(summary = "Obtiene todas las disponibilidades")
    public List<DisponibilidadModelo> obtenerDisponibilidades() {
        return disponibilidadService.obtenerDisponibilidades();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una disponibilidad por ID")
    public DisponibilidadModelo obtenerDisponibilidadPorId(@PathVariable Long id) {
        return disponibilidadService.obtenerDisponibilidadPorId(id);
    }

    @PostMapping
    @Operation(summary = "Registra una nueva disponibilidad")
    public DisponibilidadModelo guardarDisponibilidad(@RequestBody DisponibilidadModelo disponibilidad) {
        return disponibilidadService.guardarDisponibilidad(disponibilidad);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una disponibilidad")
    public DisponibilidadModelo actualizarDisponibilidad(@PathVariable Long id,
                                                   @RequestBody DisponibilidadModelo disponibilidad) {
        return disponibilidadService.actualizarDisponibilidad(id, disponibilidad);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una disponibilidad")
    public void eliminarDisponibilidad(@PathVariable Long id) {
        disponibilidadService.eliminarDisponibilidad(id);
    }
}