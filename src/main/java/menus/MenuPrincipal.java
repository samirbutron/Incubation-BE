package menus;

import java.util.Scanner;

public class MenuPrincipal {

  private static final Scanner entrada = new Scanner(System.in);
  public static void menuPrincipal () {
    int opcion;
    do {
      System.out.println("\n Menu principal");
      System.out.println("1.-Registro de pacientes");
      System.out.println("2.-Registro de medicos");
      System.out.println("3.-Salir...");
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          MenuPaciente.menuPaciente();
          break;
        case 2:
          MenuMedico.menuMedico();
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
      }
    } while (opcion != 3);

  }
}
