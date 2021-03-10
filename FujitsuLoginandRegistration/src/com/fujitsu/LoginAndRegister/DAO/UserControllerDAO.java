package com.fujitsu.LoginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserControllerDAO {

	public ResultSet getData() {
		String url = "jdbc:mysql://localhost:3306/usecase?autoReconnect=true&useSSL=false";
		String db_username = "root";
		String db_password = "Anonymus@1996";

		Connection con;
		PreparedStatement pstmt;

		String sql = " select * from register";
		ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, db_username, db_password);

			pstmt = con.prepareStatement(sql);

			result = pstmt.executeQuery();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
