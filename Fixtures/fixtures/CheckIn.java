package fixtures;


import fit.ActionFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
import com.samscdrental.failures.*;


public class CheckIn extends ActionFixture {
	PhysicalIDADT physicalID;
	public static RentalCharge theRentalChargeForm;

	public void CDID(String value) throws FormatDeviation
	{
		physicalID = PhysicalIDADT.parseString(value); 
	}
	public void Return() 	
	{
		theRentalChargeForm = RentalProcess.checkIn( physicalID); 
	}
	

}


