package fixtures;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
import com.samscdrental.failures.*;


public class FixtureHelper {

	@SuppressWarnings("rawtypes")
	public static Object parseADT(String s, Class type)
			throws FormatDeviation
			 
			{
		if (type == CustomerIDADT.class) {
			return new CustomerIDADT(s);
		}
		if (type == Name.class) {
			return new Name(s);
		}
		if (type == PhysicalIDADT.class) {
			return new PhysicalIDADT(s);
		}
		if (type == CDCategory.class)
		{
			return  CDCategory.parseString(s); 
		}
		if (type == UPCCode.class)
			return new UPCCode(s);
		if (type == TimeStamp.class)
			return new TimeStamp(s); 
		if (type == Dollar.class)
			return new Dollar(s); 
		if (type == Count.class)
			return new Count(s); 
		if (type == YesNo.class)
			return new YesNo(s); 
		return null; 
	}

}
