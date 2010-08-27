package com.samscdrental.model;

import com.samscdrental.failures.*;
import com.samscdrental.helper.*;

/**
 * <p>Title: Sams CD Rental Store</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Ken Pugh
 * @version 1.0
 */

public class CDCategory
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 

	public CDCategory()
	{

	}
	public CDCategory(String aString)
	{
		try {
			fromString(aString);
		} catch (FormatDeviation e) {
			Log.write("CD Category Error " + aString + e.getMessage()); 
		} 
	}
	public String toString()
	{
		return theValue;
	}

	public static CDCategory parseString( String aString ) throws
		FormatDeviation
	{
		CDCategory aCDCategory = new CDCategory();
		aCDCategory.fromString( aString );
		return aCDCategory;
	}
	private static final int LENGTH_OF_VALUE = 30;

	private void fromString( String aString ) throws FormatDeviation
	{
		if (aString.length() <= LENGTH_OF_VALUE) 
			theValue = aString; 
		else 
		throw new FormatDeviation( 
		ERROR_CD_CATEGORY_VALUE + "Exceeds "  + LENGTH_OF_VALUE + ":"
		+ aString + ":");
	}

	public boolean equals( CDCategory aCDCategory )
	{
		return ( theValue.equals(aCDCategory.theValue ));
	}

	public boolean equals( Object obj )
	{
		return this.equals( ( CDCategory ) obj );
	}

	public boolean isValid()
	{
		// Note that validity is based on whether a value appears 
		// in the database table (AVT) 
		return CDCategoryValid.isCDCategoryValid(this); 
	}

	private static String INVALID_VALUE_STRING = "INVALIDCATEGORY"; 
	private String theValue = INVALID_VALUE_STRING;

	private static final String ERROR_CD_CATEGORY_VALUE =
		"Bad CDCategory value ";
	private static String DEFAULT_VALUE_STRING = "NotSet"; 
	public static final CDCategory DEFAULT_VALUE = new CDCategory(DEFAULT_VALUE_STRING); 
	public static final CDCategory INVALID_VALUE = new CDCategory(INVALID_VALUE_STRING); 


}
