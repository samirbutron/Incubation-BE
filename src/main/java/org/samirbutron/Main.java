package org.samirbutron;

import classes.Celular;
import classes.Persona;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Persona persona1 = new Persona("Juanito", 23, 1.70, 65.5, "235-125-1234");
    Persona persona2 = new Persona("Eustacio", 33, 1.67, 56.2, "967-145-9057");
    Persona persona3 = new Persona("Perengano", 18, 1.63, 71.6, "165-566-6455");
    Persona persona4 = new Persona("Arnoldo", 55, 1.63, 80.1, "154-457-2342");
    Persona persona5 = new Persona("Rolando", 48, 1.73, 73.2, "333-126-1265");

    List<Persona> listaPersonas = new ArrayList<Persona>();

    //Agregar elementos a listaPersonas
    listaPersonas.add(persona1);
    listaPersonas.add(persona2);
    listaPersonas.add(persona3);
    listaPersonas.add(persona4);
    listaPersonas.add(persona5);
    System.out.println(listaPersonas);
    //Buscar en listaPersonas
    Persona personaBuscada = listaPersonas.get(1);
    System.out.println(personaBuscada);
    //Editar
    Persona personaEditada = listaPersonas.get(2);
    personaEditada.setAltura(1.80);
    personaEditada.setNombre("Cornelio");
    listaPersonas.set(2,personaEditada);
    System.out.println(listaPersonas);
    //Eliminar
    listaPersonas.remove(1);
    System.out.println(listaPersonas);
    //Iterar la listaPersonas
    for(int i = 0; i < listaPersonas.size(); i++){
      System.out.printf("\n[%d]=>" + listaPersonas.get(i).getNombre(), i);
    }
    System.out.println("\n");
    for(Persona p : listaPersonas){
      System.out.println(p);
    }
  }
}