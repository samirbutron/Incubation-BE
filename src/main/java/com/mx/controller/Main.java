package com.mx.controller;

import com.mx.entidad.Mascota;
import com.mx.service.Implementacion;

public class Main {
    public static void main(String[] args) {
        Implementacion imp = new Implementacion();
        Mascota mascota1 = new Mascota(7, "Steve", 2, 12.5);
        imp.guardar(mascota1);
        mascota1 = new Mascota(7, "Coronel", 2, 12.5);
        imp.editar(mascota1);
        imp.eliminar(mascota1);
        mascota1 = new Mascota(2, "Coronel", 2, 12.5);
        Mascota mascota2 = imp.buscar(mascota1);
        System.out.println(mascota2);
        System.out.println(imp.mostrar());
    }
}
