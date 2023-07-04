package com.mx.metodos;

public interface MetodosGenericos {
  public void guardar(Object obj);
  public void editar(Object obj, int indice);
  public void eliminar(int indice, String clase);
  public Object buscar(int indice, String clase);
  public void mostrar( String clase);

}
