package com.mx.service;

import com.mx.entidad.Consumible;
import com.mx.entidad.Articulo;
import com.mx.metodos.MetodosGenericos;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Implementacion implements MetodosGenericos {
  List<Consumible> consumibleList = new ArrayList<>();
  List<Articulo> articuloList = new ArrayList<>();

  private static Implementacion instance;
  public static Implementacion getInstance() {
    if(instance == null){
      return instance = new Implementacion();
    }else {
      return instance;
    }
  }

  public Implementacion() {
    Articulo articulo1 = new Articulo("Camiseta", "Nike", 10, 29.99, "Rojo", "Algodón");
    articuloList.add(articulo1);
    Articulo articulo2 = new Articulo("Zapatos", "Adidas", 5, 79.99, "Negro", "Cuero");
    articuloList.add(articulo2);
    Articulo articulo3 = new Articulo("Bolígrafo", "Bic", 20, 1.99, "Azul", "Plástico");
    articuloList.add(articulo3);
    Articulo articulo4 = new Articulo("Mochila", "JanSport", 8, 39.99, "Gris", "Nylon");
    articuloList.add(articulo4);
    Articulo articulo5 = new Articulo("Reloj", "Casio", 3, 59.99, "Plateado", "Acero inoxidable");
    articuloList.add(articulo5);

    Consumible consumible1 = new Consumible("Leche", "Marca1", 10, 2.99, "31/12/2023", "Lácteo", "Natural");
    consumibleList.add(consumible1);
    Consumible consumible2 = new Consumible("Galletas", "Marca2", 5, 1.99, "15/06/2023", "Snack", "Chocolate");
    consumibleList.add(consumible2);
    Consumible consumible3 = new Consumible("Agua embotellada", "Marca4", 20, 0.49, "10/10/2023", "Bebida", "Sin sabor");
    consumibleList.add(consumible3);
    Consumible consumible4 = new Consumible("Yogur", "Marca3", 8, 0.99, "28/02/2024", "Lácteo", "Fresa");
    consumibleList.add(consumible4);
    Consumible consumible5 = new Consumible("Pan", "Marca5", 15, 1.49, "05/07/2024", "Panadería", "Blanco");
    consumibleList.add(consumible5);
  }

  @Override
  public void guardar(Object obj) {
    if (obj.getClass().equals(Articulo.class))
    {
      Articulo articulo = (Articulo) obj;
      if (articuloList.isEmpty()) {
        articuloList.add(articulo);
        System.out.println("Se registro el articulo de manera satisfactoria");
      } else {
        boolean existe = false;
        for (Articulo a : articuloList) {
          if (articulo.getNombre().equals(a.getNombre()) && articulo.getMarca()
              .equals(a.getMarca())) {
            existe = true;
            System.out.println("Este articulo ya existe en registro");
            break;
          }
        }
        if (!existe) {
          articuloList.add(articulo);
          System.out.println("Se registro el articulo de manera satisfactoria");
        }
      }
    }else{
      Consumible consumible = (Consumible) obj;
      if (consumibleList.isEmpty()) {
        consumibleList.add(consumible);
        System.out.println("Se registro el ingeniero de manera satisfactoria");
      } else {
        boolean existe = false;
        for (Consumible m : consumibleList) {
          if (consumible.getNombre().equals(m.getNombre()) && consumible.getMarca()
              .equals(m.getMarca())) {
            existe = true;
            System.out.println("Este ingeniero ya existe en registro");
            break;
          }
        }
        if (!existe) {
          consumibleList.add(consumible);
          System.out.println("Se registro el articulo de manera satisfactoria");
        }
      }
    }
  }

  @Override
  public void editar(Object obj, int indice) {
    if(obj.getClass().equals(Articulo.class)){
      articuloList.set(indice, (Articulo) obj);
    }else {
      consumibleList.set(indice, (Consumible) obj);
    }
  }

  @Override
  public void eliminar(int indice, String clase) {
    if(clase.equalsIgnoreCase("articulo")){
      articuloList.remove(indice);
    }else {
      consumibleList.remove(indice);
    }
  }

  @Override
  public Object buscar(int indice, String clase) {
    if (clase.equalsIgnoreCase("articulo")){
      if (articuloList.size() <= indice){
        return null;
      } else {
        return articuloList.get(indice);
      }
    } else {
      if (consumibleList.size() <= indice){
        return null;
      } else {
        return consumibleList.get(indice);
      }
    }
  }

  @Override
  public void mostrar(String clase) {
    if (clase.equalsIgnoreCase("articulo")){
      for (Articulo m : articuloList){
        System.out.println(m);
      }
    } else {
      for (Consumible i : consumibleList){
        System.out.println(i);
      }
    }
  }

  public void listar(String clase) {
    if (clase.equalsIgnoreCase("articulo")) {
      for (Articulo a : articuloList) {
        System.out.println("[" + a.getNombre() + " " + a.getMarca() + " => " + a.getPrecio());
      }
    } else {
      for (Consumible c : consumibleList) {
        System.out.println("[" + c.getNombre() + " " + c.getMarca() + " => " + c.getPrecio());
      }
    }
  }

  public void buscarArticuloMasCaro() {
    if (articuloList.isEmpty()){
      System.out.println("No hay articulos en el registro");
      return;
    }
    double valorMaximo = Integer.MIN_VALUE;
    List<Articulo> articulosCaros = new ArrayList<>();
    for (Articulo a : articuloList){
      if(a.getPrecio() > valorMaximo){
        valorMaximo = a.getPrecio();
        articulosCaros.clear();
        articulosCaros.add(a);
      } else if(a.getPrecio() == valorMaximo){
        articulosCaros.add(a);
      }
    }
    if(!articulosCaros.isEmpty()){
      System.out.println("Los articulos mas caros son: ");
      for (Articulo a : articulosCaros){
        System.out.println(a);
      }
      System.out.println("Con precio de: "+ valorMaximo);
    }
  }

  public void bucarConsumibleMasBarato() {
    if (consumibleList.isEmpty()){
      System.out.println("No hay consumibles en el registro");
      return;
    }
    double valorMinimo = Integer.MAX_VALUE;
    List<Consumible> consumiblesBaratos = new ArrayList<>();
    for (Consumible a : consumibleList){
      if(a.getPrecio() < valorMinimo){
        valorMinimo = a.getPrecio();
        consumiblesBaratos.clear();
        consumiblesBaratos.add(a);
      } else if(a.getPrecio() == valorMinimo){
        consumiblesBaratos.add(a);
      }
    }
    if(!consumiblesBaratos.isEmpty()){
      System.out.println("Los consumibles mas baratos son: ");
      for (Consumible a : consumiblesBaratos){
        System.out.println(a);
      }
      System.out.println("Con precio de: "+ valorMinimo);
    }
  }

  public void calcularValorConsumiblesConImpuesto() {
    double valorTotal = 0;
    for (Consumible c : consumibleList){
      valorTotal += c.precioImpuesto()*c.getStock();
    }
    System.out.println("Valor total calculado :"+valorTotal);
  }

  public void ProductosConMayorValor() {
    double valorTotalConsumibles = 0;
    for (Consumible c : consumibleList){
      valorTotalConsumibles += c.precioImpuesto()*c.getStock();
    }
    double valorTotalArticulos = 0;
    for (Articulo a : articuloList){
      valorTotalArticulos += a.precioImpuesto()*a.getStock();
    }
    if (valorTotalArticulos == valorTotalConsumibles){
      System.out.println("Ambos tipos de producto acumulan el mismo valor: " +valorTotalArticulos);
    }else if (valorTotalArticulos > valorTotalConsumibles){
      System.out.println("Los articulos acumulan un valor mayor a los consumibles, con: "+valorTotalArticulos);
    }else {
      System.out.println("Los consumibles acumulan un valor mayor a los articulos, con: "+valorTotalConsumibles);
    }
  }
}
