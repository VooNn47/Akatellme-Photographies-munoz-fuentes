package com.estudio.service_reservas.controller;

import com.estudio.service_reservas.model.Reserva;
import com.estudio.service_reservas.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
@Tag(name = "Reservas", description = "Operaciones relacionadas con la gestion de reservas")

public class ReservaController 
{
    private final ReservaService reservaService;

    ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @Operation(summary = "Listar todas las reservas")
    @GetMapping
    public List<Reserva> listar(){
        return reservaService.listarTodos();
    }
    @Operation(summary = "Buscar una reserva por id")
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtener(@PathVariable Long id){
        return reservaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @Operation(summary = "Registrar una nueva reserva")
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Reserva reserva){
        try{
            return ResponseEntity.ok(reservaService.guardar(reserva));
        }catch (RuntimeException e){
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
    @Operation(summary = "Eliminar una reserva")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    

}
