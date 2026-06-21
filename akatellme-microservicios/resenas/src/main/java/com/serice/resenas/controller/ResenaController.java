package com.serice.resenas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serice.resenas.model.Modelo;
import com.serice.resenas.service.ResenasService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/resenas")
@CrossOrigin(origins = "*") 
public class ResenaController {

    @Autowired
    private ResenasService service;

    @GetMapping
    @Operation(summary = "Obtener todas las reseñas")
    public List<Modelo> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Modelo> guardar(@Valid @RequestBody Modelo resena) {
        return ResponseEntity.ok(service.guardar(resena));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reseñas por ID")
    public ResponseEntity<Modelo> buscar(@PathVariable Long id) {
        Modelo resena = service.buscarPorId(id);

        if (resena == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resena);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reseña por ID")
    public ResponseEntity<Modelo> actualizar(@PathVariable Long id,
                                            @Valid @RequestBody Modelo resena) {

        Modelo resenaExistente = service.buscarPorId(id);

        if (resenaExistente == null) {
            return ResponseEntity.notFound().build();
        }

        resena.setId(id);

        return ResponseEntity.ok(service.guardar(resena));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar reseñas por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}