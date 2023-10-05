package com.database;

import java.sql.Connection;

// Una interfaz que luego implementara nuestro MySqlConnection
public interface DatabaseConnection {

	public Connection connect();

    public void close(Connection connection);

}
