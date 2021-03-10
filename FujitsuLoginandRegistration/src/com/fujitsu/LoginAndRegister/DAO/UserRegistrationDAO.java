package com.fujitsu.LoginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.fujitsu.LoginAndRegister.model.User;

public class UserRegistrationDAO {

	public boolean registerUser(User register) {
		System.out.println("Running RegistrationDAO :: registerUser");

		String url = "jdbc:mysql://localhost:3306/registration";
		String db_username = "root";
		String db_password = "Anonymus@1996";

		Connection con;
		PreparedStatement pstmt;
		String sql = "insert into register values (?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, db_username, db_password);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, register.getId());
			pstmt.setString(2, register.getUsername());
			pstmt.setString(3, register.getPassword());
			pstmt.setInt(4, register.getPhone());
			pstmt.setString(5, register.getAddress());

			int result = pstmt.executeUpdate();

			if (result > 0)

				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Running RegistrationDAO :: registerUser");

		return false;

	}

}
