package com.mx.menus;

import com.mx.service.Implementacion;
import java.util.Scanner;

public class MenuPrincipal {

  private final MenuConsumible menuConsumible = new MenuConsumible();
  private final MenuArticulo menuArticulo = new MenuArticulo();

  private final Implementacion implementacion = Implementacion.getInstance();
  private final Scanner entrada = new Scanner(System.in);

  public void menu() {
    int option;
    do {
      System.out.println("\n Menu principal");
      System.out.println("1.-Registro de Articulo");
      System.out.println("2.-Registro de Consumibles");
      System.out.println("3.-Productos con mas valor");
      System.out.println("4.-Salir...");
      try {
        option = entrada.nextInt();
      } catch (Exception e) {
        option = 0;
      }
      switch (option) {
        case 1:
          menuArticulo.menu();
          break;
        case 2:
          menuConsumible.menu();
          break;
        case 3:
          implementacion.ProductosConMayorValor();
          break;
        case 4:
          System.out.println("Saliendo...");
          break;
      }
    } while (option != 4);
  }
}
