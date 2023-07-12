package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Integer> {

  List<Producto> findByMarca(String marca);

  List<Producto> findByPrecioPublicoLessThan(double precio);

  Producto findByNombreAndMarca(String nombre, String marca);
}
