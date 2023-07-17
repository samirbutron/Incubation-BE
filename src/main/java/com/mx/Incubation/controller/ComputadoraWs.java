package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Computadora;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImplementacionComputadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("computadora")
@CrossOrigin
public class ComputadoraWs {

  @Autowired
  ImplementacionComputadora impComputadora;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impComputadora.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Computadora computadora) {
    return impComputadora.guardar(computadora);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Computadora computadora) {
    return impComputadora.editar(computadora);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Computadora computadora) {
    return impComputadora.eliminar(computadora);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Computadora computadora) {
    return impComputadora.buscar(computadora);
  }

  @GetMapping("precioDePC")
  public Respuesta precioDePC(@RequestBody Computadora computadora) {
    return impComputadora.precioDePC(computadora);
  }

  @GetMapping("computadoraDeMarca")
  public Respuesta computadoraDeMarca(@RequestBody Computadora computadora) {
    return impComputadora.computadoraDeMarca(computadora);
  }

  @GetMapping("pcMayorPrecio")
  public Respuesta pcMayorPrecio() {
    return impComputadora.pcMayorPrecio();
  }
}
