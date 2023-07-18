package com.mx.Incubation.service;

import com.mx.Incubation.dao.LibroDao;
import com.mx.Incubation.entity.Libro;
import com.mx.Incubation.response.Respuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Implementacion implements Metodos {

  @Autowired
  LibroDao libroDao;

  @Override
  public Respuesta guardar(Libro libro) {
    List<Libro> list = libroDao.findAll();
    for (Libro l : list) {
      if (l.equals(libro) || l.getFolio().equals(libro.getFolio())) {
        return new Respuesta("ERROR", "El folio o libro ya existe en el registro", l, 0);
      }
    }
    libroDao.save(libro);
    return new Respuesta("EXITO", "El libro se guardo en el registro", libro, 1);
  }

  @Override
  public Respuesta editar(Libro libro) {
    if (libroDao.findById(libro.getFolio()).isEmpty()) {
      return new Respuesta("ERROR", "El libro buscado no existe en el registro", libro, 0);
    } else {
      libroDao.save(libro);
      return new Respuesta("EXITO", "El libro se edito en el registro", libro, 1);
    }
  }

  @Override
  public Respuesta eliminar(Libro libro) {
    if (libroDao.findById(libro.getFolio()).isEmpty()) {
      return new Respuesta("ERROR", "El libro buscado no existe en el registro", libro, 0);
    } else {
      libroDao.delete(libro);
      return new Respuesta("EXITO", "El libro se borro del registro", libro, 1);
    }
  }

  @Override
  public Respuesta buscar(Libro libro) {
    libro = libroDao.findById(libro.getFolio()).orElse(null);
    if (libro == null) {
      return new Respuesta("ERROR", "El libro buscado no existe en el registro", null, 0);
    } else {
      return new Respuesta("EXITO", "El libro buscado existe en el registro", libro, 1);
    }
  }

  @Override
  public Respuesta mostrar() {
    List<Libro> list = libroDao.findAll();
    if (list.isEmpty()) {
      return new Respuesta("INFO", "No existen libros en el registro", null, 0);
    } else {
      return new Respuesta("EXITO", "Se encontraron los siguientes libros :", list, 1);
    }
  }

}

