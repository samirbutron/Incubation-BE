package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDao extends JpaRepository<Alumno, String> {

}
