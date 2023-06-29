package data;

import classes.Medico;
import classes.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorMedicos {

  private static List<Medico> medicos = new ArrayList<>();

  public GestorMedicos(){
    medicos = new ArrayList<>();
  }

  public static void agregarMedico(){
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa el nombre");
    //entrada = new Scanner(System.in);
    String nombre = entrada.nextLine();

    System.out.println("Ingresa el apellido");
    entrada = new Scanner(System.in);
    String apellido = entrada.nextLine();

    System.out.println("Ingrese la edad");
    entrada = new Scanner(System.in);
    int edad = entrada.nextInt();

    System.out.println("Ingrese el genero");
    entrada = new Scanner(System.in);
    String genero = entrada.next();

    System.out.println("Ingrese el telefono");
    entrada = new Scanner(System.in);
    String telefono = entrada.nextLine();

    System.out.println("Ingresa la especialidad");
    entrada = new Scanner(System.in);
    String especialidad = entrada.nextLine();

    System.out.println("Ingresa el turno");
    entrada = new Scanner(System.in);
    String turno = entrada.nextLine();

    System.out.println("Ingresa la seccion");
    entrada = new Scanner(System.in);
    String seccion = entrada.nextLine();

    Medico medico = new Medico(nombre,apellido,edad,genero,telefono,especialidad,turno,seccion);

    boolean existe = false;
    for (Medico m : medicos){
      if(m.equals(medico)){
        System.out.println("El medico ya existe en el registro");
        existe = true;
        break;
      }
    }
    if(!existe) {
      medicos.add(medico);
      System.out.println("El medico ha sido guardado con exito");
    }
  }

  public static void agregarPaciente(int indice){
    System.out.println("Ingresa el indice del paciente a agregar");
    Scanner entrada = new Scanner(System.in);
    int indice2 = entrada.nextInt();
    Paciente paciente = GestorPacientes.obtenerPaciente(indice2);
    if(paciente != null) {
      medicos.get(indice).getPacientes().add(paciente);
      System.out.println("Paciente agregado exitosamente");
    }else {
      System.out.println("Paciente no encontrado");
    }
  }

  public static void quitarPaciente(int indice){
    System.out.println("Ingresa el indice del paciente a quitar");
    Scanner entrada = new Scanner(System.in);
    int indice2 = entrada.nextInt();
    Paciente paciente = GestorPacientes.obtenerPaciente(indice2);
    if(paciente != null) {
      medicos.get(indice).getPacientes().add(paciente);
      System.out.println("Paciente agregado exitosamente");
    }else {
      System.out.println("Paciente no encontrado");
    }
  }

  public static boolean verificarMedicoExiste(int indice) {
    if (indice >= medicos.size()) {
      System.out.println("No existen medicos con ese indice");
      return false;
    }else {
      System.out.println("El medico con ese indice es el siguiente: ");
      System.out.println(medicos.get(indice).toString());
      return true;
    }
  }

  public static void editarNombreMedico (int indice){
    System.out.println("Ingrese el nuevo nombre");
    Scanner entrada = new Scanner(System.in);
    String nombre = entrada.nextLine();
    medicos.get(indice).setNombre(nombre);
  }

  public static void editarApellidoMedico(int indice) {
    System.out.println("Ingrese el nuevo apellido");
    Scanner entrada = new Scanner(System.in);
    String apellido = entrada.nextLine();
    medicos.get(indice).setApellido(apellido);
  }

  public static void editarEdadMedico(int indice) {
    System.out.println("Ingrese la nueva edad");
    Scanner entrada = new Scanner(System.in);
    int edad = entrada.nextInt();
    medicos.get(indice).setEdad(edad);
  }

  public static void editarGeneroMedico(int indice) {
    System.out.println("Ingrese el nuevo genero");
    Scanner entrada = new Scanner(System.in);
    String genero = entrada.nextLine();
    medicos.get(indice).setGenero(genero);
  }

  public static void editarTelefonoMedico(int indice) {
    System.out.println("Ingrese el nuevo telefono");
    Scanner entrada = new Scanner(System.in);
    String telefono = entrada.nextLine();
    medicos.get(indice).setTelefono(telefono);
  }

  public static void eliminarMedico(int indice) {
    medicos.remove(indice);
    System.out.println("Medico eliminado exitosamente");
  }

  public static void listarMedicos() {
    if(medicos.isEmpty()){
      System.out.println("No hay medicos en el registro");
    }else {
      for (Medico m : medicos) {
        System.out.printf("\n[%d] =>" + m.getNombre() + " " + m.getApellido(),
            medicos.indexOf(m));
      }
    }
  }

  public static void mostrarMedicos() {
    if (medicos.isEmpty()) {
      System.out.println("No hay medicos en el registro");
    } else {
      for (Medico m : medicos) {
        System.out.println(m.toString());
      }
    }
  }

  public static void buscarMedicoPorNombre(String nombre) {
    if (medicos.isEmpty()){
      System.out.println("No existen medicos en el registro");
    }else {
      for(Medico m : medicos){
        if(m.getNombre().equalsIgnoreCase(nombre)){
          System.out.println(m);
        }
      }
    }
  }

  public static void buscarMedicoPorApellido(String apellido) {
    if (medicos.isEmpty()){
      System.out.println("No existen medicos en el registro");
    }else {
      for(Medico m : medicos){
        if(m.getApellido().equalsIgnoreCase(apellido)){
          System.out.println(m);
        }
      }
    }
  }

  public static void buscarMedicoPorTurno(String turno) {
    if (medicos.isEmpty()) {
      System.out.println("No existen medicos en el registro");
    } else {
      for (Medico m : medicos){
        if (m.getTurno().equalsIgnoreCase(turno)){
          System.out.println(m);
        }
      }
    }
  }
}
