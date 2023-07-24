package com.mx.Incubation.service;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.response.Respuesta;

public interface ClienteMethods {

  Respuesta save(Cliente cliente);

  Respuesta update(Cliente cliente);

  Respuesta delete(Cliente cliente);

  Respuesta search(Cliente cliente);

  Respuesta show();

}
