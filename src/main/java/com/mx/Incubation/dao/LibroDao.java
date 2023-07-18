package com.mx.Incubation.dao;

import com.mx.Incubation.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDao extends JpaRepository<Libro, String> {

}
