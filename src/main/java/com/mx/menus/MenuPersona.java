package com.mx.menus;

import com.mx.entidad.Mascota;
import com.mx.entidad.Persona;
import com.mx.service.ImpMascota;
import com.mx.service.ImpPersona;
import java.util.Scanner;
public class MenuPersona {

  private String nombre, apellido, ciudad;
  private int edad;
  private final ImpPersona impPersona = ImpPersona.getInstance();
  private static Scanner entrada = new Scanner(System.in);

  public void menu() {
    int opcion;
    String curp;
    Persona persona;
    do{
      System.out.println("\n*****Menu de persona*******");
      System.out.println("1.-Agregar Persona");
      System.out.println("2.-Editar Persona");
      System.out.println("3.-Eliminar Persona");
      System.out.println("4.-Listar Persona");
      System.out.println("5.-Mostrar Persona ");
      System.out.println("6.-Buscar por CURP");
      System.out.println("7.-Buscar persona con mas mascotas");
      System.out.println("8.-Mascotas por persona");
      System.out.println("9.-Regresar al menu principal");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          System.out.println("Ingresa el CURP");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          System.out.println("Ingresa el nombre");
          entrada = new Scanner(System.in);
          nombre = entrada.nextLine();
          System.out.println("Ingresa el apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          System.out.println("Ingresa la edad");
          entrada = new Scanner(System.in);
          edad = entrada.nextInt();
          System.out.println("Ingresa la ciudad");
          entrada = new Scanner(System.in);
          ciudad = entrada.nextLine();
          persona = new Persona(curp,nombre,apellido,edad,ciudad);
          impPersona.guardar(persona);
          break;
        case 2:
          System.out.println("Ingresa CURP de la persona");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          persona = new Persona(curp);
          persona = impPersona.buscar(persona);
          if (persona == null) {
            System.out.println("La persona que tratas de editar no existe");
          }else {
            menuEditarPersona(persona);
          }
          break;
        case 3:
          System.out.println("Ingresa el CURP del persona a eliminar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          persona = new Persona(curp);
          persona = impPersona.buscar(persona);
          if (persona == null){
            System.out.println("El persona a eliminar no existe");
          } else {
            impPersona.eliminar(persona);
            System.out.println("Se borro el persona:");
            System.out.println(persona);
          }
          break;
        case 4:
          impPersona.listar();
          break;
        case 5:
          impPersona.mostrar();
          break;
        case 6:
          System.out.println("Ingresa el CURP de la persona a buscar");
          entrada = new Scanner(System.in);
          curp = entrada.nextLine();
          //UPPERCASE para caso de CURP
          persona = new Persona(curp.toUpperCase());
          persona = impPersona.buscar(persona);
          if (persona == null){
            System.out.println("La persona buscada no existe");
          }else {
            System.out.println("Se encontro el persona:");
            System.out.println(persona);
          }
          break;
        case 7:
          impPersona.personaConMasMascotas();
          break;
        case 8:
          impPersona.mascotaPorPersona();
          break;
        case 9:
          System.out.println("Saliendo del menu Persona...");
          break;
        default:
          System.out.println("Opcion invalida, intente otra opcion");
          break;
      }
    }while (opcion != 9);
  }

  private void menuEditarPersona(Persona persona) {
    int opcion;
    do {
      System.out.println("Menu editar Medico");
      System.out.println("1.-Nombre");
      System.out.println("2.- Apellido");
      System.out.println("3.- Edad");
      System.out.println("4.- Ciudad");
      System.out.println("5.- Mascotas");
      System.out.println("6.- Salir");
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
          persona.setCiudad(nombre);
          impPersona.editar(persona);
          break;
        case 2:
          System.out.println("Ingresa la apellido");
          entrada = new Scanner(System.in);
          apellido = entrada.nextLine();
          persona.setApellido(apellido);
          impPersona.editar(persona);
          break;
        case 3:
          System.out.println("Ingresa la edad");
          entrada = new Scanner(System.in);
          edad = entrada.nextInt();
          persona.setEdad(edad);
          impPersona.editar(persona);
          break;
        case 4:
          System.out.println("Ingresa el ciudad");
          entrada = new Scanner(System.in);
          ciudad = entrada.nextLine();
          persona.setCiudad(ciudad);
          impPersona.editar(persona);
          break;
        case 5:
          menuMascotas(persona);
          break;
        case 6:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion invalida, intente de nuevo");
          break;
      }
    } while (opcion != 6);
  }

  public void menuMascotas(Persona persona){
    int opcion;
    Mascota mascota;
    ImpMascota impMascota = ImpMascota.getInstance();
    do{
      System.out.println("Menu de edicion de mascotas");
      System.out.println("1.-Agregar mascota");
      System.out.println("2.-Remover mascota");
      System.out.println("3.-Salir");
      entrada = new Scanner(System.in);
      try {
        opcion = entrada.nextInt();
      } catch (Exception e) {
        opcion = 0;
      }
      switch (opcion){
        case 1:
          System.out.println("Ingresa el nombre de la mascota a agregar");
          entrada = new Scanner(System.in);
          nombre = entrada.nextLine();
          mascota = new Mascota(nombre);
          mascota = impMascota.buscar(mascota);
          if (mascota == null || persona.getMascotaList().contains(mascota)){
            System.out.println("La mascota a agregar no existe o ya se tiene agregada");
          } else {
            persona.getMascotaList().add(mascota);
            impPersona.editar(persona);
            System.out.println("Se agrego la siguiente mascota a la persona:");
            System.out.println(mascota);
          }
          break;
        case 2:
            System.out.println("Ingresa el nombre de la mascota a retirar");
            entrada = new Scanner(System.in);
            nombre = entrada.nextLine();
            mascota = new Mascota(nombre);
            mascota = impMascota.buscar(mascota);
          if (mascota == null || persona.getMascotaList().isEmpty()){
            System.out.println("El mascota a retirar no existe o no hay mascotas para retirar");
          } else {
            persona.getMascotaList().remove(mascota);
            impPersona.editar(persona);
            System.out.println("Se retiro el siguiente mascota a la persona:");
            System.out.println(mascota);
          }
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
