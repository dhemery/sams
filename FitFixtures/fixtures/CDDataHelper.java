package fixtures;

import com.samscdrental.model.CD; 
import java.util.*; 
public class CDDataHelper {
	// Makes CDs data public for use by fixture 
	public String CustomerID; 
	public String PhysicalID; 
	public String StartTime;
	public String Title;
	public String Rented; 
	public String Temp;
	CDDataHelper(CD aCD)
	{
		CustomerID = aCD.getCustomerID().toString();
		PhysicalID = aCD.getPhysicalID().toString();
		StartTime = aCD.getStartTime().toString();
		Rented = aCD.getRented().toString();
		Title = aCD.getTitle().toString(); 
	}
	static Object [] getData(Collection<CD> cds )
	{
		int size = cds.size(); 
		CDDataHelper [] rdh = new CDDataHelper[size];
		Iterator<CD> iterator = cds.iterator(); 
		int index = 0; 
		while (iterator.hasNext())
		{
			rdh[index] = new CDDataHelper(iterator.next());
			index++; 
		}
		return rdh; 
	//	Log.write("Get data for CD size " + CDs.size()); 
	//	return rentals.toArray(); 
	}

}
