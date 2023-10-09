package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DatabaseConnection;
import com.model.Product;
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
	
	public User getUserByUsername(String userName) throws Exception {
		User usuario = null;
		Connection connection = null;

		try {

			connection = dbConnection.connect();
			String consulta = "SELECT * FROM usuarios WHERE userName = ?";
			PreparedStatement stmt = connection.prepareStatement(consulta);
			stmt.setString(1, userName);

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				usuario = new User();
				usuario.setId(resultSet.getInt("id"));
				usuario.setUserName(resultSet.getString("userName"));
				usuario.setPassWord(resultSet.getString("password"));
				usuario.setRole(resultSet.getString("role"));
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
	
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();
		Connection connection = null;

		try {
			connection = dbConnection.connect();
			String consulta = "SELECT * FROM usuarios";
			PreparedStatement stmt = connection.prepareStatement(consulta);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				User usuario = new User();
				usuario.setId(resultSet.getInt("id"));
				usuario.setUserName(resultSet.getString("userName"));
				usuario.setRole(resultSet.getString("role"));

				users.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(connection);
		}

		return users;
	}
	
	public void createUser(User usuario){
	    Connection connection = null;

	    try {
	        connection = dbConnection.connect();
	        String consulta = "INSERT INTO usuarios (userName, password, role) VALUES (?, ?, ?)";
	        PreparedStatement stmt = connection.prepareStatement(consulta);
	        stmt.setString(1, usuario.getUserName());
	        stmt.setString(2, usuario.getPassWord());
	        stmt.setString(3, usuario.getRole());
	        

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
	
	public void quitAdminPrivileges(Integer id) {
	    Connection connection = null;

	    try {
	        connection = dbConnection.connect();
	        String consulta = "UPDATE usuarios SET role = ? WHERE id = ?"
;
	        PreparedStatement stmt = connection.prepareStatement(consulta);
	        stmt.setString(1, "STANDARD");
	        stmt.setInt(2, id);

	        int filasAfectadas = stmt.executeUpdate();

	        if (filasAfectadas == 1) {
	            System.out.println("Rol cambiado correctamente");
	        } else {
	            System.out.println("Fallo al cambiar el rol");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbConnection.close(connection);
	    }
	}
	
	public void putAdminPrivileges(Integer id) {
	    Connection connection = null;

	    try {
	        connection = dbConnection.connect();
	        String consulta = "UPDATE usuarios SET role = ? WHERE id = ?"
;
	        PreparedStatement stmt = connection.prepareStatement(consulta);
	        stmt.setString(1, "ADMIN");
	        stmt.setInt(2, id);

	        int filasAfectadas = stmt.executeUpdate();

	        if (filasAfectadas == 1) {
	            System.out.println("Rol cambiado correctamente");
	        } else {
	            System.out.println("allo al cambiar el rol");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbConnection.close(connection);
	    }
	}
	

}
