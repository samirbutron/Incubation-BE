package com.mx.metodos;

public interface MetodosGenericos {

  void guardar(Object obj, String clase);

  void editar(Object obj, String clase);

  void eliminar(Object obj, String clase);

  Object buscar(Object obj, String clase);

  void mostrar(String clase);

}
