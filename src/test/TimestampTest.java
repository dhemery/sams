package test;
import junit.framework.*;

import com.samscdrental.failures.FormatDeviation;
import com.samscdrental.model.adt.*;
public class TimestampTest extends TestCase {
	public void testTimeStampConstructorAndString()
	{
		String DATE_STRING = "1/1/10 10:00 AM";  
		try {
			TimeStamp.TEST_ONLY_set_date(DATE_STRING);
		} catch (FormatDeviation e) {
			fail("Did not have correct date string" + e.getMessage()); 
		} 
		TimeStamp t = new TimeStamp();
		assertEquals(DATE_STRING, t.toString()); 
	}



}
