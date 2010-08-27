package com.samscdrental.model.adt;

/**
 * <p>Title: Sams CD Rental Store</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Ken Pugh
 * @version 1.0
 */
import com.samscdrental.failures.*;
import com.samscdrental.helper.*;

public class CustomerIDADT
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 
	public static final CustomerIDADT DEFAULT_VALUE = defaultValue(); 

	private static CustomerIDADT defaultValue()
	{
		try {
			return CustomerIDADT.parseString("C000");
		} catch (FormatDeviation e) {
			Log.write("Cannot create Default CustomerID");
			return null; 
		} 

	}
	public CustomerIDADT()
	{

	}

	public CustomerIDADT( String aString ) throws FormatDeviation
	{
		fromString( aString );

	}

	/**
	 * fromString
	 *
	 * @param aString String
	 * @return boolean
	 */
	public void fromString( String aString ) throws FormatDeviation
	{
		if ( aString.length() == LENGTH_OF_VALUE )
		{
			if ( !StringHelper.containsOnlyAlphanumerics( aString ) )
			{
				throw new FormatDeviation(
					ERROR_CUSTOMER_ID_BAD_CHARACTERS );
			}

			theValue = aString;
		}
		else
		{

			throw new FormatDeviation(String.format(ERROR_CUSTOMER_ID_BAD_LENGTH, aString, aString.length(), LENGTH_OF_VALUE));
		}
	}

	public static CustomerIDADT parseString( String aString ) throws
		FormatDeviation
	{
		return new CustomerIDADT( aString );
	}

	boolean isInvalid()
	{
		return theValue.equals( INVALID_ID );
	}

/*	public String getValue()
	{
		return theValue;
	}
*/
	/**
	 * Returns a string representation of the object.
	 *
	 * @return a string representation of the object.
	 */
	public String toString()
	{
		return theValue;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj the reference object with which to compare.
	 * @return <code>true</code> if this object is the same as the obj argument;
	 *   <code>false</code> otherwise.
	 * @todo Implement this java.lang.Object method
	 */
	public boolean equals( CustomerIDADT aCustomerID )
	{
		return theValue.equals( aCustomerID.theValue );
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj the reference object with which to compare.
	 * @return <code>true</code> if this object is the same as the obj argument;
	 *   <code>false</code> otherwise.
	 * @todo Implement this java.lang.Object method
	 */
	public boolean equals( Object obj )
	{
		return equals( ( CustomerIDADT ) obj );
	}

	private String theValue = INVALID_ID;
	private static final String INVALID_ID = "INVALID ID";
	private static final int LENGTH_OF_VALUE = 4;

	// Error messages
	private static final String ERROR_CUSTOMER_ID_BAD_LENGTH =
		"Customer ID %s length was %s, expected %s";
	private static final String ERROR_CUSTOMER_ID_BAD_CHARACTERS =
		"Customer ID can contain only digits and letters ";

}
