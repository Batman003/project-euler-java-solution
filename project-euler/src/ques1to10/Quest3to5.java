package ques1to10;

import java.util.ArrayList;
import java.util.List;



public class Quest3to5 {
	
	public Long largePrimeFactorOfNumber(long req) {
		
//		QUES = 3
//		The prime factors of 13195 are 5, 7, 13 and 29.
//		What is the largest prime factor of the number 600851475143 ?
		
		List<Long> list = new ArrayList<>();
		long temp = req;
		for(long i = 2;i<=Math.sqrt(req);i++) {
			if(isPrime(i)) {
				if(temp % i == 0) {
					temp = temp / i;
					list.add(i);
				}
			}
		}
		return list.get(list.size()-1);
	}
	
	public boolean isPrime(long num) {
		int i, m = 0, flag = 0;
		m = (int) (num / 2);
		if (num == 0 || num == 1) {
			return false;
		} else {

			for (i = 2; i <= m; i++) {
				if (num % i == 0) {
					flag = 1;
					break;
				}
			}

			if (flag == 0)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Quest3to5 ques = new Quest3to5();
		System.out.println("START");
		Long result = ques.largePrimeFactorOfNumber(600851475143l);
		System.out.println("RESULT ::"+result);
		System.out.println("END");
	}
}
