package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DatabaseConnection;
import com.model.Product;
import com.model.Usuario;

public class UserDao {

	private DatabaseConnection dbConnection;

	public UserDao(DatabaseConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public Usuario getUserByNameAndPassword(String userName, String password) {
		Usuario usuario = null;
		Connection connection = null;

		try {

			connection = dbConnection.connect();
			String consulta = "SELECT * FROM productos WHERE userName = ?, password = ?";
			PreparedStatement stmt = connection.prepareStatement(consulta);
			stmt.setString(1, userName);
			stmt.setString(1, password);

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setUserName(resultSet.getString("userName"));
				usuario.setPassWord(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(connection);
		}

		return usuario;
		
	}
	

}
