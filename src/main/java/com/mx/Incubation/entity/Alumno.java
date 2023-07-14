package com.mx.Incubation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

  @Id
  @Column
  private String matricula;
  @Column
  private String nombre;
  @Column
  private String apellido;
  @Column
  private String genero;
  @Column
  private String ciudad;
  @Column
  private int edad;
  @Column
  private double promedio;
  @ManyToMany(mappedBy = "alumnos")
  List<Curso> cursos = new ArrayList<>();
}
