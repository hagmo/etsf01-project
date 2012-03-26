package tests;

import static org.junit.Assert.*;
import model.JSONDatabase;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import controller.EffortEstimation;

public class TestEffortEstimation {

	/*********************************************
	 *  PRIVATE STATIC CONSTANTS
	 *********************************************/
	
	private static final String EFFORTPM_COLUMN = "effort[pm]";
	private static final String CPLX_COLUMN = "cplx";
	private static final String RELY_COLUMN = "rely";
	// First line values
	private static final String FIRST_LINE_RELY_VALUE = "nominal";
	private static final String FIRST_LINE_CPLX_VALUE = "very_high";
	private static final String FIRST_LINE_EFFORT_VALUE = "278";

	// Last line values
	private static final String LAST_LINE_RELY_VALUE = "nominal";
	private static final String LAST_LINE_CPLX_VALUE = "high";
	private static final String LAST_LINE_EFFORT_VALUE = "155";

	// Index for first and last lines
	private static final String FIRST_LINE_INDEX = "0";
	private static final String LAST_LINE_INDEX = "59";
	

	/*********************************************
	 * CLASS OBJECTS
	 *********************************************/
	
	private JSONDatabase database;
	
	@Before
	public void setUp(){
		 database = JSONDatabase.getInstance();
	}
	
	@Test
	public void testSimilarity(){
		EffortEstimation estimator = new EffortEstimation(database.getJSONObject());
		estimator.calculateSimilarity(database.getProjectAsJSONObject("1"));
	}
	
}