package com.samscdrental.model;


import com.samscdrental.model.adt.*;
import com.samscdrental.failures.*;
import com.samscdrental.dataaccess.*;
import com.samscdrental.helper.Log;
public class RentalProcess {


	public static RentalCharge checkIn(PhysicalIDADT physicalID) {
		TimeStamp doneTime = new TimeStamp();
		CD cd = CDAccess.findByPhysicalID(physicalID); 
		Customer customer = CustomerAccess.findByCustomerID(cd.getCustomerID()); 
		Count rentalDays = doneTime.differenceInDays(cd.getStartTime()); 
		cd.unRent(); 
		CDAccess.update(cd); 
		// Simple computation 
		Dollar rentalFee = Dollar.DEFAULT_VALUE;
		try {
			rentalFee = new Dollar("2.00").times(rentalDays);
		} catch (FormatDeviation e) {
			Log.write("Error in converting Dollar " + e.getMessage() + "checkIn"); 
			} 
		return new 	RentalCharge(customer.getName(), cd.getTitle(), 
				doneTime, rentalFee); 
	}
	public static RentalContract checkOut( CustomerIDADT customerID, PhysicalIDADT physicalID) {
		TimeStamp startTime = new TimeStamp();
		Customer customer = CustomerAccess.findByCustomerID(customerID); 
		CD cd = CDAccess.findByPhysicalID(physicalID); 
		cd.rent(customerID, startTime); 
		CDAccess.update(cd); 
		TimeStamp rentalDue = startTime.addDays(2); 
		return new 	RentalContract( customer.getName(), cd.getTitle(), 
				physicalID, cd.getCustomerID(), rentalDue); 
	}
	public static Dollar computeRentalFee(CDCategory category, Count rentalDays) {
		
		CDCategoryValue cv = CategoryValuesAccess.findByCategory(category); 
		Count days = cv.getbaseRentalDays(); 
		Dollar baseRate = cv.getbaseRentalFee(); 
		Dollar extraRate = cv.getExtraDayRentalFee();
		Count extraDays = rentalDays.minusButNotLessThanZero(days);
		Dollar extraFee = extraRate.times(extraDays); 
		Dollar fee = baseRate.plus(extraFee); 
		return fee; 
		
	}
}
