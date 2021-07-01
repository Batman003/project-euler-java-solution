package ques21to30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. 
//However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

public class Ques23 {
	
	public static final int  ABUNDANT_NUMBER_LIMIT = 28124;
	private static final String PERFECT_NUMBER = "P";
	private static final String ABUNDANT_NUMBER = "A";
	private static final String DEFICIENT_NUMBER = "D";
	
	
	private static boolean getAbundantNumber(int num, String flag) {
		// TODO Auto-generated method stub
		
		int limit = (int) Math.sqrt(num);
		Integer sumOfProperDivisor = 0;	
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		for (int i = 2; i <= limit; i++) {
			if (num % i == 0) {
				set.add(i);
				set.add(num / i);
			}
		}
		sumOfProperDivisor = set.parallelStream().reduce(0, Integer::sum);
		
		if(flag.equalsIgnoreCase(PERFECT_NUMBER) && sumOfProperDivisor == num) {
			return true;
		}else if(flag.equalsIgnoreCase(ABUNDANT_NUMBER) && sumOfProperDivisor > num) {
			return true;
		}else if(flag.equalsIgnoreCase(DEFICIENT_NUMBER) && sumOfProperDivisor < num) {
			return true;
		}
		return false;
	}
	
	public static List<Integer> getAbundantNumList(int limit, String flag) {
		
		List<Integer> abundantNumList = new ArrayList<Integer>();
		
		for (int i = 2; i < limit; i++) {
			if(getAbundantNumber(i, flag)) {
				abundantNumList.add(i);
			}
		}
		return abundantNumList;
	}
	
	

	public static void main(String[] args) {
		
		int result = 0;
		
		List<Integer> list = getAbundantNumList(ABUNDANT_NUMBER_LIMIT, "A");
		
		boolean[] sumOfTwoAbundantNumber = new boolean[ABUNDANT_NUMBER_LIMIT+1];
		
		for(int x = 0; x < list.size();x++) {
			for(int y = x; y < list.size();y++) {
				if(list.get(x) + list.get(y) <= ABUNDANT_NUMBER_LIMIT) {
				sumOfTwoAbundantNumber[list.get(x) + list.get(y)]  = true;
				}else {
					break;
				}
			}
		}
		
		for (int i = 1; i < ABUNDANT_NUMBER_LIMIT; i++) {
			if(!sumOfTwoAbundantNumber[i]) {
				result += i;
			}
		}

		System.out.println("Sum of all positive integers which cannot be written as the sum of two abundant numbers:: "+result);
	}
}
