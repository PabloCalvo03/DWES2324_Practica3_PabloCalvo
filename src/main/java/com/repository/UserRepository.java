package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DatabaseConnection;
import com.model.User;

public class UserRepository {

	private DatabaseConnection dbConnection;

	public UserRepository(DatabaseConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public User getUserByCredentials(String userName, String password) throws Exception {
		User usuario = null;
		Connection connection = null;

		try {

			connection = dbConnection.connect();
			String consulta = "SELECT * FROM usuarios WHERE userName = ? AND password = ?";
			PreparedStatement stmt = connection.prepareStatement(consulta);
			stmt.setString(1, userName);
			stmt.setString(2, password);

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				usuario = new User();
				usuario.setId(resultSet.getInt("id"));
				usuario.setUserName(resultSet.getString("userName"));
				usuario.setPassWord(resultSet.getString("password"));
			} else {
				throw new Exception("Datos incorrectos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(connection);
		}

		return usuario;
		
	}
	
	public void createUser(User usuario) {
	    Connection connection = null;

	    try {
	        connection = dbConnection.connect();
	        String consulta = "INSERT INTO usuarios (userName, password) VALUES (?, ?)";
	        PreparedStatement stmt = connection.prepareStatement(consulta);
	        stmt.setString(1, usuario.getUserName());
	        stmt.setString(2, usuario.getPassWord());
	        

	        int filasAfectadas = stmt.executeUpdate();

	        if (filasAfectadas == 1) {
	            System.out.println("Usuario creado correctamente");
	        } else {
	            System.out.println("No se pudo crear el usuario");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbConnection.close(connection);
	    }
	}
	

}
