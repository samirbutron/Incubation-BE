package com.mx.metodos;

import com.mx.entidad.Producto;

//La interfaz es una plantilla con metodos vacios que son implementados por
// cualquier clase y es dentro de la clase que se implmenta la logica
public interface MetodosProducto {
  public void guardar(Producto producto);
  public void editar(Producto producto);
  public void eliminar (Producto producto);
  public  Producto buscar(Producto producto);
  public void mostrar();
  public void listar();

}
