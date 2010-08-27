package com.samscdrental.model.adt;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;

import com.samscdrental.failures.FormatDeviation;

/**
 * <p>Title: Sams CD Rental Store</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Ken Pugh
 * @version 1.0
 */

public class TimeStamp
	implements java.io.Serializable
{
	private static DateFormat format = DateFormat.getDateTimeInstance(
	        DateFormat.SHORT, DateFormat.SHORT);

	private static final long serialVersionUID = -1L; 
	public static final TimeStamp DEFAULT_VALUE = defaultValue(); 
	private static TimeStamp defaultValue()
	{
		
		Calendar c = Calendar.getInstance(); 
		c.set(1970, 1, 1, 0, 0); 
		Date d = c.getTime(); 
		return new TimeStamp(d); 

	}
	public TimeStamp()
	{
		if (testDate != null)
			theDate = testDate;
		else 
			theDate = new Date();
	}
	public TimeStamp(Date aDate)
	{
		// Will be initialized to the current time
		theDate = aDate;
	}
	/**
	 * subtract
	 *
	 * @param aTimestamp Timestamp
	 * @return int - Number of Days
	 */
	public Count differenceInDays( TimeStamp aTimestamp )
	{
		long thisMilliseconds = this.theDate.getTime();
		long thatMilliseconds = aTimestamp.theDate.getTime();
		long millisecondsDifference = thisMilliseconds - thatMilliseconds;
		int days = ( int ) ( millisecondsDifference /
							 NUMBER_MILLISECONDS_IN_DAY );
		return new Count(days);

	}

	/**
	 * add
	 *
	 * @param days int
	 * @return Timestamp
	 */
	public TimeStamp addDays( int days )
	{
		long thisMilliseconds = this.theDate.getTime();
		long thatMilliseconds = thisMilliseconds +
			days * NUMBER_MILLISECONDS_IN_DAY;

		TimeStamp aTimestamp = new TimeStamp();
		aTimestamp.theDate = new Date( thatMilliseconds );
		return aTimestamp;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return a string representation of the object.
	 * @todo Implement this java.lang.Object method
	 */
	public String toString()
	{
		String a = format.format(theDate); 
		return a; 

	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj the reference object with which to compare.
	 * @return <code>true</code> if this object is the same as the obj argument;
	 *   <code>false</code> otherwise.
	 * @todo Implement this java.lang.Object method
	 */
	public boolean equals( TimeStamp aTimestamp )
	{
		return theDate.equals( aTimestamp.theDate );
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
		return equals( ( TimeStamp ) obj );
	}

	public TimeStamp( String aString ) throws FormatDeviation
	{
		theDate = fromString( aString );

	}


	public static Date fromString( String aString ) throws FormatDeviation
	{
		Date DEFAULT_DATE = new Date(); 
		if ( aString.length() <= LENGTH_OF_VALUE )
		{
			try {
				return format.parse(aString);
			} 
			catch (ParseException e) {
				new FormatDeviation( ERROR_TIMESTAMP_BAD_CHARACTERS 
						  + e.getMessage());
			} 
		}
		else
		{
			throw new FormatDeviation( ERROR_TIMESTAMP_BAD_LENGTH );
		}
		return DEFAULT_DATE; 
	}
	
	public static TimeStamp parseString( String aString ) throws
		FormatDeviation
	{
		return new TimeStamp( aString );
	}

	public static void  TEST_ONLY_set_date(String dateString) throws FormatDeviation
	{ 
		testDate = fromString(dateString); 
		System.err.println("Setting Test date to " + testDate);
		
	}
	private static Date testDate = null; 
	// Error messages
	private static final String ERROR_TIMESTAMP_BAD_LENGTH =
		"Timestamp not correct length ";
	private static final String ERROR_TIMESTAMP_BAD_CHARACTERS =
		"Timestamp does not correct format";
	private static int LENGTH_OF_VALUE = 20; 
	private Date theDate;
	private static final long NUMBER_MILLISECONDS_IN_DAY = 1000 * 24 * 60 * 60;
}
