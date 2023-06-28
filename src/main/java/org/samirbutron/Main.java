package org.samirbutron;

import classes.Alumno;
import classes.Profesor;
import com.sun.management.UnixOperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    String nombre, apellido, grupo, materia;
    int grado, materias, edad, menu, menuA, menuP, submenu, indice, indice2;
    double promedio, sueldo;
    boolean existe = false;
    List<Alumno> alumnos;

    List<Alumno> estudiantes = new ArrayList<Alumno>();
    Alumno alumno1 = new Alumno("Juanito", "Perez", 15, 9.6, 5, "Azul", 6);
    Alumno alumno2 = new Alumno("Perengano", "Ramirez", 13, 7.6, 5, "Rojo", 6);
    estudiantes.add(alumno1);
    estudiantes.add(alumno2);
    List<Profesor> profesores = new ArrayList<Profesor>();
    Profesor profesor1 = new Profesor("Sutano", "Hernandez", 45, "Matematicas",15000, estudiantes);
    Profesor profesor2 = new Profesor("Ignacio", "Belafonte", 37, "Espanol", 16000, estudiantes);
    profesores.add(profesor1);
    profesores.add(profesor2);

    Alumno alumno;
    Profesor profesor;

    do{
      System.out.println("\n Menu principal");
      System.out.println("1.-Registro de Alumnos");
      System.out.println("2.-Registro de Profesores");
      System.out.println("3.-Salir");
      menu = entrada.nextInt();

      switch (menu) {
        case 1:
          do {
            System.out.println("Menu de alumnos");
            System.out.println("1.-Agregar");
            System.out.println("2.-Editar");
            System.out.println("3.-Buscar");
            System.out.println("4.-Eliminar");
            System.out.println("5.-Listar");
            System.out.println("6.-Mostrar");
            System.out.println("7.-Buscar por Nombre");
            System.out.println("8.-Regresar al menu principal");
            entrada = new Scanner(System.in);
            menuA = entrada.nextInt();

            switch (menuA) {
              case 1:
                System.out.println("Ingresa el nombre");
                entrada = new Scanner(System.in);
                nombre = entrada.nextLine();

                System.out.println("Ingresa el apellido");
                entrada = new Scanner(System.in);
                apellido = entrada.nextLine();

                System.out.println("Ingrese la edad");
                entrada = new Scanner(System.in);
                edad = entrada.nextInt();

                System.out.println("Ingrese el promedio");
                entrada = new Scanner(System.in);
                promedio = entrada.nextDouble();

                System.out.println("Ingrese el grado");
                entrada = new Scanner(System.in);
                grado = entrada.nextInt();

                System.out.println("Ingrese el grupo");
                entrada = new Scanner(System.in);
                grupo = entrada.nextLine();

                System.out.println("Ingrese las materias");
                entrada = new Scanner(System.in);
                materias = entrada.nextInt();

                alumno = new Alumno(nombre, apellido, edad, promedio, grado, grupo, materias);
                for (Alumno a : estudiantes) {
                  if (a.equals(alumno)) {
                    System.out.println("El alumno ya existe en el registro");
                    existe = true;
                  }
                  if (!existe) {
                    estudiantes.add(alumno);
                    System.out.println("El alumno ha sido guardado en el registro");
                  }
                }
                break;
              case 2:
                System.out.println("Ingrese el indice del alumno a buscar");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();
                if (indice >= estudiantes.size()) {
                  System.out.println("El alumno con ese indice no existe");
                } else {
                  alumno = estudiantes.get(indice);
                  do {
                    System.out.println("Menu editar Alumno");
                    System.out.println("1.-Nombre");
                    System.out.println("2.- Apellido");
                    System.out.println("3.- Edad");
                    System.out.println("4.- Promedio");
                    System.out.println("5.- Grado");
                    System.out.println("6.- Grupo");
                    System.out.println("7.- Materias");
                    System.out.println("8.- Salir");
                    entrada = new Scanner(System.in);
                    submenu = entrada.nextInt();
                    switch (submenu) {
                      case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        entrada = new Scanner(System.in);
                        nombre = entrada.nextLine();
                        estudiantes.get(indice).setNombre(nombre);
                        break;
                      case 2:
                        System.out.println("Ingrese el nuevo apellido");
                        entrada = new Scanner(System.in);
                        apellido = entrada.nextLine();
                        estudiantes.get(indice).setApellido(apellido);
                        break;
                      case 3:
                        System.out.println("Ingrese la nueva edad");
                        entrada = new Scanner(System.in);
                        edad = entrada.nextInt();
                        estudiantes.get(indice).setEdad(edad);
                        break;
                      case 4:
                        System.out.println("Ingrese el nuevo promedio");
                        entrada = new Scanner(System.in);
                        promedio = entrada.nextDouble();
                        estudiantes.get(indice).setPromedio(promedio);
                        break;
                      case 5:
                        System.out.println("Ingrese el nuevo grado");
                        entrada = new Scanner(System.in);
                        grado = entrada.nextInt();
                        estudiantes.get(indice).setGrado(grado);
                        break;
                      case 6:
                        System.out.println("Ingrese el nuevo grupo");
                        entrada = new Scanner(System.in);
                        grupo = entrada.nextLine();
                        estudiantes.get(indice).setNombre(grupo);
                        break;
                      case 7:
                        System.out.println("Ingrese las nuevas materias");
                        entrada = new Scanner(System.in);
                        materias = entrada.nextInt();
                        estudiantes.get(indice).setMaterias(materias);
                      case 8:
                        System.out.println("Saliendo...");
                        break;
                      default:
                        System.out.println("Opcion invalida, intente de nuevo");
                        break;
                    }
                  } while (submenu != 8);
                }
                break;
              case 3:
                System.out.println("Ingrese el indice del alumno a buscar");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();
                if (indice >= estudiantes.size()) {
                  System.out.println("El alumno con ese indice no existe");
                } else {
                  alumno = estudiantes.get(indice);
                  System.out.println("Se encontró el alumno");
                  System.out.println(alumno);
                }
                break;
              case 4:
                System.out.println("Ingresa el indice a eliminar");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();
                if (indice >= estudiantes.size()) {
                  System.out.println("El indice que trata de eliminar no existe");
                } else {
                  alumno = estudiantes.get(indice);
                  estudiantes.remove(indice);
                  System.out.println("El siguiente estudiante fue dado de baja:");
                  System.out.println(alumno);
                }
                break;
              case 5:
                if (estudiantes.size() == 0) {
                  System.out.println("No existen alumnos en el registro");
                } else {
                  for (Alumno a : estudiantes) {
                    System.out.println(
                        estudiantes.indexOf(a) + ".- " + a.getNombre() + " " + a.getApellido()
                            + " ");
                  }
                }
                break;
              case 6:
                if (estudiantes.isEmpty()) {
                  System.out.println("No existen alumnos en el registro");
                } else {
                  for (Alumno a : estudiantes) {
                    System.out.println(a.toString());
                  }
                }
                break;
              case 7:
                System.out.println("Ingresa el nombre a buscar");
                entrada = new Scanner(System.in);
                nombre = entrada.nextLine();

                System.out.println("Ingresa el apellido a buscar");
                entrada = new Scanner(System.in);
                apellido = entrada.nextLine();

                for (Alumno a : estudiantes) {
                  if (nombre.equals(a.getNombre()) && apellido.equals(a.getApellido())) {
                    System.out.println("Se encontro un alumno");
                    System.out.println(a);
                    existe = true;
                    break;
                  }
                }
                if (!existe) {
                  System.out.println("El alumno que se busco no existe");
                }
                break;
            }
          }while (menuA != 8);
          break;
        case 2:
          do {
            System.out.println("Menu de profesores");
            System.out.println("1.-Agregar");
            System.out.println("2.-Editar");
            System.out.println("3.-Buscar");
            System.out.println("4.-Eliminar");
            System.out.println("5.-Listar");
            System.out.println("6.-Mostrar");
            System.out.println("7.-Buscar por Nombre");
            System.out.println("8.-Regresar al menu principal");
            entrada = new Scanner(System.in);
            menuP = entrada.nextInt();

            switch (menuP) {
              case 1:
                System.out.println("Ingresa el nombre");
                entrada = new Scanner(System.in);
                nombre = entrada.nextLine();

                System.out.println("Ingresa el apellido");
                entrada = new Scanner(System.in);
                apellido = entrada.nextLine();

                System.out.println("Ingrese la edad");
                entrada = new Scanner(System.in);
                edad = entrada.nextInt();

                System.out.println("Ingrese la materia");
                entrada = new Scanner(System.in);
                materia = entrada.nextLine();

                System.out.println("Ingrese el sueldo");
                entrada = new Scanner(System.in);
                sueldo = entrada.nextDouble();

                profesor = new Profesor(nombre, apellido, edad, materia, sueldo, null);
                for (Profesor p : profesores) {
                  if (p.equals(profesor)) {
                    System.out.println("El profesor ya existe en el registro");
                    existe = true;
                  }
                  if (!existe) {
                    profesores.add(profesor);
                    System.out.println("El profesor ha sido guardado en el registro");
                  }
                }
                break;
              case 2:
                System.out.println("Ingrese el indice del profesor a buscar");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();
                if (indice >= profesores.size()) {
                  System.out.println("El profesor con ese indice no existe");
                } else {
                  profesor = profesores.get(indice);
                  do {
                    System.out.println("Menu editar de Profesor");
                    System.out.println("1.-Nombre");
                    System.out.println("2.- Apellido");
                    System.out.println("3.- Edad");
                    System.out.println("4.- Materia");
                    System.out.println("5.- Sueldo");
                    System.out.println("6.-Agregar alumno");
                    System.out.println("7.-Quitar alumno");
                    System.out.println("8.- Salir");
                    entrada = new Scanner(System.in);
                    submenu = entrada.nextInt();
                    switch (submenu) {
                      case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        entrada = new Scanner(System.in);
                        nombre = entrada.nextLine();
                        profesores.get(indice).setNombre(nombre);
                        break;
                      case 2:
                        System.out.println("Ingrese el nuevo apellido");
                        entrada = new Scanner(System.in);
                        apellido = entrada.nextLine();
                        profesores.get(indice).setApellido(apellido);
                        break;
                      case 3:
                        System.out.println("Ingrese la nueva edad");
                        entrada = new Scanner(System.in);
                        edad = entrada.nextInt();
                        profesores.get(indice).setEdad(edad);
                        break;
                      case 4:
                        System.out.println("Ingrese el nuevo materia");
                        entrada = new Scanner(System.in);
                        materia = entrada.nextLine();
                        profesores.get(indice).setMateria(materia);
                        break;
                      case 5:
                        System.out.println("Ingrese el nuevo sueldo");
                        entrada = new Scanner(System.in);
                        sueldo = entrada.nextDouble();
                        profesores.get(indice).setSueldo(sueldo);
                        break;
                      case 6:
                        System.out.println("Ingresa el indice del alumno a asignar");
                        entrada = new Scanner(System.in);
                        indice2 = entrada.nextInt();

                        if(indice >= profesores.size() && indice2 >= estudiantes.size()){
                          System.out.println("El profesor y alumno que tratas de asignar no existen");
                        } else if (indice < profesores.size() && indice2 >= estudiantes.size()) {
                          System.out.println("El alumno que tratas de asignar no existe");
                        } else if (indice >= profesores.size()) {
                          System.out.println("El profesor al que tratas de asignar el alumno no existe");;
                        }else {
                          alumno = estudiantes.get(indice2);
                          profesores.get(indice).getAlumnoList().add(alumno);
                          System.out.println("El alumno siguiente ha sido asignado correctamente");
                          System.out.println(alumno);
                        }
                        break;
                      case 7:
                        System.out.println("Ingresa el indice del alumno que desea retirar");
                        entrada = new Scanner(System.in);
                        indice2 = entrada.nextInt();

                        if(indice >= profesores.size() && indice2 >= estudiantes.size()){
                          System.out.println("El profesor y alumno que tratas de asignar no existen");
                        } else if (indice < profesores.size() && indice2 >= estudiantes.size()) {
                          System.out.println("El alumno que tratas de asignar no existe");
                        } else if (indice >= profesores.size()) {
                          System.out.println("El profesor al que tratas de asignar el alumno no existe");;
                        }else {
                          alumno = profesores.get(indice).getAlumnoList().get(indice2);
                          profesores.get(indice).getAlumnoList().remove(indice2);
                          System.out.println("El alumno siguiente ha sido retirado correctamente");
                          System.out.println(alumno);
                        }
                        break;
                      case 8:
                        System.out.println("Saliendo...");
                        break;
                      default:
                        System.out.println("Opcion invalida, intente de nuevo");
                        break;
                    }
                  } while (submenu != 8);
                }
                break;
              case 3:
                System.out.println("Ingrese el indice del profesor a buscar");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();
                if (indice >= profesores.size()) {
                  System.out.println("El profesor con ese indice no existe");
                } else {
                  profesor = profesores.get(indice);
                  System.out.println("Se encontró el profesor");
                  System.out.println(profesor);
                }
                break;
              case 4:
                System.out.println("Ingresa el indice a eliminar");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();
                if (indice >= profesores.size()) {
                  System.out.println("El indice que trata de eliminar no existe");
                } else {
                  profesor = profesores.get(indice);
                  profesores.remove(indice);
                  System.out.println("El siguiente profesor fue dado de baja:");
                  System.out.println(profesor);
                }
                break;
              case 5:
                if (profesores.size() == 0) {
                  System.out.println("No existen profesores en el registro");
                } else {
                  for (Profesor p : profesores) {
                    System.out.println(
                        profesores.indexOf(p) + ".- " + p.getNombre() + " " + p.getApellido()
                            + " ");
                  }
                }
                break;
              case 6:
                if (profesores.isEmpty()) {
                  System.out.println("No existen profesores en el registro");
                } else {
                  for (Profesor p : profesores) {
                    System.out.println(p.toString());
                  }
                }
                break;
              case 7:
                System.out.println("Ingresa el indice del profesor");
                entrada = new Scanner(System.in);
                indice = entrada.nextInt();

                System.out.println("Ingresa el indice del alumno");
                entrada = new Scanner(System.in);
                indice2 = entrada.nextInt();

                if(indice >= profesores.size() && indice2 >= estudiantes.size()){
                  System.out.println("El profesor y alumno que tratas de asignar no existen");
                } else if (indice < profesores.size() && indice2 >= estudiantes.size()) {
                  System.out.println("El alumno que tratas de asignar no existe");
                } else if (indice >= profesores.size() && indice2 <= estudiantes.size()) {
                  System.out.println("El profesor al que tratas de asignar el alumno no existe");;
                }else {
                  alumno = estudiantes.get(indice2);
                  profesores.get(indice).getAlumnoList().add(alumno);
                  System.out.println("El alumno siguiente ha sido asignado correctamente");
                  System.out.println(alumno);
                }
                break;
            }
          }while (menuP != 8);
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      };
    }while (menu!= 3);
  }
}