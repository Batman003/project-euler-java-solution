package ques11to20;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Ques15 {
	
	private static long startTime = System.currentTimeMillis();
	
	public static BigInteger findRoutes(int limit) {
		
		List<BigInteger> a = new ArrayList<>();
		a.add(new BigInteger("1"));
		
		List<BigInteger> b = new ArrayList<>();
		b.add(new BigInteger("1"));
		b.add(new BigInteger("1"));
		
		List<BigInteger> c = null;
		
		List<List<BigInteger>> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		
		for(int i=2;i<limit+limit+1;i++) {
			c = new ArrayList<>();
			c = prepareList(list.get(i-1));
			list.add(c);
		}
			a = list.get(list.size()-1);
		return  a.get((a.size()/2));
	}

	

	private static List<BigInteger> prepareList(List<BigInteger> list) {
		// TODO Auto-generated method stub
		
		List<BigInteger> resp = new ArrayList<>();
		resp.add(new BigInteger("1"));
		
		for(int i=0;i<list.size()-1;i++) {
			resp.add(list.get(i).add(list.get(i+1)));
		}
		resp.add(new BigInteger("1"));
		return resp;
	}



	public static void main(String[] args) {
		BigInteger res = findRoutes(20);
		System.out.println("RESULT :: "+res);
		long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}
}
