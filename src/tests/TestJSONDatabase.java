package tests;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import model.JSONDatabase;

public class TestJSONDatabase extends TestCase{


	/*********************************************
	 *  PRIVATE STATIC CONSTANTS
	 *********************************************/
	
	private static final String EFFORTPM_COLUMN = "effort[pm]";
	private static final String CPLX_COLUMN = "cplx";
	private static final String RELY_COLUMN = "rely";
	// First line values
	private static final String FIRST_LINE_RELY_VALUE = "2";
	private static final String FIRST_LINE_CPLX_VALUE = "4";
	private static final String FIRST_LINE_EFFORT_VALUE = "42256.0";

	// Last line values
	private static final String LAST_LINE_RELY_VALUE = "3";
	private static final String LAST_LINE_CPLX_VALUE = "4";
	private static final String LAST_LINE_EFFORT_VALUE = "5776.0";

	// Index for first and last lines
	private static final String FIRST_LINE_INDEX = "0";
	private static final String LAST_LINE_INDEX = "152";
	

	/*********************************************
	 * CLASS OBJECTS
	 *********************************************/
	
	private JSONDatabase database;
	private JSONObject firstJSON;
	private JSONObject lastJSON;
	
	
	@Before
	public void setUp(){
		 database = JSONDatabase.getInstance();
		 firstJSON = database.getOneProjectAsJSONObject(FIRST_LINE_INDEX);
		 lastJSON = database.getOneProjectAsJSONObject(LAST_LINE_INDEX);
	}
	
	@Test
	public void testReadFromDatabaseINalt0File(){
		try {
			// Test first project
			assertEquals(FIRST_LINE_RELY_VALUE , firstJSON.get(RELY_COLUMN));
			assertEquals(FIRST_LINE_CPLX_VALUE , firstJSON.get(CPLX_COLUMN));
			assertEquals(FIRST_LINE_EFFORT_VALUE, firstJSON.get(EFFORTPM_COLUMN));
			// Test last project
			assertEquals(LAST_LINE_RELY_VALUE , lastJSON.get(RELY_COLUMN));
			assertEquals(LAST_LINE_CPLX_VALUE , lastJSON.get(CPLX_COLUMN));
			assertEquals(LAST_LINE_EFFORT_VALUE, lastJSON.get(EFFORTPM_COLUMN));
		} catch (JSONException e) {
			e.printStackTrace();
		}		
	}
}
