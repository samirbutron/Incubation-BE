package com.mx.Incubation.service;

import com.mx.Incubation.entity.Hardware;
import com.mx.Incubation.response.Respuesta;

public interface MetodosHardware {

  Respuesta guardar(Hardware hardware);

  Respuesta editar(Hardware hardware);

  Respuesta eliminar(Hardware hardware);

  Respuesta buscar(Hardware hardware);

  Respuesta mostrar();

  Respuesta componenteMayorCosto();

}
