package org.samirbutron;

import classes.Celular;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Celular cel0 = new Celular("Xiaomi", "Redmi", 5000, 12.5, 124);
    Celular cel1 = new Celular("Apple", "Iphone12", 2000, 13, 256);
    Celular cel2 = new Celular("Motorola", "Moto g", 6000, 14.2, 32);

    List<Celular> lista = new ArrayList<Celular>();

    //Agregar elementos a lista
    lista.add(cel0);
    lista.add(cel1);
    lista.add(cel2);
    //Imprimir lista
    System.out.println(lista);
    //Buscar en lista
    Celular celular = lista.get(1);
    System.out.println(celular);
    //Editar
    Celular celular1 = lista.get(2);
    celular1.setAlmacenamiento(520);
    celular1.setModelo("Iphone14");
    System.out.println(celular1);
    lista.set(2,celular1);
    //Eliminar
    lista.remove(1);
    System.out.println(lista);
    //Iterar la lista
    for(int i = 0; i < lista.size(); i++){
      System.out.printf("\n[%d]=>" + lista.get(i).getMarca(), i);
    }
    System.out.println("\n");
    for(Celular c : lista){
      System.out.println(c);
    }
  }
}