package ques11to20;

import java.math.BigInteger;


//QUESTION 20 : 
//	
//	n! means n × (n − 1) × ... × 3 × 2 × 1
//
//	For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//	and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//
//	Find the sum of the digits in the number 100!

public class Ques20 {

	
	public static int getFactorial(int num) {
		BigInteger getFactorial = BigInteger.ONE;
		for(int i = 0;i<num;i++) {
			getFactorial = getFactorial.multiply(BigInteger.valueOf(num-i));
			//System.out.println(i+ "getFactorial:: "+getFactorial);
		}
		
		BigInteger result = BigInteger.ZERO;
		
		while(getFactorial != BigInteger.ZERO) {
			BigInteger temp = getFactorial.mod(BigInteger.TEN);
			getFactorial = getFactorial.divide(BigInteger.TEN);
			result = result.add(temp);
		}
		return result.intValue();
	}
	
	public static void main(String[] args) {
		int result = getFactorial(100);
		System.out.println(result);
	}
}
