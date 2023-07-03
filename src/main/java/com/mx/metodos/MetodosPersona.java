package com.mx.metodos;

import com.mx.entidad.Persona;
import com.mx.service.ImpPersona;

public interface MetodosPersona {

  public void guardar(Persona persona);
  public void editar(Persona persona);
  public void eliminar(Persona persona);
  public Persona buscar(Persona persona);
  public void mostrar();
  public void listar();
}
