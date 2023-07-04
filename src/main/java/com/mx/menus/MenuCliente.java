package com.mx.menus;

import com.mx.entidad.Cliente;
import com.mx.entidad.Cuenta;
import com.mx.service.Implementacion;
import java.util.Scanner;

public class MenuCliente {

  private String nombre, curp, apellido, ciudad;
  private int edad;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
    int opcion;
    Cliente cliente;
    do {
      System.out.println("\n*****Menu de cliente*******");
      System.out.println("1.-Agregar Cliente");
      System.out.println("2.-Editar Cliente");
      System.out.println("3.-Eliminar Cliente");
      System.out.println("4.-Listar Cliente");
      System.out.println("5.-Mostrar Cliente ");
      System.out.println("6.-Buscar por CURP");
      System.out.println("7.-Buscar cliente con mayor saldo ");
      System.out.println("8.-Buscar cliente con mayor deuda");
      System.out.println("9.-Regresar al menu principal");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
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
          System.out.println("Ingresa la ciudad");
          entrada = new Scanner(System.in);
          ciudad = entrada.nextLine();
          cliente = new Cliente(curp, nombre, apellido, edad, ciudad);
          implementacion.guardar(cliente, "cliente");
          break;
        case 2:
          System.out.println("Ingresa CURP de la cliente");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          cliente = new Cliente(curp);
          cliente = (Cliente) implementacion.buscar(cliente, "cliente");
          if (cliente == null) {
            System.out.println("El cliente que tratas de editar no existe");
          } else {
            menuEditarCliente(cliente);
          }
          break;
        case 3:
          System.out.println("Ingresa el CURP del cliente a eliminar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          cliente = new Cliente(curp);
          cliente = (Cliente) implementacion.buscar(cliente, "cliente");
          if (cliente == null) {
            System.out.println("El cliente a eliminar no existe");
          } else {
            implementacion.eliminar(cliente, "cliente");
            System.out.println("Se borro el cliente:");
            System.out.println(cliente);
          }
          break;
        case 4:
          implementacion.listar("cliente");
          break;
        case 5:
          implementacion.mostrar("cliente");
          break;
        case 6:
          System.out.println("Ingresa el CURP de la cliente a buscar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          //UPPERCASE para caso de CURP
          cliente = new Cliente(curp.toUpperCase());
          cliente = (Cliente) implementacion.buscar(cliente, "cliente");
          if (cliente == null) {
            System.out.println("La cliente buscado no existe");
          } else {
            System.out.println("Se encontro el cliente:");
            System.out.println(cliente);
          }
          break;
        case 7:
          implementacion.buscarMayorSaldo();
          break;
        case 8:
          implementacion.buscarMayorDeuda();
          break;
        case 9:
          System.out.println("Saliendo del menu Cliente...");
          break;
        default:
          System.out.println("Opcion invalida, intente otra opcion");
          break;
      }
    } while (opcion != 9);
  }

  private void menuEditarCliente(Cliente cliente) {
    int opcion;
    do {
      System.out.println("Menu editar Cliente");
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
          cliente.setNombre(nombre);
          implementacion.editar(cliente, "cliente");
          break;
        case 2:
          System.out.println("Ingresa la apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          cliente.setApellido(apellido);
          implementacion.editar(cliente, "cliente");
          break;
        case 3:
          System.out.println("Ingresa la edad");
          entrada = new Scanner(System.in);
          edad = entrada.nextInt();
          cliente.setEdad(edad);
          implementacion.editar(cliente, "cliente");
          break;
        case 4:
          System.out.println("Ingresa la ciudad");
          entrada = new Scanner(System.in);
          ciudad = entrada.nextLine();
          cliente.setCiudad(ciudad);
          implementacion.editar(cliente, "cliente");
          break;
        case 5:
          menuCuenta(cliente);
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

  private void menuCuenta(Cliente cliente) {
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
          if (cuenta == null || cliente.getCuentaList().contains(cuenta)) {
            System.out.println("La cuenta a agregar no existe o ya esta agregado");
          } else {
            cliente.getCuentaList().add(cuenta);
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
          if (cuenta == null || cliente.getCuentaList().isEmpty()) {
            System.out.println("El cuenta a retirar no existe o no hay cuenta para retirar");
          } else {
            cliente.getCuentaList().remove(cuenta);
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
