package com.mx.menus;

import com.mx.entidad.Mascota;
import com.mx.service.ImpMascota;
import java.util.Scanner;

public class MenuMascota {

  private String especie;
  private int edad;
  private double peso;
  private final ImpMascota impMascota = ImpMascota.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
  int opcion;
  String nombre;
  Mascota mascota;
    do{
    System.out.println("\n*****Menu de Mascota*******");
    System.out.println("1.-Agregar mascota");
    System.out.println("2.-Editar mascota");
    System.out.println("3.-Eliminar mascota");
    System.out.println("4.-Listar mascotas");
    System.out.println("5.-Mostrar mascotas");
    System.out.println("6.-Buscar por Edad");
    System.out.println("7.-Mostrar mascotas por especie");
    System.out.println("8.-Regresar al menu principal");
    entrada = new Scanner(System.in);
    try {
      opcion = entrada.nextInt();
    } catch (Exception e) {
      opcion = 0;
    }
    switch (opcion){
      case 1:
        System.out.println("Ingresa el nombre");
        entrada = new Scanner(System.in);
        nombre = entrada.nextLine();
        System.out.println("Ingresa la edad");
        entrada = new Scanner(System.in);
        edad = entrada.nextInt();
        System.out.println("Ingresa el peso");
        entrada = new Scanner(System.in);
        peso = entrada.nextDouble();
        System.out.println("Ingresa la especie");
        entrada = new Scanner(System.in);
        especie = entrada.nextLine();
        mascota = new Mascota(nombre, edad, peso, especie);
        impMascota.guardar(mascota);
        break;
      case 2:
        System.out.println("Ingresa el nombre para buscar la mascota");
        entrada = new Scanner(System.in);
        nombre = entrada.nextLine();
        mascota = new Mascota(nombre);
        mascota = impMascota.buscar(mascota);
        if (mascota == null) {
          System.out.println("El mascota que tratas de editar no existe");
        } else {
          menuEditarMascota(mascota);
        }
        break;
      case 3:
        System.out.println("Ingresa el nombre de la Mascota a eliminar");
        entrada = new Scanner(System.in);
        nombre = entrada.nextLine();
        mascota = new Mascota(nombre);
        mascota = impMascota.buscar(mascota);
        if (mascota == null){
          System.out.println("La mascota a eliminar no existe");
        } else {
          impMascota.eliminar(mascota);
          System.out.println("Se borro el mascota:");
          System.out.println(mascota);
        }
        break;
      case 4:
        impMascota.listar();
        break;
      case 5:
        impMascota.mostrar();
        break;
      case 6:
        System.out.println("Ingresa la edad de la mascota");
        entrada = new Scanner(System.in);
        edad = entrada.nextInt();
        impMascota.buscarPorEdad(edad);
        break;
      case 7:
        impMascota.mostrarPorEspecie();
        break;
      case 8:
        System.out.println("Saliendo del menu Mascota...");
        break;
      default:
        System.out.println("Opcion invalida, intente otra opcion");
        break;
    }
  }while (opcion != 8);
}

  public void menuEditarMascota(Mascota mascota){
    int opcion;
    do {
      System.out.println("Menu editar Mascota");
      System.out.println("1.-Edad");
      System.out.println("2.- Peso");
      System.out.println("3.- Especie");
      System.out.println("4.- Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          System.out.println("Ingresa la edad");
          edad = entrada.nextInt();
          mascota.setEdad(edad);
          impMascota.editar(mascota);
          break;
        case 2:
          System.out.println("Ingresa el peso");
          entrada = new Scanner(System.in);
          peso = entrada.nextDouble();
          mascota.setPeso(peso);
          impMascota.editar(mascota);
          break;
        case 3:
          System.out.println("Ingresa la especie");
          entrada = new Scanner(System.in);
          especie = entrada.nextLine();
          mascota.setEspecie(especie);
          impMascota.editar(mascota);
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
