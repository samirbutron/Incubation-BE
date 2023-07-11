package com.mx.general;

import java.util.List;

import com.mx.entidad.Mascota;

public interface Metodos {
  public String guardar(Mascota mascota);

  public String editar(Mascota mascota);

  public String eliminar(Mascota mascota);

  public Mascota buscar(Mascota mascota);

  public List mostrar();
}
