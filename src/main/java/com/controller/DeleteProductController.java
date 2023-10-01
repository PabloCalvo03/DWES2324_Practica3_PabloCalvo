package com.controller;

import java.io.IOException;

import com.dao.ProductDao;
import com.database.DatabaseConnection;
import com.database.DatabaseEnvironmentData;
import com.database.MySqlConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProductController
 */
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(DatabaseEnvironmentData.url, DatabaseEnvironmentData.usuario, DatabaseEnvironmentData.contraseña);
		ProductDao productDao = new ProductDao(connection);
		
		Integer productId = Integer.parseInt(request.getParameter("id"));
		
		productDao.deleteProduct(productId);
		
		response.sendRedirect("ListProductsController");
		
		
	}

	
	

}
