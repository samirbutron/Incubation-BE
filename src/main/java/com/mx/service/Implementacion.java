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
    //Creamos conexion
    Connection cone;
    //Abrimos la conexion
    PreparedStatement pst;
    //Declaramos la consulta sql
    String query = "INSERT INTO MASCOTAS VALUES(?,?,?,?)";
    try {
      //Registramos clase
      Class.forName(db.getDriver());
      //Creamos objeto para la conexion
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
      //Ejecutamos la consulta sql
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
    Connection cone;
    PreparedStatement pst;
    String query = "UPDATE MASCOTAS SET NOMBRE=?,EDAD=?,PESO=? WHERE NO_REGISTRO=?";
    try {
      Class.forName(db.getDriver());
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
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
    Connection cone;
    PreparedStatement pst;
    String query = "DELETE FROM MASCOTAS WHERE NO_REGISTRO=?";
    try {
      Class.forName(db.getDriver());
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
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
    Connection cone;
    PreparedStatement pst;
    String query ="SELECT * FROM MASCOTAS WHERE NO_REGISTRO=?";
    ResultSet rs = null;
    try {
      Class.forName(db.getDriver());
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
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
  public List<Mascota> mostrar() {
    List<Mascota> lista = new ArrayList<>();
    String resultado = "";
    Connection cone;
    PreparedStatement pst;
    String query ="SELECT * FROM MASCOTAS";
    ResultSet rs = null;
    try {
      Class.forName(db.getDriver());
      cone = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
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
