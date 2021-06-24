package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeapYear {
	
	
	public static boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			//System.out.println("Year is leap year");
			return true;
		}else {
			//System.out.println("Year is not leap year");
			return false;
		}
	}
	
	
	public static List<Integer> totalLeapYear(int startYear, int endYear) {
		
		List<Integer> result = new ArrayList<Integer>();
	
		for(int i=startYear;i<=endYear;i+=4) {
			if(isLeapYear(i)) {
				result.add(i);
			};	
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		isLeapYear(1904);
		List<Integer> arr = totalLeapYear(1900, 3999);
		System.out.println(Arrays.asList(arr));
		System.out.println("Total leap years:: "+arr.size());
	}
}
