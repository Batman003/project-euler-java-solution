package ques1to10;

public class Ques9 {
	
	
//	Question 9 : 
//		A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//		a2 + b2 = c2
//		For example, 32 + 42 = 9 + 16 = 25 = 52.
//		There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//		Find the product abc.
	
	
	public int pythogorialTriplet(int limit) {

		for (int i = 1; i <= limit; i++) {
			for (int j = 1; j <= limit; j++) {
				int a = 1;
				int b = 1;
				int c = 1;

				a = (int) Math.pow(i, 2);
				b = (int) Math.pow(j, 2);

				c = a + b;

				c = (int) Math.sqrt(c);

				if (isTriplet(i, j, c)) {
					if (i + j + c == limit) {
						System.out.println("NUMMBER " + i + " " + j + " " + c);
						int res = i * j * c;
						return res;
					}
				}
			}
		}
		return 0;
	}
	
	private boolean isTriplet(int i, int j, int k) {
		// TODO Auto-generated method stub
		int firstSecond = (int) (Math.pow(i, 2) + Math.pow(j, 2));
		int third = (int) (Math.pow(k, 2));

		if (firstSecond == third)
			return true;
		return false;

	}

	public static void main(String[] args) {
		
		Ques9 ques9 = new Ques9();
		System.out.println(ques9.pythogorialTriplet(1000));
	}
}
