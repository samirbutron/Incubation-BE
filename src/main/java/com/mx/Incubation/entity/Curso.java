package com.mx.Incubation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

  @Id
  @Column
  private int nrc;
  @Column
  private String curso;
  @Column
  private int creditos;
  @Column
  private String tipo;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "alumno_curso", //tabla en DB
      joinColumns =
      @JoinColumn(name = "curso_nrc" //nombre en base de datos
          , referencedColumnName = "nrc" //id dentro de Java
      ),
      inverseJoinColumns =
      @JoinColumn(name = "alumno_matricula", //nombre en base de datos
          referencedColumnName = "matricula" //id dentro de Java
      )
  )
  @JsonIgnore
  private List<Alumno> alumnos = new ArrayList<>();
}
