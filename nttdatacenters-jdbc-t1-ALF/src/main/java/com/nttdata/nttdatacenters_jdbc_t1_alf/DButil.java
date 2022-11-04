package com.nttdata.nttdatacenters_jdbc_t1_alf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {

	// URL
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// Requisito previo para iniciar Oracle
	private static final String USERNAME = "SYSTEM"; // Nombre de usuario
	private static final String PWD = "rootroot"; // Contraseña
	
	// Conexión con la base de datos
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USERNAME, PWD);
		return conn;
	}

	// Crea un método para liberar todos los recursos
	public void closeAll(ResultSet rst, Statement stmt, Connection conn) {
		if (rst != null) {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
