package ques11to20;

import java.util.HashMap;
import java.util.Map;



/*QUESTION 19

You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?*/


public class Ques19 {
	
	private static final int LEAP_YEAR_DAYS = 366;
	private static final int NORMAL_YEAR_DAYS = 365;
	private static final int INITIAL_YEAR = 1900;
	private static final int WEEK_CONSTANT = 7;
	private static final int FIRST_SUNDAY_CONSTANT = 1;
	
	private static boolean isLeapYear(int year) {
		boolean isLeap = false;
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			isLeap =  true;
		return isLeap;
	}
	
	public static Map<Integer, Integer> getMonthInYear(int year){
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 31);
		if(isLeapYear(year)) map.put(2, 29);
		else map.put(2, 28);
		map.put(3, 31);map.put(4, 30);
		map.put(5, 31);map.put(6, 30);
		map.put(7, 31);map.put(8, 31);
		map.put(9, 30);map.put(10, 31);
		map.put(11, 30);map.put(12, 31);
		return map;
	}
	
	public static int getFirstYearSundayDate(int startYear) {

		int totalNumberOfDays = 0;
		int lastSunday = 0;
		
		for(int i=INITIAL_YEAR;i<startYear;i++) {
			if(isLeapYear(i)) {
				totalNumberOfDays += LEAP_YEAR_DAYS;
			}else {
				totalNumberOfDays += NORMAL_YEAR_DAYS;
			}
		}
		int temp = totalNumberOfDays;
		while(temp > 0) {
			temp -= WEEK_CONSTANT;
			lastSunday += WEEK_CONSTANT; 
		}	
		return lastSunday-totalNumberOfDays;
	}
	
	
	public static int getFinalResult(int startYear, int endYear) {
		
		int startYearFirstSunday = getFirstYearSundayDate(startYear);
		int count = 0;
		
		for(int i = startYear;i<=endYear;i++) {
			Map<Integer,Integer> map = getMonthInYear(i);
			
			for(int j=1;j<=12;j++) {
				int currentMonthDays = map.get(j);
				if(startYearFirstSunday == FIRST_SUNDAY_CONSTANT) {
					count++;
				}	
				while(startYearFirstSunday < currentMonthDays) {
					startYearFirstSunday += WEEK_CONSTANT;
				}
				startYearFirstSunday -= currentMonthDays;
			}
		}
		return count;
	}
	

	public static void main(String[] args) {

		int countingSundays = getFinalResult(1901, 2000);
		System.out.println("Sunday Fell On First of the month between given years:: "+countingSundays);
	}
}
