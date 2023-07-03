package com.mx.menus;

import com.mx.entidad.Alumno;
import com.mx.service.Implementacion;
import java.util.Scanner;

public class MenuAlumno {
  private String nombre, apellido;
  private int edad;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
    int opcion;
    String curp;
    Alumno alumno;
    do{
      System.out.println("\n*****Menu de alumno*******");
      System.out.println("1.-Agregar Alumno");
      System.out.println("2.-Editar Alumno");
      System.out.println("3.-Eliminar Alumno");
      System.out.println("4.-Listar Alumno");
      System.out.println("5.-Mostrar Alumno ");
      System.out.println("6.-Buscar por CURP");
      System.out.println("7.-Regresar al menu principal");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          System.out.println("Ingresa el CURP");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          System.out.println("Ingresa el nombre");
          entrada = new Scanner(System.in);
          nombre = entrada.nextLine();
          System.out.println("Ingresa el apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          System.out.println("Ingresa la edad");
          entrada = new Scanner(System.in);
          edad = entrada.nextInt();
          alumno = new Alumno(curp,nombre,apellido,edad);
          implementacion.guardar(alumno,"alumno");
          break;
        case 2:
          System.out.println("Ingresa CURP de la alumno");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          alumno = new Alumno(curp);
          alumno = (Alumno) implementacion.buscar(alumno, 1,"alumno");
          if (alumno == null) {
            System.out.println("La alumno que tratas de editar no existe");
          }else {
            menuEditarAlumno(alumno);
          }
          break;
        case 3:
          System.out.println("Ingresa el CURP del alumno a eliminar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          alumno = new Alumno(curp);
          alumno = (Alumno) implementacion.buscar(alumno, 1, "alumno");
          if (alumno == null){
            System.out.println("El alumno a eliminar no existe");
          } else {
            implementacion.eliminar(alumno, 1, "alumno");
            System.out.println("Se borro el alumno:");
            System.out.println(alumno);
          }
          break;
        case 4:
          implementacion.listar("alumno");
          break;
        case 5:
          implementacion.mostrar("alumno");
          break;
        case 6:
          System.out.println("Ingresa el CURP de la alumno a buscar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          //UPPERCASE para caso de CURP
          alumno = new Alumno(curp.toUpperCase());
          alumno = (Alumno) implementacion.buscar(alumno,1,"alumno");
          if (alumno == null){
            System.out.println("La alumno buscado no existe");
          }else {
            System.out.println("Se encontro el alumno:");
            System.out.println(alumno);
          }
          break;
        case 7:
          System.out.println("Saliendo del menu Alumno...");
          break;
        default:
          System.out.println("Opcion invalida, intente otra opcion");
          break;
      }
    }while (opcion != 7);
  }

  private void menuEditarAlumno(Alumno alumno) {
    int opcion;
    do {
      System.out.println("Menu editar Alumno");
      System.out.println("1.-Nombre");
      System.out.println("2.- Apellido");
      System.out.println("3.- Edad");
      System.out.println("4.- Salir");
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
          alumno.setNombre(nombre);
          implementacion.editar(alumno, 1, "alumno");
          break;
        case 2:
          System.out.println("Ingresa la apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          alumno.setApellido(apellido);
          implementacion.editar(alumno, 1, "alumno");
          break;
        case 3:
          System.out.println("Ingresa la edad");
          entrada = new Scanner(System.in);
          edad = entrada.nextInt();
          alumno.setEdad(edad);
          implementacion.editar(alumno, 1, "alumno");
          break;
        case 4:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
    } while (opcion != 4);
  }
}
