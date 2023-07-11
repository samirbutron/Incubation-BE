package com.mx.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Mascota;
import com.mx.general.ConexionDb;
import com.mx.general.Metodos;

public class Implementacion implements Metodos {
  ConexionDb db = new ConexionDb();

  @Override
  public String guardar(Mascota mascota) {
    String resultado = "";

    //Crear conexion
    Connection cone;

    //abrir conexion
    PreparedStatement pst;

    //declarar o preparar la consulta sql
    String query = "INSERT INTO MASCOTAS VALUES(?,?,?,?)";

    try {
      //registrar clase con forname
      Class.forName(db.getDriver());

      //crear objeto para la conexion
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());

      //ejecutamos sentecia sql
      pst = cone.prepareStatement(query);

      pst.setInt(1,mascota.getNo_registro());
      pst.setString(2, mascota.getNombre());
      pst.setInt(3, mascota.getEdad());
      pst.setDouble(4, mascota.getPeso());

      int insert = pst.executeUpdate();
      if(insert > 0) {
        resultado = "1";
        System.out.println("Se registro la mascota " + insert);
      }else {
        resultado = "0";
        System.out.println("No se guardo la mascota "+ insert);
      }
    } catch (Exception e) {
      System.out.println("ERROR al guardar en la base de datos \n"+e.getMessage());
    }
    return resultado;
  }

  @Override
  public String editar(Mascota mascota) {
    String resultado = "";
    //Creamos la conexion
    Connection cone;

    //abrir la conexion
    PreparedStatement pst;

    //declarar sentecia sql
    String query = "UPDATE MASCOTAS SET NOMBRE=?,EDAD=?,PESO=? WHERE NO_REGISTRO=?";

    try {
      //registrar clase
      Class.forName(db.getDriver());

      //crear el objeto de conexion
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());

      //preparacion para la ejecucion de la asetencia sql
      pst = cone.prepareStatement(query);

      pst.setString(1, mascota.getNombre());
      pst.setInt(2, mascota.getEdad());
      pst.setDouble(3, mascota.getPeso());
      pst.setInt(4, mascota.getNo_registro());

      int update = pst.executeUpdate();

      if(update > 0) {
        resultado = "1";
        System.out.println("Se edito la mascota "+update);
      }else {
        resultado = "0";
        System.out.println("No se pudo editar "+update );
      }
    } catch (Exception e) {
      System.out.println("ERROR al editar en la base de datos "+e.getMessage());
    }

    return resultado;
  }

  @Override
  public String eliminar(Mascota mascota) {
    String resultado = "";

    //Creamos la conexion
    Connection cone;

    //abrimos la conexion
    PreparedStatement pst;

    //declaramos sentecia sql
    String query = "DELETE FROM MASCOTAS WHERE NO_REGISTRO=?";

    try {
      //registramos la clase
      Class.forName(db.getDriver());

      //creamos el objeto de conexion
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());

      //preparar la ejecucion de la sentencia sql
      pst = cone.prepareStatement(query);

      pst.setInt(1, mascota.getNo_registro());

      int delete = pst.executeUpdate();

      if(delete > 0) {
        resultado = "1";
        System.out.println("Se elimino la mascota "+delete);
      }else {
        resultado = "0";
        System.out.println("No se elimino la mascota "+delete);
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar de la base de datos "+e.getMessage());
    }

    return resultado;
  }

  @Override
  public Mascota buscar(Mascota mascota) {
    String resultado ="";

    //Crear la conexion
    Connection cone;

    //abrir la conexion
    PreparedStatement pst;


    //preparar nuestra sentecia sql
    String query ="SELECT * FROM MASCOTAS WHERE NO_REGISTRO=?";

    //DECLARAMOS RESULTSET
    ResultSet rs = null;

    try {
      //registrar la clase
      Class.forName(db.getDriver());

      //Crear objeto de conexion
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());

      //preparar ejecucion de setencia sql
      pst = cone.prepareStatement(query);

      pst.setInt(1, mascota.getNo_registro());

      rs = pst.executeQuery();

      while(rs.next()) {
        mascota = new Mascota(rs.getInt("NO_REGISTRO"),
                rs.getString("NOMBRE"),
                rs.getInt("EDAD"),
                rs.getDouble("PESO"));
      }

    } catch (Exception e) {
      System.out.println("ERROR al buscar en la base de datos "+e.getMessage());
    }
    return mascota;
  }

  @Override
  public List mostrar() {
    List<Mascota> lista = new ArrayList();
    String resultado = "";

    //preparar la conexion
    Connection cone;

    //abrir la conexion
    PreparedStatement pst;

    //declaramos nuestra sentencia sql
    String query ="SELECT * FROM MASCOTAS";

    ResultSet rs = null;

    try {
      //Registrar la clase
      Class.forName(db.getDriver());

      //crear objeto de coenxion
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());

      //preparar la ejecucion de la setencia
      pst = cone.prepareStatement(query);

      rs = pst.executeQuery(query);

      while(rs.next()) {
        lista.add(
                new Mascota(rs.getInt("NO_REGISTRO"),
                        rs.getString("NOMBRE"),
                        rs.getInt("EDAD"),
                        rs.getDouble("PESO"))
        );
      }


    } catch (Exception e) {
      System.out.println("ERROR al mostrar datos de la base de datos "+e.getMessage());
    }

    return lista;
  }

}
