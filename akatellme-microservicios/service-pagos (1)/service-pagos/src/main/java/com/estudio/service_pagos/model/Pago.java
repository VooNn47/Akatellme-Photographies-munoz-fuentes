package com.estudio.service_pagos.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El monto no puede estar vacio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double monto;

    @NotBlank(message = "El metodo de pago no puede estar vacio")
    private String metodoPago;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;
    
    @NotNull(message = "La fecha de pago no puede estar vacia")
    private LocalDate fechaPago;

    @NotNull(message = "La reserva es obligatoria")
    @Positive(message = "El id de reserva debe ser mayor a 0")
    private Long reservaId;



}
