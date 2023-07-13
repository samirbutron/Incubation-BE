package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends JpaRepository<Persona, String> {

}
