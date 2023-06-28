package org.samirbutron;

import classes.Casa;
import classes.Computadora;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

public class Main {
  private static Scanner entrada;
  private static String calle, colonia, ciudad;
  private static int numero, numeroPisos;
  private static double precio, metrosCuadrados;
  private static Casa casa = new Casa();

  public static void main(String[] args) {

    Casa casa1 = new Casa("Obelisco", 104, "Pilares", "Alhambra", 2,145000, 400);
    Casa casa2 = new Casa("Cantera", 132, "Pilares", "Alhambra", 1,250000, 750.2);
    Casa casa3 = new Casa("Zeus", 200, "Olimpo", "Carolina", 3,550000, 670.10);
    Casa casa4 = new Casa("a", 1, "a", "a", 1,1, 1);
    List<Casa> list = new ArrayList<>();
    list.add(casa1);
    list.add(casa2);
    list.add(casa3);
    list.add(casa4);

    int menu;
    do{
      System.out.println("**************************************************");
      System.out.println("Menu principal de Casas");
      System.out.println("1.-Agregar casa al registro");
      System.out.println("2.-Editar");
      System.out.println("3.-Buscar por indice");
      System.out.println("4.-Eliminar");
      System.out.println("5.-Mostrar casas");
      System.out.println("6.-Lista por calle");
      System.out.println("7.-Buscar por colonia");
      System.out.println("8.-Buscar por numero, colonia y calle");
      System.out.println("9.-Salir");
      try {
        menu = new Scanner(System.in).nextInt();
      } catch (Exception e) {
        menu = 0;
      }
      switch (menu) {
        case 1:
          System.out.println("Ingresa la calle");
          entrada = new Scanner(System.in);
          try {
            calle = entrada.nextLine();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          System.out.println("Ingresa el numero de la casa");
          entrada = new Scanner(System.in);
          try {
            numero = entrada.nextInt();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          System.out.println("Ingresa la colonia de la casa");
          entrada = new Scanner(System.in);
          try {
            colonia = entrada.nextLine();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          System.out.println("Ingresa el ciudad de la casa");
          entrada = new Scanner(System.in);
          try {
            ciudad = entrada.nextLine();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          System.out.println("Ingresa el numero de pisos de la casa");
          entrada = new Scanner(System.in);
          try {
            numeroPisos = entrada.nextInt();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          System.out.println("Ingresa el precio de la casa");
          entrada = new Scanner(System.in);
          try {
            precio = entrada.nextDouble();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          System.out.println("Ingresa los metros cuadrados de la casa");
          entrada = new Scanner(System.in);
          try {
            metrosCuadrados = entrada.nextDouble();
          } catch (Exception e) {
            System.out.println("Valor inaceptable para campo");
            break;
          }

          casa = new Casa(calle, numero, colonia, ciudad, numeroPisos, precio, metrosCuadrados);
          boolean existe = false;
          for(Casa c : list){
            if(c.equals(casa)){
              existe = true;
              break;
            }
          }
          if(!existe) {
            list.add(casa);
            System.out.println("La casa ha sido agregada exitosamente a la lista");
          }else {
            System.out.println("La casa ya existe dentro de la lista");
          }
          break;

        case 2:
          System.out.println("Ingresa el indice de la casa a editar");
          entrada = new Scanner(System.in);
          int indice = entrada.nextInt();
          try {
            casa = list.get(indice);
          } catch (Exception e) {
            System.out.println("Casa inexistente");
            break;
          }
          System.out.println("Se encontro la casa:");
          System.out.println(casa);
          System.out.println("Ingresa el campo a editar:");
          int submenu;
          do {
            System.out.println("1.-Calle");
            System.out.println("2.-Numero");
            System.out.println("3.-Colonia");
            System.out.println("4.-Ciudad");
            System.out.println("5.-Numero de pisos");
            System.out.println("6.-Precio");
            System.out.println("7.-Metros cuadrados");
            System.out.println("8.-Salir de edición");
            entrada = new Scanner(System.in);
            try {
              submenu = entrada.nextInt();
            } catch (Exception e) {
              submenu = 0;
            }
            menuEditar(submenu);
          }while (submenu != 8);
          break;
        case 3:
          System.out.println("Ingresa el indice de la casa a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          try {
            casa = list.get(indice);
          } catch (Exception e) {
            System.out.println("Casa inexistente");
            break;
          }
          System.out.println("Se encontro la casa");
          System.out.println(casa);
          break;
        case 4:
          System.out.println("Ingresa el indice de la casa a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          try {
            casa = list.get(indice);
          } catch (Exception e) {
            System.out.println("Casa inexistente");
            break;
          }
          System.out.println("Se encontro la casa a eliminar");
          list.remove(indice);
          System.out.println("Se elimino la casa:");
          System.out.println(casa);
          break;
        case 5:
          System.out.println("Lista de casas en el registro:");
          for (Casa i : list){
            System.out.println(i.toString());
          }
          break;
        case 6:
          for(int i =0 ; i < list.size(); i++){
            System.out.printf("\n[%d] => "+list.get(i).getCiudad(),i);
          }
          break;
        case 7:
          System.out.println("Ingresa la colonia de casa a buscar");
          entrada = new Scanner(System.in);
          calle = entrada.nextLine();
          for (Casa c : list) {
            if (calle.equals(c.getColonia())) {
              System.out.printf("\n[%d]"+c,list.indexOf(casa));
            }
          }
          break;
          case 8:
            System.out.println("Ingresa el numero, colonia y calle de la casa a buscar");
            entrada = new Scanner(System.in);
            try {
              numero = entrada.nextInt();
            } catch (Exception e) {
              System.out.println("Valor inaceptable para campo");
              break;
            }
            entrada = new Scanner(System.in);
            try {
              colonia = entrada.nextLine();
            } catch (Exception e) {
              System.out.println("Valor inaceptable para campo");
              break;
            }
            entrada = new Scanner(System.in);
            try {
              calle = entrada.nextLine();
            } catch (Exception e) {
              System.out.println("Valor inaceptable para campo");
              break;
            }
            for(Casa c : list){
              if(c.getNumero() == numero && c.getColonia().equals(colonia) && c.getCalle().equals(calle)){
                System.out.println(c);
              }
            }
            break;
        case 9:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
      System.out.println();
    }while(menu != 9);
  }

  public static void menuEditar(int opcion) {
    switch (opcion) {
      case 1:
        System.out.println("Ingresa la nueva calle");
        entrada = new Scanner(System.in);
        calle = entrada.nextLine();
        casa.setCalle(calle);
        break;
      case 2:
        System.out.println("Ingresa el nuevo numero");
        entrada = new Scanner(System.in);
        numero = entrada.nextInt();
        casa.setNumero(numero);
        break;
      case 3:
        System.out.println("Ingresa la nueva colonia");
        entrada = new Scanner(System.in);
        colonia = entrada.nextLine();
        casa.setColonia(colonia);
        break;
      case 4:
        System.out.println("Ingresa la nueva ciudad");
        entrada = new Scanner(System.in);
        ciudad = entrada.nextLine();
        casa.setCiudad(ciudad);
        break;
      case 5:
        System.out.println("Ingresa el nuevo numero de pisos");
        entrada = new Scanner(System.in);
        numeroPisos = entrada.nextInt();
        casa.setNumeroPisos(numeroPisos);
        break;
      case 6:
        System.out.println("Ingresa el nuevo precio");
        entrada = new Scanner(System.in);
        precio = entrada.nextDouble();
        casa.setPrecio(precio);
        break;
      case 7:
        System.out.println("Ingresa la nueva superficie");
        entrada = new Scanner(System.in);
        metrosCuadrados = entrada.nextDouble();
        casa.setMetrosCuadrados(metrosCuadrados);
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

