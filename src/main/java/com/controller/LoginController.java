package com.controller;

import java.io.IOException;

import com.controller.configurer.ConfigLoader;
import com.repository.UserRepository;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
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
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection connection = new MySqlConnection(configLoader.getJDBC(), configLoader.getUser(), configLoader.getPass());
		UserRepository userRepository = new UserRepository(connection);
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User usuario = null;
		try {
			usuario = userRepository.getUserByCredentials(username, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(usuario != null && usuario.getUserName() != null && usuario.getPassWord() != null) {
			session.setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + "/ListProductsController");
		} else {
			response.sendRedirect("JSP/login.jsp");
		}

	}

}
