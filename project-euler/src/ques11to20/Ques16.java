package ques11to20;

import java.math.BigInteger;

public class Ques16 {
	
	public static BigInteger powerDigitSum(int num, int power) {
		
		BigInteger number = new BigInteger(String.valueOf(num));
		BigInteger powerNum = number.pow(power);
		BigInteger sum = BigInteger.ZERO;
		
		while(powerNum != BigInteger.ZERO) {
			sum = sum.add(powerNum.mod(BigInteger.TEN));
			powerNum = powerNum.divide(BigInteger.TEN);
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(powerDigitSum(2, 1000));
	}
}
