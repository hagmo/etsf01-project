package conversion;

import controller.Estimation;

public class Converter {

	/*********************************************
	 * PUBLIC CONSTANTS
	 *********************************************/
	public static final int PERSON_HOURS = 1;
	public static final int PERSON_DAYS = 24;
	public static final int PERSON_MONTHS = 720;
	public static final int PERSON_YEARS = 262800;

	public static final int HOURS = 0;
	public static final int DAYS = 1;
	public static final int MONTHS = 2;
	public static final int YEARS = 3;


	/*********************************************
	 * PRIVATE CONSTANTS
	 *********************************************/

	private static final int HOURS_IN_DAY = 24;
	private static final int HOURS_IN_MONTH = 720;
	private static final int HOURS_IN_YEAR = 262800;
	
	/*********************************************
	 * STATIC METHOD
	 *********************************************/
	
	/**
	 * Converts the current value to number of hours. 
	 * @param currentUnit  	the current unit (hours = 0, days = 1, months = 2, years = 3)
	 * @param value 		the value to be converted.
	 * @return a double value in the unit hours.
	 */
	public static double convertToHours(int currentUnit, double value) {
		double normalizedValue;
		switch (currentUnit) {
		case HOURS:
			normalizedValue = value;
			break;
		case DAYS:
			normalizedValue = value * HOURS_IN_DAY;
			break;
		case MONTHS:
			normalizedValue = value * HOURS_IN_MONTH;
			break;
		case YEARS:
			normalizedValue = value * HOURS_IN_YEAR;
			break;
		default: 
			normalizedValue = value;
			break;
		}
		return normalizedValue;
	}
	
	/**
	 * Converts the current value to number of Person-days. 
	 * @param currentUnit  	the current unit (hours = 0, days = 1, months = 2, years = 3)
	 * @param value 		the value to be converted.
	 * @return a double value in the unit Person-days.
	 */
	public static double convertToDays(int currentUnit, double value){
		return convertToHours(currentUnit, value)/HOURS_IN_DAY;
	}
	
	/**
	 * Converts the current value to number of Person-months. 
	 * @param currentUnit  	the current unit (hours = 0, days = 1, months = 2, years = 3)
	 * @param value 		the value to be converted.
	 * @return a double value in the unit Person-months.
	 */
	public static double convertToMonths(int currentUnit, double value){
		return convertToHours(currentUnit, value)/HOURS_IN_MONTH;
	}
	
	/**
	 * Converts the current value to number of Person-years. 
	 * @param currentUnit  	the current unit (hours = 0, days = 1, months = 2, years = 3)
	 * @param value 		the value to be converted.
	 * @return a double value in the unit Person-months.
	 */
	public static double convertToYears(int currentUnit, double value){
		return convertToHours(currentUnit, value)/HOURS_IN_YEAR;
	}
	
}
