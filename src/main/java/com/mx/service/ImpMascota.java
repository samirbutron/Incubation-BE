package com.mx.service;

import com.mx.entidad.Mascota;
import com.mx.metodos.MetodosMascota;
import java.util.HashMap;
import java.util.Map;

public class ImpMascota implements MetodosMascota {

  private static ImpMascota instance;
  private final HashMap<String,Mascota> mascotaHashMap = new HashMap<>();

  public ImpMascota() {
    Mascota mascota1 = new Mascota("Max", 2, 5.7, "Perro");
    Mascota mascota2 = new Mascota("Luna", 1, 3.2, "Gato");
    Mascota mascota3 = new Mascota("Rocky", 1, 10.1, "Perro");
    Mascota mascota4 = new Mascota("Simba", 6, 1.5, "Gato");
    Mascota mascota5 = new Mascota("Poli", 3, 1.5, "Perico");
    mascotaHashMap.put(mascota1.getNombre(),mascota1);
    mascotaHashMap.put(mascota2.getNombre(),mascota2);
    mascotaHashMap.put(mascota3.getNombre(),mascota3);
    mascotaHashMap.put(mascota4.getNombre(),mascota4);
  }

  public static ImpMascota getInstance(){
    if (instance == null){
      instance = new ImpMascota();
    }
    return instance;
  }

  @Override
  public void guardar(Mascota mascota) {
    if(mascotaHashMap.isEmpty()){
      mascotaHashMap.put(mascota.getNombre(), mascota);
      System.out.println("Mascota guardado de manera satisfactoria");
    }else {
      Mascota m;
      boolean existe = false;
      for(String key : mascotaHashMap.keySet()){
        m = mascotaHashMap.get(key);
        if(mascota.getNombre().equalsIgnoreCase(key)){
          System.out.println("El nombre que tratas de registrar ya existe");
          existe = true;
          break;
        } else if (mascota.getEdad() == m.getEdad() && mascota.getEspecie().equalsIgnoreCase(m.getEspecie())) {
          System.out.println("Este mascota ya se encuentra registrado");
          existe = true;
          break;
        }
      }
      if (!existe){
        mascotaHashMap.put(mascota.getNombre(), mascota);
        System.out.println("La mascota se agrego de manera satisfactoria");
      }
    }
  }

  @Override
  public void editar(Mascota mascota) {
    mascotaHashMap.put(mascota.getNombre(), mascota);
  }

  @Override
  public void eliminar(Mascota mascota) {
    mascotaHashMap.remove(mascota.getNombre());
  }

  @Override
  public Mascota buscar(Mascota mascota) {
    if(mascotaHashMap.isEmpty()){
      return null;
    }else {
      for (String key : mascotaHashMap.keySet()){
        if (mascota.getNombre().equalsIgnoreCase(key)){
          mascota = mascotaHashMap.get(key);
          return mascota;
        }
      }
    }
    return null;
  }

  @Override
  public void mostrar() {
    System.out.println(mascotaHashMap);
  }

  @Override
  public void listar() {
    if (mascotaHashMap.isEmpty()){
      System.out.println("No existen mascotas para listar");
    }else {
      for (String key : mascotaHashMap.keySet()){
        Mascota p = mascotaHashMap.get(key);
        System.out.println("["+p.getNombre()+" "+p.getEspecie()+"]");
      }
    }
  }

  public void mostrarPorEspecie(){
    HashMap<String,Integer> mascotasPorEspecie = new HashMap<>();
    for (Mascota mascota : mascotaHashMap.values()) {
      String especie = mascota.getEspecie();
      if (!mascotasPorEspecie.containsKey(especie)) {
        mascotasPorEspecie.put(especie, 1);
      } else {
        int conteoActual = mascotasPorEspecie.get(especie);
        mascotasPorEspecie.put(especie, conteoActual + 1);
      }
    }
    for (Map.Entry<String, Integer> entry : mascotasPorEspecie.entrySet()) {
      String especie = entry.getKey();
      int conteo = entry.getValue();
      System.out.println("Especie: " + especie + ", Cantidad: " + conteo);
    }
  }

  public void buscarPorEdad(int edad) {
    boolean imprimio = false;
    if(mascotaHashMap.isEmpty()){
      System.out.println("No existen mascotas para listar");
    }else {
      for(Mascota mascota : mascotaHashMap.values()){
        if(mascota.getEdad() == edad){
          System.out.println(mascota);
          imprimio = true;
        }
      }
      if (!imprimio){
        System.out.println("No existen mascotas con esa edad");
      }
    }
  }
}
