package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements DatabaseConnection{

	    private final String dbUrl;
	    private final String dbUser;
	    private final String dbPassword;

	    public MySqlConnection(String dbUrl, String dbUser, String dbPassword) {
	        this.dbUrl = dbUrl;
	        this.dbUser = dbUser;
	        this.dbPassword = dbPassword;
	    }

	    // Metodo para abrir la conexion con la base de datos MySql
	    public Connection connect() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("No se pudo conectar a la base de datos.");
	        }
	    }

	    // Metodo para cerrar la conexion con la base de datos MySql
	    public void close(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
