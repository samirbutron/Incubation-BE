package com.mx.Incubation.service;

import com.mx.Incubation.entity.Farmacia;
import com.mx.Incubation.response.Respuesta;

public interface FarmaciaMethods {

  Respuesta save(Farmacia farmacia);

  Respuesta update(Farmacia farmacia);

  Respuesta delete(Farmacia farmacia);

  Respuesta search(Farmacia farmacia);

  Respuesta show();

}
