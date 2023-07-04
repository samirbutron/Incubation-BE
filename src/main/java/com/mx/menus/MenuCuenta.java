package com.mx.menus;

import com.mx.entidad.Cuenta;
import com.mx.service.Implementacion;
import java.util.Scanner;

public class MenuCuenta {


  private String numeroDeCuenta, tipo;
  private double saldo, deuda;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);
  private Cuenta cuenta = new Cuenta();

  public void menu() {
    {
      int opcion;
      do {
        System.out.println("\n*****Menu de cuenta*******");
        System.out.println("1.-Agregar Cuenta");
        System.out.println("2.-Editar Cuenta");
        System.out.println("3.-Eliminar Cuenta");
        System.out.println("4.-Listar Cuentas");
        System.out.println("5.-Mostrar Cuentas");
        System.out.println("6.-Buscar por Numero de cuenta");
        System.out.println("7.-Regresar al menu principal");
        entrada = new Scanner(System.in);
        try {
          opcion = entrada.nextInt();
        } catch (Exception e) {
          opcion = 0;
        }
        switch (opcion) {
          case 1:
            System.out.println("Ingresa el Numero de cuenta");
            entrada = new Scanner(System.in);
            numeroDeCuenta = entrada.nextLine();
            System.out.println("Ingresa el tipo");
            entrada = new Scanner(System.in);
            tipo = entrada.nextLine();
            System.out.println("Ingresa los saldo");
            entrada = new Scanner(System.in);
            saldo = entrada.nextInt();
            System.out.println("Ingresa las deuda");
            entrada = new Scanner(System.in);
            deuda = entrada.nextInt();
            cuenta = new Cuenta(numeroDeCuenta, tipo, saldo, deuda);
            implementacion.guardar(cuenta, "cuenta");
            break;
          case 2:
            System.out.println("Ingresa Numero de cuenta del cuenta a editar");
            entrada = new Scanner(System.in);
            numeroDeCuenta = entrada.nextLine();
            cuenta = (Cuenta) implementacion.buscar(cuenta, "cuenta");
            if (cuenta == null) {
              System.out.println("El cuenta que tratas de editar no existe");
            } else {
              menuEditarCuenta(cuenta);
            }
            break;
          case 3:
            System.out.println("Ingresa el Numero de cuenta del cuenta a eliminar");
            entrada = new Scanner(System.in);
            numeroDeCuenta = entrada.nextLine();
            cuenta = (Cuenta) implementacion.buscar(cuenta, "cuenta");
            if (cuenta == null) {
              System.out.println("El cuenta a eliminar no existe");
            } else {
              implementacion.eliminar(cuenta, "cuenta");
              System.out.println("Se borro el cuenta:");
              System.out.println(cuenta);
            }
            break;
          case 4:
            implementacion.listar("cuenta");
            break;
          case 5:
            implementacion.mostrar("cuenta");
            break;
          case 6:
            System.out.println("Ingresa el Numero de cuenta de la cuenta a buscar");
            entrada = new Scanner(System.in);
            numeroDeCuenta = entrada.nextLine();
            cuenta = (Cuenta) implementacion.buscar(cuenta, "cuenta");
            if (cuenta == null) {
              System.out.println("El cuenta buscado no existe");
            } else {
              System.out.println("Se encontro el cuenta:");
              System.out.println(cuenta);
            }
            break;
          case 7:
            System.out.println("Saliendo del menu Cuenta...");
            break;
          default:
            System.out.println("Opcion invalida, intente otra opcion");
            break;
        }
      } while (opcion != 7);
    }
  }

  private void menuEditarCuenta(Cuenta cuenta) {
    int opcion;
    do {
      System.out.println("Menu editar Cuenta");
      System.out.println("1.- Tipo");
      System.out.println("2.- Saldo");
      System.out.println("3.- Deuda");
      System.out.println("4.- Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          System.out.println("Ingresa el Tipo");
          entrada = new Scanner(System.in);
          tipo = entrada.nextLine();
          cuenta.setTipo(tipo);
          implementacion.editar(cuenta, "cuenta");
          break;
        case 2:
          System.out.println("Ingresa la Saldo");
          entrada = new Scanner(System.in);
          saldo = entrada.nextDouble();
          cuenta.setSaldo(saldo);
          implementacion.editar(cuenta, "cuenta");
          break;
        case 3:
          System.out.println("Ingresa los Deuda");
          entrada = new Scanner(System.in);
          deuda = entrada.nextDouble();
          cuenta.setDeuda(deuda);
          implementacion.editar(cuenta, "cuenta");
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
