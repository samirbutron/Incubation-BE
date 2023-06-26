package classes;

public class Persona {
  String nombre;
  int edad;
  double altura;
  double peso;
  String celular;

  public Persona() {
  }

  public Persona(String nombre, int edad, double altura, double peso, String celular) {
    this.nombre = nombre;
    this.edad = edad;
    this.altura = altura;
    this.peso = peso;
    this.celular = celular;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  @Override
  public String toString() {
    return "Persona{" +
        "nombre='" + nombre + '\'' +
        ", edad=" + edad +
        ", altura=" + altura +
        ", peso=" + peso +
        ", celular='" + celular + '\'' +
        '}';
  }
}
