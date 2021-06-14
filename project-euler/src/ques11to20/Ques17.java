package ques11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques17 {
	
	static List<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[] {0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8}));
	static List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[] {6,6,5,5,5,7,6,6}));
	
	public static Integer twpDigitLength(int num) {
		//TODO 1 to 99
		if(num < 20) {
		return list1.get(num);
		}else {
			return list2.get(num / 10-2 ) + list1.get(num % 10);
		}
	}

	public static int getResult(int num) {
		
		int response = 0;
		if(num < 100)
			return twpDigitLength(num);
		
		
		  int h = (int) (Math.floor(num / 100) % 10);
		  int t = (int) Math.floor(num / 1000);
		  int s = num % 100;

		  if (num > 999)
			  response+= twpDigitLength(t) + "thousand".length();
		  if (h != 0)
			  response+= twpDigitLength(h) + "hundred".length();
		  if (s != 0)
			  response+= "and".length() + twpDigitLength(s);
		  return response;

	}
	
	public static int generateNumber(int limit){
		
		int result = 0;
		
		for(int i=1;i<=limit;i++) {
			result+=getResult(i);
		}
		
	return result;
	}
	
	public static void main(String[] args) {
		int result = generateNumber(1000);
		System.out.println(result);

	}
}
