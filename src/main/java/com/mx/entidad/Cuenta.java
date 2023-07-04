package com.mx.entidad;

public class Cuenta {

  private String numeroDeCuenta;
  private String tipo;
  private double saldo;
  private double deuda;

  public Cuenta() {
  }

  public Cuenta(String numeroDeCuenta) {
    this.numeroDeCuenta = numeroDeCuenta;
  }

  public Cuenta(String numeroDeCuenta, String tipo, double saldo, double deuda) {
    this.numeroDeCuenta = numeroDeCuenta;
    this.tipo = tipo;
    this.saldo = saldo;
    this.deuda = deuda;
  }

  public String getNumeroDeCuenta() {
    return numeroDeCuenta;
  }

  public void setNumeroDeCuenta(String numeroDeCuenta) {
    this.numeroDeCuenta = numeroDeCuenta;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public double getDeuda() {
    return deuda;
  }

  public void setDeuda(double deuda) {
    this.deuda = deuda;
  }

  @Override
  public String toString() {
    return "Cuenta{" +
        "numeroDeCuenta='" + numeroDeCuenta + '\'' +
        ", tipo='" + tipo + '\'' +
        ", saldo=" + saldo +
        ", deuda=" + deuda +
        '}';
  }
}
