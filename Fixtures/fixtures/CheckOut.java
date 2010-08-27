package fixtures;


import fit.ActionFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
import com.samscdrental.failures.*;


public class CheckOut extends ActionFixture {
	CustomerIDADT customerID; 
	PhysicalIDADT physicalID; 
	public static RentalContract theRentalForm;
	public void CustomerID(String value) throws FormatDeviation 
	{
		customerID = CustomerIDADT.parseString(value); 
	}
	public void CDID(String value) throws FormatDeviation
	{
		physicalID = PhysicalIDADT.parseString(value); 
	}
	public void Rent() 	
	{
		theRentalForm = RentalProcess.checkOut(customerID, physicalID); 
	}
	

}


