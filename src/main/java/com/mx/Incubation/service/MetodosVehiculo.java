package com.mx.Incubation.service;

import com.mx.Incubation.entity.Vehiculo;
import com.mx.Incubation.response.Respuesta;

public interface MetodosVehiculo {

  public Respuesta guardar(Vehiculo vehiculo);

  public Respuesta editar(Vehiculo vehiculo);

  public Respuesta eliminar(Vehiculo vehiculo);

  public Respuesta buscar(Vehiculo vehiculo);

  public Respuesta mostrar();

}
