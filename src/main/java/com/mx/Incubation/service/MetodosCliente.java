package com.mx.Incubation.service;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.response.Respuesta;

public interface MetodosCliente {

  Respuesta guardar(Cliente cliente);

  Respuesta editar(Cliente cliente);

  Respuesta eliminar(Cliente cliente);

  Respuesta buscar(Cliente cliente);

  Respuesta mostrar();
}
