package com.mx.webService;

import com.mx.entidad.Mascota;
import com.mx.general.Resultado;
import com.mx.service.Implementacion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("mascotas")
public class WebService {
    Implementacion imp = new Implementacion();

    //http://localhost:9001/JDBC/jDBC/mascotas/listar
    @Path("listar")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Mascota> mostrar() {
        return (List<Mascota>) imp.mostrar();
    }

    @Path("guardar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado guardar(Mascota mascota) {
        Resultado rs = new Resultado();
        rs.setObj(mascota);
        String p = imp.guardar(mascota);
        if (p.equals("1")) {
            rs.setMensaje("Se guardo de manera correcta");
            rs.setRespuesta(p);
        } else {
            rs.setMensaje("No se pudo guardar la mascota");
            rs.setRespuesta(p);
        }
        return rs;
    }

    @Path("editar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado editar(Mascota mascota) {
        Resultado rs = new Resultado();
        rs.setObj(mascota);
        String p = imp.editar(mascota);
        if (p.equals("1")) {
            rs.setMensaje("Se edito la mascota de manera correcta");
            rs.setRespuesta(p);
        } else {
            rs.setMensaje("No se edito la mascota");
            rs.setRespuesta(p);
        }
        return rs;
    }

    @Path("eliminar")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado eliminar(Mascota mascota) {
        Resultado rs = new Resultado();
        rs.setObj(mascota);
        String p = imp.eliminar(mascota);
        if (p.equals("1")) {
            rs.setMensaje("Se elimino la mascota");
            rs.setRespuesta(p);
        } else {
            rs.setMensaje("No se elimino la mascota");
            rs.setRespuesta(p);
        }
        return rs;
    }

    @Path("buscar")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Mascota buscar(Mascota mascota) {
        mascota = imp.buscar(mascota);
        return mascota;
    }

}
