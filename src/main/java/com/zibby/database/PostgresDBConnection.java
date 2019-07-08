package com.zibby.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDBConnection {
	
	 private final static String url = "jdbc:postgresql://razorvision.cbkyes5an8on.us-east-1.rds.amazonaws.com:5432/cognicaldb";
	    private final static String user = "cognicaladmin";
	    private final static String password = "Y9wTyh$2uN72D4w^mcWv";
	
	
	    public static Connection connect() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	    }	    
	public static Connection connectDB(){
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("", "cognicaladmin", "");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return conn;
		
	}

	   public static String selectQuery() throws SQLException {
	      Connection c = connect();
	      Statement stmt = null;
	      ResultSet rs = null;
	      try {

	         stmt = c.createStatement();
	         rs = stmt.executeQuery( "select * from lms_esigncode order by created_at desc limit 1;" );
	         
	         
	         while ( rs.next() ) {
	            
	            System.out.println(rs.getString("application_id"));
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
		return rs.getString("application_id");
	   }
	
	
	
}