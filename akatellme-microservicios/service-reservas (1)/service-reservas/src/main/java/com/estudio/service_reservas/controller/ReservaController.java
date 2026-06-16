package com.estudio.service_reservas.controller;

import com.estudio.service_reservas.model.Reserva;
import com.estudio.service_reservas.service.ReservaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")


public class ReservaController 
{
    private final ReservaService reservaService;

    ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listar(){
        return reservaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtener(@PathVariable Long id){
        return reservaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
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
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody Reserva reserva){

        try {

            return reservaService.buscarPorId(id)
                    .map(r -> {

                        reserva.setId(id);

                        return ResponseEntity.ok(
                                reservaService.guardar(reserva));
                    })
                    .orElse(ResponseEntity.notFound().build());

    } catch (RuntimeException e) {

        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    

}
