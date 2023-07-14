package com.mx.Incubation.service;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.repository.ClienteDao;
import com.mx.Incubation.response.Respuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpCliente implements MetodosCliente {

  @Autowired
  ClienteDao clienteDao;

  @Override
  public Respuesta guardar(Cliente cliente) {
    List<Cliente> clienteList = clienteDao.findAll();
    if (!clienteList.isEmpty()) {
      for (Cliente p : clienteList) {
        if (p.getRfc().equals(cliente.getRfc())) {
          return new Respuesta("ERROR", "Este RFC ya esta registrado", cliente, 0);
        }
      }
    }
    clienteDao.save(cliente);
    return new Respuesta("EXITO", "El cliente fue agregado", cliente, 1);
  }

  @Override
  public Respuesta editar(Cliente cliente) {
    Cliente clienteBuscada = clienteDao.findById(cliente.getRfc()).orElse(null);
    if (clienteBuscada == null) {
      return new Respuesta("ERROR", "El cliente buscado no existe", cliente, 0);
    }
    clienteDao.save(cliente);
    return new Respuesta("EXITO", "El cliente se edito", cliente, 1);
  }

  @Override
  public Respuesta eliminar(Cliente cliente) {
    Cliente clienteBuscada = clienteDao.findById(cliente.getRfc()).orElse(null);
    if (clienteBuscada == null) {
      return new Respuesta("ERROR", "El cliente a eliminar no existe", cliente, 0);
    } else if (!clienteBuscada.getFacturas().isEmpty()) {
      return new Respuesta("ERROR", "El cliente aun tiene facturas", clienteBuscada, 1);
    }
    clienteDao.delete(cliente);
    return new Respuesta("EXITO", "El cliente se elimino", clienteBuscada, 1);
  }

  @Override
  public Respuesta buscar(Cliente cliente) {
    Cliente clienteBuscada = clienteDao.findById(cliente.getRfc()).orElse(null);
    if (clienteBuscada == null) {
      return new Respuesta("ERROR", "No existe una cliente con este RFC", cliente, 0);
    }
    return new Respuesta("EXITO", "El cliente se encontro", clienteBuscada, 1);
  }

  @Override
  public Respuesta mostrar() {
    List<Cliente> clienteList = clienteDao.findAll();
    if (clienteList.isEmpty()) {
      return new Respuesta("ERROR", "No hay clientes", null, 0);
    }
    return new Respuesta("EXITO", "Se encontraron las siguientes clientes", clienteList, 1);
  }
}
