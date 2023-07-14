package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.entity.Factura;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDao extends JpaRepository<Factura, Integer> {

  List<Factura> findByNombreTienda(String nombreTienda);

  List<Factura> findByCliente(Cliente cliente);

  List<Factura> findByFechaAfter(Date fecha);
}
