package com.mx.menus;

import java.util.Scanner;

public class MenuPrincipal {

  private MenuMascota menuMascota = new MenuMascota();
  private MenuPersona menuPersona = new MenuPersona();

  private final Scanner entrada = new Scanner(System.in);
  public void menu() {
    int option;
    do {
      System.out.println("\n Menu principal");
      System.out.println("1.-Registro de Personas");
      System.out.println("2.-Registro de Mascotas");
      System.out.println("3.-Salir...");
      try {
        option = entrada.nextInt();
      } catch (Exception e) {
        option = 0;
      }
      switch (option) {
        case 1:
          menuPersona.menu();
          break;
        case 2:
          menuMascota.menu();
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
      }
    } while (option != 3);
  }
}
