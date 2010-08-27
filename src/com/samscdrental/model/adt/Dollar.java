package com.samscdrental.model.adt;

import java.math.*;
import java.text.*;

import com.samscdrental.failures.*;

/**
 * <p>Title: Sams CD Rental Store</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Ken Pugh
 * @version 1.0
 */

public class Dollar
	implements java.io.Serializable
{
	private static final long serialVersionUID = -1L; 
	public static final Dollar DEFAULT_VALUE = new Dollar(0); 

	public Dollar()
	{
	}

	public Dollar( double value )
	{
		theValue = new BigDecimal( value );
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
		s.replaceAll( ",", "" );
		if ( s.startsWith( "$" ) )
		{
			s = s.substring( 1 );
		}
		try
		{
			theValue = new BigDecimal( s );
		}
		catch ( NumberFormatException exception )
		{
			throw new FormatDeviation( ERROR_DOLLAR_BAD_FORMAT + aString );
		}

		return;
	}

	/**
	 * PhysicalID
	 *
	 * @param aString String
	 */
	public Dollar( String aString ) throws FormatDeviation
	{
		fromString( aString );

	}

	public static Dollar parseString( String aString ) throws
		FormatDeviation
	{
		return new Dollar( aString );
	}

	
	public boolean equals( Dollar aDollar )
	{
	return aDollar.theValue.equals( this.theValue );
	}

	void fromDouble( double value )
	{
		theValue = new BigDecimal( value );

	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return a string representation of the object.
	 * @todo Implement this java.lang.Object method
	 */
	public String toString()
	{
		return NumberFormat.getCurrencyInstance().format( theValue );
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
		return equals( ( Dollar ) obj );
	}

	private BigDecimal theValue = new BigDecimal( 0.0 );

	// Error messages
	static final String ERROR_DOLLAR_BAD_FORMAT =
		"Dollar - bad format ";

	public Dollar times(Count other) {
		int otherInt = other.getValue(); 
		BigDecimal otherBD = new BigDecimal(otherInt); 
		BigDecimal result = this.theValue.multiply(otherBD);
		Dollar resultDollar = new Dollar();
		resultDollar.theValue = result;
		return resultDollar;
	}

	public Dollar plus(Dollar other) {
		BigDecimal otherBD = other.theValue;
		BigDecimal result = this.theValue.add(otherBD);
		Dollar resultDollar = new Dollar();
		resultDollar.theValue = result;
		return resultDollar;
	}

}
