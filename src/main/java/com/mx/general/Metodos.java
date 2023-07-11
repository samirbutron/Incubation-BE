package com.mx.general;

import java.util.List;

import com.mx.entidad.Mascota;

public interface Metodos {
  String guardar(Mascota mascota);

  String editar(Mascota mascota);

  String eliminar(Mascota mascota);

  Mascota buscar(Mascota mascota);

  List<Mascota> mostrar();
}
