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

public class RentalContract
	implements java.io.Serializable
{
	public static RentalContract NOT_FOUND = notFound();
	private static RentalContract notFound() {
		return new RentalContract(Name.DEFAULT_VALUE,
				Name.DEFAULT_VALUE, 
				PhysicalIDADT.DEFAULT_VALUE, CustomerIDADT.DEFAULT_VALUE,
				TimeStamp.DEFAULT_VALUE); 
	}
	private static final long serialVersionUID = -1L; 

	public Name getCustomerName(){
		return 	theCustomerName; 
	}
	public PhysicalIDADT getPhysicalID() 
	{
	return thePhysicalID;
	}
	public CustomerIDADT getCustomerID(){
		return theCustomerID;
	}
	public TimeStamp getDueDate () { 
		return theDueDate;
	}
	public Name getTitle() {
		return theTitle;
	}

	public RentalContract( Name aCustomerName, Name aTitle, 
			PhysicalIDADT aPhysicalID, CustomerIDADT aCustomerID, 
			TimeStamp aDueDate)
	{
		theCustomerName =aCustomerName;
		theTitle = aTitle;
		thePhysicalID = aPhysicalID;
		theCustomerID = aCustomerID;  
		theDueDate = aDueDate;
		}

	private Name theCustomerName;
	private	PhysicalIDADT thePhysicalID;
	private CustomerIDADT theCustomerID;
	private TimeStamp theDueDate; 
	private Name theTitle;

	public boolean testEquals(RentalContract other)
	{
		if (!other.getCustomerID().equals(this.getCustomerID()))
		{
			System.err.println("Customer ID difference " + this.getCustomerID() +
					" " + other.getCustomerID()); 
			return false; 
		} 
		if (!other.getCustomerName().equals(this.getCustomerName()))	
		{
			System.err.println("Customer Name difference " + this.getCustomerName() +
					" " + other.getCustomerName()); 
			return false; 
		} 
		if (!other.getDueDate().equals(this.getDueDate()))
		{
			System.err.println("Due date difference " + this.getDueDate() +
					" " + other.getDueDate()); 
			return false; 
		} 
		if (!other.getPhysicalID().equals(this.getPhysicalID()))
		{
			System.err.println("Physical ID difference " + this.getPhysicalID() +
					" " + other.getPhysicalID()); 
			return false; 
		} 
		if (!other.getTitle().equals(this.getTitle()))
		{
			System.err.println("Title difference " + this.getTitle() +
					" " + other.getTitle()); 
			return false; 
		} 
		return true; 

	}	

}
