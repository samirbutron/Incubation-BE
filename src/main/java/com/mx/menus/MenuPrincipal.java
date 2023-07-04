package com.mx.menus;

import java.util.Scanner;

public class MenuPrincipal {

  private final MenuCuenta menuCuenta = new MenuCuenta();
  private final MenuCliente menuCliente = new MenuCliente();

  private final Scanner entrada = new Scanner(System.in);

  public void menu() {
    int option;
    do {
      System.out.println("\n Menu principal");
      System.out.println("1.-Registro de Clientes");
      System.out.println("2.-Registro de Cuentas");
      System.out.println("3.-Salir...");
      try {
        option = entrada.nextInt();
      } catch (Exception e) {
        option = 0;
      }
      switch (option) {
        case 1:
          menuCliente.menu();
          break;
        case 2:
          menuCuenta.menu();
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
      }
    } while (option != 3);
  }
}
