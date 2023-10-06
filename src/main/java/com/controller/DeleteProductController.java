package com.controller;

import java.io.IOException;

import com.configurer.ConfigLoader;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.repository.ProductRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProductController
 */
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private ConfigLoader configLoader;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.configLoader = ConfigLoader.getInstance();
	}
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
		DatabaseConnection connection = new MySqlConnection(configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		ProductRepository productRepository = new ProductRepository(connection);

		Integer productId = Integer.parseInt(request.getParameter("id"));

		productRepository.deleteProduct(productId);

		response.sendRedirect("ListProductsController");


	}




}
