package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Farmaco;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmacoDao extends JpaRepository<Farmaco, Integer> {

  Farmaco findByNombreAndMarcaAndStockAndPrecioAndCaducidad(String nombre, String marca, int stock,
      double precio, Date caducidad);

  Farmaco<List> findByMarca(String marca);
}
