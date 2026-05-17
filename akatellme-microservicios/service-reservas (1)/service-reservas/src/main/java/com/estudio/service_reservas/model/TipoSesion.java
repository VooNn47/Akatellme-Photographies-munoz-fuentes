package com.estudio.service_reservas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class TipoSesion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @Positive(message = "La duracion debe ser mayor a 0")
    private int duracion;

    @Positive(message = "El precio debe ser mayor a 0")
    private double precio;


}
