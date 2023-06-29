package menus;

import data.GestorMedicos;
import java.util.Scanner;

public class MenuMedico {

  private static Scanner entrada = new Scanner(System.in);
  
  public static void menuMedico(){
    int opcion;
    do{
      System.out.println("\n*****Menu de medicos*******");
      System.out.println("1.-Agregar");
      System.out.println("2.-Editar");
      System.out.println("3.-Eliminar");
      System.out.println("4.-Listar");
      System.out.println("5.-Mostrar");
      System.out.println("6.-Buscar por indice");
      //TODO buscar por nombre y apellido
      System.out.println("7.-Buscar por Nombre");
      System.out.println("8.-Buscar por Apellido");
      System.out.println("9.-Buscar por Turno");
      System.out.println("10.-Regresar al menu principal");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          GestorMedicos.agregarMedico();
          break;
        case 2:
          System.out.println("Ingresa el indice del medico a editar");
          entrada = new Scanner(System.in);
          int indice = entrada.nextInt();
          if(GestorMedicos.verificarMedicoExiste(indice)) {
            menuEditarMedico(indice);
          }
          break;
        case 3:
          System.out.println("Ingresa el indice del paciente a eliminar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
          if(GestorMedicos.verificarMedicoExiste(indice)) {
            GestorMedicos.eliminarMedico(indice);
          }
          break;
        case 4:
          GestorMedicos.listarMedicos();
          break;
        case 5:
          GestorMedicos.mostrarMedicos();
          break;
        case 6:
          System.out.println("Ingresa el indice del medico a buscar");
          entrada = new Scanner(System.in);
          indice = entrada.nextInt();
            GestorMedicos.verificarMedicoExiste(indice);
          break;
        case 7:
          System.out.println("Ingresa el nombre del medico a buscar");
          entrada = new Scanner(System.in);
          String nombre = entrada.nextLine();
          GestorMedicos.buscarMedicoPorNombre(nombre);
          break;
        case 8:
          System.out.println("Ingresa el apellido del medico a buscar");
          entrada = new Scanner(System.in);
          String apellido = entrada.nextLine();
          GestorMedicos.buscarMedicoPorApellido(apellido);
          break;
        case 9:
          System.out.println("Ingresa el turno por el que se busca a los medicos");
          entrada = new Scanner(System.in);
          String alergia = entrada.nextLine();
          GestorMedicos.buscarMedicoPorTurno(alergia);
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

  public static void menuEditarMedico(int indice){
    int opcion;
    do {
      System.out.println("Menu editar Medico");
      System.out.println("1.-Nombre");
      System.out.println("2.- Apellido");
      System.out.println("3.- Edad");
      System.out.println("4.- Genero");
      System.out.println("5.- Telefono");
      System.out.println("6.- Pacientes");
      System.out.println("7.- Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion) {
        case 1:
          GestorMedicos.editarNombreMedico(indice);
          break;
        case 2:
          GestorMedicos.editarApellidoMedico(indice);
          break;
        case 3:
          GestorMedicos.editarEdadMedico(indice);
          break;
        case 4:
          GestorMedicos.editarGeneroMedico(indice);
          break;
        case 5:
          GestorMedicos.editarTelefonoMedico(indice);
          break;
        case 6:
          menuPacientes(indice);
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

  public static void menuPacientes(int indice){
    int opcion;
    do{
      System.out.println("Menu de pacientes");
      System.out.println("1.-Agregar paciente");
      System.out.println("2.-Remover paciente");
      System.out.println("3.-Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          GestorMedicos.agregarPaciente(indice);
          break;
        case 2:
          GestorMedicos.quitarPaciente(indice);
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
