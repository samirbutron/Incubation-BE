package com.mx.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
    int no_registro;
    String nombre;
    int edad;
    double peso;
}
