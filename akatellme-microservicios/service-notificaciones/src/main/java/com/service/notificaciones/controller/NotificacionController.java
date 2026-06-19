package com.service.notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.service.notificaciones.model.Notificacion;
import com.service.notificaciones.service.NotificacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notificaciones")
@CrossOrigin(origins = "*") 
public class NotificacionController 
{
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listar()
    {
        List<Notificacion> notificaciones =
                notificacionService.listarTodo();

        return ResponseEntity.ok(notificaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> buscar(
            @PathVariable Long id)
    {
        return notificacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> guardar(
            @Valid @RequestBody Notificacion notificacion)
    {
        try {

            Notificacion nuevaNotificacion =
                    notificacionService.guardar(notificacion);

            return new ResponseEntity<>(
                    nuevaNotificacion,
                    HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Notificacion notificacion)
    {
        try {

            return notificacionService.buscarPorId(id)
                    .map(n -> {

                        notificacion.setId(id);

                        return new ResponseEntity<>(
                                notificacionService.guardar(notificacion),
                                HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(
                            HttpStatus.NOT_FOUND));

        } catch (Exception e) {

            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id)
    {
        try {

            notificacionService.eliminar(id);

            return new ResponseEntity<>(
                    "Notificación eliminada correctamente",
                    HttpStatus.NO_CONTENT);

        } catch (Exception e) {

            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }
}