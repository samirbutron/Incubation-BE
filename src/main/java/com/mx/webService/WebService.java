package com.mx.webService;

import com.mx.entidad.Libro;
import com.mx.general.Resultado;
import com.mx.service.Implementacion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("libros")
public class WebService {
    Implementacion imp = new Implementacion();

    //http://localhost:9001/JDBC/jDBC/libros/listar
    @Path("listar")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libro> mostrar() {
        return imp.mostrar();
    }

    @Path("guardar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado guardar(Libro libro) {
        Resultado rs = new Resultado();
        rs.setObj(libro);
        String p = imp.guardar(libro);
        if (p.equals("1")) {
            rs.setMensaje("Se guardo el libro de manera correcta");
            rs.setRespuesta(p);
        } else {
            rs.setMensaje("No se pudo guardar el libro");
            rs.setRespuesta(p);
        }
        return rs;
    }

    @Path("editar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado editar(Libro libro) {
        Resultado rs = new Resultado();
        rs.setObj(libro);
        String p = imp.editar(libro);
        if (p.equals("1")) {
            rs.setMensaje("Se edito el libro de manera correcta");
            rs.setRespuesta(p);
        } else {
            rs.setMensaje("No se edito el libro");
            rs.setRespuesta(p);
        }
        return rs;
    }

    @Path("eliminar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado eliminar(Libro libro) {
        Resultado rs = new Resultado();
        rs.setObj(libro);
        String p = imp.eliminar(libro);
        if (p.equals("1")) {
            rs.setMensaje("Se elimino el libro");
            rs.setRespuesta(p);
        } else {
            rs.setMensaje("No se elimino el libro");
            rs.setRespuesta(p);
        }
        return rs;
    }

    @Path("buscar")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Libro buscar(Libro libro) {
        libro = imp.buscar(libro);
        return libro;
    }

    @Path("buscarPorAutor")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libro> buscarPorAutor(Libro libro) {
        return imp.buscarPorAutor(libro);
    }
}
