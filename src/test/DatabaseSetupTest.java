package test;
import junit.framework.*;
import com.samscdrental.dataaccess.DatabaseSetup;
public class DatabaseSetupTest extends TestCase {
	@SuppressWarnings("static-access")
	public void testSetup(){
		DatabaseSetup.setup(); 
		this.assertNotNull(DatabaseSetup.connection);
		DatabaseSetup.removeTables();
		DatabaseSetup.setupTables();
		assertTrue("Table Setup", DatabaseSetup.setupComplete);
	
	}

}
