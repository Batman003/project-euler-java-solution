package ques1to10;

public class Ques5 {
	
//	QUESTION : 5
//	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	
	public int devideByEach(int limit) {
		
		boolean flag = true;
		int number = 1;
		int recurrance = 0;
		while(flag) {
			for(int i=1;i<=limit;i++) {
				if(number % i !=0) {
					break;
				}
				if(recurrance == limit) {
					flag=false;
				}
				recurrance++;
			}
			recurrance=1;
			number++;
		}
		return number-1;
	}
	
	public static void main(String[] args) {
		Ques5 ques5 = new Ques5();
		System.out.println("START");
		int response = ques5.devideByEach(20);
		System.out.println("RESPONSE:: "+response);
		System.out.println("END");
	}
}
