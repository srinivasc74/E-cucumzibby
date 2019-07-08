package com.zibby.tests;

import java.sql.SQLException;

import com.zibby.database.PostgresDBConnection;

public class TestingDB {

	
	public static void main(String[] args) throws SQLException {
		
		System.out.println(PostgresDBConnection.selectQuery());
	}
	
}
