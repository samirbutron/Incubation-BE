package com.mx.menus;

import com.mx.entidad.Consumible;
import com.mx.service.Implementacion;
import java.util.Scanner;

public class MenuConsumible {


  private String nombre, marca, tipo, sabor, caducidad;
  private int stock, indice;
  private double precio;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
    {
      int opcion;
      Consumible consumible;
      do {
        System.out.println("\n*****Menu de consumible*******");
        System.out.println("1.-Agregar Consumible");
        System.out.println("2.-Editar Consumible");
        System.out.println("3.-Eliminar Consumible");
        System.out.println("4.-Listar Consumibles");
        System.out.println("5.-Mostrar Consumibles");
        System.out.println("6.-Buscar por Indice");
        System.out.println("7.-Buscar consumible mas barato");
        System.out.println("8.-Valor de consumibles con impuesto");
        System.out.println("9.-Regresar al menu principal");
        entrada = new Scanner(System.in);
        try {
          opcion = entrada.nextInt();
        } catch (Exception e) {
          opcion = 0;
        }
        switch (opcion) {
          case 1:
            System.out.println("Ingresa el nombre del consumible");
            entrada = new Scanner(System.in);
            nombre = entrada.nextLine();
            System.out.println("Ingresa la marca");
            entrada = new Scanner(System.in);
            marca = entrada.nextLine();
            System.out.println("Ingresa el stock");
            entrada = new Scanner(System.in);
            stock = entrada.nextInt();
            System.out.println("Ingresa el precio");
            entrada = new Scanner(System.in);
            precio = entrada.nextDouble();
            System.out.println("Ingresa la caducidad (dd/MM/yyy)");
            entrada = new Scanner(System.in);
            caducidad = entrada.nextLine();
            System.out.println("Ingresa el tipo");
            entrada = new Scanner(System.in);
            tipo = entrada.nextLine();
            System.out.println("Ingresa el sabor");
            entrada = new Scanner(System.in);
            sabor = entrada.nextLine();
            consumible = new Consumible(nombre, marca, stock, precio, caducidad, tipo, sabor);
            implementacion.guardar(consumible);
            break;
          case 2:
            System.out.println("Ingresa el indice del consumible a editar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            consumible = (Consumible) implementacion.buscar(indice, "consumible");
            if (consumible == null) {
              System.out.println("El consumible que tratas de editar no existe");
            } else {
              menuEditarConsumible(indice,consumible);
            }
            break;
          case 3:
            System.out.println("Ingresa el Indice del consumible a eliminar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            consumible = (Consumible) implementacion.buscar(indice, "consumible");
            if (consumible == null) {
              System.out.println("El consumible a eliminar no existe");
            } else {
              implementacion.eliminar(indice, "consumible");
              System.out.println("Se borro el consumible:");
              System.out.println(consumible);
            }
            break;
          case 4:
            implementacion.listar("consumible");
            break;
          case 5:
            implementacion.mostrar("consumible");
            break;
          case 6:
            System.out.println("Ingresa el Indice de la consumible a buscar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            consumible = (Consumible) implementacion.buscar(indice, "consumible");
            if (consumible == null) {
              System.out.println("El consumible buscado no existe");
            } else {
              System.out.println("Se encontro el consumible:");
              System.out.println(consumible);
            }
            break;
          case 7:
            implementacion.bucarConsumibleMasBarato();
            break;
          case 8:
            implementacion.calcularValorConsumiblesConImpuesto();
            break;
          case 9:
            System.out.println("Saliendo del menu Consumible...");
            break;
          default:
            System.out.println("Opcion invalida, intente otra opcion");
            break;
        }
      } while (opcion != 9);
    }
  }

  private void menuEditarConsumible(int indice, Consumible consumible) {
    int opcion;
    do {
      System.out.println("Menu editar Consumible");
      System.out.println("1.- Nombre");
      System.out.println("2.- Marca");
      System.out.println("3.- Stock");
      System.out.println("4.- Precio");
      System.out.println("5.- Caducidad");
      System.out.println("6.- Tipo");
      System.out.println("7.- Sabor");
      System.out.println("8.- Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          System.out.println("Ingresa el Nombre");
          entrada = new Scanner(System.in);
          nombre = entrada.nextLine();
          consumible.setNombre(nombre);
          implementacion.editar(consumible, indice);
          break;
        case 2:
          System.out.println("Ingresa la Marca");
          entrada = new Scanner(System.in);
          marca = entrada.nextLine();
          consumible.setMarca(marca);
          implementacion.editar(consumible, indice);
          break;
        case 3:
          System.out.println("Ingresa el Stock");
          entrada = new Scanner(System.in);
          stock = entrada.nextInt();
          consumible.setStock(stock);
          implementacion.editar(consumible, indice);
          break;
        case 4:
          System.out.println("Ingresa los Precio");
          entrada = new Scanner(System.in);
          precio = entrada.nextInt();
          consumible.setPrecio(precio);
          implementacion.editar(consumible, indice);
          break;
        case 5:
          System.out.println("Ingresa la Caducidad (dd/MM/yyy)");
          entrada = new Scanner(System.in);
          caducidad = entrada.nextLine();
          consumible.setCaducidad(caducidad);
          implementacion.editar(consumible, indice);
          break;
        case 6:
          System.out.println("Ingresa el Tipo");
          entrada = new Scanner(System.in);
          tipo = entrada.nextLine();
          consumible.setTipo(tipo);
          implementacion.editar(consumible, indice);
          break;
        case 7:
          System.out.println("Ingresa el Sabor");
          entrada = new Scanner(System.in);
          sabor = entrada.nextLine();
          consumible.setSabor(sabor);
          implementacion.editar(consumible, indice);
          break;
        case 8:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
    } while (opcion != 8);
  }
}
