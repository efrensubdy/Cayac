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
	private static final String DB_URL = "jdbc:mysql://seqmysql.cgle3ujtslg6.us-west-2.rds.amazonaws.com/seq_cayac";
	private static final String DB_USER = "devopsSEQ";
	private static final String DB_PASSWORD = "VbW3ra4L5VbpnJJk";
	//private static final String DB_URL = "jdbc:mysql://181.143.181.205:3306/seqconsultores_sys";
	//private static final String DB_USER = "seq";

	//private static final String DB_PASSWORD = "susypadyn";

	public static Connection conection() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return conn;

	}


}
