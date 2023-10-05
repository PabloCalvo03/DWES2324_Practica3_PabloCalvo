package com.database;


// Esta clase es como un .env, en Java no existe asi que he creado una interfaz con los valores.
public interface DatabaseEnvironmentData {

	String url = "jdbc:mysql://localhost:3306/productosdb";
	String usuario = "root";
	String contraseña = "root";
}
