package ques11to20;

import java.util.ArrayList;
import java.util.List;

public class Ques17 {

	public static String getDigitInWord(int num, int count) {
		
		String response = "";
		if(count == 1) {
			switch(num) {
			case 1 :
				response =  "ONE";
				break;
			case 2 :
				response =  "TWO";
				break;
			case 3 :
				response =  "THREE";
				break;
			case 4 :
				response =  "FOUR";
				break;
			case 5 :
				response =  "FIVE";
				break;
			case 6 :
				response =  "SIX";
				break;
			case 7 :
				response =  "SEVEN";
				break;
			case 8 :
				response =  "EIGHT";
				break;
			case 9 :
				response =  "NINE";
				break;
			default:
				System.out.println("No number is found");
			
			}
		}else if(count == 2) {
			switch(num) {
			case 10 :
				response =  "TEN";
				break;
			case 11 :
				response =  "ELEVEN";
				break;
			case 12 :
				response =  "TWELVE";
				break;
			case 13 :
				response =  "THIRTEEN";
				break;
			case 14 :
				response =  "FOURTEEN";
				break;
			case 15 :
				response =  "FIFTEEN";
				break;
			case 16 :
				response =  "SIXTEEN";
				break;
			case 17 :
				response =  "SEVENTEEN";
				break;
			case 18 :
				response =  "EIGHTEEN";
				break;
			case 19 :
				response =  "NINETEEN";
				break;
			case 20 :
				response =  "TWENTY";
				break;
			case 30 :
				response =  "THIRTY";
				break;
			case 40 :
				response =  "FORTY";
				break;
			case 50 :
				response =  "FIFTY";
				break;
			case 60 :
				response =  "SIXTY";
				break;
			case 70 :
				response =  "SEVENTY";
				break;
			case 80 :
				response =  "EIGHTY";
				break;
			case 90 :
				response =  "NINETY";
				break;
			default:
				System.out.println("No number is found");
			}
			
			}else if(count == 3) {
				switch(num) {
				case 100 :
					response = "ONEHUNDREDAND";
					break;
				case 200 :
					response = "TWOHUNDREDAND";
					break;
				case 300 :
					response = "THREEHUNDREDAND";
					break;
				case 400 :
					response = "FOURHUNDREDAND";
					break;
				case 500 :
					response = "FIVEHUNDREDAND";
					break;
				case 600 :
					response = "SIXHUNDREDAND";
					break;
				case 700 :
					response = "SEVENHUNDREDAND";
					break;
				case 800 :
					response = "EIGHTHUNDREDAND";
					break;
				case 900 :
					response = "NINEHUNDREDAND";
					break;
					
				}
				
		}else if(count == 4) {
			response = "ONETHOUSAND";
		}else {
			System.out.println("INVALID NUMBER DIGIT:: "+num);
		}
		return response;
	}
	
	public List<Integer> generateNumber(int limit){
		
		int rem = 0;
		int count = 0;
		String response = "";
		List<Integer> list = new ArrayList<>();
		
		for(int i=1;i<=limit;i++) {
			
			 rem = 0;
			count = 0;
			response = "";
			int carry = 0;
			int newNum = i;
			
			if(newNum > 20) {
				while(newNum > 0) {
					rem = newNum % 10;
					newNum = newNum /10;
					count++;
					
					if(rem > 0) {
						
						int temp = rem;
					if(count == 2) {
						temp *= 10;
					}else if(count == 3) {
						temp *= 100;
					}else if(count == 4) {
						temp *= 1000;
					}
					response = getDigitInWord(temp, count);
					carry += response.length();
					System.out.println("NUMBER:: "+i+" RESPONSE:: "+response);
					}
				}
				list.add(carry);
				System.out.println("CARRY:: "+carry);
			}else if(newNum>9){
				response = getDigitInWord(newNum, 2);
				list.add(response.length());
				System.out.println("NUMBER:: "+newNum+" RESPONSE:: "+response);
			}else {
				response = getDigitInWord(newNum, 1);
				list.add(response.length());
				System.out.println("NUMBER:: "+newNum+" RESPONSE:: "+response);
			}
			
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Ques17 ques17 = new Ques17();
		List<Integer> list = ques17.generateNumber(1000);
		
		int result = 0;
		for(int i=0;i<list.size();i++) {
			result += list.get(i);
		}
		
		
		System.out.println(result-27);
		
		//TODO CODE IS INCOMPLETE
	}
}
