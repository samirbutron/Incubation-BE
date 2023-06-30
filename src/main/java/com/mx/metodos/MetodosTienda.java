package com.mx.metodos;

import com.mx.entidad.Tienda;

//La interfaz es una plantilla con metodos vacios que son implementados por
// cualquier clase y es dentro de la clase que se implmenta la logica
public interface MetodosTienda {
  public void guardar(Tienda tienda);
  public void editar(Tienda tienda);
  public void eliminar (Tienda tienda);
  public  Tienda buscar(Tienda tienda);
  public void mostrar();
  public void listar();
}
