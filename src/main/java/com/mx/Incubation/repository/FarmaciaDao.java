package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaDao extends JpaRepository<Farmacia, Integer> {

  Farmacia findByCiudadAndColoniaAndCalleAndNumero(String ciudad,
      String colonia, String calle, int numero);
}
