package com.fujitsu.LoginAndRegister.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.LoginAndRegister.DAO.UserRegistrationDAO;
import com.fujitsu.LoginAndRegister.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {

	UserRegistrationDAO dao;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String Address =request.getParameter("address");
		
		Random random =new Random();
		
		
		
		int userId = random.nextInt(999);
		
		
		User newUser = new User(userId,username,password,phone,Address);		
	//	System.out.println("New User" +newUser);
		//save USEr in DAtaBaSe
		dao= new UserRegistrationDAO();
	boolean result =	dao.registerUser(newUser);
		
	if(result) {
		System.out.println("User Registerd Succefully!");
		response.sendRedirect("Welcomejsp.jsp");
	}
	else {
		System.err.println("Internal Server Error!");
	}
	
	
	}

}
