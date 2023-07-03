package com.mx.menus;

import com.mx.entidad.Alumno;
import com.mx.entidad.Curso;
import com.mx.service.Implementacion;
import java.util.Scanner;

public class MenuCurso {


  private String nombre, categoria;
  private int creditos, horas, indice;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);
  private Curso curso = new Curso();
  public void menu() {
    {
      int opcion;
      do {
        System.out.println("\n*****Menu de curso*******");
        System.out.println("1.-Agregar Curso");
        System.out.println("2.-Editar Curso");
        System.out.println("3.-Eliminar Curso");
        System.out.println("4.-Listar Cursos");
        System.out.println("5.-Mostrar Cursos");
        System.out.println("6.-Buscar por Indice");
        System.out.println("7.-Regresar al menu principal");
        entrada = new Scanner(System.in);
        try {
          opcion = entrada.nextInt();
        } catch (Exception e) {
          opcion = 0;
        }
        switch (opcion) {
          case 1:
            System.out.println("Ingresa el nombre");
            entrada = new Scanner(System.in);
            nombre = entrada.nextLine();
            System.out.println("Ingresa el categoria");
            entrada = new Scanner(System.in);
            categoria = entrada.nextLine();
            System.out.println("Ingresa los creditos");
            entrada = new Scanner(System.in);
            creditos = entrada.nextInt();
            System.out.println("Ingresa las horas");
            entrada = new Scanner(System.in);
            horas = entrada.nextInt();
            curso = new Curso(nombre, categoria, creditos, horas);
            implementacion.guardar(curso, "curso");
            break;
          case 2:
            System.out.println("Ingresa Indice del curso a editar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            curso = (Curso) implementacion.buscar(curso, indice, "curso");
            if (curso == null) {
              System.out.println("El curso que tratas de editar no existe");
            } else {
              menuEditarCurso(curso);
            }
            break;
          case 3:
            System.out.println("Ingresa el Indice del curso a eliminar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            curso = (Curso) implementacion.buscar(curso, indice, "curso");
            if (curso == null) {
              System.out.println("El curso a eliminar no existe");
            } else {
              implementacion.eliminar(curso, indice, "curso");
              System.out.println("Se borro el curso:");
              System.out.println(curso);
            }
            break;
          case 4:
            implementacion.listar("curso");
            break;
          case 5:
            implementacion.mostrar("curso");
            break;
          case 6:
            System.out.println("Ingresa el Indice de la curso a buscar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            curso = (Curso) implementacion.buscar(curso, indice, "curso");
            if (curso == null) {
              System.out.println("El curso buscado no existe");
            } else {
              System.out.println("Se encontro el curso:");
              System.out.println(curso);
            }
            break;
          case 7:
            System.out.println("Saliendo del menu Curso...");
            break;
          default:
            System.out.println("Opcion invalida, intente otra opcion");
            break;
        }
      } while (opcion != 7);
    }
  }

    private void menuEditarCurso(Curso curso){
      int opcion;
      do {
        System.out.println("Menu editar Curso");
        System.out.println("1.-Nombre");
        System.out.println("2.- Categoria");
        System.out.println("3.- Creditos");
        System.out.println("4.- Horas");
        System.out.println("5.- Alumnos");
        System.out.println("6.- Salir");
        entrada = new Scanner(System.in);
        try {
          opcion = entrada.nextInt();
        } catch (Exception e) {
          opcion = 0;
        }
        switch (opcion) {
          case 1:
            System.out.println("Ingresa el nombre");
            entrada = new Scanner(System.in);
            nombre = entrada.nextLine();
            curso.setNombre(nombre);
            implementacion.editar(curso, indice, "curso");
            break;
          case 2:
            System.out.println("Ingresa la categoria");
            entrada = new Scanner(System.in);
            categoria = entrada.nextLine();
            curso.setCategoria(categoria);
            implementacion.editar(curso, indice, "curso");
            break;
          case 3:
            System.out.println("Ingresa los creditos");
            entrada = new Scanner(System.in);
            creditos = entrada.nextInt();
            curso.setCreditos(creditos);
            implementacion.editar(curso, indice, "curso");
            break;
          case 4:
            System.out.println("Ingresa las horas");
            entrada = new Scanner(System.in);
            horas = entrada.nextInt();
            curso.setHoras(horas);
            implementacion.editar(curso, indice, "curso");
            break;
          case 5:
            menuAlumnos(curso);
            break;
          case 6:
            System.out.println("Saliendo...");
            break;
          default:
            System.out.println("Opcion invalida, intente de nuevo");
            break;
        }
      } while (opcion != 6);
    }

  private void menuAlumnos(Curso curso){
    int opcion;
    Alumno alumno;
    String curp;
    do{
      System.out.println("Menu de edicion de alumnos");
      System.out.println("1.-Agregar alumno");
      System.out.println("2.-Remover alumno");
      System.out.println("3.-Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          System.out.println("Ingresa el curp de la alumno a agregar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          alumno = new Alumno(curp);
          alumno = (Alumno) implementacion.buscar(alumno, 1, "alumno");
          if (alumno == null || curso.getAlumnos().contains(alumno)){
            System.out.println("La alumno a agregar no existe o ya esta agregado");
          } else {
            curso.getAlumnos().add(alumno);
            System.out.println("Se agrego la siguiente alumno del curso:");
            System.out.println(alumno);
          }
          break;
        case 2:
          System.out.println("Ingresa el nombre de la alumno a retirar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          alumno = new Alumno(curp);
          alumno = (Alumno) implementacion.buscar(alumno, 1, "alumno");
          if (alumno == null || curso.getAlumnos().isEmpty()){
            System.out.println("El alumno a retirar no existe o no hay alumnos para retirar");
          } else {
            curso.getAlumnos().remove(alumno);
            System.out.println("Se retiro el siguiente alumno del curso:");
            System.out.println(alumno);
          }
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
        default:
          break;
      }
    }while (opcion != 3);
  }
}
