package com.mx.Incubation.service;

import com.mx.Incubation.entity.Persona;
import com.mx.Incubation.repository.PersonaDao;
import com.mx.Incubation.response.Respuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersona implements MetodosPersona {

  @Autowired
  PersonaDao personaDao;

  @Override
  public Respuesta guardar(Persona persona) {
    List<Persona> personaList = personaDao.findAll();
    if (!personaList.isEmpty()) {
      for (Persona p : personaList) {
        if (p.getCurp().equals(persona.getCurp())) {
          return new Respuesta("ERROR", "Este curp ya esta registrado", persona, 0);
        }
      }
    }
    personaDao.save(persona);
    return new Respuesta("EXITO", "La persona fue agregada", persona, 1);
  }

  @Override
  public Respuesta editar(Persona persona) {
    Persona personaBuscada = personaDao.findById(persona.getCurp()).orElse(null);
    if (personaBuscada == null) {
      return new Respuesta("ERROR", "La persona buscada no existe", persona, 0);
    }
    personaDao.save(persona);
    return new Respuesta("EXITO", "La persona se edito", persona, 1);
  }

  @Override
  public Respuesta eliminar(Persona persona) {
    Persona personaBuscada = personaDao.findById(persona.getCurp()).orElse(null);
    if (personaBuscada == null) {
      return new Respuesta("ERROR", "La persona a eliminar no existe", persona, 0);
    } else if (!personaBuscada.getVehiculos().isEmpty()) {
      return new Respuesta("ERROR", "La persona aun tiene vehiculos", personaBuscada, 1);
    }
    personaDao.delete(persona);
    return new Respuesta("EXITO", "La persona se elimino", personaBuscada, 1);
  }

  @Override
  public Respuesta buscar(Persona persona) {
    Persona personaBuscada = personaDao.findById(persona.getCurp()).orElse(null);
    if (personaBuscada == null) {
      return new Respuesta("ERROR", "No existe una persona con este curp", persona, 0);
    }
    return new Respuesta("EXITO", "La persona se encontro", personaBuscada, 1);
  }

  @Override
  public Respuesta mostrar() {
    List<Persona> personaList = personaDao.findAll();
    if (personaList.isEmpty()) {
      return new Respuesta("ERROR", "No hay personas", null, 0);
    }
    return new Respuesta("EXITO", "Se encontraron las siguientes personas", personaList, 1);
  }
}
