package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Cliente;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, String> {

  Cliente findByNombreAndApellidoPAndApellidoMAndDob(String nombre, String apellidoP,
      String apellidoM,
      Date DOB);
}
