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
public class ClienteWs {

  @Autowired
  ImpCliente impGym;

  @GetMapping("listar")
  public Respuesta listar() {
    return impGym.show();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Cliente cliente) {
    return impGym.save(cliente);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Cliente cliente) {
    return impGym.update(cliente);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Cliente cliente) {
    return impGym.search(cliente);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Cliente cliente) {
    return impGym.delete(cliente);
  }
}
