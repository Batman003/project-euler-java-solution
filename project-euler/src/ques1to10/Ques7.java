package ques1to10;


//QUESTION : 7
//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//What is the 10 001st prime number?

public class Ques7 {
	
	public int givenPrime(int number) {
		boolean runFlag = true;
		int startNumber = 2;
		int occurance = 0;

		while (runFlag) {
			if (isPrime(startNumber)) {
				occurance++;
			}
			
			if (occurance == number) {
				runFlag = false;
			}
			startNumber++;
		}

		return startNumber-1;
	}
	private boolean isPrime(int number) {
		// TODO Auto-generated method stub
		
		for(int i=2; i<=Math.sqrt(number);i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Ques7 ques7 = new Ques7();
		
		System.out.println(ques7.givenPrime(10001));
	}
}
