package com.samscdrental.model.adt;



import com.samscdrental.failures.*;
import com.samscdrental.helper.*;

public class YesNo
	implements java.io.Serializable
{

	private static final long serialVersionUID = -1L; 

	private static String YES_STRING = "Yes"; 
	private static String NO_STRING = "No"; 
	private static final String INVALID_STRING = "INV";
	public static YesNo YES = getObject("Yes");
	public static YesNo NO = getObject("No"); 
	private String theValue = INVALID_STRING;
	private static final int LENGTH_OF_VALUE = 3;
	public static final YesNo DEFAULT_VALUE = defaultValue(); 

	// Error messages
	private static final String ERROR_YES_NO_BAD_LENGTH =
		"YesNo not correct length ";
	private static final String ERROR_YES_NO_BAD_CHARACTERS =
		"YesNo does not contain yes or no";

	private static YesNo defaultValue()
	{
		try {
			return YesNo.parseString(NO_STRING);
		} catch (FormatDeviation e) {
			Log.write("Cannot create Default Yes No");
			return new YesNo(); 
		} 

	}
	public YesNo()
	{
	}



	public YesNo( String aString ) throws FormatDeviation
	{
		fromString( aString );

	}

	boolean isInvalid()
	{
		return !theValue.equals(YES_STRING) && 
		!theValue.equals(NO_STRING); 
	}

	private void fromString( String aString ) throws FormatDeviation
	{
		if ( aString.length() <= LENGTH_OF_VALUE )
		{
			String temp = aString.toLowerCase(); 
			if (temp.equals(YES_STRING.toLowerCase()))
			{
				theValue = YES_STRING;
				return;
			}
			else if (temp.equals(NO_STRING.toLowerCase()))
			{
				theValue = NO_STRING;
				return;
			}
			else 
			{
			theValue = INVALID_STRING; 
			Log.write("Yes No Bad Chars:" + aString + ":");
			throw new FormatDeviation(
					ERROR_YES_NO_BAD_CHARACTERS + " " + aString );
			}
		}
		else
		{
			theValue = INVALID_STRING; 
			Log.write("Yes No Bad Length:"+aString+":");
			throw new FormatDeviation( ERROR_YES_NO_BAD_LENGTH );
		}
	}

	public static YesNo parseString( String aString ) throws
		FormatDeviation
	{
		return new YesNo( aString );
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj the reference object with which to compare.
	 * @return <code>true</code> if this object is the same as the obj argument;
	 *   <code>false</code> otherwise.
	 * @todo Implement this java.lang.Object method
	 */
	public boolean equals( YesNo aYesNo )
	{
		return ( aYesNo.theValue.equals( this.theValue ) );

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
		return equals( ( FormatDeviation ) obj );
	}
	
	private static YesNo getObject(String aString)
	{
		try {
			return YesNo.parseString(aString);
		} catch (FormatDeviation e) {
			Log.write("Cannot create Default Yes No");
			return null; 
		} 

	}


}
