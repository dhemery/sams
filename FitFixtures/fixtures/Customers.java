package fixtures;


import fit.ColumnFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
import com.samscdrental.dataaccess.*;


public class Customers extends ColumnFixture {
	public CustomerIDADT CustomerID ;
	public Name Name;

	public boolean add() throws Exception {
			Customer aCustomer = new Customer(CustomerID, Name);  
			CustomerAccess.addCustomer(aCustomer);
			return true; 
		}


	public Name findNameByCustomerID() 
	{
		Customer aCustomer = CustomerAccess.findByCustomerID(CustomerID); 
		return aCustomer.getName(); 
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
