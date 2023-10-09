package com.controller.filters;

import java.io.IOException;

import com.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AdminAuthenticationFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AdminAuthenticationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
	        HttpSession session = request.getSession(false);
	        User user = null;
	        
	        if(session != null) {
	        user = (User) session.getAttribute("usuario");
	        }
	        

			if (session == null || session.getAttribute("usuario") == null || !user.getRole().equals("ADMIN")) {
	            response.sendRedirect(request.getContextPath() + "/JSP/login.jsp");
	            return;
	        }
	        
	        chain.doFilter(request, response);
	}

}
