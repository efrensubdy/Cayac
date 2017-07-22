/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_USER = "root";
	//private static final String DB_PASSWORD = "seqc";
	private static final String DB_PASSWORD = "1234";
	
	
	public static Connection conection() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return conn;
		
	}

	
}
