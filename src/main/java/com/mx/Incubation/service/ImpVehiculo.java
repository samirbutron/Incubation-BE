package com.mx.Incubation.service;

import com.mx.Incubation.entity.Vehiculo;
import com.mx.Incubation.repository.VehiculoDao;
import com.mx.Incubation.response.Respuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpVehiculo implements MetodosVehiculo {

  @Autowired
  VehiculoDao vehiculoDao;

  @Autowired
  ImpPersona impPersona;

  @Override
  public Respuesta guardar(Vehiculo vehiculo) {
    List<Vehiculo> vehiculoList = vehiculoDao.findAll();
    if (!vehiculoList.isEmpty()) {
      for (Vehiculo p : vehiculoList) {
        if (p.getMatricula().equals(vehiculo.getMatricula())) {
          return new Respuesta("ERROR", "Esta matricula ya existe", p, 0);
        }
      }
    }
    if (impPersona.buscar(vehiculo.getPersona()).getValor() == 0 && vehiculo.getPersona() != null) {
      return new Respuesta("ERROR", "La persona asociada al vehiculo no existe", vehiculo, 0);
    }
    vehiculoDao.save(vehiculo);
    return new Respuesta("EXITO", "El vehiculo fue agregado", vehiculo, 1);
  }

  @Override
  public Respuesta editar(Vehiculo vehiculo) {
    Vehiculo vehiculoBuscado = vehiculoDao.findById(vehiculo.getMatricula()).orElse(null);
    if (vehiculoBuscado == null) {
      return new Respuesta("ERROR", "El vehiculo a editar no existe", vehiculo, 0);
    } else {
      if (impPersona.buscar(vehiculo.getPersona()).getValor() == 0
          && vehiculo.getPersona() != null) {
        return new Respuesta("ERROR", "La persona a asociar el vehiculo no existe", vehiculoBuscado,
            0);
      } else {
        vehiculoDao.save(vehiculo);
        return new Respuesta("EXITO", "El vehiculo fue editado", vehiculo, 1);
      }
    }
  }

  @Override
  public Respuesta eliminar(Vehiculo vehiculo) {
    Vehiculo vehiculoBuscado = vehiculoDao.findById(vehiculo.getMatricula()).orElse(null);
    if (vehiculoBuscado == null) {
      return new Respuesta("ERROR", "El vehiculo a eliminar no existe", vehiculo, 0);
    } else {
      vehiculoDao.delete(vehiculo);
      return new Respuesta("EXITO", "El vehiculo fue eliminado", vehiculo, 1);
    }
  }

  @Override
  public Respuesta buscar(Vehiculo vehiculo) {
    Vehiculo vehiculoBuscado = vehiculoDao.findById(vehiculo.getMatricula()).orElse(null);
    if (vehiculoBuscado == null) {
      return new Respuesta("ERROR", "El vehiculo no existe", vehiculo, 0);
    } else {
      return new Respuesta("EXITO", "El vehiculo se encontro", vehiculoBuscado, 1);
    }
  }

  @Override
  public Respuesta mostrar() {
    List<Vehiculo> vehiculoList = vehiculoDao.findAll();
    if (vehiculoList.isEmpty()) {
      return new Respuesta("ERROR", "No existen vehiculos en registro", null, 0);
    } else {
      return new Respuesta("EXITO", "Los vehiculos en registro son los siguientes", vehiculoList,
          1);
    }
  }
}
