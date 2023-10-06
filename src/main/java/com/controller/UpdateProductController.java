package com.controller;

import java.io.IOException;

import com.configurer.ConfigLoader;
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
 * Servlet implementation class UpdateProductController
 */
public class UpdateProductController extends HttpServlet {
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
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Float peso = Float.parseFloat(request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));

		Product product = new Product(id, nombre, descripcion, peso, stock);

		request.setAttribute("product", product);

		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/updateProduct.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession() == null) {
			response.sendRedirect("/JSP/login.jsp");
		}
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		ProductRepository productRepository = new ProductRepository(connection);

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Float peso = Float.parseFloat(request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));

		Product product = new Product(id, nombre, descripcion, peso, stock);

		productRepository.updateProduct(product);

		response.sendRedirect("ListProductsController");

	}

}
