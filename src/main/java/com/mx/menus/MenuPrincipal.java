package com.mx.menus;

import java.util.Scanner;

public class MenuPrincipal {

  private final MenuMedico menuMedico = new MenuMedico();
  private final MenuIngeniero menuIngeniero = new MenuIngeniero();

  private final Scanner entrada = new Scanner(System.in);

  public void menu() {
    int option;
    do {
      System.out.println("\n Menu principal");
      System.out.println("1.-Registro de Ingeniero");
      System.out.println("2.-Registro de Medicos");
      System.out.println("3.-Salir...");
      try {
        option = entrada.nextInt();
      } catch (Exception e) {
        option = 0;
      }
      switch (option) {
        case 1:
          menuIngeniero.menu();
          break;
        case 2:
          menuMedico.menu();
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
      }
    } while (option != 3);
  }
}
