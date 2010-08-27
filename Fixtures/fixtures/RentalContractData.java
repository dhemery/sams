package fixtures;

import com.samscdrental.model.RentalContract;
import com.samscdrental.model.adt.CustomerIDADT;
import com.samscdrental.model.adt.Name;
import com.samscdrental.model.adt.PhysicalIDADT;
import com.samscdrental.model.adt.TimeStamp;

import fit.ColumnFixture;


public class RentalContractData extends ColumnFixture {
	
	public CustomerIDADT CustomerID;
	public Name CustomerName;
	public PhysicalIDADT PhysicalID;
	public Name Title;
	public TimeStamp RentalDue;
	public boolean check()
	{
	RentalContract rentalContract = CheckOut.theRentalForm;
	RentalContract current = 
	 new RentalContract(CustomerName,
			Title, 
			PhysicalID, CustomerID, RentalDue);
	return current.testEquals(rentalContract); 
	}

	@Override
	public Object parse(String s, @SuppressWarnings("rawtypes") Class type) throws Exception {
		Object o = FixtureHelper.parseADT(s, type); 
		if (o != null)
			return o; 
		return super.parse(s, type);
	}
}