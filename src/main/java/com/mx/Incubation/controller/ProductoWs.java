package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Producto;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.Implementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productos")
@CrossOrigin
public class ProductoWs {

  @Autowired
  Implementacion implementacion;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return implementacion.mostrar();
  }

  @PostMapping(value = "guardar")
  public Respuesta guardar(@RequestBody Producto producto) {
    return implementacion.guardar(producto);
  }

  @PostMapping(value = "editar")
  public Respuesta editar(@RequestBody Producto producto) {
    return implementacion.editar(producto);
  }

  @PostMapping(value = "eliminar")
  public Respuesta eliminar(@RequestBody Producto producto) {
    return implementacion.eliminar(producto);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Producto producto) {
    return implementacion.buscar(producto);
  }

  @GetMapping("buscarBajosDeStock")
  public Respuesta buscarBajoStock() {
    return implementacion.buscarBajosDeStock();
  }

  @GetMapping("buscarMenorAPrecio")
  public Respuesta buscarMenorAPrecio(@RequestBody Producto producto) {
    return implementacion.buscarMenorAPrecio(producto);
  }

  @GetMapping("buscarMarca")
  public Respuesta buscarMarca(@RequestBody Producto producto) {
    return implementacion.buscarPorMarca(producto);
  }

  @GetMapping("obtenerCodigo")
  public Respuesta buscarCodigo(@RequestBody Producto producto) {
    return implementacion.buscarCodigo(producto);
  }

  @GetMapping("marcasMasBaratas")
  public Respuesta marcasMasBaratas() {
    return implementacion.marcaMasBarata();
  }

  @GetMapping("valorDeMarca")
  public Respuesta valorDeMarca(@RequestBody Producto producto) {
    return implementacion.valorDeMarca(producto);
  }

}
