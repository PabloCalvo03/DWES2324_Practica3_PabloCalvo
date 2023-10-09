package com.controller;

import java.io.IOException;
import java.util.List;

import com.configurer.ConfigLoader;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.model.User;
import com.repository.UserRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListUsersController
 */
public class ListUsersController extends HttpServlet {
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
    public ListUsersController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(this.configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		UserRepository userRepository = new UserRepository(connection);

		List<User> users = userRepository.getAllUsers();

		request.setAttribute("users", users);

		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listUsers.jsp");

		dispatcher.forward(request, response);

	}

}
