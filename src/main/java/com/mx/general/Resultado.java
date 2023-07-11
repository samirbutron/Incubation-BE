package com.mx.general;

public class Resultado {
  String mensaje;
  String respuesta;
  Object obj;

  public Resultado() {
  }

  @Override
  public String toString() {
    return "Resultado [mensaje=" + mensaje + ", respuesta=" + respuesta + ", obj=" + obj + "]\n";
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setRespuesta(String respuesta) {
    this.respuesta = respuesta;
  }

  public Object getObj() {
    return obj;
  }

  public void setObj(Object obj) {
    this.obj = obj;
  }

}
