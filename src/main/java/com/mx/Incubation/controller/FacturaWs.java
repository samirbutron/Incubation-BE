package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Factura;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factura")
@CrossOrigin
public class FacturaWs {

  @Autowired
  ImpFactura impFactura;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impFactura.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Factura factura) {
    return impFactura.guardar(factura);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Factura factura) {
    return impFactura.editar(factura);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Factura factura) {
    return impFactura.eliminar(factura);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Factura factura) {
    return impFactura.buscar(factura);
  }

  @GetMapping("clienteMayorGasto")
  public Respuesta clienteMayorGasto() {
    return impFactura.clienteMayorGasto();
  }

  @GetMapping("gananciaDeTienda")
  public Respuesta gananciaDeTienda(@RequestBody Factura factura) {
    return impFactura.gananciaDeTienda(factura);
  }

  @GetMapping("tiendaMayorVentaArticulos")
  public Respuesta tiendaMayorVentaArticulos() {
    return impFactura.tiendaMayorVentaArticulos();
  }

  @GetMapping("articulosDeCliente")
  public Respuesta articulosDeCliente(@RequestBody Factura factura) {
    return impFactura.articulosDeCliente(factura);
  }

  @GetMapping("facturaDespuesDeFecha")
  public Respuesta facturaDespuesDeFecha(@RequestBody Factura factura) {
    return impFactura.facturaDespuesDeFecha(factura);
  }
}
