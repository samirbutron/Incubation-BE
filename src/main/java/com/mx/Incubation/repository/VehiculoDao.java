package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoDao extends JpaRepository<Vehiculo, String> {

}
