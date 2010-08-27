

import com.samscdrental.dataaccess.CDAccess;
import com.samscdrental.dataaccess.CustomerAccess;
import com.samscdrental.dataaccess.DatabaseSetup;
import com.samscdrental.failures.FormatDeviation;
import com.samscdrental.model.CD;
import com.samscdrental.model.Customer;
import com.samscdrental.model.RentalCharge;
import com.samscdrental.model.RentalContract;
import com.samscdrental.model.RentalProcess;
import com.samscdrental.model.adt.CustomerIDADT;
import com.samscdrental.model.adt.Name;
import com.samscdrental.model.adt.PhysicalIDADT;
import com.samscdrental.model.adt.TimeStamp;
import com.samscdrental.model.adt.YesNo;

public class SamsCDRentalLibrary {
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
	private RentalContract contract;
	private RentalCharge charge;

	public SamsCDRentalLibrary() {
		DatabaseSetup.setup();
		DatabaseSetup.removeTables();
		DatabaseSetup.setupTables();
	}

	public void addCD(String id, String title) {
		CDAccess.addCD(makeCD(id, title));
	}

	public void addCustomer(String id, String name) {
		CustomerAccess.addCustomer(makeCustomer(id, name));
	}

	private CD getCD(String id) {
		return CDAccess.findByPhysicalID(makeCDID(id));
	}

	public String getRentalContractCDID() {
		return contract.getPhysicalID().toString();
	}

	public String getRentalContractCDTitle() {
		return contract.getTitle().toString();
	}
	
	public String getRentalContractCustomerID() {
		return contract.getCustomerID().toString();
	}

	public String getRentalContractCustomerName() {
		return contract.getCustomerName().toString();
	}

	public String getRentalContractDueDate() {
		return contract.getDueDate().toString();
	}

	public String getRentalChargeCDTitle() {
		return charge.getTitle().toString();
	}

	public String getRentalChargeCustomerName() {
		return charge.getCustomerName().toString();
	}
	
	public String getRentalChargeFee() {
		return charge.getRentalFee().toString();
	}
	
	public String getRentalChargeReturnDate() {
		return charge.getReturnDate().toString();
	}

	public String getRentalCustomerIDForCD(String id) {
		return getCD(id).getCustomerID().toString();
	}
	
	public String getRentalStartTimeForCD(String id) {
		return getCD(id).getStartTime().toString();
	}
	
	public String getRentalStatusForCD(String id) {
		return getCD(id).getRented().toString();
	}

	private CD makeCD(String id, String title) {
		return new CD(makeCDID(id), makeName(title), YesNo.DEFAULT_VALUE,  CustomerIDADT.DEFAULT_VALUE, TimeStamp.DEFAULT_VALUE);
	}
	
	private PhysicalIDADT makeCDID(String id) {
		try {
			return new PhysicalIDADT(id);
		} catch (FormatDeviation e) {
			throw new RuntimeException(e);
		}
	}

	private Customer makeCustomer(String id, String name) {
		return new Customer(makeCustomerID(id), makeName(name));
	}

	private CustomerIDADT makeCustomerID(String id) {
		try {
			return new CustomerIDADT(id);
		} catch (FormatDeviation e) {
			throw new RuntimeException(e);
		}
	}

	private Name makeName(String name) {
		try {
			return new Name(name);
		} catch (FormatDeviation e) {
			throw new RuntimeException(e);
		}
	}

	public void rent(String customerID, String cdID) {
		contract = RentalProcess.checkOut(makeCustomerID(customerID), makeCDID(cdID));
	}

	public void returnCD(String cdID) {
		charge = RentalProcess.checkIn(makeCDID(cdID));
	}

	public void setTestDate(String date) {
		try {
			TimeStamp.TEST_ONLY_set_date(date);
		} catch (FormatDeviation e) {
			throw new RuntimeException(e);
		}
	}
}
