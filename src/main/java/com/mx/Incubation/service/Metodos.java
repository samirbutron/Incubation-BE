package com.mx.Incubation.service;

import com.mx.Incubation.entity.Producto;
import com.mx.Incubation.response.Respuesta;

public interface Metodos {

  public Respuesta guardar(Producto producto);

  public Respuesta editar(Producto producto);

  public Respuesta eliminar(Producto producto);

  public Respuesta buscar(Producto producto);

  public Respuesta mostrar();

  public Respuesta buscarPorMarca(Producto producto);

  public Respuesta buscarBajosDeStock();

  public Respuesta buscarMenorAPrecio(Producto producto);
}
