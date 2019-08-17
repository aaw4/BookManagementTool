package com.minye.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbUtil {
	
		// database address
		private static String dbUrl="jdbc:mysql://localhost:3306/db_book";
		// userName
		private static String dbUsername="root";
		// password
		private static String dbPassword="123456";
		// Driver's name
		private static String jdbcName = "com.mysql.jdbc.Driver";
		
		// get database connection
		public Connection getCon() throws Exception {
			Class.forName(jdbcName);
			Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			return con;
		}
		
		// close connection
		public void closeCon(Connection con) throws Exception {
				if (con != null) {
					con.close();
				}
		}
		
		// close connection and statement
		public void close(Statement stmt, Connection con) throws Exception {
			if (stmt != null) {
				stmt.close();
				if (con != null) {
					con.close();
				}
			}
		}
}
