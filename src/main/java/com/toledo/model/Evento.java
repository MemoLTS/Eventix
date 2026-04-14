package com.toledo.model;

import java.util.concurrent.atomic.AtomicInteger;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data; 

import com.toledo.model.FechaEventix;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
public class Evento {

    private static AtomicInteger contador = new AtomicInteger(1);

    
    private int id;

    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 2, max = 50, message = "El titulo debe tener entre 2 y 50 caracteres")  
    private String title;
    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 2, max = 50, message = "La descripcion debe tener entre 2 y 50 caracteres")
    private String description;
    @NotBlank(message = "El estado es obligatorio")
    @Size(min = 2, max = 50, message = "El estado debe ser completado o pendiente")
    private String ubicacion;
    @Min(value = 1, message = "Debe ingresar una direccion valida")
    @Max(value = 100, message = "Debe ingresar una direccion valida")
    private int capacidad;
    @Min(value = 1, message = "La capacidad minima es 1")
    @Max(value = 100, message = "La capacidad maxima es 100")
    private int asistentes;
    private FechaEventix f;

    public Evento(String title, String description, String ubicacion, int capacidad) {
        this.id = contador.getAndIncrement();
        this.title = title;
        this.description = description;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.asistentes = 0; 
    }

    public int getDia() {
        return f.getDia();
    }
    public int getMes() {
        return f.getMes();
    }

    public int getAño() {
        return f.getYear();
    }

}