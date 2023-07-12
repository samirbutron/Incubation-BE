package com.mx.Incubation.service;

import com.mx.Incubation.entity.Producto;
import com.mx.Incubation.response.Respuesta;

interface Metodos {

  Respuesta guardar(Producto producto);

  Respuesta editar(Producto producto);

  Respuesta eliminar(Producto producto);

  Respuesta buscar(Producto producto);

  Respuesta mostrar();

  Respuesta buscarPorMarca(Producto producto);

  Respuesta buscarBajosDeStock();

  Respuesta buscarMenorAPrecio(Producto producto);

  Respuesta buscarCodigo(Producto producto);

  Respuesta valorDeMarca(Producto producto);

  Respuesta marcaMasBarata();
}
