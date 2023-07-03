package com.mx.service;

import com.mx.entidad.Persona;
import com.mx.metodos.MetodosPersona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImpPersona implements MetodosPersona {

  private static ImpPersona instance;
  HashMap<String, Persona> personasHashMap = new HashMap<>();

  public ImpPersona () {
    Persona persona1 = new Persona("A100", "Juan", "Pérez", 25, "Ciudad de México");
    Persona persona2 = new Persona("A200", "María", "López", 30, "Guadalajara");
    Persona persona3 = new Persona("A300", "Carlos", "García", 42, "Monterrey");
    Persona persona4 = new Persona("A400", "Ana", "Sánchez", 19, "Puebla");
    personasHashMap.put(persona1.getCurp(), persona1);
    personasHashMap.put(persona2.getCurp(), persona2);
    personasHashMap.put(persona3.getCurp(), persona3);
    personasHashMap.put(persona4.getCurp(), persona4);
  }

  public static ImpPersona getInstance(){
    if (instance == null){
      instance = new ImpPersona();
    }
    return instance;
  }

  @Override
  public void guardar(Persona persona) {
    if(personasHashMap.isEmpty()){
      personasHashMap.put(persona.getCurp(), persona);
      System.out.println("Persona guardada de manera satisfactoria");
    }else {
      Persona p;
      boolean existe = false;
      for(String key : personasHashMap.keySet()){
        p = personasHashMap.get(key);
        if(persona.getCurp().equalsIgnoreCase(key)){
          System.out.println("El CURP que tratas de registrar ya existe");
          existe = true;
          break;
        } else if (persona.getNombre().equalsIgnoreCase(p.getNombre()) && persona.getNombre().equalsIgnoreCase(p.getApellido())) {
          System.out.println("Esta persona ya se encuentra registrada");
          existe = true;
          break;
        }
      }
      if (!existe){
        personasHashMap.put(persona.getCurp(), persona);
        System.out.println("El persona se agrego de manera satisfactoria");
      }
    }
  }

  @Override
  public void editar(Persona persona) {
    personasHashMap.put(persona.getCurp(), persona);
  }

  @Override
  public void eliminar(Persona persona) {
    personasHashMap.remove(persona.getCurp());
  }

  @Override
  public Persona buscar(Persona persona) {
    if(personasHashMap.isEmpty()){
      return null;
    }else {
      for (String key : personasHashMap.keySet()){
        if (persona.getCurp().equalsIgnoreCase(key)){
          persona = personasHashMap.get(key);
          return persona;
        }
      }
    }
    return null;
  }

  @Override
  public void mostrar() {
    System.out.println(personasHashMap);
  }

  @Override
  public void listar() {
    if (personasHashMap.isEmpty()){
      System.out.println("No existen personas para listar");
    }else {
      for (String key : personasHashMap.keySet()){
        System.out.println(personasHashMap.get(key).toString());
        Persona p = personasHashMap.get(key);
        System.out.println("["+p.getCurp()+"]"+ p.getNombre()+" "+p.getApellido());
      }
    }
  }

  public void personaConMasMascotas(){
    int maximo = Integer.MIN_VALUE;
    List<Persona> personasMaximas = new ArrayList<>();

    if (personasHashMap.isEmpty()) {
      System.out.println("No hay personas en el registro");
    } else {
      for (Persona persona : personasHashMap.values()) {
        int cantidadMascotas = persona.getMascotaList().size();

        if (cantidadMascotas > maximo) {
          maximo = cantidadMascotas;
          personasMaximas.clear();
          personasMaximas.add(persona);
        } else if (cantidadMascotas == maximo) {
          personasMaximas.add(persona);
        }
      }

      if (!personasMaximas.isEmpty()) {
        System.out.println("Las personas con más mascotas son:");

        for (Persona persona : personasMaximas) {
          System.out.println(persona.getNombre());
        }
        System.out.println("Cantidad de mascotas: " + maximo);
      }
    }
  }

  public void mascotaPorPersona() {
    for (Persona persona : personasHashMap.values()){
      System.out.println(persona.getNombre()+" tiene "+persona.getMascotaList().size()+" mascotas");
    }
  }
}
