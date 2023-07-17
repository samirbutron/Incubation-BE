package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Hardware;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImplementacionHardware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hardware")
@CrossOrigin
public class HardwareWs {

  @Autowired
  ImplementacionHardware impHardware;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impHardware.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Hardware hardware) {
    return impHardware.guardar(hardware);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Hardware hardware) {
    return impHardware.editar(hardware);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Hardware hardware) {
    return impHardware.eliminar(hardware);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Hardware hardware) {
    return impHardware.buscar(hardware);
  }

  @GetMapping("componenteMayorCosto")
  public Respuesta componenteMayorCosto() {
    return impHardware.componenteMayorCosto();
  }
}
