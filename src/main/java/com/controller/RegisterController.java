package com.controller;

import java.io.IOException;

import com.configurer.ConfigLoader;
import com.database.DatabaseConnection;
import com.database.MySqlConnection;
import com.encryptor.BCrypt;
import com.model.User;
import com.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
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
    public RegisterController() {
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
		User usuarioForRegister = null;
		try {
			usuarioForRegister = userRepository.getUserByUsername(username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(usuarioForRegister == null && username.isEmpty() && password.isEmpty()) {
			User usuario = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
			try {
				userRepository.createUser(usuario);
				response.sendRedirect("JSP/login.jsp");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			
			response.sendRedirect("JSP/registro.jsp");

		}
	}

}
