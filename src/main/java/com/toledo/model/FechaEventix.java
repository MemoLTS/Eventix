package com.toledo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FechaEventix {
    private String nombre;
    private int dia;
    private int mes;
    private int year;
}