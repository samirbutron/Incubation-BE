package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends JpaRepository<Curso, Integer> {

}
