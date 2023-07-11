package com.mx.controller;

import com.mx.entidad.Libro;
import com.mx.service.Implementacion;

public class Main {
    public static void main(String[] args) {
        Implementacion imp = new Implementacion();
        Libro libro = new Libro("FolioPrueba", "TituloPrueba", "AutorPrueba", "EditoriaPrueba", "GeneroPrueba", 1, 1);
        imp.guardar(libro);
        System.out.println(imp.buscar(libro));
        Libro libroEditado = new Libro(libro.getFolio(), libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getGenero(), libro.getPrecio(), libro.getNo_paginas());
        libroEditado.setTitulo("TituloCambiado");
        libroEditado.setAutor("AutorCAmbiado");
        imp.editar(libroEditado);
        System.out.println(imp.buscar(libroEditado));
        imp.eliminar(libroEditado);
        System.out.println(imp.mostrar());
        Libro autorABuscar = new Libro("STEPHEN KING");
        System.out.println(imp.buscarPorAutor(autorABuscar));
    }
}
