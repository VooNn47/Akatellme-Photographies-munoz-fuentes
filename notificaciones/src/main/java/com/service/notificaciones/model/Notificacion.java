package com.service.notificaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Notificacion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El mensaje es obligatorio")
    @Size(min = 5, max = 255,
           message = "El mensaje debe tener entre 5 y 255 caracteres")
    private String mensaje;

    @NotBlank(message = "El tipo de notificación es obligatorio")
    private String tipo;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    private String fecha;
}