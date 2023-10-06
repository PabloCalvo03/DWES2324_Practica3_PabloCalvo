package com.controller;

import java.io.IOException;

import com.dao.UserDao;
import com.database.DatabaseConnection;
import com.database.DatabaseEnvironmentData;
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
		DatabaseConnection connection = new MySqlConnection(DatabaseEnvironmentData.url, DatabaseEnvironmentData.usuario, DatabaseEnvironmentData.contraseña);
		UserDao userDao = new UserDao(connection);
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User usuario = null;
		try {
			usuario = userDao.getUserByNameAndPassword(username, password);
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
