package com.samscdrental.dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import com.samscdrental.helper.*;
import com.samscdrental.failures.*;
import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
public class CategoryValuesAccess {
	public static boolean addCategoryValue( CDCategoryValue aCategoryValue){
		
		try {
			DatabaseSetup.open(); 

			Statement statement = DatabaseSetup.connection.createStatement();
			statement.execute("INSERT INTO CDCATVALS VALUES ('" +
					aCategoryValue.getCategory().toString() + "', '" +
					aCategoryValue.getbaseRentalDays().toString() + "', '" + 
					aCategoryValue.getbaseRentalFee().toString() + "', '" +
					aCategoryValue.getExtraDayRentalFee().toString() +  "' );"); 
				return true; 
		}
			catch(SQLException ex) {
			Log.write("Add Category Values SQLException: " + ex.getMessage());
			return false; 
		}
	}
	public static Collection<CDCategory> getAllCDCategorys()
	{
		   Collection<CDCategory> list = new ArrayList<CDCategory>();
		   String selectString = "select * from CDCATVALS;";
			try {
				Statement s  = DatabaseSetup.connection.createStatement();
				ResultSet rs = s.executeQuery(selectString);
				while (rs.next()) {
					CDCategory category = createCDCategoryValue(rs).getCategory();
					list.add(category);
					}
				s.close();
			} catch(SQLException ex) {
				Log.write("SQLException: " + ex.getMessage());
			}
			return list;
	}
	public static CDCategoryValue findByCategory(CDCategory aCDCategory)
	{
		String selectString = "select * from CDCATVALS where CATEGORY = '" + aCDCategory.toString() + "';";
		try {
			Statement s  = DatabaseSetup.connection.createStatement();
			ResultSet rs = s.executeQuery(selectString);
			while (rs.next()) {
				return createCDCategoryValue(rs);
				}
			s.close();
			return CDCategoryValue.NOT_FOUND; 

		} catch(SQLException ex) {
			Log.write("SQLException: " + ex.getMessage());
		}

		return CDCategoryValue.NOT_FOUND; 
	}
	private static CDCategoryValue createCDCategoryValue(ResultSet rs) throws SQLException{
	
		String t1 = rs.getString(1).trim();
		String t2 = rs.getString(2).trim();
		String t3 = rs.getString(3).trim();	
		String t4 = rs.getString(4).trim();	
		CDCategory aCDCategory = CDCategory.DEFAULT_VALUE;
		Count aBaseRentalPeriodDays = Count.DEFAULT_VALUE ;
		Dollar aBaseRentalFee = Dollar.DEFAULT_VALUE ;		
		Dollar aExtraDayRentalFee = Dollar.DEFAULT_VALUE;	

		try {
				aCDCategory = CDCategory.parseString(t1);
				aBaseRentalPeriodDays = Count.parseString(t2);
				aBaseRentalFee = Dollar.parseString(t3);
				aExtraDayRentalFee = Dollar.parseString(t4);
		} catch (Deviation e) {
			Log.write("Deviation: " + e.getMessage());
		} 
		return new CDCategoryValue(aCDCategory,
				aBaseRentalPeriodDays, aBaseRentalFee,
				aExtraDayRentalFee); 

	}
	}


