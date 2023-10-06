package com.controller;

import java.io.IOException;

import com.controller.configurer.ConfigLoader;
import com.repository.ProductRepository;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateProductController
 */
public class CreateProductController extends HttpServlet {
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
    public CreateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		ProductRepository productDao = new ProductRepository(connection);

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Float peso = Float.parseFloat( request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));


		Product product = new Product(nombre, descripcion, peso, stock);

		productDao.createProduct(product);

		response.sendRedirect("ListProductsController");
	}

}
