package com.toledo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FechaEventix {
    private int eventoId;
    @Min(value = 1, message = "El dia debe ser entre 1 y 31")
    @Max(value = 31, message = "El dia debe ser entre 1 y 31")
    private int dia;
    @Min(value = 1, message = "El mes debe ser entre 1 y 12")
    @Max(value = 12, message = "El mes debe ser entre 1 y 12")
    private int mes;
    @Min(value = 2000, message = "El año debe ser 2000 o posterior")
    @Max(value = 2050, message = "El año debe ser 2050 o anterior")
    private int año;
}