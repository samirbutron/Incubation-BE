package com.mx.Incubation.service;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.entity.Factura;
import com.mx.Incubation.repository.FacturaDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpFactura implements MetodosFactura {

  @Autowired
  FacturaDao facturaDao;

  @Autowired
  ImpCliente impCliente;

  @Override
  public Respuesta guardar(Factura factura) {
    List<Factura> facturaList = facturaDao.findAll();
    if (!facturaList.isEmpty()) {
      for (Factura p : facturaList) {
        if (p.getFolio() == factura.getFolio()) {
          return new Respuesta("ERROR", "Este folio ya existe", p, 0);
        }
      }
    }
    if (impCliente.buscar(factura.getCliente()).getValor() == 0 && factura.getCliente() != null) {
      return new Respuesta("ERROR", "El cliente asociado a la factura no existe", factura, 0);
    }
    facturaDao.save(factura);
    return new Respuesta("EXITO", "La factura fue agregada", factura, 1);
  }

  @Override
  public Respuesta editar(Factura factura) {
    Factura facturaBuscado = facturaDao.findById(factura.getFolio()).orElse(null);
    if (facturaBuscado == null) {
      return new Respuesta("ERROR", "La factura a editar no existe", factura, 0);
    } else {
      if (factura.getCliente() != null) {
        if (impCliente.buscar(factura.getCliente()).getValor() == 0) {
          return new Respuesta("ERROR", "El cliente a asociar la factura no existe", facturaBuscado,
              0);
        }
      }
      facturaDao.save(factura);
      return new Respuesta("EXITO", "La factura fue editada", factura, 1);
    }
  }

  @Override
  public Respuesta eliminar(Factura factura) {
    Factura facturaBuscado = facturaDao.findById(factura.getFolio()).orElse(null);
    if (facturaBuscado == null) {
      return new Respuesta("ERROR", "La factura a eliminar no existe", factura, 0);
    } else {
      facturaDao.delete(factura);
      return new Respuesta("EXITO", "La factura fue eliminada", factura, 1);
    }
  }

  @Override
  public Respuesta buscar(Factura factura) {
    Factura facturaBuscado = facturaDao.findById(factura.getFolio()).orElse(null);
    if (facturaBuscado == null) {
      return new Respuesta("ERROR", "La factura no existe", factura, 0);
    } else {
      return new Respuesta("EXITO", "La factura se encontro", facturaBuscado, 1);
    }
  }

  @Override
  public Respuesta mostrar() {
    List<Factura> facturaList = facturaDao.findAll();
    if (facturaList.isEmpty()) {
      return new Respuesta("ERROR", "No existen facturas en registro", null, 0);
    } else {
      return new Respuesta("EXITO", "Los facturas en registro son las siguientes", facturaList,
          1);
    }
  }

  @Override
  public Respuesta clienteMayorGasto() {
    List<Factura> facturas = facturaDao.findAll();
    if (facturas.isEmpty()) {
      return new Respuesta("ERROR", "No existen facturas en registro", null, 0);
    }
    HashMap<Cliente, Double> clientesMap = new HashMap<>();
    for (Factura f : facturas) {
      if (clientesMap.containsKey(f.getCliente())) {
        double newValue = clientesMap.get(f.getCliente()) + f.getTotal();
        clientesMap.put(f.getCliente(), newValue);
      } else {
        clientesMap.put(f.getCliente(), f.getTotal());
      }
    }
    List<Cliente> clientesMayorGastoList = new ArrayList<>();
    double maxGasto = Double.MIN_VALUE;
    for (Cliente cliente : clientesMap.keySet()) {
      if (clientesMap.get(cliente) == maxGasto) {
        clientesMayorGastoList.add(cliente);
      } else if (clientesMap.get(cliente) > maxGasto) {
        maxGasto = clientesMap.get(cliente);
        clientesMayorGastoList.clear();
        clientesMayorGastoList.add(cliente);
      }
    }
    return new Respuesta("EXITO", "Los clientes de mayor gasto son los siguientes",
        clientesMayorGastoList, 1);
  }

  @Override
  public Respuesta gananciaDeTienda(Factura factura) {
    List<Factura> facturasTienda = facturaDao.findByNombreTienda(factura.getNombreTienda());
    if (facturasTienda.isEmpty()) {
      return new Respuesta("ERROR", "No existen facturas de esa tienda", null, 0);
    }
    double ganancia = 0;
    for (Factura f : facturasTienda) {
      ganancia += f.getTotal();
    }
    return new Respuesta("EXITO", "La tienda obtuvo el siguiente ingreso",
        factura.getNombreTienda() + " : " + ganancia, 1);
  }

  @Override
  public Respuesta tiendaMayorVentaArticulos() {
    List<Factura> facturas = facturaDao.findAll();
    if (facturas.isEmpty()) {
      return new Respuesta("ERROR", "No existen facturas en registro", null, 0);
    }
    HashMap<String, Integer> tiendasMap = new HashMap<>();
    for (Factura f : facturas) {
      if (tiendasMap.containsKey(f.getNombreTienda())) {
        int newValue = tiendasMap.get(f.getNombreTienda()) + f.getNoArticulos();
        tiendasMap.put(f.getNombreTienda(), newValue);
      } else {
        tiendasMap.put(f.getNombreTienda(), f.getNoArticulos());
      }
    }
    List<String> tiendasMayorVentaArticulos = new ArrayList<>();
    int maxArticulos = Integer.MIN_VALUE;
    for (String tienda : tiendasMap.keySet()) {
      if (tiendasMap.get(tienda) == maxArticulos) {
        tiendasMayorVentaArticulos.add(tienda);
      } else if (tiendasMap.get(tienda) > maxArticulos) {
        maxArticulos = tiendasMap.get(tienda);
        tiendasMayorVentaArticulos.clear();
        tiendasMayorVentaArticulos.add(tienda);
      }
    }
    return new Respuesta("EXITO", "Las tiendas de mayor venta de articulos son los siguientes",
        tiendasMayorVentaArticulos, 1);
  }

  @Override
  public Respuesta articulosDeCliente(Factura factura) {
    List<Factura> facturas = facturaDao.findByCliente(factura.getCliente());
    if (facturas.isEmpty()) {
      return new Respuesta("ERROR", "No existen facturas en registro", null, 0);
    }
    int articulosSum = 0;
    for (Factura f : facturas) {
      articulosSum += f.getNoArticulos();
    }
    return new Respuesta("EXITO", "Esta es la cantida de articulos para el cliente", articulosSum,
        1);
  }

  @Override
  public Respuesta facturaDespuesDeFecha(Factura factura) {
    List<Factura> facturas = facturaDao.findByFechaAfter(factura.getFecha());
    if (facturas.isEmpty()) {
      return new Respuesta("ERROR", "No existen facturas en registro", null, 0);
    }
    return new Respuesta("EXITO", "Estas son las facturas despues de la fecha ingresada", facturas,
        1);
  }
}
