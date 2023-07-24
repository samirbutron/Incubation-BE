package com.mx.Incubation.service;

import com.mx.Incubation.dto.ClienteDto;
import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.repository.ClienteDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpCliente implements ClienteMethods {

  @Autowired
  ClienteDao clienteDao;

  @Override
  public Respuesta save(Cliente cliente) {
    Cliente clienteBuscado = clienteDao.findById(cliente.getEmail()).orElse(null);
    if (clienteBuscado != null) {
      return new Respuesta("ERROR", "Este Email ya esta registrado", clienteBuscado,
          false);
    } else if (clienteExiste(cliente)) {
      clienteBuscado = clienteDao.findByNombreAndApellidoPAndApellidoMAndDob(cliente.getNombre(),
          cliente.getApellidoP(),
          cliente.getApellidoM(),
          cliente.getDob());
      return new Respuesta("ERROR",
          "Este cliente ya esta registrado con otro Email", clienteBuscado, false);
    }
    clienteDao.save(cliente);
    return new Respuesta("EXITO", "El cliente se registró exitosamente", cliente, true);
  }

  @Override
  public Respuesta update(Cliente cliente) {
    Cliente clienteBuscado = clienteDao.findById(cliente.getEmail()).orElse(null);
    if (clienteBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el cliente con este Email", null,
          false);
    }
    if (!clienteBuscado.getEmail().equals(cliente.getEmail())) {
      return new Respuesta("ERROR", "El Email no se puede cambiar", clienteBuscado, false);
    }
    if (clienteExiste(cliente)) {
      return new Respuesta("EXITO", "Este cliente se guardo sin cambios",
          clienteBuscado, true);
    }
    clienteDao.save(cliente);
    return new Respuesta("EXITO", "El cliente se actualizó exitosamente", cliente, true);
  }

  @Override
  public Respuesta delete(Cliente cliente) {
    Cliente clienteBuscado = clienteDao.findById(cliente.getEmail()).orElse(null);
    if (clienteBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el cliente con este Email", null,
          false);
    } else if (!clienteBuscado.getHoteles().isEmpty()) {
      return new Respuesta("ERROR", "No se puede eliminar un cliente con clientes", clienteBuscado,
          false);
    }
    clienteDao.delete(cliente);
    return new Respuesta("EXITO", "El cliente se eliminó exitosamente", cliente, true);
  }

  @Override
  public Respuesta search(Cliente gym) {
    Cliente clienteBuscado = clienteDao.findById(gym.getEmail()).orElse(null);
    if (clienteBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el cliente con este Email", null,
          false);
    }
    ClienteDto cliente = new ClienteDto(clienteBuscado);
    return new Respuesta("EXITO", "El cliente se encontró exitosamente", cliente, true);
  }

  @Override
  public Respuesta show() {
    List<Cliente> clientes = clienteDao.findAll();
    if (clientes.isEmpty()) {
      return new Respuesta("EXITO", "No existen cliente en el registro", null, true);
    }
    List<ClienteDto> clienteDtoList = new ArrayList<>();
    for (Cliente cliente : clientes) {
      clienteDtoList.add(new ClienteDto(cliente));
    }
    return new Respuesta("EXITO", "Se encontraron los siguientes clientes", clienteDtoList, true);
  }

  private boolean clienteExiste(Cliente cliente) {
    Cliente searchedCliente = clienteDao.findByNombreAndApellidoPAndApellidoMAndDob(
        cliente.getNombre(),
        cliente.getApellidoP(), cliente.getApellidoM(),
        cliente.getDob());
    return searchedCliente != null;
  }
}
