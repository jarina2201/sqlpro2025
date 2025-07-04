package org.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLJDBCRevice {
	public static void main(String[] args) {
		
		Connection con = null;
		
		//1.Load the driver
try {
	Class.forName("oracle.jdbc.OracleDriver");
			
	//2.connect to database
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Hr","jarina");
			
	//3.Sql query
	String query = "select * from courseDetails";
			
	//4.Prepare the statement
	PreparedStatement ps = con.prepareStatement(query);
			
	//5.Execute Query
	ResultSet eq = ps.executeQuery();
	
	//6.Iterate the results
	
	while (eq.next()) {
			
		int c_id = eq.getInt("course_Id");
		String c_name = eq.getString("course_name");
			
			
		System.out.println(c_id+" ---->"+c_name);
		}
			
					
	} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	//7.Close the database connection
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}}


