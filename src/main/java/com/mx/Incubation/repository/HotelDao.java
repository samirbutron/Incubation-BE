package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

  Hotel findByCiudadAndEstadoAndColoniaAndCalleAndNumeroAndCodigoPostal(String ciudad,
      String estado, String colonia, String calle, int numero, int codigoPostal);
}
