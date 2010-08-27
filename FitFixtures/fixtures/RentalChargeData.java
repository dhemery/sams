package fixtures;

import fit.ColumnFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;


public class RentalChargeData extends ColumnFixture {
	public Name CustomerName;
	public TimeStamp ReturnDate;
	public Dollar RentalFee; 
	public Name Title; 
	public boolean check()
	{
	RentalCharge rentalCharge = CheckIn.theRentalChargeForm;
	RentalCharge current = new RentalCharge(CustomerName, Title, ReturnDate, RentalFee);
	return current.testEquals(rentalCharge); 

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object parse(String s, Class type) throws Exception {
		Object o = FixtureHelper.parseADT(s, type); 
		if (o != null)
			return o; 
		return super.parse(s, type);
	}
}