package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.configurer.ConfigLoader;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.repository.UserRepository;

/**
 * Servlet implementation class UserChangeToAdminController
 */
public class UserChangeToAdminController extends HttpServlet {
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
    public UserChangeToAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hago uso de inyeccion de dependencias
		DatabaseConnection connection = new MySqlConnection(configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		UserRepository userRepository = new UserRepository(connection);

		Integer id = Integer.parseInt(request.getParameter("id"));



		userRepository.putAdminPrivileges(id);

		response.sendRedirect("ListUsersController");
	}

}
