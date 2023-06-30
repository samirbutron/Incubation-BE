package org.samirbutron;

import com.mx.entidad.Producto;
import com.mx.entidad.Tienda;
import com.mx.service.ImpProducto;
import com.mx.service.ImpTienda;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String codigo_barras;
    String nombre;
    String marca;
    String tipo;
    int stock;

    int numeroSucursal;
    String ciudad;
    String colonia;
    String calle;
    int numero;

    List<Producto> productos;
    ImpProducto impProducto = new ImpProducto();
    ImpTienda impTienda = new ImpTienda();

    Producto producto = new Producto();
    Tienda tienda = new Tienda();
    int menu, menut, menup, submenu, menutp;
    Scanner entrada = new Scanner(System.in);

    do{
      System.out.println("\nSistema de tiendas");
      System.out.println("1 => Registro de productos");
      System.out.println("2 => Registro de tiendas");
      System.out.println("3 => Salir");
      entrada = new Scanner(System.in);
      menu = entrada.nextInt();

      switch (menu) {
        case 1:
          do {
            System.out.println("\nMenu de Productos");
            System.out.println("1.-Alta de producto");
            System.out.println("2.-Editar producto");
            System.out.println("3.-Buscar producto");
            System.out.println("4.-Eliminar producto");
            System.out.println("5.-Mostrar productos");
            System.out.println("6.-Listar productos");
            System.out.println("7.-Salir");
            entrada = new Scanner(System.in);
            menup = entrada.nextInt();
            switch (menup){
              case 1:
                System.out.println("Ingresa el codigo de barras");
                entrada = new Scanner(System.in);
                codigo_barras = entrada.nextLine();
                System.out.println("Ingresa el nombre");
                entrada = new Scanner(System.in);
                nombre = entrada.nextLine();
                System.out.println("Ingresa la marca");
                entrada = new Scanner(System.in);
                marca = entrada.nextLine();
                System.out.println("Ingresa el tipo");
                entrada = new Scanner(System.in);
                tipo = entrada.nextLine();
                System.out.println("Ingresa el stock");
                entrada = new Scanner(System.in);
                stock = entrada.nextInt();
                producto = new Producto(codigo_barras,nombre,marca,tipo,stock);
                impProducto.guardar(producto);
                break;
              case 2:
                System.out.println("Ingresa el codigo de barras para buscar el producto");
                entrada = new Scanner(System.in);
                codigo_barras = entrada.nextLine();
                producto = new Producto(codigo_barras);
                producto = impProducto.buscar(producto);
                if (producto == null) {
                  System.out.println("El producto que tratas de editar no existe");
                } else {
                  do {
                    System.out.println("\nMenu de edicion");
                    System.out.println("1.-Nombre");
                    System.out.println("2.-Marca");
                    System.out.println("3.-Tipo");
                    System.out.println("4.-Stock");
                    System.out.println("5.-Regresar al menu producto");
                    entrada = new Scanner(System.in);
                    submenu = entrada.nextInt();
                    switch (submenu){
                      case 1:
                        System.out.println("Ingresa el nombre");
                        nombre = entrada.nextLine();
                        producto.setNombre(nombre);
                        impProducto.editar(producto);
                        break;
                      case 2:
                        System.out.println("Ingresa la marca");
                        entrada = new Scanner(System.in);
                        marca = entrada.nextLine();
                        producto.setMarca(marca);
                        impProducto.editar(producto);
                        break;
                      case 3:
                        System.out.println("Ingresa el tipo");
                        entrada = new Scanner(System.in);
                        tipo = entrada.nextLine();
                        producto.setTipo(tipo);
                        impProducto.editar(producto);
                        break;
                      case 4:
                        System.out.println("Ingresa el stock");
                        entrada = new Scanner(System.in);
                        stock = entrada.nextInt();
                        producto.setStock(stock);
                        impProducto.editar(producto);
                        break;
                      case 5:
                        System.out.println("Regresando al menu producto");
                        break;
                      default:
                        System.out.println("Opcion invalida, intente de nuevo");
                        break;
                    }
                  }while(submenu != 5);
                }
                break;
              case 3:
                System.out.println("Ingresa el codigo de barras del producto");
                entrada = new Scanner(System.in);
                codigo_barras = entrada.nextLine();
                producto = new Producto(codigo_barras);
                producto = impProducto.buscar(producto);
                if (producto == null){
                  System.out.println("El producto buscado no existe");
                }else {
                  System.out.println("Se encontro el producto:");
                  System.out.println(producto);
                }
                break;
              case 4:
                System.out.println("Ingresa la llave del producto a eliminar");
                entrada = new Scanner(System.in);
                codigo_barras = entrada.nextLine();
                producto = new Producto(codigo_barras);
                producto = impProducto.buscar(producto);
                if (producto == null){
                  System.out.println("El producto a eliminar no existe");
                } else {
                  impProducto.eliminar(producto);
                  System.out.println("Se borro el producto:");
                  System.out.println(producto);
                }
                break;
              case 5:
                impProducto.mostrar();
                break;
              case 6:
                impProducto.listar();
                break;
              case 7:
                System.out.println("Saliendo...");
                break;
              default:
                System.out.println("Opcion invalida, intenta de nuevo");
                break;
            }
          }while (menup != 7);
          break;
        case 2:
          do {
            System.out.println("\nMenu de tienda");
            System.out.println("1.-Alta de tienda");
            System.out.println("2.-Editar tienda");
            System.out.println("3.-Buscar tienda");
            System.out.println("4.-Eliminar tienda");
            System.out.println("5.-Mostrar tiendas");
            System.out.println("6.-Listar tiendas");
            System.out.println("7.-Stock completo de tienda");
            System.out.println("8.-Tienda con mayor stock");
            System.out.println("9.-Numero de tiendas por ciudad");
            System.out.println("10.-Salir");
            entrada = new Scanner(System.in);
            menut = entrada.nextInt();
            switch (menut){
              case 1:
                System.out.println("Ingresa el numero de sucursal");
                entrada = new Scanner(System.in);
                numeroSucursal = entrada.nextInt();
                System.out.println("Ingresa la ciudad");
                entrada = new Scanner(System.in);
                ciudad = entrada.nextLine();
                System.out.println("Ingresa la colonia");
                entrada = new Scanner(System.in);
                colonia = entrada.nextLine();
                System.out.println("Ingresa la calle");
                entrada = new Scanner(System.in);
                calle = entrada.nextLine();
                System.out.println("Ingresa el numero");
                entrada = new Scanner(System.in);
                numero = entrada.nextInt();
                tienda = new Tienda(numeroSucursal,ciudad,colonia,calle,numero);
                impTienda.guardar(tienda);
                break;
              case 2:
                System.out.println("Ingresa el numero de sucursal para buscar la tienda");
                entrada = new Scanner(System.in);
                numeroSucursal = entrada.nextInt();
                tienda = new Tienda(numeroSucursal);
                tienda = impTienda.buscar(tienda);
                if (tienda == null) {
                  System.out.println("La tienda que tratas de editar no existe");
                } else {
                  do {
                    System.out.println("\nMenu de edicion");
                    System.out.println("1.-Ciudad");
                    System.out.println("2.-Colonia");
                    System.out.println("3.-Calle");
                    System.out.println("4.-Numero");
                    System.out.println("5.-Productos");
                    System.out.println("6.-Regresar al menu tienda");
                    entrada = new Scanner(System.in);
                    submenu = entrada.nextInt();
                    switch (submenu){
                      case 1:
                        System.out.println("Ingresa el ciudad");
                        entrada = new Scanner(System.in);
                        ciudad = entrada.nextLine();
                        tienda.setCiudad(ciudad);
                        impTienda.editar(tienda);
                        break;
                      case 2:
                        System.out.println("Ingresa la colonia");
                        entrada = new Scanner(System.in);
                        colonia = entrada.nextLine();
                        tienda.setColonia(colonia);
                        impTienda.editar(tienda);
                        break;
                      case 3:
                        System.out.println("Ingresa el calle");
                        entrada = new Scanner(System.in);
                        calle = entrada.nextLine();
                        tienda.setCalle(calle);
                        impTienda.editar(tienda);
                        break;
                      case 4:
                        System.out.println("Ingresa el numero");
                        entrada = new Scanner(System.in);
                        numero = entrada.nextInt();
                        tienda.setNumero(numero);
                        impTienda.editar(tienda);
                        break;
                      case 5:
                        do {
                          System.out.println("\nMenu de productos para tienda");
                          System.out.println("1.-Agregar producto a tienda");
                          System.out.println("2.-Quitar producto de tienda");
                          System.out.println("3.-Salir...");
                          entrada = new Scanner(System.in);
                          menutp = entrada.nextInt();
                          switch (menutp){
                            case 1:
                              System.out.println("Ingresa el codigo de barras del producto a agregar");
                              entrada = new Scanner(System.in);
                              codigo_barras = entrada.nextLine();
                              producto = new Producto(codigo_barras);
                              producto = impProducto.buscar(producto);
                              if (producto == null){
                                System.out.println("El producto a agregar no existe");
                              } else {
                                tienda.getProductos().add(producto);
                                impTienda.editar(tienda);
                                System.out.println("Se agrego el siguiente producto a la tienda:");
                                System.out.println(producto);
                              }
                              break;
                            case 2:
                              System.out.println("Ingresa el codigo de barras del producto a retirar");
                              entrada = new Scanner(System.in);
                              codigo_barras = entrada.nextLine();
                              producto = new Producto(codigo_barras);
                              producto = impProducto.buscar(producto);
                              if (producto == null){
                                System.out.println("El producto a retirar no existe");
                              } else {
                                tienda.getProductos().remove(producto);
                                impTienda.editar(tienda);
                                System.out.println("Se retiro el siguiente producto a la tienda:");
                                System.out.println(producto);
                              }
                              break;
                            case 3:
                              System.out.println("Saliendo...");
                              break;
                            default:
                              System.out.println("Opcion invalida, intenta otra opcion");
                              break;
                          }
                        }while (menutp != 3);
                        break;
                      case 6:
                        System.out.println("Regresando al menu tienda");
                        break;
                      default:
                        System.out.println("Opcion invalida, intente de nuevo");
                        break;
                    }
                  }while(submenu != 6);
                }
                break;
              case 3:
                System.out.println("Ingresa el numero de sucursal del tienda");
                entrada = new Scanner(System.in);
                numeroSucursal = entrada.nextInt();
                tienda = new Tienda(numeroSucursal);
                tienda = impTienda.buscar(tienda);
                if (tienda == null){
                  System.out.println("El tienda buscado no existe");
                }else {
                  System.out.println("Se encontro el tienda:");
                  System.out.println(tienda);
                }
                break;
              case 4:
                System.out.println("Ingresa la llave del tienda a eliminar");
                entrada = new Scanner(System.in);
                numeroSucursal = entrada.nextInt();
                tienda = new Tienda(numeroSucursal);
                tienda = impTienda.buscar(tienda);
                if (tienda == null){
                  System.out.println("El tienda a eliminar no existe");
                } else {
                  impTienda.eliminar(tienda);
                  System.out.println("Se borro el tienda:");
                  System.out.println(tienda);
                }
                break;
              case 5:
                impTienda.mostrar();
                break;
              case 6:
                impTienda.listar();
                break;
              case 7:
                System.out.println("Ingresa el numero de sucursal para buscar la tienda");
                entrada = new Scanner(System.in);
                numeroSucursal = entrada.nextInt();
                tienda = new Tienda(numeroSucursal);
                tienda = impTienda.buscar(tienda);
                if (tienda == null) {
                  System.out.println("El tienda que tratas de editar no existe");
                } else {
                  System.out.println("Esta tienda cuenta con un stock sumado de:"+impTienda.stockSum(tienda));
                }
                break;
              case 8:
                impTienda.biggestStock();
                break;
              case 9:
                impTienda.tiendaPorCiudad();
                break;
              case 10:
                System.out.println("Saliendo...");
                break;
            }
          }while (menut != 10);
          break;
        case 3:
          System.out.println("Saliendo...");
          break;
      }
    }while (menu != 3);

  }
}