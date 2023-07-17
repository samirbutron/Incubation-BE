package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoraDao extends JpaRepository<Computadora, String> {

}
