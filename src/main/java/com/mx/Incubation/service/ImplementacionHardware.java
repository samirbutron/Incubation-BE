package com.mx.Incubation.service;

import com.mx.Incubation.entity.Computadora;
import com.mx.Incubation.entity.Hardware;
import com.mx.Incubation.repository.HardwareDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionHardware implements MetodosHardware {

  @Autowired
  HardwareDao hardwareDao;

  @Override
  public Respuesta guardar(Hardware hardware) {
    for (Hardware h : hardwareDao.findAll()) {
      if (hardware.getNumeroSerie() == h.getNumeroSerie()) {
        return new Respuesta("ERROR", "Este Numero de serie ya esta utilizado", h, false);
      }
    }
    hardwareDao
        .save(hardware);
    return new Respuesta("EXITO", "El hardware fue guardado", hardware, true);
  }

  @Override
  public Respuesta editar(Hardware hardware) {
    Hardware hardwareBuscado = hardwareDao.findById(hardware.getNumeroSerie()).orElse(null);
    if (hardwareBuscado == null) {
      return new Respuesta("ERROR", "El hardware a editar no existe", null, false);
    }
    hardwareDao.save(hardware);
    return new Respuesta("EXITO", "El hardware se edito", hardware, true);
  }

  @Override
  public Respuesta eliminar(Hardware hardware) {
    Hardware hardwareBuscado = hardwareDao
        .findById(hardware.getNumeroSerie()).orElse(null);
    if (hardwareBuscado == null) {
      return new Respuesta("ERROR", "La hardware a eliminar no existe", null, false);
    } else if (!hardwareBuscado.getComputadoras().isEmpty()) {
      for (Computadora c : hardware.getComputadoras()) {
        c.getHardware().remove(hardwareBuscado);
      }
    }
    hardwareDao.delete(hardware);
    return new Respuesta("EXITO", "La hardware se elimino", hardware, true);
  }

  @Override
  public Respuesta buscar(Hardware hardware) {
    Hardware hardwareBuscado = hardwareDao
        .findById(hardware.getNumeroSerie()).orElse(null);
    if (hardwareBuscado == null) {
      return new Respuesta("ERROR", "La hardware a buscar no existe", null, false);
    }
    hardwareDao
        .save(hardware);
    return new Respuesta("EXITO", "La hardware se encontro", hardware, true);
  }

  @Override
  public Respuesta mostrar() {
    return new Respuesta("EXITO", "Se encontraron las siguientes hardwares", hardwareDao
        .findAll(), true);
  }

  @Override
  public Respuesta componenteMayorCosto() {
    List<Hardware> hardwareList = hardwareDao.findAll();
    List<Hardware> hardwareCaro = new ArrayList<>();
    int mayorPrecio = Integer.MIN_VALUE;
    for (Hardware h : hardwareList) {
      if (h.getPrecio() > mayorPrecio) {
        hardwareCaro.clear();
        hardwareCaro.add(h);
        mayorPrecio = h.getPrecio();
      } else if (h.getPrecio() == mayorPrecio) {
        hardwareCaro.add(h);
      }
    }
    return new Respuesta("EXITO", "Este es el hardware de mayor precio", hardwareCaro, true);
  }
}
