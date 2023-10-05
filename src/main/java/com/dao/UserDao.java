package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DatabaseConnection;
import com.model.Product;

public class UserDao {

	private DatabaseConnection dbConnection;

	public UserDao(DatabaseConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public Usuario getUserByNameAndPassword(String userName, String password) {
		return null;
		
	}
	

}
