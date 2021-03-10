package com.fujitsu.LoginAndRegister.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import com.fujitsu.LoginAndRegister.DAO.UserControllerDAO;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserControllerDAO dao = new UserControllerDAO();
		ResultSet rs = dao.getData();
		ArrayList register = new ArrayList();
		
		try {
			while (rs.next()) {

				register.add("id : " +(rs.getInt(1)));
				register.add("username  : " +(rs.getString(2)));
				register.add("password  : " +(rs.getString(3)));
				register.add("phone  : " +(rs.getInt(4)));
				register.add("address : " +(rs.getString(5)));
				System.out.println("\n");
			}
		request.setAttribute("register", register);
		//response.sendRedirect("admin.jsp");
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
		
		for(int i = 0 ;i<register.size();i++)
			System.out.println(register.get(i));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}
}
