package fixtures;



import fit.ColumnFixture;

import com.samscdrental.dataaccess.*;
public class SetupDatabase extends ColumnFixture{
	public boolean setup() {
		System.err.println("Setting up database"); 
		DatabaseSetup.setup(); 
		DatabaseSetup.removeTables();
		DatabaseSetup.setupTables();
		return true; 
	} 


}
