package ques1to10;

public class Ques4 {

	/*
	 * Ques 4 : A palindromic number reads the same both ways. The largest
	 * palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */

	public int result(int startDigit, int endDigit) {
		int res = 0;
		int max = 0;
		for (int i = startDigit; i >= endDigit; i--) {
			for (int j = startDigit; j >= endDigit; j--) {
				res = i * j;
				if (isPalindrom(res) && res > max) {
					max = i * j;
				}
			}
		}
		return max;
	}

	private boolean isPalindrom(int num) {
		String res = String.valueOf(num);
		StringBuilder sb= new StringBuilder(res).reverse();
		return sb.toString().equalsIgnoreCase(res);
	}

	public static void main(String[] args) {
		Ques4 ques = new Ques4();
		int response = ques.result(999, 100);
		System.out.println("Final Res:: " + response);
	}
}
