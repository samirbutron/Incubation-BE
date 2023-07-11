package com.mx.Incubation.service;

import com.mx.Incubation.dao.PersonaDao;
import com.mx.Incubation.entity.Persona;
import com.mx.Incubation.response.Respuesta;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Implementacion implements Metodos {

  @Autowired
  PersonaDao personaDao;

  @Override
  public Respuesta guardar(Persona persona) {
    List<Persona> personaList = personaDao.findAll();
    LocalDate now = LocalDate.now();
    LocalDate fechaNacimiento = persona.getFecha_nacimiento().toLocalDate();
    if (Period.between(fechaNacimiento, now).getYears() < 18) {
      return new Respuesta("ERROR", "La persona es menor de edad", persona, 0);
    }
    for (Persona p : personaList) {
      if (p.getCurp().equals(persona.getCurp())) {
        return new Respuesta("ERROR", "El curp ya existe en el registro", p, 0);
      } else if (p.getNombre().equals(persona.getNombre()) && p.getApellido()
          .equals(persona.getApellido())) {
        return new Respuesta("ERROR", "La persona ya existe en el registro", p, 0);
      }
    }
    personaDao.save(persona);
    return new Respuesta("EXITO", "La persona se agrego en el registro", persona, 1);
  }

  @Override
  public Respuesta editar(Persona persona) {
    if (personaDao.findById(persona.getCurp()).isEmpty()) {
      return new Respuesta("ERROR", "La persona buscada no existe en el registro", persona, 0);
    } else {
      personaDao.save(persona);
      return new Respuesta("EXITO", "La persona se edito en el registro", persona, 1);
    }
  }

  @Override
  public Respuesta eliminar(Persona persona) {
    persona = personaDao.findById(persona.getCurp()).orElse(null);
    if (persona == null) {
      return new Respuesta("ERROR", "La persona buscada no existe en el registro", null, 0);
    } else {
      personaDao.delete(persona);
      return new Respuesta("EXITO", "La persona se elimino del registro", persona, 1);
    }
  }

  @Override
  public Respuesta buscar(Persona persona) {
    persona = personaDao.findById(persona.getCurp()).orElse(null);
    if (persona == null) {
      return new Respuesta("ERROR", "La persona buscada no existe en el registro", null, 0);
    } else {
      return new Respuesta("EXITO", "La persona se encontro en el registro", persona, 1);
    }
  }

  public Respuesta buscarPorNacionalidad(Persona persona) {
    List<Persona> personaList = personaDao.findByNacionalidad(persona.getNacionalidad());
    if (personaList.isEmpty()) {
      return new Respuesta("INFO", "No existen personas en el registro", null, 0);
    } else {
      return new Respuesta("EXITO",
          "Se encontraron las siguientes personas con dicha nacionalidad: ", personaList, 1);
    }
  }

  @Override
  public Respuesta mostrar() {
    List<Persona> personaList = personaDao.findAll();
    if (personaList.isEmpty()) {
      return new Respuesta("INFO", "No existen personas en el registro", null, 0);
    } else {
      return new Respuesta("EXITO", "Se encontraron las siguientes personas: ", personaList, 1);
    }
  }
}
