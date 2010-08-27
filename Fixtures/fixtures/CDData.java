package fixtures;



import fit.RowFixture;

import com.samscdrental.dataaccess.*;


public class CDData extends RowFixture {
	@SuppressWarnings("rawtypes")
	@Override
	public Object parse(String s, Class type) throws Exception {
		Object o = FixtureHelper.parseADT(s, type); 
		if (o != null)
			return o; 
		return super.parse(s, type);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getTargetClass() {
		return CDDataHelper.class;
	}

	@Override
	public Object[] query() throws Exception {
		return CDDataHelper.getData(CDAccess.getAll()); 
	}
}
