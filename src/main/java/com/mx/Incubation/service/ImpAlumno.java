package com.mx.Incubation.service;

import com.mx.Incubation.entity.Alumno;
import com.mx.Incubation.entity.Curso;
import com.mx.Incubation.repository.AlumnoDao;
import com.mx.Incubation.response.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAlumno implements MetodosAlumno {

  @Autowired
  AlumnoDao alumnoDao;

  public Respuesta guardar(Alumno alumno) {
    for (Alumno a : alumnoDao.findAll()) {
      if (alumno.getMatricula().equals(a.getMatricula())) {
        return new Respuesta("ERROR", "Esta matricula ya esta registrada", a, 0);
      }
    }
    alumnoDao.save(alumno);
    return new Respuesta("EXITO", "El alumno se guardo", alumno, 1);
  }

  @Override
  public Respuesta editar(Alumno alumno) {
    Alumno alumnoBuscado = alumnoDao.findById(alumno.getMatricula()).orElse(null);
    if (alumnoBuscado == null) {
      return new Respuesta("ERROR", "No existe el alumno que se desea editar", null, 0);
    }
    alumnoDao.save(alumno);
    return new Respuesta("EXITO", "El alumno se edito", alumno, 1);
  }

  @Override
  public Respuesta eliminar(Alumno alumno) {
    Alumno alumnoBuscado = alumnoDao.findById(alumno.getMatricula()).orElse(null);
    if (alumnoBuscado == null) {
      return new Respuesta("ERROR", "No existe el alumno que se desea eliminar", null, 0);
    } else if (!alumnoBuscado.getCursos().isEmpty()) {
      for (Curso c : alumnoBuscado.getCursos()) {
        c.getAlumnos().remove(alumnoBuscado);
      }
    }
    alumnoDao.delete(alumno);
    return new Respuesta("EXITO", "El alumno se elimino", alumnoBuscado, 1);
  }

  @Override
  public Respuesta buscar(Alumno alumno) {
    Alumno alumnoBuscado = alumnoDao.findById(alumno.getMatricula()).orElse(null);
    if (alumnoBuscado == null) {
      return new Respuesta("ERROR", "No existe el alumno buscado", alumnoBuscado, 0);
    }
    return new Respuesta("EXITO", "El alumno se encontro", alumnoBuscado, 1);
  }

  @Override
  public Respuesta mostrar() {
    return new Respuesta("EXITO", "Se encontraron los siguientes alumnos", alumnoDao.findAll(), 1);
  }
}
