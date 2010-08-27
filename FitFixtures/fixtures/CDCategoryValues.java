package fixtures;



import fit.ColumnFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
import com.samscdrental.dataaccess.*;


public class CDCategoryValues extends ColumnFixture {
		public CDCategory Category;
		public int RentalDays;
		public double BaseRentalFee;
		public double ExtraDayRentalFee; 
		public boolean add() throws Exception {
				// Must change here 
				Count CountRentalDays = new Count(RentalDays); 
				Dollar DollarBaseRentalFee = new Dollar(BaseRentalFee);
				Dollar DollarExtraDayRentalFee = new Dollar(ExtraDayRentalFee);
		
				CDCategoryValue aCategoryValue = new CDCategoryValue
				(Category, CountRentalDays,
						DollarBaseRentalFee,DollarExtraDayRentalFee); 
  
				CategoryValuesAccess.addCategoryValue(aCategoryValue);
			    return true; 
			}


		public boolean findByCategory() 
		{
			CDCategoryValue aCategoryValue 
				= CategoryValuesAccess.findByCategory(Category);
					return aCategoryValue.getCategory().equals(Category); 		
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
