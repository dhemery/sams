package com.samscdrental.model;
import com.samscdrental.dataaccess.CategoryValuesAccess;
import java.util.*; 
public class CDCategoryValid {
	public static boolean isCDCategoryValid(CDCategory aCDCategory)
	{
		Collection<CDCategory> all = CategoryValuesAccess.getAllCDCategorys();
		Iterator<CDCategory> iterator = all.iterator(); 
		while (iterator.hasNext())
		{
			if (aCDCategory.equals(iterator.next()))
					return true;  
		}
		return false;
	}

}
