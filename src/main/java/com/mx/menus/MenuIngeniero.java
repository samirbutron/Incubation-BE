package com.mx.menus;

import com.mx.entidad.Ingeniero;
import com.mx.service.Implementacion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuIngeniero {

  private String nombre, apellido, genero, especialidad, departamento;
  private Date fechaNacimiento;
  private double sueldo;
  private int indice;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
    int opcion;
    Ingeniero ingeniero;
    do {
      System.out.println("\n*****Menu de ingeniero*******");
      System.out.println("1.-Agregar Ingeniero");
      System.out.println("2.-Editar Ingeniero");
      System.out.println("3.-Eliminar Ingeniero");
      System.out.println("4.-Listar Ingeniero");
      System.out.println("5.-Mostrar Ingeniero ");
      System.out.println("6.-Buscar por indice");
      System.out.println("9.-Regresar al menu principal");
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
          System.out.println("Ingresa el apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          System.out.println("Ingresa el genero");
          entrada = new Scanner(System.in);
          genero = entrada.nextLine();
          System.out.println("Ingresa la fecha de Nacimiento en formato dd/MM/yyyy");
          entrada = new Scanner(System.in);
          String stringFecha = entrada.nextLine();
          try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(stringFecha);
          } catch (Exception e) {
            System.out.println("Error de parsing en fecha" + e.getMessage());
          }
          System.out.println("Ingresa el sueldo");
          entrada = new Scanner(System.in);
          sueldo = entrada.nextDouble();
          System.out.println("Ingresa la especialidad");
          entrada = new Scanner(System.in);
          especialidad = entrada.nextLine();
          System.out.println("Ingresa el departamento");
          entrada = new Scanner(System.in);
          departamento = entrada.nextLine();
          ingeniero = new Ingeniero(nombre, apellido, genero, fechaNacimiento, sueldo, especialidad, departamento);
          implementacion.guardar(ingeniero);
          break;
        case 2:
          System.out.println("Ingresa el indice del ingeniero");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          ingeniero = (Ingeniero) implementacion.buscar(indice, "ingeniero");
          if (ingeniero == null) {
            System.out.println("El ingeniero que tratas de editar no existe");
          } else {
            Ingeniero(ingeniero);
          }
          break;
        case 3:
          System.out.println("Ingresa el indice del ingeniero a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextLine();
          ingeniero = new Ingeniero(indice);
          ingeniero = (Ingeniero) implementacion.buscar(ingeniero, "ingeniero");
          if (ingeniero == null) {
            System.out.println("El ingeniero a eliminar no existe");
          } else {
            implementacion.eliminar(ingeniero, "ingeniero");
            System.out.println("Se borro el ingeniero:");
            System.out.println(ingeniero);
          }
          break;
        case 4:
          implementacion.listar("ingeniero");
          break;
        case 5:
          implementacion.mostrar("ingeniero");
          break;
        case 6:
          System.out.println("Ingresa el indice de la ingeniero a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextLine();
          //UPPERCASE para caso de indice
          ingeniero = new Ingeniero(indice.toUpperCase());
          ingeniero = (Ingeniero) implementacion.buscar(ingeniero, "ingeniero");
          if (ingeniero == null) {
            System.out.println("La ingeniero buscado no existe");
          } else {
            System.out.println("Se encontro el ingeniero:");
            System.out.println(ingeniero);
          }
          break;
        case 7:
          implementacion.buscarMayorSaldo();
          break;
        case 8:
          implementacion.buscarMayorDeuda();
          break;
        case 9:
          System.out.println("Saliendo del menu Ingeniero...");
          break;
        default:
          System.out.println("Opcion invalida, intente otra opcion");
          break;
      }
    } while (opcion != 9);
  }

  private void menuEditarIngeniero(Ingeniero ingeniero) {
    int opcion;
    do {
      System.out.println("Menu editar Ingeniero");
      System.out.println("1.-Nombre");
      System.out.println("2.- Apellido");
      System.out.println("3.- Edad");
      System.out.println("4.- Ciudad");
      System.out.println("5.- Cuentas");
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
          ingeniero.setNombre(nombre);
          implementacion.editar(ingeniero, "ingeniero");
          break;
        case 2:
          System.out.println("Ingresa la apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          ingeniero.setApellido(apellido);
          implementacion.editar(ingeniero, "ingeniero");
          break;
        case 3:
          System.out.println("Ingresa la sueldo");
          entrada = new Scanner(System.in);
          sueldo = entrada.nextInt();
          ingeniero.setEdad(sueldo);
          implementacion.editar(ingeniero, "ingeniero");
          break;
        case 4:
          System.out.println("Ingresa la fechaNacimiento");
          entrada = new Scanner(System.in);
          fechaNacimiento = entrada.nextLine();
          ingeniero.setCiudad(fechaNacimiento);
          implementacion.editar(ingeniero, "ingeniero");
          break;
        case 5:
          menuCuenta(ingeniero);
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

  private void menuCuenta(Ingeniero ingeniero) {
    int opcion;
    Cuenta cuenta;
    String NumeroDeCuenta;
    do {
      System.out.println("Menu de edicion de cuenta");
      System.out.println("1.-Agregar cuenta");
      System.out.println("2.-Remover cuenta");
      System.out.println("3.-Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          System.out.println("Ingresa el Numero de cuenta de la cuenta a agregar");
          entrada = new Scanner(System.in);
          NumeroDeCuenta = entrada.nextLine();
          cuenta = new Cuenta(NumeroDeCuenta);
          cuenta = (Cuenta) implementacion.buscar(cuenta, "cuenta");
          if (cuenta == null || ingeniero.getCuentaList().contains(cuenta)) {
            System.out.println("La cuenta a agregar no existe o ya esta agregado");
          } else {
            ingeniero.getCuentaList().add(cuenta);
            System.out.println("Se agrego la siguiente cuenta del curso:");
            System.out.println(cuenta);
          }
          break;
        case 2:
          System.out.println("Ingresa el nombre de la cuenta a retirar");
          entrada = new Scanner(System.in);
          NumeroDeCuenta = entrada.nextLine();
          cuenta = new Cuenta(NumeroDeCuenta);
          cuenta = (Cuenta) implementacion.buscar(cuenta, "cuenta");
          if (cuenta == null || ingeniero.getCuentaList().isEmpty()) {
            System.out.println("El cuenta a retirar no existe o no hay cuenta para retirar");
          } else {
            ingeniero.getCuentaList().remove(cuenta);
            System.out.println("Se retiro el siguiente cuenta del curso:");
            System.out.println(cuenta);
          }
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
        default:
          break;
      }
    } while (opcion != 3);
  }
}
