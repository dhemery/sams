package com.samscdrental.model.adt;

import com.samscdrental.failures.*;
import com.samscdrental.helper.Log;

/**
 * <p>Title: Sams CD Rental Store</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Ken Pugh
 * @version 1.0
 */

public class Count
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 
	public static final Count DEFAULT_VALUE = new Count(0); 

	Count()
	{
	}

	public Count( int value )
	{
		theValue = value; 
	}

	/**
	 * fromString
	 *
	 * @param aString String
	 * @return boolean
	 */
	public void fromString( String aString ) throws FormatDeviation
	{
		String s = aString.trim();
		theValue = 0; 
		theValue = Integer.parseInt(s); 
		return;
	}

	/**
	 * PhysicalID
	 *
	 * @param aString String
	 * @throws FormatDeviation 
	 */
	public Count( String aString ) 
	{
		try {
			fromString( aString );
		} catch (FormatDeviation e) {
			Log.write("Count format error "+ e.getMessage()); 
		}

	}

	public static Count parseString( String aString ) throws
		FormatDeviation
	{
		return new Count( aString );
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj the reference object with which to compare.
	 * @return <code>true</code> if this object is the same as the obj argument;
	 *   <code>false</code> otherwise.
	 * @todo Implement this java.lang.Object method
	 */
	public boolean equals( Count aDollar )
	{
		return aDollar.theValue == theValue ;
	}

	void fromint( int value )
	{
		theValue = value; 

	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return a string representation of the object.
	 * @todo Implement this java.lang.Object method
	 */
	public String toString()
	{
		return Integer.toString(theValue); 
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
		return equals( ( Count ) obj );
	}

	private int theValue = 0; 

	// Error messages
	static final String ERROR_COUNT_BAD_FORMAT =
		"Count - bad format ";

	public Count minusButNotLessThanZero(Count other) {
		int result = this.theValue - other.theValue; 
		if (result < 0)
			result = 0; 
		return new Count(result);
	}
	int getValue(){
		return theValue;
	}
	}

