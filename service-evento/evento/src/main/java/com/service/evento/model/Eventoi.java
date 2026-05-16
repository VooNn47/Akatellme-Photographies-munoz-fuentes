package com.service.evento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

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

public class Eventoi 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(min = 3, max = 100,
           message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El lugar es obligatorio")
    @Size(min = 3, max = 100,
           message = "El lugar debe tener entre 3 y 100 caracteres")
    private String lugar;

    @NotBlank(message = "La fecha es obligatoria")
    private String fecha;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @Transient
    private Object datosUsuario;
}