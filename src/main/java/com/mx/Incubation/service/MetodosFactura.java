package com.mx.Incubation.service;

import com.mx.Incubation.entity.Factura;
import com.mx.Incubation.response.Respuesta;

public interface MetodosFactura {

  Respuesta guardar(Factura factura);

  Respuesta editar(Factura factura);

  Respuesta eliminar(Factura factura);

  Respuesta buscar(Factura factura);

  Respuesta mostrar();

  Respuesta clienteMayorGasto();

  Respuesta gananciaDeTienda(Factura factura);

  Respuesta tiendaMayorVentaArticulos();

  Respuesta articulosDeCliente(Factura factura);

  Respuesta facturaDespuesDeFecha(Factura factura);
}
