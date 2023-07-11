package com.mx.general;

import com.mx.entidad.Libro;

import java.util.List;

public interface Metodos {
    String guardar(Libro libro);

    String editar(Libro libro);

    String eliminar(Libro libro);

    Libro buscar(Libro libro);

    List<Libro> mostrar();
}
