package com.mx.general;

public class ConexionDb {
  String driver;
  String url;
  String user;
  String password;

  public ConexionDb() {
    this.driver = "oracle.jdbc.OracleDriver";
    this.url = "jdbc:oracle:thin:@localhost:1521:xe";
    this.user = "SYSTEM";
    this.password = "1122";
  }

  public String getDriver() {
    return driver;
  }

  public String getUrl() {
    return url;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }
}
