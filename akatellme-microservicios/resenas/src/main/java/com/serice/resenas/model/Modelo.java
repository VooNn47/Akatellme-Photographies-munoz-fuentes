package com.serice.resenas.model;
import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Modelo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteid;
    @NotNull(message = "el Id del evento es obligatorio")
    private Long eventoid;

    @NotBlank(message = "el comentario es obligatorio")
    private String comentario;

    @NotNull(message = "la clasificacion debe ser obligatoria")
    private Integer clasificacion;
    private LocalDate fecha;




}
