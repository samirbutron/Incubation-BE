package com.mx.Incubation.service;

import com.mx.Incubation.entity.Curso;
import com.mx.Incubation.response.Respuesta;

public interface MetodosCurso {

  Respuesta guardar(Curso curso);

  Respuesta editar(Curso curso);

  Respuesta eliminar(Curso curso);

  Respuesta buscar(Curso curso);

  Respuesta mostrar();
}
