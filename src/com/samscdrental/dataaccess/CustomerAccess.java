
//Work on this 
package com.samscdrental.dataaccess;
import java.sql.*;	
import com.samscdrental.helper.*;
import com.samscdrental.failures.*;
import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
public class CustomerAccess {
	public static boolean addCustomer(Customer aCustomer){
		
		try {
			DatabaseSetup.open(); 
			Statement statement = DatabaseSetup.connection.createStatement();
			statement.execute("INSERT INTO CUSTOMERS VALUES ('" +
					aCustomer.getCustomerID().toString() + "', '" +
					aCustomer.getName().toString() +  "' );"); 
				return true; 
		}
			catch(SQLException ex) {
			Log.write("SQLException: " + ex.getMessage());
			return false; 
		}
	}
	public static Customer findByCustomerID(CustomerIDADT aCustomerID)
	{
		
		String selectString = "select * from CUSTOMERS where CustomerID = '" + aCustomerID.toString() + "';";
		try {
			Statement s  = DatabaseSetup.connection.createStatement();
			ResultSet rs = s.executeQuery(selectString);
			while (rs.next()) {
				return createCustomer(rs);
				}
			s.close();
			return Customer.NOT_FOUND; 

		} catch(SQLException ex) {
			Log.write("SQLException: " + ex.getMessage());
		}

		return Customer.NOT_FOUND; 
	}
	private static Customer createCustomer(ResultSet rs) throws SQLException{
		String t1 = rs.getString(1).trim();
		String t2 = rs.getString(2).trim();
		CustomerIDADT aCustomerID = CustomerIDADT.DEFAULT_VALUE;
		Name aName = Name.DEFAULT_VALUE;
		try {
			aCustomerID = CustomerIDADT.parseString(t1);
			aName = Name.parseString(t2);
		} catch (Deviation e) {
			Log.write("Deviation: " + e.getMessage());
		} 
		return new Customer( aCustomerID, aName );

	}
	}


