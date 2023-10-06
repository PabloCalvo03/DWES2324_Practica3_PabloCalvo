package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DatabaseConnection;
import com.model.Product;

public class ProductRepository {

	private DatabaseConnection dbConnection;

	public ProductRepository(DatabaseConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public Product getProductoById(Integer idProducto) {

		Product producto = new Product();
		Connection connection = null;

		try {

			connection = dbConnection.connect();
			String consulta = "SELECT * FROM productos WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(consulta);
			stmt.setInt(1, idProducto);

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				producto.setId(resultSet.getInt("id"));
				producto.setNombre(resultSet.getString("nombre"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setPeso(resultSet.getFloat("peso"));
				producto.setStock(resultSet.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(connection);
		}

		return producto;
	}

	public List<Product> getAllProducts() {

		List<Product> productos = new ArrayList<>();
		Connection connection = null;

		try {
			connection = dbConnection.connect();
			String consulta = "SELECT * FROM productos";
			PreparedStatement stmt = connection.prepareStatement(consulta);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Product producto = new Product();
				producto.setId(resultSet.getInt("id"));
				producto.setNombre(resultSet.getString("nombre"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setPeso(resultSet.getFloat("peso"));
				producto.setStock(resultSet.getInt("stock"));

				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(connection);
		}

		return productos;
	}

	public void deleteProduct(Integer productId) {
		Connection connection = null;

		try {
			connection = dbConnection.connect();
			String consulta = "DELETE FROM productos WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(consulta);
			stmt.setInt(1, productId);

			int filasAfectadas = stmt.executeUpdate();

			if (filasAfectadas == 1) {
				System.out.println("Producto eliminado correctamente");
			} else {
				System.out.println("No se pudo eliminar el producto");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(connection);
		}
	}

	public void createProduct(Product producto) {
	    Connection connection = null;

	    try {
	        connection = dbConnection.connect();
	        String consulta = "INSERT INTO productos (nombre, descripcion, peso, stock) VALUES (?, ?, ?, ?)";
	        PreparedStatement stmt = connection.prepareStatement(consulta);
	        stmt.setString(1, producto.getNombre());
	        stmt.setString(2, producto.getDescripcion());
	        stmt.setFloat(3, producto.getPeso());
	        stmt.setInt(4, producto.getStock());

	        int filasAfectadas = stmt.executeUpdate();

	        if (filasAfectadas == 1) {
	            System.out.println("Producto creado correctamente");
	        } else {
	            System.out.println("No se pudo crear el producto");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbConnection.close(connection);
	    }
	}

	public void updateProduct(Product producto) {
	    Connection connection = null;

	    try {
	        connection = dbConnection.connect();
	        String consulta = "UPDATE productos SET nombre = ?, descripcion = ?, peso = ?, stock = ? WHERE id = ?"
;
	        PreparedStatement stmt = connection.prepareStatement(consulta);
	        stmt.setString(1, producto.getNombre());
	        stmt.setString(2, producto.getDescripcion());
	        stmt.setFloat(3, producto.getPeso());
	        stmt.setInt(4, producto.getStock());
	        stmt.setInt(5, producto.getId());

	        int filasAfectadas = stmt.executeUpdate();

	        if (filasAfectadas == 1) {
	            System.out.println("Producto creado correctamente");
	        } else {
	            System.out.println("No se pudo crear el producto");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbConnection.close(connection);
	    }
	}

}
