package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=ulla97";
	static private Connection connection = null;

	public static Connection getConnection() {

		try {
			if (connection == null /*|| connection.isClosed()*/) {			//devo avviare la connessione e quindi verificare che non sia chiusa, ma non la metto in questo caso perchè da errore 
				connection = DriverManager.getConnection(jdbcUrl);
			}
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
