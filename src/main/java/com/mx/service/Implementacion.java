package com.mx.service;

import com.mx.entidad.Ingeniero;
import com.mx.entidad.Medico;
import com.mx.metodos.MetodosGenericos;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.standard.Media;

public class Implementacion implements MetodosGenericos {
  List<Ingeniero> ingenieroList = new ArrayList<>();
  List<Medico> medicoList = new ArrayList<>();

  Implementacion instance;
  public Implementacion getInstance() {
    if(instance == null){
      return instance = new Implementacion();
    }else {
      return instance;
    }
  }

  public Implementacion() {

  }

  @Override
  public void guardar(Object obj) {
    if (obj.getClass().equals(Medico.class))
    {
      Medico medico = (Medico) obj;
      if (medicoList.isEmpty()) {
        medicoList.add(medico);
        System.out.println("Se registro el medico de manera satisfactoria");
      } else {
        boolean existe = false;
        for (Medico m : medicoList) {
          if (medico.getNombre().equals(m.getNombre()) && medico.getApellido()
              .equals(m.getApellido())) {
            existe = true;
            System.out.println("Este medico ya existe en registro");
            break;
          }
        }
        if (!existe) {
          medicoList.add(medico);
          System.out.println("Se registro el medico de manera satisfactoria");
        }
      }
    }else{
      Ingeniero ingeniero = (Ingeniero) obj;
      if (ingenieroList.isEmpty()) {
        ingenieroList.add(ingeniero);
        System.out.println("Se registro el ingeniero de manera satisfactoria");
      } else {
        boolean existe = false;
        for (Ingeniero m : ingenieroList) {
          if (ingeniero.getNombre().equals(m.getNombre()) && ingeniero.getApellido()
              .equals(m.getApellido())) {
            existe = true;
            System.out.println("Este ingeniero ya existe en registro");
            break;
          }
        }
        if (!existe) {
          ingenieroList.add(ingeniero);
          System.out.println("Se registro el medico de manera satisfactoria");
        }
      }
    }
  }

  @Override
  public void editar(Object obj, int indice) {
    if(obj.getClass().equals(Medico.class)){
      medicoList.set(indice, (Medico) obj);
    }else {
      ingenieroList.set(indice, (Ingeniero) obj);
    }
  }

  @Override
  public void eliminar(int indice, String clase) {
    if(clase.equalsIgnoreCase("medico")){
      medicoList.remove(indice);
    }else {
      ingenieroList.remove(indice);
    }
  }

  @Override
  public Object buscar(int indice, String clase) {
    if (clase.equalsIgnoreCase("medico")){
      if (medicoList.size() <= indice){
        return null;
      } else {
        return medicoList.get(indice);
      }
    } else {
      if (ingenieroList.size() <= indice){
        return null;
      } else {
        return ingenieroList.get(indice);
      }
    }
  }

  @Override
  public void mostrar(String clase) {
    if (clase.equalsIgnoreCase("medico")){
      for (Medico m : medicoList){
        System.out.println(m);
      }
    } else {
      for (Ingeniero i : ingenieroList){
        System.out.println(i);
      }
    }
  }

  public void listar(String clase) {
    if (clase.equalsIgnoreCase("medico")){
      for (Medico m : medicoList){
        System.out.println("["+m.getNombre()+" "+m.getApellido()+" => "+m.getArea());
      }
    } else {
      for (Ingeniero i : ingenieroList){
        System.out.println("["+i.getNombre()+" "+i.getApellido()+" => "+i.getDepartamento());
      }

    }
}
