package com.mx.general;

import com.mx.entidad.Mascota;

import java.util.List;

public interface Metodos {
    String guardar(Mascota mascota);

    String editar(Mascota mascota);

    String eliminar(Mascota mascota);

    Mascota buscar(Mascota mascota);

    List<Mascota> mostrar();
}
