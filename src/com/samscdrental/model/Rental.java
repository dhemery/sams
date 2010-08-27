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

public class Rental
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 
	public static Rental NOT_FOUND = notFound();
	private static Rental notFound() {
		return new Rental(CustomerIDADT.DEFAULT_VALUE,
				PhysicalIDADT.DEFAULT_VALUE, TimeStamp.DEFAULT_VALUE); 
	}


	public Rental( CustomerIDADT aCustomerID, PhysicalIDADT aPhysicalID, 
			 TimeStamp aStartTime)
				   
	{
		theCustomerID = aCustomerID;
		thePhysicalID = aPhysicalID;
		theStartTime = aStartTime;
	}

	public CustomerIDADT getCustomerID() {
		return theCustomerID; 
	}
	public PhysicalIDADT getthePhysicalID() {
		return thePhysicalID; 
	}
	public TimeStamp getStartTime() {
		return theStartTime; 
	}	
	private CustomerIDADT theCustomerID = CustomerIDADT.DEFAULT_VALUE;
	private PhysicalIDADT thePhysicalID = PhysicalIDADT.DEFAULT_VALUE;
	private TimeStamp theStartTime = new TimeStamp();

}
