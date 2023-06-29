package menus;

import data.GestorPacientes;
import java.util.Scanner;

public class MenuPaciente {

  private static Scanner entrada = new Scanner(System.in);

  public static void menuPaciente() {
    int opcion;
    do{
      System.out.println("\n*****Menu de paciente*******");
      System.out.println("1.-Agregar");
      System.out.println("2.-Editar");
      System.out.println("3.-Eliminar");
      System.out.println("4.-Listar");
      System.out.println("5.-Mostrar");

      System.out.println("6.-Buscar por indice");
      //TODO campos juntos
      System.out.println("7.-Buscar por Nombre");
      System.out.println("8.-Buscar por Apellido");
      System.out.println("9.-Buscar por Alergia");
      System.out.println("10.-Regresar al menu principal");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          GestorPacientes.agregarPaciente();
          break;
        case 2:
          System.out.println("Ingresa el indice del paciente a editar");
          entrada = new Scanner(System.in);
          int indice = entrada.nextInt();
          if(GestorPacientes.verificarPacienteExiste(indice)) {
          menuEditarPaciente(indice);
          }
          break;
        case 3:
          System.out.println("Ingresa el indice del paciente a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          if(GestorPacientes.verificarPacienteExiste(indice)) {
          GestorPacientes.eliminarPaciente(indice);
          }
          break;
        case 4:
            GestorPacientes.listarPacientes();
          break;
        case 5:
            GestorPacientes.mostrarPacientes();
          break;
          case 6:
            System.out.println("Ingresa el indice del paciente a buscar");
            entrada = new Scanner(System.in);
            indice = entrada.nextInt();
            GestorPacientes.verificarPacienteExiste(indice);
            break;
        case 7:
          System.out.println("Ingresa el nombre del paciente a buscar");
          entrada = new Scanner(System.in);
          String nombre = entrada.nextLine();
          GestorPacientes.buscarPacientePorNombre(nombre);
          break;
        case 8:
          System.out.println("Ingresa el apellido del paciente a buscar");
          entrada = new Scanner(System.in);
          String apellido = entrada.nextLine();
          GestorPacientes.buscarPacientePorApellido(apellido);
          break;
        case 9:
          System.out.println("Ingresa la alergia por la que se busca a los pacientes");
          entrada = new Scanner(System.in);
          String alergia = entrada.nextLine();
          GestorPacientes.buscarPacientePorAlergia(alergia);
          break;
        case 10:
          System.out.println("Saliendo del menu paciente...");
          break;
        default:
          System.out.println("Opcion invalida, intente otra opcion");
          break;
      }
    }while (opcion != 10);
  }

  public static void menuEditarPaciente(int indice){
    int opcion;
    do {
      System.out.println("Menu editar Paciente");
      System.out.println("1.-Nombre");
      System.out.println("2.- Apellido");
      System.out.println("3.- Edad");
      System.out.println("4.- Genero");
      System.out.println("5.- Telefono");
      System.out.println("6.- Padecimientos");
      System.out.println("7.- Alergias");
      System.out.println("8.- Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          GestorPacientes.editarNombrePaciente(indice);
          break;
        case 2:
          GestorPacientes.editarApellidoPaciente(indice);
          break;
        case 3:
          GestorPacientes.editarEdadPaciente(indice);
          break;
        case 4:
          GestorPacientes.editarGeneroPaciente(indice);
          break;
        case 5:
          GestorPacientes.editarTelefonoPaciente(indice);
          break;
        case 6:
          menuPadecimientos(indice);
          break;
        case 7:
          menuAlergias(indice);
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

  public static void menuPadecimientos(int indice){
    int opcion;
    do{
      System.out.println("Menu de padecimientos");
      System.out.println("1.-Agregar padecimiento");
      System.out.println("2.-Remover padecimiento");
      System.out.println("3.-Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          GestorPacientes.agregarAlergia(indice);
          break;
        case 2:
          GestorPacientes.quitarAlergia(indice);
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
        default:
          break;
      }
    }while (opcion != 3);
  }

  public static void menuAlergias(int indice) {
    int opcion;
    do{
      System.out.println("Menu de alergias");
      System.out.println("1.-Agregar alergias");
      System.out.println("2.-Remover alergias");
      System.out.println("3.-Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          GestorPacientes.agregarPadecimiento(indice);
          break;
        case 2:
          GestorPacientes.quitarPadecimiento(indice);
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
        default:
          break;
      }
    }while (opcion != 3);
  }
}
