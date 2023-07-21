package com.mx.Incubation.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Respuesta {

  private String tipo; //ERROR, INFO, EXITO...
  private String mensaje;
  private Object obj;
  private boolean flag;  //true para exito, false para fracaso

  @Override
  public String toString() {
    return tipo + ": " + mensaje + "\n con el objeto: " + obj + "codigo :" + flag;
  }
}
