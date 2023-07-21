package com.mx.Incubation.service;

import com.mx.Incubation.entity.Farmaco;
import com.mx.Incubation.response.Respuesta;

public interface FarmacoMethods {

  Respuesta save(Farmaco farmaco);

  Respuesta update(Farmaco farmaco);

  Respuesta delete(Farmaco farmaco);

  Respuesta search(Farmaco farmaco);

  Respuesta show();
}
