package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
@CrossOrigin
public class ClienteWS {

  @Autowired
  ImpCliente impCliente;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impCliente.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Cliente cliente) {
    return impCliente.guardar(cliente);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Cliente cliente) {
    return impCliente.editar(cliente);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Cliente cliente) {
    return impCliente.eliminar(cliente);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Cliente cliente) {
    return impCliente.buscar(cliente);
  }
}
