package com.mx.service;

import com.mx.entidad.Libro;
import com.mx.general.ConexionDB;
import com.mx.general.Metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos {
    ConexionDB db = new ConexionDB();

    @Override
    public String guardar(Libro libro) {
        String resultado = "";
        //Creamos conexion
        Connection cone;
        //Abrimos la conexion
        PreparedStatement pst;
        //Declaramos la consulta sql
        String query = "INSERT INTO LIBROS VALUES(?,?,?,?,?,?,?)";
        try {
            //Registramos clase
            Class.forName(db.getDriver());
            //Creamos objeto para la conexion
            cone = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            //Ejecutamos la consulta sql
            pst = cone.prepareStatement(query);

            pst.setString(1, libro.getFolio());
            pst.setString(2, libro.getTitulo());
            pst.setString(3, libro.getAutor());
            pst.setString(4, libro.getEditorial());
            pst.setString(5, libro.getGenero());
            pst.setInt(6, libro.getPrecio());
            pst.setInt(7, libro.getNo_paginas());

            int insert = pst.executeUpdate();
            if (insert > 0) {
                resultado = "1";
                System.out.println("Se registro el libro codigo: " + insert + " exitoso");
            } else {
                resultado = "0";
                System.out.println("No se guardo el libro codigo: " + insert + " fallido");
            }
        } catch (Exception e) {
            System.out.println("ERROR al guardar en la base de datos \n" + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String editar(Libro libro) {
        String resultado = "";
        Connection cone;
        PreparedStatement pst;
        String query = "UPDATE LIBROS SET FOLIO=?,TITULO=?,AUTOR=?, EDITORIAL=?, GENERO=?, PRECIO=?, NO_PAGINAS=? WHERE FOLIO=?";
        try {
            Class.forName(db.getDriver());
            cone = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            pst = cone.prepareStatement(query);
            pst.setString(1, libro.getFolio());
            pst.setString(2, libro.getTitulo());
            pst.setString(3, libro.getAutor());
            pst.setString(4, libro.getEditorial());
            pst.setString(5, libro.getGenero());
            pst.setInt(6, libro.getPrecio());
            pst.setInt(7, libro.getNo_paginas());
            pst.setString(8, libro.getFolio());
            int update = pst.executeUpdate();
            if (update > 0) {
                resultado = "1";
                System.out.println("Se edito el libro codigo: " + update + " exitoso");
            } else {
                resultado = "0";
                System.out.println("No se edito el libro codigo: " + update + " fallido");
            }
        } catch (Exception e) {
            System.out.println("ERROR al editar en la base de datos " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String eliminar(Libro libro) {
        String resultado = "";
        Connection cone;
        PreparedStatement pst;
        String query = "DELETE FROM LIBROS WHERE FOLIO=?";
        try {
            Class.forName(db.getDriver());
            cone = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            pst = cone.prepareStatement(query);
            pst.setString(1, libro.getFolio());
            int delete = pst.executeUpdate();
            if (delete > 0) {
                resultado = "1";
                System.out.println("Se elimino la libro codigo: " + delete + " exitoso");
            } else {
                resultado = "0";
                System.out.println("No se elimino la libro codigo: " + delete + " fallido");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar de la base de datos " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public Libro buscar(Libro libro) {
        String resultado = "";
        Connection cone;
        PreparedStatement pst;
        String query = "SELECT * FROM LIBROS WHERE FOLIO=?";
        ResultSet rs = null;
        try {
            Class.forName(db.getDriver());
            cone = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            pst = cone.prepareStatement(query);
            pst.setString(1, libro.getFolio());
            rs = pst.executeQuery();
            while (rs.next()) {
                libro = new Libro(rs.getString("FOLIO"),
                        rs.getString("TITULO"),
                        rs.getString("AUTOR"),
                        rs.getString("EDITORIAL"),
                        rs.getString("GENERO"),
                        rs.getInt("PRECIO"),
                        rs.getInt("NO_PAGINAS"));
            }
        } catch (Exception e) {
            System.out.println("ERROR al buscar en la base de datos " + e.getMessage());
        }
        return libro;
    }

    public List<Libro> buscarPorAutor(Libro libro) {
        List<Libro> lista = new ArrayList<>();
        String resultado = "";
        Connection cone;
        PreparedStatement pst;
        String query = "SELECT * FROM LIBROS WHERE AUTOR =?";
        ResultSet rs = null;
        try {
            Class.forName(db.getDriver());
            cone = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            pst = cone.prepareStatement(query);
            pst.setString(1, libro.getAutor());
            rs = pst.executeQuery();
            while (rs.next()) {
                lista.add(
                        new Libro(rs.getString("FOLIO"),
                                rs.getString("TITULO"),
                                rs.getString("AUTOR"),
                                rs.getString("EDITORIAL"),
                                rs.getString("GENERO"),
                                rs.getInt("PRECIO"),
                                rs.getInt("NO_PAGINAS"))
                );
            }
        } catch (Exception e) {
            System.out.println("ERROR al obtener autores de la base de datos " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Libro> mostrar() {
        List<Libro> lista = new ArrayList<>();
        String resultado = "";
        Connection cone;
        PreparedStatement pst;
        String query = "SELECT * FROM LIBROS";
        ResultSet rs = null;
        try {
            Class.forName(db.getDriver());
            cone = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            pst = cone.prepareStatement(query);
            rs = pst.executeQuery(query);
            while (rs.next()) {
                lista.add(
                        new Libro(rs.getString("FOLIO"),
                                rs.getString("TITULO"),
                                rs.getString("AUTOR"),
                                rs.getString("EDITORIAL"),
                                rs.getString("GENERO"),
                                rs.getInt("PRECIO"),
                                rs.getInt("NO_PAGINAS"))
                );
            }
        } catch (Exception e) {
            System.out.println("ERROR al mostrar datos de la base de datos " + e.getMessage());
        }
        return lista;
    }
}
