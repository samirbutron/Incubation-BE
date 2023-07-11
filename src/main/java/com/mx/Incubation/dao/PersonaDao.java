package com.mx.Incubation.dao;

import com.mx.Incubation.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends JpaRepository<Persona, String> {

  List<Persona> findByNacionalidad(String nacionalidad);
}
