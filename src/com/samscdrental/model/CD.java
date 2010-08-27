package com.samscdrental.model;
import com.samscdrental.model.adt.*;

/**
 * <p>Title: Sams CD Rental Store</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Ken Pugh
 * @version 1.0
 */

public class CD
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 
	private PhysicalIDADT thsPhysicalID; 
	private Name theTitle; 
	private YesNo theRented;
	private CustomerIDADT theCustomerID;
	private TimeStamp theStartTime; 
	public static CD NOT_FOUND = notFound();
	private static CD notFound() {
		return new CD(PhysicalIDADT.DEFAULT_VALUE,
				Name.DEFAULT_VALUE, YesNo.DEFAULT_VALUE,
				CustomerIDADT.DEFAULT_VALUE, TimeStamp.DEFAULT_VALUE);  
	}
	public CD( PhysicalIDADT aPhysicalID, Name aTitle, YesNo aRented, 
			CustomerIDADT aCustomerID,TimeStamp aStartTime )
	{
		thsPhysicalID = aPhysicalID;
		theTitle = aTitle;
		theRented = aRented;
		if (theRented.equals(YesNo.YES))
		{
			theCustomerID = aCustomerID;
			theStartTime = aStartTime;
		}
		else
		{
			theCustomerID = CustomerIDADT.DEFAULT_VALUE;
			theStartTime = TimeStamp.DEFAULT_VALUE; 
		}
		
	}

	public Name getTitle()
	{
		return theTitle;
	}



	public CustomerIDADT getCustomerID() {
		return theCustomerID; 
	}
	public PhysicalIDADT getPhysicalID() {
		return thsPhysicalID; 
	}
	public TimeStamp getStartTime() {
		return theStartTime; 
	}
	public YesNo getRented()
	{
		return theRented; 
	}

	public void unRent() {
		theRented = YesNo.NO;
		theCustomerID = CustomerIDADT.DEFAULT_VALUE;
		theStartTime = TimeStamp.DEFAULT_VALUE; 
	}
	public void rent(CustomerIDADT customerID, TimeStamp startTime) {
		theRented = YesNo.YES; 	
		theCustomerID = customerID;
		theStartTime = startTime; 
		
	} 

	
}

