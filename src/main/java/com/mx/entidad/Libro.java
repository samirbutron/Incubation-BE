package com.mx.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    private String folio;
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private int precio;
    private int no_paginas;

    public Libro(String autor) {
        this.autor = autor;
    }
}
