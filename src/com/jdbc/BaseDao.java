package com.jdbc;

import java.sql.*;

public class BaseDao {
	private String dbUrl="jdbc:mysql://localhost:3306/sushe";
	private String dbUser="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.cj.jdbc.Driver";
	
	//???????ݿ?
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){}
		return conn;		
	}
	
//    ????
	public static void main(String[] args)
	{
		System.out.println(new BaseDao().getConn());
		
	}
	
}
