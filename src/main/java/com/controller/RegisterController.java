package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDao;
import com.database.DatabaseConnection;
import com.database.DatabaseEnvironmentData;
import com.database.MySqlConnection;
import com.model.User;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		DatabaseConnection connection = new MySqlConnection(DatabaseEnvironmentData.url, DatabaseEnvironmentData.usuario, DatabaseEnvironmentData.contraseña);
		UserDao userDao = new UserDao(connection);
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && password != null) {
			User usuario = new User(username, password);
			try {
				userDao.createUser(usuario);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		response.sendRedirect("JSP/login.jsp");

		}
	}

}
