package fixtures;

import fit.ColumnFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.model.*;
import com.samscdrental.dataaccess.*;


public class CDs extends ColumnFixture {
	public PhysicalIDADT PhysicalID = PhysicalIDADT.DEFAULT_VALUE ;
	public Name Title = Name.DEFAULT_VALUE;
	public CustomerIDADT CustomerID = CustomerIDADT.DEFAULT_VALUE; 
	public YesNo Rented = YesNo.DEFAULT_VALUE; 
	public TimeStamp StartTime = TimeStamp.DEFAULT_VALUE; 

	public boolean add() throws Exception {
				CD aCD = new CD( PhysicalID, Title, Rented, 
						CustomerID, StartTime );   
			CDAccess.addCD(aCD);
			return true; 
		}


	public Name findTitleByPhysicalID() 
	{
		CD aCD = CDAccess.findByPhysicalID(PhysicalID); 
		
		return aCD.getTitle(); 
		}


	@SuppressWarnings("rawtypes")
	@Override
	public Object parse(String s, Class type) throws Exception {
		Object o = FixtureHelper.parseADT(s, type); 
		if (o != null)
			return o; 
		//			if (type == CDAlbum.class) {
		//				return new CDAlbum(s);
		//			}
		return super.parse(s, type);
	}
}
