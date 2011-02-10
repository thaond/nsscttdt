package com.ext.portlet.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionPool {
	private static DataSource datasource = null;
	private static Connection con = null;
	private static DataSource getDataSource(){
		try {
			if(datasource == null) {
				Context ic = new InitialContext();
				Context envCtx = (Context) ic.lookup("java:comp/env");
				datasource = (DataSource)envCtx.lookup(JNDINames.PROVIDER_DATASOURCE);
			}
			return datasource;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return datasource;		
	}
	public static Connection getConnection() throws SQLException{
		try {
			 datasource=getDataSource();
			 con=datasource.getConnection();
			return con;
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
		return con;
	}
	
	public static Connection getConnection(int level) throws SQLException{
		try {
			datasource=getDataSource();
			Connection con=datasource.getConnection();
			con.setTransactionIsolation(level);
			return con;
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
		return con;
	}
	
	public static void closeConnection(Connection con){
		try {
			if(con!=null) {
				con.close();	
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement stmt){
		try {
			if(stmt!=null) {
				stmt.close();	
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(PreparedStatement pre){
		try {
			if(pre!=null) {
				pre.close();	
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet re){
		try {
			if(re!=null) {
				re.close();	
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
