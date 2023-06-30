package com.mx.service;

import com.mx.entidad.Producto;
import com.mx.entidad.Tienda;
import com.mx.metodos.MetodosTienda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImpTienda implements MetodosTienda {

  HashMap<Integer, Tienda> hashTienda = new HashMap<>();

  public ImpTienda(){
    Tienda tienda = new Tienda(11, "Pachuca", "Olimpo", "Zeus",100);
    Tienda tienda1 = new Tienda(12, "Petra", "Tor", "Aaavit",114);
    Tienda tienda2 = new Tienda(13, "Pachuca", "Olimpo", "Zeus",220);
    hashTienda.put(11,tienda);
    hashTienda.put(12,tienda1);
    hashTienda.put(13,tienda2);
  }
  @Override
  public void guardar(Tienda tienda) {
    if(hashTienda.isEmpty()){
      hashTienda.put(tienda.getNumeroSucursal(), tienda);
      System.out.println("Tienda guardado de manera satisfactoria");
    }else {
      Tienda t;
      boolean existe = false;
      for(Integer key : hashTienda.keySet()){
        t = hashTienda.get(key);
        if(tienda.getNumeroSucursal() == key){
          System.out.println("El codigo de barras que tratas de registrar ya existe");
          existe = true;
          break;
        } else if (tienda.getCiudad().equals(t.getCiudad()) && tienda.getColonia().equals(t.getColonia())) {
          System.out.println("Este tienda ya se encuentra registrado");
          existe = true;
          break;
        }
      }
      if (!existe){
        hashTienda.put(tienda.getNumeroSucursal(), tienda);
        System.out.println("El tienda se agrego de manera satisfactoria");
      }
    }
  }

  @Override
  public void editar(Tienda tienda) {
    hashTienda.put(tienda.getNumeroSucursal(), tienda);
  }

  @Override
  public void eliminar(Tienda tienda) {
    hashTienda.remove(tienda.getNumeroSucursal());
  }

  @Override
  public Tienda buscar(Tienda tienda) {
    if(hashTienda.isEmpty()){
      return null;
    }else {
      for (Integer key : hashTienda.keySet()){
        if (tienda.getNumeroSucursal() == key){
          tienda = hashTienda.get(key);
          return tienda;
        }
      }
    }
    return null;
  }

  @Override
  public void mostrar() {
    for (Integer key : hashTienda.keySet()){
      System.out.println(hashTienda.get(key).toString());
    }
  }

  public void listar() {
    if (hashTienda.isEmpty()){
      System.out.println("No existen productos para listar");
    }else {
      for (Integer key : hashTienda.keySet()){
        Tienda t = hashTienda.get(key);
        System.out.println("["+t.getNumeroSucursal() +"] => "+ t.getCiudad() +" "+ t.getColonia());
      }
    }
  }

  public int stockSum(Tienda tienda) {
    int suma = 0;
    List<Producto> productoList = hashTienda.get(tienda.getNumeroSucursal()).getProductos();
    if(!productoList.isEmpty()) {
      for (Producto p : productoList) {
        suma += p.getStock();
      }
    }
    return suma;
  }

  public void biggestStock() {
    if (hashTienda.isEmpty()) {
      System.out.println("No existen productos para listar");
    } else {
      HashMap<Integer, Integer> stocksTienda = new HashMap<>();
      for (Integer key : hashTienda.keySet()) {
        stocksTienda.put(key,stockSum(hashTienda.get(key)));
      }
      int maximo = Integer.MIN_VALUE;
      int claveMaxima = Integer.MIN_VALUE;
      for(Integer key : stocksTienda.keySet()){
        if (stocksTienda.get(key) > maximo){
          maximo = stocksTienda.get(key);
          claveMaxima = key;
        }
      }
      System.out.println("La tienda con mayor stock es:");
      System.out.println(hashTienda.get(claveMaxima));
      System.out.println("Con stock sumado de:");
      System.out.println(maximo);
    }
  }

  public void tiendaPorCiudad() {
    if (hashTienda.isEmpty()) {
      System.out.println("No existen productos para listar");
    } else {
      HashMap<String, List<Tienda>> tiendasPorCiudad = new HashMap<>();
      for (Tienda tienda : hashTienda.values()) {
        String ciudad = tienda.getCiudad();
        if (!tiendasPorCiudad.containsKey(ciudad)) {
          tiendasPorCiudad.put(ciudad, new ArrayList<>());
        }
        tiendasPorCiudad.get(ciudad).add(tienda);
      }
      for (String ciudad : tiendasPorCiudad.keySet()) {
        System.out.println("Ciudad: " + ciudad);
        List<Tienda> tiendas = tiendasPorCiudad.get(ciudad);
        for (Tienda tienda : tiendas) {
          System.out.println(tienda);
        }
        System.out.println();
      }
    }
  }
}
