package com.estudio.service_reservas.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Reserva 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha no puede estar vacia")
    private LocalDate fecha;

    @NotNull(message = "La hora no puede estar vacia")
    private LocalTime hora;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;

    @NotNull(message = "Debe seleccionar un tipo de sesion")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_sesion_id")
    private TipoSesion tipoSesion;

    
    @NotNull(message = "Debe seleccionar un fotografo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fotografo_id")
    private Fotografo fotografo;

    @NotNull(message = "El usuario es obligatorio")
    @Positive(message = "El id del usuario debe ser mayor a 0")
    private Long usuarioId;

    








}
