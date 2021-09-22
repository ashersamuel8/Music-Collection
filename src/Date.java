import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date> {
	
	private int year;
	private int month;
	private int day;
	
	private static final int QUADRENNIAL = 4;
	private static final int CENTENNIAL = 100;
	private static final int QUARTERCENTENNIAL = 400;
	private static final int THE_EIGHTYS = 1980;
	private static final int ALIGN_MONTHS = 1;
	private static final int NON_LEAP_YEAR_FEBRUARY = 28;
	private static final int LEAP_YEAR_FEBRUARY = 29;
	private static final int THIRTY_DAY_MONTH = 30;
	private static final int THIRTYONE_DAY_MONTH = 31;
	
	//take "mm/dd/yyyy" and create a Date object
	public Date(String date) {
		StringTokenizer buffer = new StringTokenizer(date, "/");
		
		this.month = Integer.parseInt(buffer.nextToken());
		this.day = Integer.parseInt(buffer.nextToken());
		this.year = Integer.parseInt(buffer.nextToken());
	}  
	
	//create an object with today's date (see Calendar class)
	public Date() {
		Calendar currentDate = Calendar.getInstance();
		
		this.year = currentDate.get(Calendar.YEAR);
		this.month = currentDate.get(Calendar.MONTH);
		this.day = currentDate.get(Calendar.DAY_OF_MONTH);
	} 
	
	public boolean isValid() {
		Date currentDate = new Date();		
		
		if (this.compareTo(currentDate) == 1 || this.year < THE_EIGHTYS) {
			return false;
		}
		
		int monthValue = this.month - ALIGN_MONTHS;
		
		if (monthValue < Calendar.JANUARY || monthValue > Calendar.DECEMBER) {
			return false;
		}		
		
		if (monthValue == Calendar.JANUARY || monthValue == Calendar.MARCH || monthValue == Calendar.MAY || monthValue == Calendar.JULY || monthValue == Calendar.AUGUST || monthValue == Calendar.OCTOBER || monthValue == Calendar.DECEMBER) {
			if (this.day > THIRTYONE_DAY_MONTH) {
				return false;
			}
		}
		
		if(monthValue == Calendar.APRIL || monthValue == Calendar.JUNE || monthValue == Calendar.SEPTEMBER || monthValue == Calendar.NOVEMBER) {
			if (this.day > THIRTY_DAY_MONTH) {
				return false;
			}
		}
		
		if(monthValue == Calendar.FEBRUARY) {
			if (isLeapYear(this.year)) {
				if (this.day > LEAP_YEAR_FEBRUARY) {
					return false;
				}
			}
			else {
				if (this.day > NON_LEAP_YEAR_FEBRUARY) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	private boolean isLeapYear(int year) {
		if (year % QUADRENNIAL == 0) {
			if (year % CENTENNIAL == 0) {
				if (year % QUARTERCENTENNIAL == 0) {
					return true;
				}
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Date date) {
		if (this.year < date.year) {
			return -1;
		}
		if (this.year == date.year) {
			if (this.month < date.month) {
				return -1;
			}
			else if (this.month == date.month) {
				if (this.day < date.day) {
					return -1;
				}
				else if (this.day == date.day) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else {
				return 1;
			}
		}
		
		return 1;
	}
}
