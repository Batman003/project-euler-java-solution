package ques11to20;

import java.util.HashSet;
import java.util.Set;

public class Ques12 {
	
	public static long triangularNumber(int num) {
		
		boolean flag = true;
		long count = 1;
		
		while(flag) {
			long currentTriangularNumber = getTriangularNumber(count);
			int size = findFactors(currentTriangularNumber);
			if(size>num) {
				return currentTriangularNumber;
			}
			currentTriangularNumber = 0;
			count++;
		}
		return count-1;
	}
	
	private static int findFactors(long currentTriangularNumber) {
		// TODO Auto-generated method stub
		Set<Integer> factors = new HashSet<>();
		for(int i=1;i<=Math.sqrt(currentTriangularNumber);i++) {
			if(currentTriangularNumber % i == 0) {
				factors.add(i);
				factors.add((int)(currentTriangularNumber/i));
			}
		}
		return factors.size();
	}

	private static long  getTriangularNumber(long count) {
		return (count * (count+1))/2;
	}
	
	public static void main(String[] args) {
		int rangeOfDivisors = 500;
		long result = triangularNumber(rangeOfDivisors);
		System.out.println("RESULT:: "+result);
	}
}
