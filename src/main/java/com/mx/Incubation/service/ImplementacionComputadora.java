package com.mx.Incubation.service;

import com.mx.Incubation.entity.Computadora;
import com.mx.Incubation.entity.Hardware;
import com.mx.Incubation.repository.ComputadoraDao;
import com.mx.Incubation.response.Respuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementacionComputadora implements MetodosComputadora {

  @Autowired
  ComputadoraDao computadoraDao;

  @Override
  public Respuesta guardar(Computadora computadora) {
    for (Computadora c : computadoraDao.findAll()) {
      if (computadora.getDireccionMac().equals(c.getDireccionMac())) {
        return new Respuesta("ERROR", "Esta MAC ya esta utilizada", c, false);
      }
    }
    computadoraDao.save(computadora);
    return new Respuesta("EXITO", "La computadora fue guardada", computadora, true);
  }

  @Override
  public Respuesta editar(Computadora computadora) {
    Computadora computadoraBuscada = computadoraDao.findById(computadora.getDireccionMac())
        .orElse(null);
    if (computadoraBuscada == null) {
      return new Respuesta("ERROR", "La computadora a editar no existe", null, false);
    }
    computadoraDao.save(computadora);
    return new Respuesta("EXITO", "La computadora se edito", computadora, true);
  }

  @Override
  public Respuesta eliminar(Computadora computadora) {
    Computadora computadoraBuscada = computadoraDao.findById(computadora.getDireccionMac())
        .orElse(null);
    if (computadoraBuscada == null) {
      return new Respuesta("ERROR", "La computadora a eliminar no existe", null, false);
    } else if (!computadoraBuscada.getHardware().isEmpty()) {
      for (Hardware h : computadora.getHardware()) {
        h.getComputadoras().remove(computadoraBuscada);
      }
    }
    computadoraDao.delete(computadora);
    return new Respuesta("EXITO", "La computadora se elimino", computadora, true);
  }

  @Override
  public Respuesta buscar(Computadora computadora) {
    Computadora computadoraBuscada = computadoraDao.findById(computadora.getDireccionMac())
        .orElse(null);
    if (computadoraBuscada == null) {
      return new Respuesta("ERROR", "La computadora a buscar no existe", null, false);
    }
    computadoraDao.save(computadora);
    return new Respuesta("EXITO", "La computadora se encontro", computadora, true);
  }

  @Override
  public Respuesta mostrar() {
    return new Respuesta("EXITO", "Se encontraron las siguientes computadoras",
        computadoraDao.findAll(), true);
  }

  @Override
  public Respuesta precioDePC(Computadora computadora) {
    Computadora computadoraBuscada = computadoraDao.findById(computadora.getDireccionMac())
        .orElse(null);
    if (computadoraBuscada == null) {
      return new Respuesta("ERROR", "No se encontro ninguna computadora", null, false);
    }
    int sum = computadoraBuscada.getHardware().stream().mapToInt(Hardware::getPrecio).sum();
    return new Respuesta("EXITO", "El costo de dicha computadora es", sum, true);
  }

  @Override
  public Respuesta computadoraDeMarca(Computadora computadora) {
    List<Computadora> computadoraList = computadoraDao.findAll();
    if (computadoraList.isEmpty()) {
      return new Respuesta("ERROR", "No hay computadoras en registro", null, false);
    }
    List<Computadora> computadorasDeMarca = computadoraList.stream()
        .filter(c -> c.getMarca().equals(computadora.getMarca())).toList();
    return new Respuesta("EXITO", "Se encontraron las siguientes computadoras", computadorasDeMarca,
        true);
  }

  @Override
  public Respuesta pcMayorPrecio() {
    List<Computadora> computadoraList = computadoraDao.findAll();
    if (computadoraList.isEmpty()) {
      return new Respuesta("ERROR", "No hay computadoras en registro", null, false);
    }
    int costoMaximo = computadoraList.stream()
        .mapToInt(computadora ->
            computadora.getHardware().stream()
                .mapToInt(Hardware::getPrecio)
                .sum())
        .max()
        .orElse(0);
    List<Computadora> computadorasMayorPrecio = computadoraList.stream()
        .filter(computadora ->
            computadora.getHardware().stream()
                .mapToDouble(Hardware::getPrecio)
                .sum() == costoMaximo)
        .toList();
    return new Respuesta("EXITO", "Las computadoras de mayor precio son las siguientes",
        computadorasMayorPrecio, true);
  }
}
