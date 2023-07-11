package com.mx.Incubation.service;

import com.mx.Incubation.entity.Persona;
import com.mx.Incubation.response.Respuesta;

public interface Metodos {

  public Respuesta guardar(Persona persona);

  public Respuesta editar(Persona persona);

  public Respuesta eliminar(Persona persona);

  public Respuesta buscar(Persona persona);

  public Respuesta mostrar();
}
