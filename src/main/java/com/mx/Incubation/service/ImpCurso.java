package com.mx.Incubation.service;

import com.mx.Incubation.entity.Alumno;
import com.mx.Incubation.entity.Curso;
import com.mx.Incubation.peticion.Peticion;
import com.mx.Incubation.repository.AlumnoDao;
import com.mx.Incubation.repository.CursoDao;
import com.mx.Incubation.response.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpCurso implements MetodosCurso {

  @Autowired
  CursoDao cursoDao;

  @Autowired
  AlumnoDao alumnoDao;

  @Override
  public Respuesta guardar(Curso curso) {
    for (Curso c : cursoDao.findAll()) {
      if (curso.getNrc() == c.getNrc()) {
        return new Respuesta("ERROR", "Este NRC ya esta registrado", c, 0);
      } else if (curso.getCurso().equals(c.getCurso())) {
        return new Respuesta("ERROR", "Este curso ya esta registrado", c, 0);
      }
    }
    cursoDao.save(curso);
    return new Respuesta("EXITO", "El curso se guardo", curso, 1);
  }

  @Override
  public Respuesta editar(Curso curso) {
    Curso cursoBuscado = cursoDao.findById(curso.getNrc()).orElse(null);
    if (cursoBuscado == null) {
      return new Respuesta("ERROR", "No existe el curso que se desea editar", null, 0);
    }
    cursoDao.save(curso);
    return new Respuesta("EXITO", "El curso se edito", curso, 1);
  }

  @Override
  public Respuesta eliminar(Curso curso) {
    Curso cursoBuscado = cursoDao.findById(curso.getNrc()).orElse(null);
    if (cursoBuscado == null) {
      return new Respuesta("ERROR", "No existe el curso que se desea eliminar", null, 0);
    } else if (!cursoBuscado.getAlumnos().isEmpty()) {
      for (Alumno a : cursoBuscado.getAlumnos()) {
        a.getCursos().remove(cursoBuscado);
      }
    }
    cursoDao.delete(curso);
    return new Respuesta("EXITO", "El curso se elimino", cursoBuscado, 1);
  }

  @Override
  public Respuesta buscar(Curso curso) {
    Curso cursoBuscado = cursoDao.findById(curso.getNrc()).orElse(null);
    if (cursoBuscado == null) {
      return new Respuesta("ERROR", "No existe el curso buscado", null, 0);
    }
    return new Respuesta("EXITO", "El curso se encontro", cursoBuscado, 1);
  }

  @Override
  public Respuesta mostrar() {
    return new Respuesta("EXITO", "Se encontraron los siguientes cursos", cursoDao.findAll(), 1);
  }

  //Mejores practicas par este metodo? No instanciar alumnoDao
  public Respuesta inscripcion(Peticion peticion) {
    Curso cursoBuscado = cursoDao.findById(peticion.getNrcCurso()).orElse(null);
    Alumno alumnoBuscado = alumnoDao.findById(peticion.getMatriculaAlumno()).orElse(null);
    if (cursoBuscado != null && alumnoBuscado != null) {
      cursoBuscado.getAlumnos().add(alumnoBuscado);
      cursoDao.save(cursoBuscado);
      return new Respuesta("EXITO", "El alumno fue inscrito en el curso", cursoBuscado, 1);
    }
    if (cursoBuscado == null) {
      return new Respuesta("ERROR", "El curso no existe", null, 0);
    } else {
      return new Respuesta("ERROR", "El alumno no existe", null, 0);
    }
  }
}
