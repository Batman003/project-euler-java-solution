package ques21to30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




//Amicable numbers
//
//Problem 21
//Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//
//For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//
//Evaluate the sum of all the amicable numbers under 10000.

public class Ques21 {

	private static int getFactorialSum(int num) {
		// TODO Auto-generated method stub
		int sum = 0;

		int limit = (int) Math.sqrt(num);

		Set<Integer> set = new HashSet<Integer>();
		//List<Integer> set = new ArrayList<Integer>();

		set.add(1);

		for (int i = 2; i <= limit; i++) {
			if (num % i == 0) {
				set.add(i);
				set.add(num / i);
			}
		}
		
		System.out.println(Arrays.asList(set));
		sum = set.parallelStream().reduce(0, Integer::sum);
		return sum;
	}

	private static int getAmicableNumbers(int limit) {
		// TODO Auto-generated method stub

		int sum = 0;
		for (int i = 2; i < limit; i++) {

			int b = getFactorialSum(i);
			int a = getFactorialSum(b);

			if (i != b && i == a) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		//System.out.println(getAmicableNumbers(10000));
		System.out.println(getFactorialSum(500));
	}

}
