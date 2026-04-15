package com.toledo.model;

import java.util.concurrent.atomic.AtomicInteger;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;        
import lombok.Data; 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    private static AtomicInteger contador = new AtomicInteger(1);


    private int id=contador.getAndIncrement();

    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 2, max = 100, message = "El titulo debe tener entre 2 y 50 caracteres")  
    private String title;
    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 2, max = 50, message = "La descripcion debe tener entre 2 y 50 caracteres")
    private String description;
    @Min(value = 1, message = "Debe ingresar una direccion valida")
    @Max(value = 100, message = "Debe ingresar una direccion valida")
    private String ubicacion;
    @Min(value = 1, message = "La capacidad minima es 1")
    @Max(value = 100000, message = "La capacidad maxima es 100")
    private int capacidad;
    @NotBlank(message="El tipo es obligatorio")
    @Size(min = 4, max = 20, message="El tipo debe tener entre 4 y 20 caracteres")
    private String tipo;
    @Min(value = 0, message = "Los asistentes deben ser 0 o más")
    @Max(value = 100000, message = "Los asistentes no pueden superar la capacidad maxima")
    private int asistentes;


}