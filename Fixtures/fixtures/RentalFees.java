package fixtures;


import fit.ColumnFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;


public class RentalFees extends ColumnFixture {
		public CDCategory Category;
		public int RentalDays;
		public Dollar RentalFee() throws Exception {
				// Must change here 
			
				Count countRentalDays = new Count(RentalDays); 
				Dollar rentalFee = RentalProcess.computeRentalFee(Category, countRentalDays);
				   return rentalFee; 
			}

	@SuppressWarnings("rawtypes")
	@Override
	public Object parse(String s, Class type) throws Exception  {
		Object o = FixtureHelper.parseADT(s, type); 
		if (o != null)
			return o; 
		return super.parse(s, type);

	}
}