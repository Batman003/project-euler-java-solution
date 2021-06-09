package ques1to10;

public class Ques10 {
	
	public static long sumOfPrime(long limit) {
		long result = 0;
		for(int i=2; i<limit;i++) {
			if(isPrime(i)) {
				result += i;
			}
		}
		return result;
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		long num = (long) (2 * Math.pow(10,6));
		System.out.println("RESULT :: "+sumOfPrime(num));
	}
}
