package com.mx.service;

import com.mx.entidad.Producto;
import com.mx.metodos.MetodosProducto;
import java.util.HashMap;

public class ImpProducto implements MetodosProducto {
  HashMap<String, Producto> hashProducto = new HashMap<>();

  public ImpProducto() {
    Producto producto = new Producto("a100","Chips","Barcel","Fritura",15);
    Producto producto1 = new Producto("a200","Cheetos","Sabritas","Fritura",10);
    Producto producto2 = new Producto("a300","Senzo","Emperador","Galletas",20);
    Producto producto3 = new Producto("a400","Pinguinito","Marinela","Pastel",10);
    hashProducto.put("a100",producto);
    hashProducto.put("a200",producto1);
    hashProducto.put("a300",producto2);
    hashProducto.put("a400",producto3);

  }
  @Override
  public void guardar(Producto producto) {
    if(hashProducto.isEmpty()){
      hashProducto.put(producto.getCodigoBarras(), producto);
      System.out.println("Producto guardado de manera satisfactoria");
    }else {
      Producto p;
      boolean existe = false;
      for(String key : hashProducto.keySet()){
        p = hashProducto.get(key);
        if(producto.getCodigoBarras().equalsIgnoreCase(key)){
          System.out.println("El codigo de barras que tratas de registrar ya existe");
          existe = true;
          break;
        } else if (producto.getNombre().equalsIgnoreCase(p.getNombre()) && producto.getMarca().equalsIgnoreCase(p.getMarca())) {
          System.out.println("Este producto ya se encuentra registrado");
          existe = true;
          break;
        }
      }
      if (!existe){
        hashProducto.put(producto.getCodigoBarras(), producto);
        System.out.println("El producto se agrego de manera satisfactoria");
      }
    }
  }

  @Override
  public void editar(Producto producto) {
    hashProducto.put(producto.getCodigoBarras(), producto);
  }

  @Override
  public void eliminar(Producto producto) {
    hashProducto.remove(producto.getCodigoBarras());
  }

  @Override
  public Producto buscar(Producto producto) {
    if(hashProducto.isEmpty()){
      return null;
    }else {
      for (String key : hashProducto.keySet()){
        if (producto.getCodigoBarras().equalsIgnoreCase(key)){
          producto = hashProducto.get(key);
          return producto;
        }
      }
    }
    return null;
  }

  @Override
  public void mostrar() {
    System.out.println(hashProducto);
  }

  public void listar(){
    if (hashProducto.isEmpty()){
      System.out.println("No existen productos para listar");
    }else {
      for (String key : hashProducto.keySet()){
        System.out.println(hashProducto.get(key).toString());
        Producto p = hashProducto.get(key);
        System.out.println("["+p.getCodigoBarras());
      }
    }
  }
}
