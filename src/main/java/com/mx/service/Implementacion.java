package com.mx.service;

import com.mx.entidad.Alumno;
import com.mx.entidad.Curso;
import com.mx.metodos.MetodosGenericos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Implementacion implements MetodosGenericos {
  private static Implementacion instance;
  private HashMap<String, Alumno> alumnoHashMap = new HashMap<>();
  private List<Curso> cursoList = new ArrayList<>();

  public static Implementacion getInstance(){
    if (instance == null){
      instance = new Implementacion();
    }
    return instance;
  }

  public Implementacion() {
    Alumno alumno1 = new Alumno("CURP1", "Juan", "Perez", 20);
    alumnoHashMap.put(alumno1.getCurp(), alumno1);
    Alumno alumno2 = new Alumno("CURP2", "Maria", "Lopez", 22);
    alumnoHashMap.put(alumno2.getCurp(), alumno2);
    Alumno alumno3 = new Alumno("CURP3", "Pedro", "Gomez", 19);
    alumnoHashMap.put(alumno3.getCurp(), alumno3);
    Alumno alumno4 = new Alumno("CURP4", "Ana", "Martinez", 21);
    alumnoHashMap.put(alumno4.getCurp(), alumno4);
    Alumno alumno5 = new Alumno("CURP5", "Luis", "Rodriguez", 23);
    alumnoHashMap.put(alumno5.getCurp(), alumno5);

    Curso curso1 = new Curso("Matemáticas", "Ciencias", 4, 60);
    cursoList.add(curso1);
    Curso curso2 = new Curso("Historia", "Humanidades", 3, 45);
    cursoList.add(curso2);
    Curso curso3 = new Curso("Programación", "Informática", 5, 75);
    cursoList.add(curso3);
    Curso curso4 = new Curso("Inglés", "Idiomas", 2, 30);
    cursoList.add(curso4);
    Curso curso5 = new Curso("Economía", "Ciencias Sociales", 3, 45);
    cursoList.add(curso5);
  }

  @Override
  public void guardar(Object obj, String clase) {
    if (clase.equalsIgnoreCase("alumno")){
      //Proces ode verificacion para guardar Alumno
      Alumno alumno = (Alumno) obj;
      //Revisamos si el hasmap esta vacio -> Si = Agregamos de inmediato
      if (alumnoHashMap.isEmpty()){
        alumnoHashMap.put(alumno.getCurp(), alumno);
        System.out.println("El alumno se registro de manera satisfactoria");
      }else {
        //Caso contrario revisamos si ya existe el CURP como llave
        if(alumnoHashMap.containsKey(alumno.getCurp())){
          System.out.println("Este CURP ya se encuentra en registro");
        } else {
          boolean existe = false;
          //De otra forma revisamos si ya existe un alumno con nombres y apellidos
          for (Alumno a : alumnoHashMap.values()){
            if(a.getNombre().equals(alumno.getNombre()) && a.getApellido().equals(alumno.getApellido())){
              System.out.println("Ya existe un alumno con ese Nombre y Apellido");
              existe = true;
              break;
            }
          }
          //En el caso de que no exista ni CURP ni Alumno por nombre y Apellido lo agregamos
          if (!existe) {
            alumnoHashMap.put(alumno.getCurp(), alumno);
            System.out.println("Alumno agregado exitosamente");
          }
        }
      }
    }else {
      //Aplicamos una logica de verificacion similar para curso...
      Curso curso = (Curso) obj;
      if(cursoList.isEmpty()){
        cursoList.add(curso);
        System.out.println("El curso se registro de manera satisfactoria");
      } else {
        boolean existe = false;
        for (Curso c : cursoList){
          if (c.getNombre().equals(curso.getNombre())){
            System.out.println("Ya existe un curso con ese nombre");
            existe = true;
            break;
          }
        }
        if (!existe){
          cursoList.add(curso);
          System.out.println("El curso se registro de manera satisfactoria");
        }
      }
    }
  }

  @Override
  public void editar(Object obj, int indice, String clase) {
    if(clase.equalsIgnoreCase("alumno")){
      Alumno alumno = (Alumno) obj;
      alumnoHashMap.put(alumno.getCurp(),alumno);
      System.out.println("Se edito el alumno");
    } else {
      Curso curso = (Curso) obj;
      cursoList.set(indice,curso);
      System.out.println("Se edito el curso");
    }
  }

  @Override
  public void eliminar(Object obj, int indice, String clase) {
    if(clase.equalsIgnoreCase("alumno")){
      Alumno alumno = (Alumno) obj;
      alumnoHashMap.remove(alumno.getCurp());
      System.out.println("Se elimino el alumno");
    }else {
      cursoList.remove(indice);
      System.out.println("Se elimino el curso");
    }
  }

  @Override
  public Object buscar(Object obj, int indice, String clase) {
    if(clase.equalsIgnoreCase("alumno")){
      Alumno alumno = (Alumno) obj;
      if(alumnoHashMap.containsKey(alumno.getCurp())){
        alumno = alumnoHashMap.get(alumno.getCurp());
        return alumno;
      } else {
        alumno = null;
        return alumno;
      }
    }else {
      Curso curso = null;
      if (cursoList.size() <= indice){
      } else {
        curso = cursoList.get(indice);
      }
      return curso;
    }
  }


  @Override
  public void mostrar(String clase) {
    if(clase.equalsIgnoreCase("alumno")){
      for(Alumno a : alumnoHashMap.values()){
        System.out.println(a.toString());
      }
    }else {
      for(Curso c : cursoList){
        System.out.println(c);
      }
    }
  }

  public void listar(String clase) {
    if(clase.equalsIgnoreCase("alumno")){
     if(alumnoHashMap.isEmpty()) {
       System.out.println("No existen alumnos para listar");
     } else {
       for (Alumno a : alumnoHashMap.values()) {
         System.out.println("["+a.getCurp()+"]"+ a.getNombre()+" "+a.getApellido());
       }
     }
    } else {
      if(cursoList.isEmpty()) {
        System.out.println("No existen cursos para listar");
      } else {
        for (Curso c : cursoList) {
          System.out.println("[" + c.getNombre() + "]" + c.getCategoria() + ", creditos: " + c.getCreditos());
        }
      }
    }
  }

}
