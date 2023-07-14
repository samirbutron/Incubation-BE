package com.mx.Incubation.service;

import com.mx.Incubation.entity.Alumno;
import com.mx.Incubation.response.Respuesta;

public interface MetodosAlumno {

  Respuesta guardar(Alumno alumno);

  Respuesta editar(Alumno alumno);

  Respuesta eliminar(Alumno alumno);

  Respuesta buscar(Alumno alumno);

  Respuesta mostrar();
}
