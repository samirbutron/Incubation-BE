package com.mx.metodos;

import com.mx.entidad.Mascota;

public interface MetodosMascota {

  public void guardar(Mascota mascota);
  public void editar(Mascota mascota);
  public void eliminar(Mascota mascota);
  public Mascota buscar(Mascota mascota);
  public void mostrar();
  public void listar();
}
