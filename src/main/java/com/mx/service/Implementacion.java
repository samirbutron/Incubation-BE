package com.mx.service;

import com.mx.entidad.Cliente;
import com.mx.entidad.Cuenta;
import com.mx.metodos.MetodosGenericos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Implementacion implements MetodosGenericos {

  private static Implementacion instance;
  private final HashMap<String, Cliente> clienteHashMap = new HashMap<>();
  private final HashMap<String, Cuenta> cuentaHashMap = new HashMap<>();

  public static Implementacion getInstance() {
    if (instance == null) {
      instance = new Implementacion();
    }
    return instance;
  }

  public Implementacion() {
    Cuenta cuenta1 = new Cuenta("123456789", "Ahorros", 1000.89, 1500.35);
    cuentaHashMap.put(cuenta1.getNumeroDeCuenta(), cuenta1);
    Cuenta cuenta2 = new Cuenta("987654321", "Corriente", 5000.33, 10.6);
    cuentaHashMap.put(cuenta2.getNumeroDeCuenta(), cuenta2);
    Cuenta cuenta3 = new Cuenta("456789123", "Ahorros", 2000.0, 2788.9);
    cuentaHashMap.put(cuenta3.getNumeroDeCuenta(), cuenta3);
    Cuenta cuenta4 = new Cuenta("321654987", "Corriente", 3000.16, 1691.52);
    cuentaHashMap.put(cuenta4.getNumeroDeCuenta(), cuenta4);
    Cuenta cuenta5 = new Cuenta("789123456", "Ahorros", 1500.0, 591.0);
    cuentaHashMap.put(cuenta5.getNumeroDeCuenta(), cuenta5);

    Cliente cliente1 = new Cliente("CURP1", "Juan", "Perez", 25, "Ciudad de México");
    clienteHashMap.put(cliente1.getCurp(), cliente1);
    Cliente cliente2 = new Cliente("CURP2", "Maria", "Lopez", 30, "Guadalajara");
    clienteHashMap.put(cliente2.getCurp(), cliente2);
    Cliente cliente3 = new Cliente("CURP3", "Pedro", "Gomez", 35, "Monterrey");
    clienteHashMap.put(cliente3.getCurp(), cliente3);
    Cliente cliente4 = new Cliente("CURP4", "Ana", "Martinez", 28, "Puebla");
    clienteHashMap.put(cliente4.getCurp(), cliente4);
    Cliente cliente5 = new Cliente("CURP5", "Luis", "Rodriguez", 32, "Tijuana");
    clienteHashMap.put(cliente5.getCurp(), cliente5);
  }

  @Override
  public void guardar(Object obj, String clase) {
    if (clase.equalsIgnoreCase("cliente")) {
      //Proces ode verificacion para guardar Cliente
      Cliente cliente = (Cliente) obj;
      if (cliente.getEdad() > 17) {
        //Revisamos si el hasmap esta vacio -> Si = Agregamos de inmediato
        if (clienteHashMap.isEmpty()) {
          clienteHashMap.put(cliente.getCurp(), cliente);
          System.out.println("El cliente se registro de manera satisfactoria");
        } else {
          //Caso contrario revisamos si ya existe el CURP como llave
          if (clienteHashMap.containsKey(cliente.getCurp())) {
            System.out.println("Este CURP ya se encuentra en registro");
          } else {
            boolean existe = false;
            //De otra forma revisamos si ya existe un cliente con nombres y apellidos
            for (Cliente a : clienteHashMap.values()) {
              if (a.getNombre().equals(cliente.getNombre()) && a.getApellido()
                  .equals(cliente.getApellido())) {
                System.out.println("Ya existe un cliente con ese Nombre y Apellido");
                existe = true;
                break;
              }
            }
            //En el caso de que no exista ni CURP ni Cliente por nombre y Apellido lo agregamos
            if (!existe) {
              clienteHashMap.put(cliente.getCurp(), cliente);
              System.out.println("Cliente agregado exitosamente");
            }
          }
        }
      } else {
        System.out.println("Cliente no cumple la mayoria de edad");
      }
    } else {
      //Proces ode verificacion para guardar Cuenta
      Cuenta cuenta = (Cuenta) obj;
      //Revisamos si el hasmap esta vacio -> Si = Agregamos de inmediato
      if (cuentaHashMap.isEmpty()) {
        cuentaHashMap.put(cuenta.getNumeroDeCuenta(), cuenta);
        System.out.println("El cuenta se registro de manera satisfactoria");
      } else {
        //Caso contrario revisamos si ya existe el Numero como llave
        if (cuentaHashMap.containsKey(cuenta.getNumeroDeCuenta())) {
          System.out.println("Este Numero de cuenta ya se encuentra en registro");
        } else {
          cuentaHashMap.put(cuenta.getNumeroDeCuenta(), cuenta);
          System.out.println("Cliente agregado exitosamente");
        }
      }
    }
  }

  @Override
  public void editar(Object obj, String clase) {
    if (clase.equalsIgnoreCase("cliente")) {
      Cliente cliente = (Cliente) obj;
      clienteHashMap.put(cliente.getCurp(), cliente);
      System.out.println("Se edito el cliente");
    } else {
      Cuenta cuenta = (Cuenta) obj;
      cuentaHashMap.put(cuenta.getNumeroDeCuenta(), cuenta);
      System.out.println("Se edito el cuenta");
    }
  }

  @Override
  public void eliminar(Object obj, String clase) {
    if (clase.equalsIgnoreCase("cliente")) {
      Cliente cliente = (Cliente) obj;
      clienteHashMap.remove(cliente.getCurp());
      System.out.println("Se elimino el cliente");
    } else {
      Cuenta cuenta = (Cuenta) obj;
      cuentaHashMap.remove(cuenta.getNumeroDeCuenta());
      System.out.println("Se elimino la cuenta");
    }
  }

  @Override
  public Object buscar(Object obj, String clase) {
    if (clase.equalsIgnoreCase("cliente")) {
      Cliente cliente = (Cliente) obj;
      if (clienteHashMap.containsKey(cliente.getCurp())) {
        cliente = clienteHashMap.get(cliente.getCurp());
        return cliente;
      } else {
        cliente = null;
        return cliente;
      }
    } else {
      Cuenta cuenta = (Cuenta) obj;
      if (cuentaHashMap.containsKey(cuenta.getNumeroDeCuenta())) {
        cuenta = cuentaHashMap.get(cuenta.getNumeroDeCuenta());
        return cuenta;
      } else {
        cuenta = null;
        return cuenta;
      }
    }
  }


  @Override
  public void mostrar(String clase) {
    if (clase.equalsIgnoreCase("cliente")) {
      for (Cliente c : clienteHashMap.values()) {
        System.out.println(c);
      }
    } else {
      for (Cuenta c : cuentaHashMap.values()) {
        System.out.println(c);
      }
    }
  }

  public void listar(String clase) {
    if (clase.equalsIgnoreCase("cliente")) {
      if (clienteHashMap.isEmpty()) {
        System.out.println("No existen clientes para listar");
      } else {
        for (Cliente a : clienteHashMap.values()) {
          System.out.println("[" + a.getCurp() + "]" + a.getNombre() + " " + a.getApellido());
        }
      }
    } else {
      if (cuentaHashMap.isEmpty()) {
        System.out.println("No existen cuentas para listar");
      } else {
        for (Cuenta c : cuentaHashMap.values()) {
          System.out.println(
              "[" + c.getNumeroDeCuenta() + "]" + c.getTipo() + ", saldo: " + c.getSaldo());
        }
      }
    }
  }

  public void buscarMayorSaldo() {
    double maximo = Integer.MIN_VALUE;
    List<Cliente> deudasMaximas = new ArrayList<>();
    if (clienteHashMap.isEmpty()) {
      System.out.println("No hay clientes en el registro");
    } else {
      for (Cliente cliente : clienteHashMap.values()) {
        List<Cuenta> cuentas = cliente.getCuentaList();
        double saldoMaximo = 0;
        for (Cuenta c : cuentas) {
          saldoMaximo += c.getSaldo();
        }
        if (saldoMaximo > maximo) {
          maximo = saldoMaximo;
          deudasMaximas.clear();
          deudasMaximas.add(cliente);
        } else if (saldoMaximo == maximo) {
          deudasMaximas.add(cliente);
        }
      }

      if (!deudasMaximas.isEmpty()) {
        System.out.println("Los clientes con más saldo son:");
        for (Cliente cliente : deudasMaximas) {
          System.out.println(cliente.getNombre());
        }
        System.out.println("Saldo: " + maximo);
      }
    }
  }

  public void buscarMayorDeuda() {
    double maximo = Integer.MIN_VALUE;
    List<Cliente> deudasMaximas = new ArrayList<>();
    if (clienteHashMap.isEmpty()) {
      System.out.println("No hay clientes en el registro");
    } else {
      for (Cliente cliente : clienteHashMap.values()) {
        List<Cuenta> cuentas = cliente.getCuentaList();
        double deudaMaxima = 0;
        for (Cuenta c : cuentas) {
          deudaMaxima += c.getDeuda();
        }
        if (deudaMaxima > maximo) {
          maximo = deudaMaxima;
          deudasMaximas.clear();
          deudasMaximas.add(cliente);
        } else if (deudaMaxima == maximo) {
          deudasMaximas.add(cliente);
        }
      }

      if (!deudasMaximas.isEmpty()) {
        System.out.println("Los clientes con más deuda son:");
        for (Cliente cliente : deudasMaximas) {
          System.out.println(cliente.getNombre());
        }
        System.out.println("Deuda: " + maximo);
      }
    }
  }

  public void transferirCuenta(Cliente cliente, Cliente cliente2, Cuenta cuenta) {
    cliente.getCuentaList().remove(cuenta);
    cliente2.getCuentaList().add(cuenta);
  }
}
