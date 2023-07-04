package com.mx.menus;

import com.mx.entidad.Articulo;
import com.mx.service.Implementacion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuArticulo {

  private String nombre, marca, color, material;
  private double precio;
  private int stock, indice;
  private final Implementacion implementacion = Implementacion.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
    int opcion;
    Articulo articulo;
    do {
      System.out.println("\n*****Menu de articulo*******");
      System.out.println("1.-Agregar Articulo");
      System.out.println("2.-Editar Articulo");
      System.out.println("3.-Eliminar Articulo");
      System.out.println("4.-Listar Articulo");
      System.out.println("5.-Mostrar Articulo ");
      System.out.println("6.-Buscar por indice");
      System.out.println("7.-Buscar Articulo mas caro");
      System.out.println("8.-Regresar al menu principal");
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
          System.out.println("Ingresa la marca");
          entrada = new Scanner(System.in);
          marca = entrada.nextLine();
          System.out.println("Ingresa el stock");
          entrada = new Scanner(System.in);
          stock = entrada.nextInt();
          System.out.println("Ingresa el precio");
          entrada = new Scanner(System.in);
          precio = entrada.nextDouble();
          System.out.println("Ingresa el color");
          entrada = new Scanner(System.in);
          color = entrada.nextLine();
          System.out.println("Ingresa el material");
          entrada = new Scanner(System.in);
          material = entrada.nextLine();
          articulo = new Articulo(nombre, marca, stock, precio, color, material);
          implementacion.guardar(articulo);
          break;
        case 2:
          System.out.println("Ingresa el indice del articulo a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          articulo = (Articulo) implementacion.buscar(indice, "articulo");
          if (articulo == null) {
            System.out.println("El articulo que tratas de editar no existe");
          } else {
            menuEditarArticulo(indice, articulo);
          }
          break;
        case 3:
          System.out.println("Ingresa el indice del articulo a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          articulo = (Articulo) implementacion.buscar(indice, "articulo");
          if (articulo == null) {
            System.out.println("El articulo a eliminar no existe");
          } else {
            implementacion.eliminar(indice, "articulo");
            System.out.println("Se borro el articulo:");
            System.out.println(articulo);
          }
          break;
        case 4:
          implementacion.listar("articulo");
          break;
        case 5:
          implementacion.mostrar("articulo");
          break;
        case 6:
          System.out.println("Ingresa el indice del articulo a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          articulo = (Articulo) implementacion.buscar(indice, "articulo");
          if (articulo == null) {
            System.out.println("La articulo buscado no existe");
          } else {
            System.out.println("Se encontro el articulo:");
            System.out.println(articulo);
          }
          break;
        case 7:
          implementacion.buscarArticuloMasCaro();
          break;
        case 8:
          System.out.println("Saliendo del menu Articulo...");
          break;
        default:
          System.out.println("Opcion invalida, intente otra opcion");
          break;
      }
    } while (opcion != 8);
  }

  private void menuEditarArticulo(int indice, Articulo articulo) {
    int opcion;
    do {
      System.out.println("Menu editar Articulo");
      System.out.println("1.- Nombre");
      System.out.println("2.- Marca");
      System.out.println("3.- Stock");
      System.out.println("4.- Precio");
      System.out.println("5.- Color");
      System.out.println("6.- Material");
      System.out.println("7.- Salir");
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
          articulo.setNombre(nombre);
          implementacion.editar(articulo, indice);
          break;
        case 2:
          System.out.println("Ingresa la marca");
          entrada = new Scanner(System.in);
          marca = entrada.nextLine();
          articulo.setMarca(marca);
          implementacion.editar(articulo, indice);
          break;
        case 3:
          System.out.println("Ingresa el stock");
          entrada = new Scanner(System.in);
          stock = entrada.nextInt();
          articulo.setStock(stock);
          implementacion.editar(articulo, indice);
          break;
        case 4:
          System.out.println("Ingresa la precio");
          entrada = new Scanner(System.in);
          precio = entrada.nextInt();
          articulo.setPrecio(precio);
          implementacion.editar(articulo, indice);
          break;
        case 5:
          System.out.println("Ingresa el color");
          entrada = new Scanner(System.in);
          color = entrada.nextLine();
          articulo.setColor(color);
          implementacion.editar(articulo, indice);
          break;
        case 6:
          System.out.println("Ingresa el material");
          entrada = new Scanner(System.in);
          material = entrada.nextLine();
          articulo.setMaterial(material);
          implementacion.editar(articulo, indice);
          break;
        case 7:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
    } while (opcion != 7);
  }
}
