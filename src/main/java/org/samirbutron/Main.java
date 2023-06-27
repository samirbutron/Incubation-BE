package org.samirbutron;

import classes.Computadora;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static Scanner entrada;
  private static String marca, modelo, tipo;
  private static int ram, almacenamiento;
  private static double precio, tamañoTorre;
  private static Computadora compu = new Computadora();

  public static void main(String[] args) {

    Computadora compu1 = new Computadora("Dell", "Xp235", 500, 1000, 145.67,"laptop", 0);
    Computadora compu2 = new Computadora("Lenovo", "G24", 250, 720, 89.6,"escritorio", 10.2);
    Computadora compu3 = new Computadora("HP", "Note", 1600, 1000, 260.99,"laptop", 0);
    Computadora compu4 = new Computadora("HP", "Note2", 2400, 1500, 460.99,"laptop", 0);
    List<Computadora> list = new ArrayList<>();
    list.add(compu1);
    list.add(compu2);
    list.add(compu3);
    list.add(compu4);

    int menu;
    do{
      System.out.println("Menu de computadoras");
      System.out.println("1.-Agregar computadora al registro");
      System.out.println("2.-Editar");
      System.out.println("3.-Buscar");
      System.out.println("4.-Eliminar");
      System.out.println("5.-Mostrar");
      System.out.println("6.-Listar");
      System.out.println("7.-Buscar por marca");
      System.out.println("8.-Salir");
      menu = new Scanner(System.in).nextInt();
      switch (menu) {
        case 1:
          System.out.println("Ingresa la marca");
          entrada = new Scanner(System.in);
          marca = entrada.nextLine();

          System.out.println("Ingresa el modelo de la computadora");
          entrada = new Scanner(System.in);
          modelo = entrada.nextLine();

          System.out.println("Ingresa la ram de la computadora");
          entrada = new Scanner(System.in);
          ram = entrada.nextInt();

          System.out.println("Ingresa el almacenamiento de la computadora");
          entrada = new Scanner(System.in);
          almacenamiento = entrada.nextInt();

          System.out.println("Ingresa el precio de la computadora");
          entrada = new Scanner(System.in);
          precio = entrada.nextDouble();

          System.out.println("Ingresa el tipo de la computadora");
          entrada = new Scanner(System.in);
          tipo = entrada.nextLine();

          System.out.println("Ingresa el tamaño de torre de la computadora");
          entrada = new Scanner(System.in);
          tamañoTorre = entrada.nextDouble();

          compu = new Computadora(marca, modelo, ram, almacenamiento, precio, tipo, tamañoTorre);
          list.add(compu);
          System.out.println("La computadora ha sido guardada correctamente");
          break;
        case 2:
          System.out.println("Ingresa la marca de la computadora a editar");
          entrada = new Scanner(System.in);
          int indice = entrada.nextInt();
          compu = list.get(indice);
          System.out.println("Se encontro la computadora:");
          System.out.println(compu);
          System.out.println("Ingresa el campo a editar:");
          int submenu;
          do {
            System.out.println("1.-Marca");
            System.out.println("2.-Modelo");
            System.out.println("3.-Ram");
            System.out.println("4.-Almacenamiento");
            System.out.println("5.-Precio");
            System.out.println("6.-Tipo");
            System.out.println("7.-Tamaño de torre");
            System.out.println("8.-Salir de edición");
            entrada = new Scanner(System.in);
            submenu = entrada.nextInt();
            menuEditar(submenu);
          }while (submenu != 8);
          break;
        case 3:
          System.out.println("Ingresa el indice de la computadora a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          compu = list.get(indice);
          System.out.println("Se encontro la computadora");
          System.out.println(compu);
          break;
        case 4:
          System.out.println("Ingresa el indice de la computadora a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          compu = list.get(indice);
          System.out.println("Se encontro la computadora a eliminar");
          list.remove(indice);
          System.out.println("Se elimino la computadora:");
          System.out.println(compu);
          break;
        case 5:
          System.out.println("Lista de computadoras en el registro:");
          for (Computadora i : list){
            System.out.println(i.toString());
          }
          break;
        case 6:
          for(int i =0 ; i < list.size(); i++){
            System.out.printf("\n[%d] => "+list.get(i).getMarca(),i);
          }
          break;
        case 7:
          System.out.println("Ingresa la marca de computadora a buscar");
          entrada = new Scanner(System.in);
          marca = entrada.nextLine();
          for (Computadora computadora : list) {
            if (marca.equals(computadora.getMarca())) {
              System.out.printf("\n[%d]"+computadora,list.indexOf(computadora));
            }
          }
          break;
        case 8:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
      System.out.println();
    }while(menu != 8);
  }

  public static void menuEditar(int opcion) {
    switch (opcion) {
      case 1:
        System.out.println("Ingresa la nueva marca");
        entrada = new Scanner(System.in);
        marca = entrada.nextLine();
        compu.setMarca(marca);
        break;
      case 2:
        System.out.println("Ingresa el nuevo modelo");
        entrada = new Scanner(System.in);
        modelo = entrada.nextLine();
        compu.setModelo(modelo);
        break;
      case 3:
        System.out.println("Ingresa la nueva ram");
        entrada = new Scanner(System.in);
        ram = entrada.nextByte();
        compu.setRam(ram);
        break;
      case 4:
        System.out.println("Ingresa el nuevo almacenamiento");
        entrada = new Scanner(System.in);
        almacenamiento = entrada.nextInt();
        compu.setAlmacenamiento(almacenamiento);
        break;
      case 5:
        System.out.println("Ingresa el nuevo precio");
        entrada = new Scanner(System.in);
        precio = entrada.nextDouble();
        compu.setPrecio(precio);
        break;
      case 6:
        System.out.println("Ingresa el nuevo tipo");
        entrada = new Scanner(System.in);
        tipo = entrada.nextLine();
        compu.setTipo(tipo);
        break;
      case 7:
        System.out.println("Ingresa el nuevo tamaño de torre");
        entrada = new Scanner(System.in);
        tamañoTorre = entrada.nextDouble();
        compu.setTamañoTorre(tamañoTorre);
        break;
      case 8:
        System.out.println("Saliendo...");
        break;
      default:
        System.out.println("Opcion invalida, intenta de nuevo");
        break;
    }
  }
}

