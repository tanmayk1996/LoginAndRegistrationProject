package com.fujitsu.LoginAndRegister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.LoginAndRegister.DAO.LoginDAO;


@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginDAO dao = new LoginDAO();
		boolean result = dao.verifyUserCredentials(username, password);
		if(result)
		{
			System.out.println("start of login controller");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Welcomejsp.jsp");
			System.out.println("end of login controller");
		}
		
		else
		{
		

			response.sendRedirect("login.jsp");
		
		}
		
	}

}
