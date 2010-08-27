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

public class RentalCharge
	implements java.io.Serializable
{
	public static RentalCharge NOT_FOUND = notFound();
	private static RentalCharge notFound() {
		return 	new RentalCharge( Name.DEFAULT_VALUE, 
				Name.DEFAULT_VALUE, 
				TimeStamp.DEFAULT_VALUE, Dollar.DEFAULT_VALUE) ;
		}
	private static final long serialVersionUID = -1L; 

	public Name getCustomerName(){
		return 	theCustomerName; 
	}
	public Dollar getRentalFee(){
		return theRentalFee;
	}
	public TimeStamp getReturnDate () { 
		return theReturnDate;
	}
	public Name getTitle() {
		return theTitle;
	}

	public RentalCharge( Name aCustomerName, Name aTitle, 
			TimeStamp aReturnDate, Dollar aRentalFee) 
	{
		theCustomerName =aCustomerName;
		theTitle = aTitle;
		theRentalFee = aRentalFee;  
		theReturnDate = aReturnDate;
		}

	private Name theCustomerName;
	private TimeStamp theReturnDate; 
	private Dollar theRentalFee; 
	private Name theTitle;

	public boolean testEquals(RentalCharge other)
	{
		if (!other.getCustomerName().equals(this.getCustomerName()))	
		{
			System.err.println("Name difference " + this.getCustomerName() +
					" " + other.getCustomerName()); 
			return false; 
		}
		if (!other.getReturnDate().equals(this.getReturnDate()))
		{
			System.err.println("Return difference " 
					+  this.getReturnDate() + " " + other.getReturnDate()); 
			return false;
		}
		if (!other.getRentalFee().equals(this.getRentalFee()))
		{
			System.err.println("RentalFee difference " +
					this.getRentalFee() + " " + other.getRentalFee()); 
			return false;
		}
		if (!other.getTitle().equals(this.getTitle()))
		{
			System.err.println("Title difference " + 
					this.getTitle() +
					" " + other.getTitle()); 
			return false;
		}
		return true; 

	}

}