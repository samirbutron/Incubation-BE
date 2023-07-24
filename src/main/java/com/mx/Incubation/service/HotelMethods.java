package com.mx.Incubation.service;

import com.mx.Incubation.entity.Hotel;
import com.mx.Incubation.response.Respuesta;

public interface HotelMethods {

  Respuesta save(Hotel hotel);

  Respuesta update(Hotel hotel);

  Respuesta delete(Hotel hotel);

  Respuesta search(Hotel hotel);

  Respuesta show();
}
