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

public class PhysicalIDADT
	implements java.io.Serializable
{

	private static final long serialVersionUID = -1L; 
	public static final PhysicalIDADT DEFAULT_VALUE = defaultValue(); 

	private static PhysicalIDADT defaultValue()
	{
		try {
			return PhysicalIDADT.parseString("CD0000000000");
		} catch (FormatDeviation e) {
			Log.write("Cannot create Default PhysicalID");
			return null; 
		} 

	}
	public PhysicalIDADT()
	{
	}



	public PhysicalIDADT( String aString ) throws FormatDeviation
	{
		fromString( aString );

	}

	boolean isInvalid()
	{
		return theValue.equals( INVALID_ID );
	}

	private void fromString( String aString ) throws FormatDeviation
	{
		if ( aString.length() == LENGTH_OF_VALUE )
		{
			if ( !StringHelper.containsOnlyAlphanumerics(aString) )
			{
				throw new FormatDeviation(
					ERROR_PHYSICAL_ID_BAD_CHARACTERS );
			}
			theValue = aString;
		}
		else
		{
			throw new FormatDeviation( ERROR_PHYSICAL_ID_BAD_LENGTH );
		}
	}

	public static PhysicalIDADT parseString( String aString ) throws
		FormatDeviation
	{
		return new PhysicalIDADT( aString );
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj the reference object with which to compare.
	 * @return <code>true</code> if this object is the same as the obj argument;
	 *   <code>false</code> otherwise.
	 * @todo Implement this java.lang.Object method
	 */
	public boolean equals( PhysicalIDADT aPhysicalID )
	{
		return ( aPhysicalID.theValue.equals( this.theValue ) );

	}

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
	public boolean equals( Object obj )
	{
		return equals( ( PhysicalIDADT ) obj );
	}

	private String theValue = INVALID_ID;
	private static final String INVALID_ID = "INVALID_ID";
	private static final int LENGTH_OF_VALUE = 12;

	// Error messages
	private static final String ERROR_PHYSICAL_ID_BAD_LENGTH =
		"Physical ID not correct length ";
	private static final String ERROR_PHYSICAL_ID_BAD_CHARACTERS =
		"Physical ID can contain only digits ";

}
