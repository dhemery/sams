// Work on this 
	package com.samscdrental.dataaccess;
	import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

	import com.samscdrental.helper.*;
	import com.samscdrental.failures.*;
	import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
	public class CDAccess {
		public static boolean addCD(CD aCD){
			
			try {
				DatabaseSetup.open(); 
				Statement statement = DatabaseSetup.connection.createStatement();
				statement.execute("INSERT INTO CDS VALUES ('" +
						aCD.getPhysicalID().toString() + "', '" +
						aCD.getTitle().toString() + "', '" +
						aCD.getRented().toString() + "', '" +
						aCD.getCustomerID().toString() + "', '" +
						aCD.getStartTime().toString() +  "' );"); 
						return true; 
			}
				catch(SQLException ex) {
				Log.write("SQLException: " + ex.getMessage());
				return false; 
			}
		}
		public static CD findByPhysicalID(PhysicalIDADT aPhysicalID)
		{
			
			String selectString = "select * from CDS where PhysicalID = '" + aPhysicalID.toString() + "';";
			try {
				Statement s  = DatabaseSetup.connection.createStatement();
				ResultSet rs = s.executeQuery(selectString);
				while (rs.next()) {
					return createCD(rs);
					}
				s.close();
				return CD.NOT_FOUND; 

			} catch(SQLException ex) {
				Log.write("SQLException: " + ex.getMessage());
			}

			return CD.NOT_FOUND; 
		}
		public static Collection<CD> getAll()
		{
			   Collection<CD> list = new ArrayList<CD>();
				String selectString = "select * from CDS;";
				try {
					Statement s  = DatabaseSetup.connection.createStatement();
					ResultSet rs = s.executeQuery(selectString);
					while (rs.next()) {
						list.add(createCD(rs));
						}
					s.close();
				} catch(SQLException ex) {
					Log.write("SQLException: " + ex.getMessage());
				}
				return list;
		}
		private static CD createCD(ResultSet rs) throws SQLException{
			String t1 = rs.getString(1).trim();
			String t2 = rs.getString(2).trim();
			String t3 = rs.getString(3).trim();
			String t4 = rs.getString(4).trim();
			String t5 = rs.getString(5).trim(); 
			Name aTitle = Name.DEFAULT_VALUE; 
			YesNo aRented = YesNo.DEFAULT_VALUE; 
			CustomerIDADT aCustomerID = CustomerIDADT.DEFAULT_VALUE; 
			TimeStamp aStartTime = TimeStamp.DEFAULT_VALUE; 
			PhysicalIDADT aPhysicalID  = PhysicalIDADT.DEFAULT_VALUE;
			try {
				aPhysicalID = PhysicalIDADT.parseString(t1);
				aTitle = Name.parseString(t2);
				aRented = YesNo.parseString(t3);
				aCustomerID = CustomerIDADT.parseString(t4);
				aStartTime = TimeStamp.parseString(t5);
				
			} catch (Deviation e) {
				Log.write("Deviation: " + e.getMessage());
			} 
			return new CD( aPhysicalID, aTitle, aRented, 
					aCustomerID ,aStartTime ); 

		}
		public static boolean update(CD aCD) {
			// TODO Auto-generated method stub
					try {
					DatabaseSetup.open(); 
					Statement statement = DatabaseSetup.connection.createStatement();
					statement.execute("UPDATE  CDS " + 
							"SET RENTED='" + aCD.getRented().toString() + "'," +
							"TITLE='" +	aCD.getTitle().toString() + "'," +
							"CUSTOMERID='" + aCD.getCustomerID().toString() + "'," + 
							"STARTTIME='" + aCD.getStartTime().toString() +  "'" +  
							"WHERE PHYSICALID='" + aCD.getPhysicalID().toString() + "';") ; 
							return true; 
				}
					catch(SQLException ex) {
					Log.write("SQLException: " + ex.getMessage() + " Update");
					return false; 
				}

		}
		}


