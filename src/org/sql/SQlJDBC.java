package org.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQlJDBC {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	
	//1.Load the driver 
	Class.forName("oracle.jdbc.OracleDriver");
	
	//2.connect to database
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Hr","jarina");
	
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
	
	//7.Close the database connection
	try {
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	

	int a=10;
	int b=20;
	
	int c=a+b;
	System.out.println(c);
	
	
	
	
	
}
}
