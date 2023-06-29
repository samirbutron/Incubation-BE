package data;

import classes.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPacientes {
  private static List<Paciente> pacientes = new ArrayList<>();

  public GestorPacientes(){
    pacientes = new ArrayList<>();
  }

  public static Paciente obtenerPaciente(int indice) {
    if (verificarPacienteExiste(indice)) {
      return pacientes.get(indice);
    }
    return null;
  }
  public static void agregarPaciente(){
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

    System.out.println("Ingresa el NSS");
    entrada = new Scanner(System.in);
    String nss = entrada.nextLine();

    Paciente paciente = new Paciente(nombre,apellido,edad,genero,telefono, nss);

    boolean existe = false;
    for (Paciente p : pacientes){
      if(p.equals(paciente)){
        System.out.println("El paciente ya existe en el registro");
        existe = true;
        break;
      }
    }
    if(!existe) {
      pacientes.add(paciente);
      System.out.println("El paciente ha sido guardado con exito");
    }
  }

  public static void agregarPadecimiento(int indice){
    System.out.println("Ingresa el padecimiento a agregar");
    Scanner entrada = new Scanner(System.in);
    String padecimiento = entrada.nextLine();
    List<String> padecimientos = pacientes.get(indice).getPadecimientos();
    if (!padecimientos.contains(padecimiento)){
      padecimientos.add(padecimiento);
    }else {
      System.out.println("Este paciente ya tiene ese padecimiento");
    }
  }
  public static void quitarPadecimiento(int indice){
    List<String> padecimientos = pacientes.get(indice).getPadecimientos();
    Scanner entrada = new Scanner(System.in);
    String padecimiento = entrada.nextLine();
    if(padecimiento.isEmpty()){
      System.out.println("Este paciente no tiene padecimientos");
    }else if(padecimientos.contains(padecimiento)){
      padecimientos.remove(padecimiento);
    }else {
      System.out.println("Padecimiento no encontrado");
    }
  }

  public static void agregarAlergia(int indice){
    System.out.println("Ingresa la alergia a agregar");
    Scanner entrada = new Scanner(System.in);
    String alergia = entrada.nextLine();
    List<String> alergias = pacientes.get(indice).getAlergias();
    if (!alergias.contains(alergia)){
      alergias.add(alergia);
    }else {
      System.out.println("Este paciente ya tiene esa alergia");
    }
  }

  public static void quitarAlergia(int indice){
    System.out.println("Ingresa la alergia a quitar");
    Scanner entrada = new Scanner(System.in);
    String alergia = entrada.nextLine();
    List<String> alergias = pacientes.get(indice).getAlergias();
    if(alergias.isEmpty()){
      System.out.println("Este paciente no tiene alergias");
    }else if(alergias.contains(alergia)){
      alergias.remove(alergia);
    }else {
      System.out.println("Alergia no encontrado");
    }
  }

  public static boolean verificarPacienteExiste(int indice) {
    if (indice >= pacientes.size()) {
      System.out.println("No existen pacientes con ese indice");
      return false;
    }else {
      System.out.println("El paciente con ese indice es el siguiente: ");
      System.out.println(pacientes.get(indice).toString());
      return true;
    }
  }

  public static void editarNombrePaciente (int indice){
    System.out.println("Ingrese el nuevo nombre");
    Scanner entrada = new Scanner(System.in);
    String nombre = entrada.nextLine();
    pacientes.get(indice).setNombre(nombre);
  }

  public static void editarApellidoPaciente(int indice) {
    System.out.println("Ingrese el nuevo apellido");
    Scanner entrada = new Scanner(System.in);
    String apellido = entrada.nextLine();
    pacientes.get(indice).setApellido(apellido);
  }

  public static void editarEdadPaciente(int indice) {
    System.out.println("Ingrese la nueva edad");
    Scanner entrada = new Scanner(System.in);
    int edad = entrada.nextInt();
    pacientes.get(indice).setEdad(edad);
  }

  public static void editarGeneroPaciente(int indice) {
    System.out.println("Ingrese el nuevo genero");
    Scanner entrada = new Scanner(System.in);
    String genero = entrada.nextLine();
    pacientes.get(indice).setGenero(genero);
  }

  public static void editarTelefonoPaciente(int indice) {
    System.out.println("Ingrese el nuevo telefono");
    Scanner entrada = new Scanner(System.in);
    String telefono = entrada.nextLine();
    pacientes.get(indice).setTelefono(telefono);
  }

  public static void eliminarPaciente(int indice) {
    pacientes.remove(indice);
    System.out.println("Paciente eliminado exitosamente");
  }

  public static void listarPacientes() {
    if(pacientes.isEmpty()){
      System.out.println("No hay pacientes en el registro");
    }else {
      for (Paciente p : pacientes) {
        System.out.printf("\n[%d] =>" + p.getNombre() + " " + p.getApellido(),
            pacientes.indexOf(p));
      }
    }
  }

  public static void mostrarPacientes() {
    if (pacientes.isEmpty()) {
      System.out.println("No hay pacientes en el registro");
    } else {
      for (Paciente p : pacientes) {
        System.out.println(p.toString());
      }
    }
  }

  public static void buscarPacientePorIndice(int indice) {
    System.out.println(pacientes.get(indice).toString());
  }

  public static void buscarPacientePorNombre(String nombre) {
    if (pacientes.isEmpty()){
      System.out.println("No existen pacientes en el registro");
    }else {
      for(Paciente p : pacientes){
        if(p.getNombre().equalsIgnoreCase(nombre)){
            System.out.println(p);
        }
      }
    }
  }

  public static void buscarPacientePorApellido(String apellido) {
    if (pacientes.isEmpty()){
      System.out.println("No existen pacientes en el registro");
    }else {
      for(Paciente p : pacientes){
        if(p.getApellido().equalsIgnoreCase(apellido)){
          System.out.println(p);
        }
      }
    }
  }

  public static void buscarPacientePorAlergia(String alergia) {
    if (pacientes.isEmpty()) {
      System.out.println("No existen pacientes en el registro");
    } else {
      for (Paciente p : pacientes){
        List<String> alergias = p.getAlergias();
        for(String a : alergias){
          if (a.equalsIgnoreCase(alergia)){
            System.out.println(p);
          }
        }
      }
    }
  }
}
