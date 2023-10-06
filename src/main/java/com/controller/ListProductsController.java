package com.controller;

import java.io.IOException;
import java.util.List;

import com.controller.configurer.ConfigLoader;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.model.Product;
import com.repository.ProductRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListProductsController
 */
public class ListProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

private ConfigLoader configLoader;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.configLoader = new ConfigLoader();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(this.configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		ProductRepository productRepository = new ProductRepository(connection);

		List<Product> products = productRepository.getAllProducts();

		request.setAttribute("products", products);

		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listProducts.jsp");

		dispatcher.forward(request, response);

	}


}
