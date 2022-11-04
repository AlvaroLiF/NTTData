package com.nttdata.nttdatacenters_jdbc_t1_alf;

import java.sql.*;
import org.slf4j.LoggerFactory;

/**
 * Práctica - JDBC
 * 
 * Clase principal
 * 
 * @author ALF
 *
 */
public class App {

	/** LOGGER */
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(App.class);

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Se usa cuando la base de datos está conectada
		Connection conn = null;
		// Una vez que la conexión de la base de datos es exitosa, el objeto cuando opera en los datos
		Statement stmt = null;
		// El conjunto de resultados se devolverá al consultar datos
		ResultSet rst = null;
		// Instanciamos DButils
		DButil db = new DButil();

		try {
			// Conexión a la base de datos
			conn = db.getConnection();
			log.info("¡Conectado exitosamente a la base de datos!");
			// Consulta todos los datos de la tabla NTTDATA_ORACLE_SOCCER_PLAYER
			String sql = "select * from NTTDATA_ORACLE_SOCCER_PLAYER";
			// Crear objeto de operación de datos
			stmt = conn.createStatement();
			// stmt ejecuta la instrucción de consulta y coloca el resultado devuelto en
			// primer lugar
			rst = stmt.executeQuery(sql);
			// Recorrer el conjunto de resultados
			while (rst.next()) {
				// Obtenemos los datos de las columnas y los metemos en sus variables
				String idSoccerPlayer = rst.getString(1);
				String name = rst.getString(2);
				Date birthDate = rst.getDate(3);
				String firstRol = rst.getString(4);
				String secondRol = rst.getString(5);
				String idSoccerTeam = rst.getString(6);
				//Imprimimos por pantalla las columnas mediante el log
				if (log.isInfoEnabled()) {
					log.info(String.format(
							" ID: %s | Nombre: %s | Fecha de nacimiento: %s | Primera posición: %s | Segunda posición: %s | ID del equipo: %s | ",
							idSoccerPlayer, name, birthDate, firstRol, secondRol, idSoccerTeam));
				}
			}
			//Capturamos los errores
		} catch (SQLException e) {
			log.error("No se puede conectar a la base de datos");
			e.printStackTrace();
		} finally {
			// Cerramos la base de datos
			db.closeAll(rst, stmt, conn);
		}
	}

}
