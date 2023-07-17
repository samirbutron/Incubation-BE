package com.mx.Incubation.service;

import com.mx.Incubation.entity.Computadora;
import com.mx.Incubation.response.Respuesta;

public interface MetodosComputadora {

  Respuesta guardar(Computadora computadora);

  Respuesta editar(Computadora computadora);

  Respuesta eliminar(Computadora computadora);

  Respuesta buscar(Computadora computadora);

  Respuesta mostrar();

  Respuesta precioDePC(Computadora computadora);

  Respuesta computadoraDeMarca(Computadora computadora);

  Respuesta pcMayorPrecio();
}
