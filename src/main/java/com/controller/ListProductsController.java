package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.ProductDao;
import com.database.DatabaseConnection;
import com.database.DatabaseEnvironmentData;
import com.database.MySqlConnection;
import com.model.Product;

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
		if(request.getSession() == null) {
			response.sendRedirect("/JSP/login.jsp");
		}
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(DatabaseEnvironmentData.url, DatabaseEnvironmentData.usuario, DatabaseEnvironmentData.contraseña);
		ProductDao productDao = new ProductDao(connection);

		List<Product> products = productDao.getAllProducts();

		request.setAttribute("products", products);

		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listProducts.jsp");

		dispatcher.forward(request, response);

	}


}
