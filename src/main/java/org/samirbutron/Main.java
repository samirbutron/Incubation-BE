package org.samirbutron;

import classes.Motocicleta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static Scanner entrada;
  private static String marca, tipo;
  private static int velocidad;
  private static double peso;
  private static Motocicleta moto = new Motocicleta();

  public static void main(String[] args) {

    List<Motocicleta> list = new ArrayList<>();

    int menu;
    do{
      System.out.println("Menu de motocicletas");
      System.out.println("1.-Agregar motocicleta al registro");
      System.out.println("2.-Editar");
      System.out.println("3.-Buscar");
      System.out.println("4.-Eliminar");
      System.out.println("5.-Listar");
      System.out.println("6.-Mostrar");
      System.out.println("7.-Salir");
      menu = new Scanner(System.in).nextInt();
      switch (menu) {
        case 1:
          System.out.println("Ingresa la marca");
          entrada = new Scanner(System.in);
          marca = entrada.nextLine();

          System.out.println("Ingresa la velocidad de la moto");
          entrada = new Scanner(System.in);
          velocidad = entrada.nextInt();

          System.out.println("Ingresa el tipo de la moto");
          entrada = new Scanner(System.in);
          tipo = entrada.nextLine();

          System.out.println("Ingresa el peso de la moto");
          entrada = new Scanner(System.in);
          peso = entrada.nextDouble();

          moto = new Motocicleta(marca, velocidad, tipo, peso);
          list.add(moto);
          System.out.println("La motocicleta ha sido guardada correctamente");
          break;
        case 2:
          System.out.println("Ingresa el indice de la moto a editar");
          entrada = new Scanner(System.in);
          int indice = entrada.nextInt();
          moto = list.get(indice);
          System.out.println("Se encontro la moto:");
          System.out.println(moto);
          System.out.println("Ingresa el campo a editar:");
          int submenu;
          do {
            System.out.println("1.-Marca");
            System.out.println("2.-Velocidad");
            System.out.println("3.-Tipo");
            System.out.println("4.-Peso");
            System.out.println("5.-Salir de edicion");
            entrada = new Scanner(System.in);
            submenu = entrada.nextInt();
            menuEditar(submenu);
          }while (submenu != 5);
          break;
        case 3:
          System.out.println("Ingresa el indice de la moto a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          moto = list.get(indice);
          System.out.println("Se encontro la moto");
          System.out.println(moto);
          break;
        case 4:
          System.out.println("Ingresa el indice de la moto a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          moto = list.get(indice);
          System.out.println("Se encontro la moto a eliminar");
          list.remove(indice);
          System.out.println("Se elimino la moto:");
          System.out.println(moto);
          break;
        case 5:
          System.out.println("Lista de motocicletas en el registro:");
          for (Motocicleta i : list){
            System.out.println(i.toString());
          }
          break;
        case 6:

          break;
        case 7:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
    }while(menu != 7);
  }

  public static void menuEditar(int opcion) {
    switch (opcion) {
      case 1:
        System.out.println("Ingresa la nueva marca");
        entrada = new Scanner(System.in);
        marca = entrada.nextLine();
        moto.setMarca(marca);
        break;
      case 2:
        System.out.println("Ingresa la nueva velocidad");
        entrada = new Scanner(System.in);
        velocidad = entrada.nextInt();
        moto.setVelocidad(velocidad);
        break;
      case 3:
        System.out.println("Ingresa el nuevo tipo");
        entrada = new Scanner(System.in);
        tipo = entrada.nextLine();
        moto.setTipo(tipo);
        break;
      case 4:
        System.out.println("Ingresa el nuevo peso");
        entrada = new Scanner(System.in);
        peso = entrada.nextDouble();
        moto.setPeso(peso);
        break;
      case 5:
        System.out.println("Saliendo...");
        break;
      default:
        System.out.println("Opcion invalida, intenta de nuevo");
        break;
    }
  }
}

