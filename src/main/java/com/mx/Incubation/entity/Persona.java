package com.mx.Incubation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

  @Id
  private String curp;
  private String nombre;
  private String apellido;
  /*Anotacion para mapear con la base de datos (que no funciono)
  @Column(name = "FECHA_NACIMIENTO")
    Anotacion para reconocer formato de fecha
  @JsonFormat(pattern = "yyyy-MM-dd")
  */
  private Date fecha_nacimiento;
  private String genero;
  private double peso;
  private String nacionalidad;
}
