
package fixtures;

import fit.ColumnFixture;

import com.samscdrental.model.adt.*;
import com.samscdrental.failures.*;


public class TestDate extends ColumnFixture {
	public String Date ;
	public boolean set(){
			try {
				TimeStamp.TEST_ONLY_set_date(Date);
				return true; 
		} catch (FormatDeviation e) {
				return false;
			} 
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
