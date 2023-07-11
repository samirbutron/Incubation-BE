package com.mx.general;

import lombok.Getter;

@Getter
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
}
