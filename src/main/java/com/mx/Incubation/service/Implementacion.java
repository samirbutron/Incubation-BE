package com.mx.Incubation.service;

import com.mx.Incubation.entity.Producto;
import com.mx.Incubation.repository.ProductoDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Implementacion implements Metodos {

  @Autowired
  ProductoDao productoDao;

  @Override
  public Respuesta guardar(Producto producto) {
    List<Producto> productoList = productoDao.findAll();
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen productos en el registro", null, 0);
    }
    for (Producto p : productoList) {
      if (p.getCodigo() == producto.getCodigo()) {
        return new Respuesta("ERROR", "Ya existe un producto con este codigo", producto, 0);
      } else if (p.getNombre().equals(producto.getNombre()) && p.getMarca()
          .equals(producto.getMarca())) {
        return new Respuesta("ERROR", "Este nombre y marca de producto ya existen en registro",
            producto, 0);
      }
    }
    productoDao.save(producto);
    return new Respuesta("EXITO", "El producto se guardo exitosamente", producto, 1);
  }

  @Override
  public Respuesta editar(Producto producto) {
    Producto productoBuscado = productoDao.findById(producto.getCodigo()).orElse(null);
    if (productoBuscado == null) {
      return new Respuesta("ERROR", "No existe un producto con este codigo", producto, 0);
    } else {
      productoDao.save(producto);
      return new Respuesta("EXITO", "El producto se cambio", producto, 1);
    }
  }

  @Override
  public Respuesta eliminar(Producto producto) {
    Producto productoBuscado = productoDao.findById(producto.getCodigo()).orElse(null);
    if (productoBuscado == null) {
      return new Respuesta("ERROR", "No existe un producto con este codigo", producto, 0);
    } else {
      productoDao.delete(producto);
      return new Respuesta("EXITO", "El producto se elimino", productoBuscado, 1);
    }
  }

  @Override
  public Respuesta buscar(Producto producto) {
    Producto productoBuscado = productoDao.findById(producto.getCodigo()).orElse(null);
    if (productoBuscado == null) {
      return new Respuesta("ERROR", "No existe un producto con este codigo", producto, 0);
    } else {
      return new Respuesta("EXITO", "El producto se encontro", productoBuscado, 1);
    }
  }

  @Override
  public Respuesta mostrar() {
    List<Producto> productoList = productoDao.findAll();
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen productos", null, 0);
    } else {
      return new Respuesta("EXITO", "Se encontraron los siguientes productos", productoList, 1);
    }
  }

  @Override
  public Respuesta buscarPorMarca(Producto producto) {
    List<Producto> productoList = productoDao.findByMarca(producto.getMarca());
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen productos de dicha marca", null, 0);
    } else {
      return new Respuesta("EXITO", "Se encontraron los siguientes productos", productoList, 1);
    }
  }

  @Override
  public Respuesta buscarBajosDeStock() {
    List<Producto> productoList = productoDao.findAll();
    List<Producto> productoLowStock = new ArrayList<>();
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen productos en registro", null, 0);
    } else {
      for (Producto p : productoList) {
        if (p.getStock() < 10) {
          productoLowStock.add(p);
        }
      }
    }
    if (productoLowStock.isEmpty()) {
      return new Respuesta("INFO", "No hay productos con bajo stock", null, 0);
    } else {
      return new Respuesta("EXITO", "Estos son los productos bajos de stock", productoLowStock, 1);
    }
  }

  @Override
  public Respuesta buscarMenorAPrecio(Producto producto) {
    List<Producto> productoList = productoDao.findByPrecioPublicoLessThan(
        producto.getPrecioPublico());
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No hay productos menores a ese precio", null, 0);
    } else {
      return new Respuesta("EXITO", "Estos son los productos menores a ese precio", productoList,
          0);
    }
  }

  @Override
  public Respuesta buscarCodigo(Producto producto) {
    Producto productoEncontrado = productoDao.findByNombreAndMarca(producto.getNombre(),
        producto.getMarca());
    if (productoEncontrado == null) {
      return new Respuesta("ERROR", "No hay producto con ese nombre y marca", null, 0);
    } else {
      return new Respuesta("EXITO", "Se encontro le producto ", productoEncontrado, 1);
    }
  }

  @Override
  public Respuesta valorDeMarca(Producto producto) {
    List<Producto> productoList = productoDao.findByMarca(producto.getMarca());
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen productos de dicha marca", null, 0);
    } else {
      double sum = productoList.stream().mapToDouble(p -> p.getPrecioPublico() * p.getStock())
          .sum();
      return new Respuesta("EXITO", "El valor agregado de la marca " + producto.getMarca() + " es",
          sum, 1);
    }
  }

  @Override
  public Respuesta marcaMasBarata() {
    List<Producto> productoList = productoDao.findAll();
    Map<String, Double> marcas = new HashMap<>();
    Map<String, Double> marcasBaratas = new HashMap<>();
    double valorMin = Integer.MAX_VALUE;
    if (productoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen productos en el registro", null, 0);
    } else {
      for (Producto p : productoList) {
        if (marcas.containsKey(p.getMarca())) {
          double valor = marcas.get(p.getMarca()) + p.getPrecio() * p.getStock();
          marcas.replace(p.getMarca(), valor);
        } else {
          double valorAgregado = p.getPrecio() * p.getStock();
          marcas.put(p.getMarca(), valorAgregado);
        }
      }
      for (String key : marcas.keySet()) {
        if (marcas.get(key) == valorMin) {
          marcasBaratas.put(key, marcas.get(key));
        } else if (marcas.get(key) < valorMin) {
          valorMin = marcas.get(key);
          marcasBaratas.clear();
          marcasBaratas.put(key, marcas.get(key));
        }
      }
      System.out.println(marcas);
      return new Respuesta("EXITO", "Estos son las marcas con los productos mas baratos ",
          marcasBaratas, 1);
    }
  }
}
