package com.mx.Incubation.service;

import com.mx.Incubation.entity.Libro;
import com.mx.Incubation.response.Respuesta;

public interface Metodos {

  public Respuesta guardar(Libro libro);

  public Respuesta editar(Libro libro);

  public Respuesta eliminar(Libro libro);

  public Respuesta buscar(Libro libro);

  public Respuesta mostrar();
}
