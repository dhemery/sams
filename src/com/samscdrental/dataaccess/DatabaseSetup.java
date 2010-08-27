package com.samscdrental.dataaccess;
import java.sql.*; 
import com.samscdrental.helper.*;

public class DatabaseSetup {
	
	public static Connection connection = null;
	public static boolean setupComplete = false; 
	static public void setup()
	{
	String userid="SA";
	String password = "";
	String url = "jdbc:hsqldb:hsql://localhost";	


			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	

			} catch(java.lang.ClassNotFoundException e) {
				Log.write(e.getMessage());
			}

			try {
			   connection = DriverManager.getConnection(url, userid, password);
			} catch(SQLException ex) {
				Log.write("SQLException: " + ex.getMessage() + " Setup");
			}

		}
	public static void setupTables()
	{
		try {
		Statement statement = connection.createStatement();
		// UPCCode CDCategory Title 
		statement.execute("CREATE TABLE CDS (PhysicalID CHAR(20), Title CHAR(50), Rented CHAR(5), CUSTOMERID CHAR(20), STARTTIME CHAR(20));"); 		
		statement.execute("CREATE TABLE CUSTOMERS (CUSTOMERID CHAR(12), NAme CHAR(20));"); 		
		statement.execute("CREATE TABLE CDCATVALS (CATEGORY CHAR(15), DAYS CHAR(2), BASEFEE CHAR(5), EXTRADAYFEE CHAR(5));");
		setupComplete= true; 
	}
		catch(SQLException ex) {
		Log.write("SQLException: " + ex.getMessage() + " Create Tables");
	}
		
	}
	public static void removeTables()
	{
		try {
		Statement statement = connection.createStatement();
		statement.execute("DROP TABLE CDS;"); 		
		statement.execute("DROP TABLE CUSTOMERS;"); 		
		statement.execute("DROP TABLE CDCATVALS;");
		setupComplete= true; 
	}
		catch(SQLException ex) {
		Log.write("SQLException: " + ex.getMessage() + " RemoveTables");
	}
		
	}
	static public void open()
	{
		if (connection == null)
			setup();
	}
	}

	

