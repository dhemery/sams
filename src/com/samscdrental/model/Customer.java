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

public class Customer
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 
	private CustomerIDADT theCustomerID;
	private Name theName;
	public static Customer NOT_FOUND = notFound();
	private static Customer notFound() {
		return new Customer(CustomerIDADT.DEFAULT_VALUE,
				Name.DEFAULT_VALUE); 
	}

	public CustomerIDADT getCustomerID()
	{
		return theCustomerID;
	}

	public Name getName()
	{
		return theName;
	}



	public Customer( CustomerIDADT aCustomerID, Name aName )
	{
		theName = aName;
		theCustomerID = aCustomerID;
	}


}
