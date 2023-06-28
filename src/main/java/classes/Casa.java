package classes;

import java.util.Objects;

public class Casa {
  private String calle;
  private int numero;
  private String colonia;
  private String ciudad;
  private int numeroPisos;
  private double precio;
  private double metrosCuadrados;

  public Casa() {
  }

  public Casa(String calle, int numero, String colonia, String ciudad, int numeroPisos,
      double precio,
      double metrosCuadrados) {
    this.calle = calle;
    this.numero = numero;
    this.colonia = colonia;
    this.ciudad = ciudad;
    this.numeroPisos = numeroPisos;
    this.precio = precio;
    this.metrosCuadrados = metrosCuadrados;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public int getNumeroPisos() {
    return numeroPisos;
  }

  public void setNumeroPisos(int numeroPisos) {
    this.numeroPisos = numeroPisos;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public double getMetrosCuadrados() {
    return metrosCuadrados;
  }

  public void setMetrosCuadrados(double metrosCuadrados) {
    this.metrosCuadrados = metrosCuadrados;
  }

  @Override
  public String toString() {
    return "Casa{" +
        "calle='" + calle + '\'' +
        ", numero=" + numero +
        ", colonia='" + colonia + '\'' +
        ", ciudad='" + ciudad + '\'' +
        ", numeroPisos=" + numeroPisos +
        ", precio=" + precio +
        ", metrosCuadrados=" + metrosCuadrados +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Casa casa = (Casa) o;
    return numero == casa.numero && numeroPisos == casa.numeroPisos
        && Double.compare(casa.precio, precio) == 0
        && Double.compare(casa.metrosCuadrados, metrosCuadrados) == 0
        && Objects.equals(calle, casa.calle) && Objects.equals(colonia,
        casa.colonia) && Objects.equals(ciudad, casa.ciudad);
  }
}
