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

public class CDCategoryValue implements java.io.Serializable
{

	private static final long serialVersionUID = -1L; 
	public static CDCategoryValue NOT_FOUND = notFound();
	private static CDCategoryValue notFound() {
	return new CDCategoryValue(CDCategory.DEFAULT_VALUE,
			Count.DEFAULT_VALUE, Dollar.DEFAULT_VALUE,
			Dollar.DEFAULT_VALUE); 
	}


public CDCategoryValue( CDCategory category, Count baseRentalDays, 
		 Dollar baseRentalFee, Dollar extraDayRentalFee)
			   
{
	theCDCategory = category;
	theBaseRentalPeriodDays = baseRentalDays;
	theBaseRentalFee = baseRentalFee;
	theExtraDayRentalFee = extraDayRentalFee; 
}

public CDCategory getCategory() {
	return theCDCategory; 
}
public Count getbaseRentalDays() {
	return theBaseRentalPeriodDays; 
}
public Dollar getbaseRentalFee() {
	return theBaseRentalFee; 
}
public Dollar getExtraDayRentalFee() {
	return theExtraDayRentalFee; 
}

private CDCategory theCDCategory = CDCategory.DEFAULT_VALUE; 
private Count theBaseRentalPeriodDays = new Count(2);
private Dollar theBaseRentalFee = new Dollar(3.0);		
private Dollar theExtraDayRentalFee = new Dollar(1.0);		

}

